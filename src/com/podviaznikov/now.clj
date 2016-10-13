(ns com.podviaznikov.now
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.common :as views]))

(defn render [{global-meta :meta pages :entries}]
  (html5 {:lang "en"}
    (views/head "Anton Podviaznikov: now")
    [:body
      (views/header)
      [:main.ph3.pb3.pt2.ph5-ns.pb5-ns.pt2-ns
        [:h1.lh-title.f2.athelas "What I'm doing now"]
        [:article.lh-copy.measure.f5
          (str (:content (first pages)))]]
      ]))
