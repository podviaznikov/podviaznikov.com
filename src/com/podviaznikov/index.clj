(ns com.podviaznikov.index
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views])        )

(defn render [{global-meta :meta posts :entries}]
  (html5 {:lang "en"}
    (views/head (:site-title global-meta))
    [:body
      (views/header true)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:dl.lh-title.pv4.mt0
          [:dt.f6.b.mb1 "Essays"]
          [:dd.ml0.mb3 [:a.link {:href "essays.html"} "My ongoing thoughts on various topics"]]
          [:dt.f6.b.mb1 "Books"]
          [:dd.ml0.mb3 [:a.link {:href "books.html"} "Notes on books"]]
          [:dt.f6.b.mb1 "Now"]
          [:dd.ml0.mb3 [:a.link {:href "now.html"} "What I'm doing and thinking about now"]]]
      ]]))
