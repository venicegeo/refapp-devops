(ns refapp.core
  (:require [ring.adapter.jetty :as jetty]))

(defn handler [_]
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "Hello world."})
