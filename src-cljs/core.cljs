(ns hello
  (:require [clojure.browser.repl :as repl]
            [c2.scale :as scale]
            [c2.event :as event]
            [c2.util :refer [bind! unify]]))

(defn log [str]
  (.log js/console (pr-str str)))

(def our-data
  {
    "7/2/13" 52
    "7/3/13" 63
    "7/4/13" 37
    "7/5/13" 57
    "7/6/13" 32
    "7/7/13" 95
    "7/8/13" 97
    "7/9/13" 127
    "7/10/13" 144
    "7/11/13" 167
    "7/12/13" 110
    "7/13/13" 71
    "7/14/13" 72
    "7/15/13" 135
    "7/16/13" 112
    "7/17/13" 118
    "7/18/13" 107
    "7/19/13" 118
    "7/20/13" 52
    "7/21/13" 92
    "7/22/13" 212
    "7/23/13" 93
    "7/24/13" 97
    "7/25/13" 174
    "7/26/13" 191
    "7/27/13" 103
    "7/28/13" 105
    "7/29/13" 98
    "7/30/13" 236
    "7/31/13" 96
    "8/1/13" 102
 })


(defn draw-histogram [data]
  (let [width 500
        bar-height 20
        s (scale/linear :domain [0 (apply max (vals data))]
                        :range [0 width])]
    (bind!
      "#bars"
      [:div#bars
       (unify data
          (fn [[label val]]
            (log (+ "Val " (s val)))
            [:div {:style {:height (+ bar-height "px")
                           :width (+ (s val) "px")
                           :background-color "gray"}}
             [:span {:style {:color "white"}} label]]))])))

(defn point-to-draw [point]
  (str "L " (clojure.string/join " " point)))

(defn point-to-start [point]
  (str "M " (clojure.string/join " " point)))

(defn points-with-index [points xint]
  (map-indexed #(vector (* xint %1) %2) (vals points)))

(defn data-to-paths [points xint]
  (clojure.string/join "\n" (map point-to-draw (points-with-index points xint))))

(defn draw-graph [data]
  (let [width 500
        height 500
        x-interval (/ width (count data))
        s (scale/linear :domain [0 (apply max (vals data))]
                        :range [0 height])
        new-data (str
                   (point-to-start (vector 0 (last (first data))))
                   (data-to-paths data x-interval))]

    (bind!
      "#graph"
      [:div#graph
        [:svg.graph {:xmlns "http://www.w3.org/2000/svg" :width width :height height}
          [:path {:d new-data
                  :stroke "red"
                  :stroke-width "2"
                  :fill "none"}]]])))


(defn init []
  ;; verify that js/document exists and that it has a getElementById
  ;; property
  (if (and js/document (.-getElementById js/document))
    (do
     (draw-histogram our-data)
     (draw-graph our-data))))

(repl/connect "http://localhost:9000/repl")
(set! (.-onload js/window) init)
