(defproject cljs_dashboard "0.1.0-SNAPSHOT"
  :description "Google Analytics & More Dashboard"
  :url "http://github.com/bendyworks/cljs_dashboard"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.0.4"]
                 [hiccup "1.0.0"]]
  :plugins [[lein-cljsbuild "0.3.2"]
            [lein-ring "0.7.0"]]
  :cljsbuild {
    :builds [{
      ; The path to the top-level ClojureScript source directory:
      :source-paths ["src-cljs"]
      ; The standard ClojureScript compiler options:
      ; (See the ClojureScript compiler documentation for details.)
      :compiler {
        :output-to "resources/public/js/main.js"
        :pretty-print true}}]}
  :ring {:handler cljs-dashboard.routes/app}
)
