(defproject refapp "0.1.0"
  :description "Just a simple hello world."
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-jetty-adapter "1.4.0"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler refapp.core/handler}
  :target-path "target/%s")
