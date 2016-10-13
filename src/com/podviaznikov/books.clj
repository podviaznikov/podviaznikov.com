(ns com.podviaznikov.books
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views]))

(defn render [{global-meta :meta posts :entries}]
  (html5 {:lang "en"}
    (views/head "Anton Podviaznikov: books")
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f2.athelas "Books"]
        [:article.lh-copy.measure "This section is not ready yet, but coming soon"]]
      ]))
