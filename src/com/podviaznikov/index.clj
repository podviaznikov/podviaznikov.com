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
            [:li "I was born in Germany"]
            [:li "I grew up in post-Soviet Ukraine"]
            [:li "I left Ukraine for Montenegro"]
            [:li "I visited more than 20 countries"]
            [:li "I live in San Francisco now"]]
        ]
        [:section
          [:h2 "Work"]
            [:ul
              [:li "I worked in decently large outsourcing company in Ukraine"]
              [:li "I worked in small product company in Montenegro"]
              [:li "I was freelance developer for two periods"]
              [:li "I was founding engineer at CircuitHub"]
              [:li "I was first engineer at HumanAPI"]
              [:li "Right now I work at Runnable"]]
          ]

      ]))
