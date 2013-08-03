(ns cljs-dashboard.views
  (:require
    [hiccup
     [page :refer [html5 include-js include-css]]]))

(def title "Dashboard")

(defn index-page []
  (html5
    [:head
      [:title title]
     (include-css "css/bootstrap.min.css")
     (include-css "css/statusboard.css")]
    [:body
     [:div {:class "container-fluid"}
      [:h1 title]
      [:div {:id "widgets-holder" :class "row-fluid"}]
      (include-js "/js/main.js")]]))
