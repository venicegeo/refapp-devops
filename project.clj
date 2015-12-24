(defproject refapp "0.1.0"
  :description "Just a simple hello world."
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [ring/ring-jetty-adapter "1.4.0"]]
  :main ^:skip-aot refapp.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
