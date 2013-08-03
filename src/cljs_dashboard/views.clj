(ns cljs-dashboard.views
  (:require
    [hiccup
      [page :refer [html5]]
      [page :refer [include-js]]]))

(defn index-page []
  (html5
    [:head
      [:title "Hello World"]]
    [:body
      [:h1 "Hello World"]
      [:div {:id "bars" :class "example"}]
      [:div {:id "graph" :class "example"}]
      (include-js "/js/main.js")]))
