(set-env!
  :source-paths #{"src"}
  :resource-paths #{"resources"}
  :dependencies '[[hiccup "1.0.5"]
                  [perun "0.4.0-SNAPSHOT"]
                  [hashobject/boot-s3 "0.1.2-SNAPSHOT"]
                  [clj-time "0.11.0"]
                  [funcool/cuerdas "1.0.1"]
                  [pandeiro/boot-http "0.6.3-SNAPSHOT"]
                  [org.martinklepsch/boot-gzip "0.1.1"]])

(require '[io.perun :refer :all]
         '[io.perun.core :as perun]
         '[boot.core :as boot]
         '[cuerdas.core :as cue]
         '[pandeiro.boot-http :refer [serve]]
         '[hashobject.boot-s3 :refer :all]
         '[org.martinklepsch.boot-gzip :refer [gzip]])

(task-options!
  pom {:project 'podviaznikov.com
       :version "0.2.0"}
  s3-sync {
    :bucket "podviaznikov.com"
    :access-key "AKIAJJCBD4JOTABPRXJA"
    :secret-key "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"
    :source "public"
    :options {"Cache-Control" "max-age=315360000, no-transform, public"}})

(defn transform-html [html]
  (-> html
    (cue/replace "<h2>" "<h2 class=\"f5\">")
    (cue/replace "<strong>" "<strong class=\"b\">")
    (cue/replace "<em>" "<em class=\"i\">")
    (cue/replace "<a href" "<a class=\"link\" href")
    ))

(defn transform-file-content [file]
  (let [content (:content file)
        new-content (transform-html content)]
    (assoc file :content new-content)))

(deftask tachyonize
  "Apply techyons classes to HTML content"
  []
  (boot/with-pre-wrap fileset
    (let [files         (perun/get-meta fileset)
          updated-files (map transform-file-content files)]
      (perun/report-info "tachyonize" "removed draft files. Remaining %s files" (count updated-files))
      (perun/set-meta fileset updated-files))))

(deftask build-dev
  "Build dev version"
  []
  (comp
        (global-metadata)
        (base)
        (markdown)
        (tachyonize)
        (ttr)
        (slug)
        (permalink)
        (canonical-url)
        (print-meta)
        (render :renderer 'com.podviaznikov.essay/render)
        (collection :renderer 'com.podviaznikov.index/render :page "index.html")
        (collection
          :renderer 'com.podviaznikov.essays/render
          :page "essays.html"
          :filterer (fn [file] (= "essay" (:type file))))
        (collection :renderer 'com.podviaznikov.now/render :page "now.html")
        (collection :renderer 'com.podviaznikov.books/render :page "books.html")
        (target)))

(deftask build
  "Build podviaznikov.com"
  []
  (comp (build-dev)
        (gzip :regex [#".html$" #".css$" #".js$"])
        (s3-sync)
        ))

(deftask dev
  []
  (comp (watch)
        (build-dev)
        (serve :resource-root "public")))
