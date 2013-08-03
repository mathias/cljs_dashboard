(ns hello
  (:require [clojure.browser.repl :as repl]))

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


(defn init []
  ;; verify that js/document exists and that it has a getElementById
  ;; property
  (if (and js/document (.-getElementById js/document))
     (.appendChild js/document.body (.createElement js/document "p"))))

(repl/connect "http://localhost:9000/repl")
(set! (.-onload js/window) init)
