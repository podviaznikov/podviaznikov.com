(ns com.podviaznikov.index
  (:use [hiccup.core :only (html)]
        [hiccup.page :only (html5 include-css include-js)]))

(defn render [{global-meta :meta posts :entries}]
  (html5 {:lang "en"}
    [:head
      [:meta {:charset "utf-8"}]
      [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
      [:title "Anton Podviaznikov"]
      [:meta {:name "viewport" :content "width=device-width, initial-scale=1.0, user-scalable=no"}]
      [:meta {:itemprop "author" :name "author" :content "Anton Podviaznikov"}]
      (include-css "/tufte.css")
      ]
    [:body
      [:header
        [:h1 "Anton Podviaznikov"]
        [:p "software engineer, traveller, citizen of the world"]]
      [:section
        [:h2 "Geography"]
        [:ul
          [:li "born in East Germany"]
          [:li "grew up in post-Soviet Ukraine"]
          [:li "left Ukraine for Montenegro"]
          [:li "visited more than 20 countries"]
          [:li "live in San Francisco now"]]]
      [:section
        [:h2 "Work"]
        [:ul
          [:li "worked in moderatly large outsourcing company in Ukraine"]
          [:li "worked in small product company in Montenegro"]
          [:li "freelanced for two separate periods"]
          [:li "I was founding engineer at CircuitHub"]
          [:li "I was first engineer at HumanAPI"]
          [:li "Right now I work at Runnable"]
          [:li "I also run small studio called Hashobject"]]]
      [:section
        [:h2 "Links"]
        [:ul
          [:li "worked in moderatly large outsourcing company in Ukraine"]
          [:li "worked in small product company in Montenegro"]
          [:li "freelanced for two separate periods"]
          [:li "I was founding engineer at CircuitHub"]
          [:li "I was first engineer at HumanAPI"]
          [:li "Right now I work at Runnable"]
          [:li "I also run small studio called Hashobject"]]]

      ]))
