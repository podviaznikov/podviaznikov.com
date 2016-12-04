(ns com.podviaznikov.books
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views]))

(defn render-book [book]
  [:li.mb3
    [:a.link.f6.b.mb0 {:href (str (:slug book))} (:title book)]
    [:p.ml0 (:author book)]])

(defn render [{global-meta :meta books :entries}]
  (html5 {:lang "en"}
    (views/head "Anton Podviaznikov: books")
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f2.athelas "Books I've read. My notes and short reviews"]
        [:ol.ph0.pv4.mt0.list
          (for [book books] (render-book book))]]
      ]))
