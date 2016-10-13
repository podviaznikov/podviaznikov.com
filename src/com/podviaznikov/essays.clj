(ns com.podviaznikov.essays
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views]))

(defn render-essay [essay]
  [:li
    [:a.link.f6.b.mb1 {:href (str (:slug essay))} (:name essay)]
    [:p.ml0.mb2 (:description essay)]])

(defn render [{global-meta :meta essays :entries}]
  (html5 {:lang "en"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:title "Anton Podviaznikov: essays"]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "Anton Podviaznikov"}]
      (include-css "https://unpkg.com/tachyons@4.5.3/css/tachyons.min.css")]
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f2.athelas "Essays, writings, thoughts"]
        [:ol.ph0.pv4.mt0.list
          (for [essay essays] (render-essay essay))]]
      ]))
