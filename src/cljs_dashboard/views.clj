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
     (include-css "//fonts.googleapis.com/css?family=Roboto")
     (include-css "css/statusboard.css")]
    [:body
     [:div {:class "container-fluid"}
      [:h1 title]
      [:div {:id "widgets-holder" :class "row-fluid"}
       [:div {:class "span-2 show bigrow"}
        [:div {:class "row-fluid grid-margins rowlabels"}
         [:div {:class "span12 heavy dateheader"} "Bus Arrivals"]]
        [:div {:class "row-fluid grid-margins"}
         [:div {:class "span12 heavy eventname"}
          [:span {:class "predate"} "8:46PM"]
          6]]]]]
      (include-js "/js/main.js")]))
