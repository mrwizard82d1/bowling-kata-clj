(ns bowling-kata.core-test
  (:require [midje.sweet :refer :all]
            [bowling-kata.core :as bkc]))

(fact "canary test"
  (+ 2 2) => 4)

(facts "correctly calculate open frames"
  (fact "correctly calculate frame with gutter ball"
    (bkc/score-frame 3 {3 {:rolls ["-" "-"]}}) => 0
    (bkc/score-frame 7 {7 {:rolls ["-" 3]}}) => 3
    (bkc/score-frame 4 {4 {:rolls [9 "-"]}}) => 9)
  (fact "correctly calculate frame with foul ball"
    (bkc/score-frame 3 {3 {:rolls ["F" "F"]}}) => 0
    (bkc/score-frame 7 {7 {:rolls ["F" 3]}}) => 3
    (bkc/score-frame 4 {4 {:rolls [9 "F"]}}) => 9)
  (fact "correctly calculate unmarked frame"
    (bkc/score-frame 2 {}) => nil
    (bkc/score-frame 2 {2 {}}) => nil
    (bkc/score-frame 2 {2 {:rolls []}}) => nil
    (bkc/score-frame 2 {2 {:rolls [3]}}) => nil))

(facts "correctly calculate spare frames")

(facts "correctly calculate strike frames")

(facts "correctly calculate 'future' frames")
