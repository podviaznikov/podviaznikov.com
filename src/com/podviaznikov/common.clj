(ns com.podviaznikov.common
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)])
  (:require [com.podviaznikov.dates :as dates]))


(defn head [title]
  [:head
    [:meta {:charset "utf-8"}]
    [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
    [:title title]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
    [:meta {:itemprop "author" :name "author" :content "Anton Podviaznikov"}]
    [:link {:rel "me" :href "https://github.com/podviaznikov"}]
    [:link {:rel "me" :href "https://twitter.com/podviaznikov"}]
    [:link {:rel "me" :href "mailto:anton@podviaznikov.com"}]
    (include-css "https://unpkg.com/tachyons@4.5.3/css/tachyons.min.css")])

(defn header
  ([]
    (header false))
  ([full]
  [:header.ph3.ph5-ns.pt1.dt
    [:div.dtc.v-mid.pt1
      [:a.baskerville.link.white.bg-black-80.ba.b--black.dib.pa3.w1.h1.br-100.f5 {:href "/"} "ap"]]
    (if full
      [:div.dtc.v-mid.ph3
        [:h1.mt0.mb0.baskerville.fw1.f3 "Anton Podviaznikov"]
        [:h2.gray.mt1.mb0.fw4.f6 "programmer, traveller, citizen of the world"]])]))
