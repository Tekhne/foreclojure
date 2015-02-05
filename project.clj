(defproject foreclojure "0.1.0-SNAPSHOT"
  :description "Solutions for www.4clojure.com problems."
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[cljfmt "0.1.6"]
                 [org.clojure/clojure "1.6.0"]
                 [org.thnetos/cd-client "0.3.4"]]
  :main ^:skip-aot foreclojure.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}}
  :plugins [[cider/cider-nrepl "0.8.2"]
            [lein-cljfmt  "0.1.6"]])
