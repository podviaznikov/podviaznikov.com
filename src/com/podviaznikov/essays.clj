(ns com.podviaznikov.essays
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views]))

(defn render-essay [essay]
  [:li.mb3
    [:a.link.f6.b.mb1 {:href (str (:slug essay))} (:title essay)]
    [:p.ml0 (:description essay)]])

(defn render [{global-meta :meta essays :entries}]
  (html5 {:lang "en"}
    (views/head "Anton Podviaznikov: essays")
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f2.athelas "Essays, writings, thoughts"]
        [:ol.ph0.pv4.mt0.list
          (for [essay essays] (render-essay essay))]]
      ]))
