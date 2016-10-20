(ns com.podviaznikov.book
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.dates :as dates]
            [com.podviaznikov.common :as views]))

(defn render [{metadata :meta books :entries book :entry}]
  (html5 {:lang "en"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:title {:itemprop "name"} (:name book)]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "Anton Podviaznikov"}]
      (include-css "https://unpkg.com/tachyons@4.5.3/css/tachyons.min.css")
      ]
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f3.athelas (:title book)]
        [:h2.lh-title.f5.athelas (:author book)]
        [:span.i.f6 "ISBN: "]
        [:span.lh-title.f6 (:ISBN book)]
        [:span.i.f6.ml4 "read: "]
        [:span.lh-title.f6 (dates/reformat-date (:date-read book) "MMMM YYYY")]
        [:article.lh-copy.measure.f5
          (str (:content book))]
        ]]))
