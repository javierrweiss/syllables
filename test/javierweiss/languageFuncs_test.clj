(ns javierweiss.languageFuncs-test
  (:require [clojure.test :refer :all]
            [javierweiss.languageFuncs :refer :all]))

(deftest syllables-splitting-english
  (testing "Splits words in syllables  "
    (is (= (sylsplit "hello") ["hel" "lo"]))
    (is (= (sylsplit "apple") ["ap" "ple"]))
    (is (= (sylsplit "entrenched") ["en" "trenched"]))))
