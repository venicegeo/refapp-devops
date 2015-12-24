(ns refapp.core-test
  (:require [clojure.test :refer :all]
            [refapp.core :refer :all]))

(deftest sample
  (testing "200 status code"
    (is (= (:status (handler {})) 200))))
