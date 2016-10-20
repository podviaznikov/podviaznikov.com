(ns com.podviaznikov.essay
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.dates :as dates]
            [com.podviaznikov.common :as views]))

(defn render [{metadata :meta essays :entries essay :entry}]
  (html5 {:lang "en"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:title {:itemprop "name"} (:title essay)]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "Anton Podviaznikov"}]
      (include-css "https://unpkg.com/tachyons@4.5.3/css/tachyons.min.css")
      ]
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f3.athelas (:title essay)]
        [:article.lh-copy.measure.f5
          (str (:content essay))]
        [:footer.mt4.cf.lh-copy.measure.f6
          [:p.i.fr
            [:span.i (:location essay)]
            ", "
            [:span.i (dates/reformat-date (:date-published essay) "MMMM YYYY")]]]
        [:p.mt4.lh-copy.measure.f6
          [:span.b "Thanks to "]
          [:span (:thanks essay)]]
        ]]))
