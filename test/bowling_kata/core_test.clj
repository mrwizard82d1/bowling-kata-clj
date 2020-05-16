(ns bowling-kata.core-test
  (:require [midje.sweet :refer :all]
            [bowling-kata.core :as bkc]))


(fact "canary test"
  (+ 2 2) => 4)


(fact "score roll"
    (bkc/score-roll "-") => 0
    (bkc/score-roll "F") => 0
    (bkc/score-roll 4) => 4
    (bkc/score-roll "/") => 10
    (bkc/score-roll "X") => 10)


(fact "characterize frame"
  (fact "spare frame"
    (bkc/spare-frame? {:rolls [2 "/"]}) => truthy
    (bkc/spare-frame? {:rolls ["-" "/"]}) => truthy
    (bkc/spare-frame? {:rolls ["F" "/"]}) => truthy
    (bkc/spare-frame? {:rolls [2 "-"]}) => falsey
    (bkc/spare-frame? {:rolls ["/" 2]}) => falsey
    (bkc/spare-frame? {:rolls ["/" "-"]}) => falsey
    (bkc/spare-frame? {:rolls ["/" "F"]}) => falsey)
  (fact "strike frame"
    (bkc/strike-frame? {:rolls ["X"]}) => truthy
    (bkc/strike-frame? {:rolls ["/" 2]}) => falsey
    (bkc/strike-frame? {:rolls [5 4]}) => falsey
    (bkc/strike-frame? {:rolls ["F" "X"]}) => falsey)
  (fact "mark frame"
    (bkc/mark-frame? {:rolls ["X"]}) => truthy
    (bkc/mark-frame? {:rolls [8 "/"]}) => truthy
    (bkc/mark-frame? {:rolls  [8 "-"]}) => falsey)
  (fact "open frame"
    (bkc/open-frame? {:rolls [7 2]}) => truthy
    (bkc/open-frame? {:rolls ["F" 2]}) => truthy
    (bkc/open-frame? {:rolls [2 "-"]}) => truthy
    (bkc/open-frame? {:rolls ["-" "-"]}) => truthy
    (bkc/open-frame? {:rolls ["X"]}) => falsey
    (bkc/open-frame? {:rolls [4 "/"]}) => falsey))


(fact "score frame alone"
      (bkc/score-frame-alone {:rolls ["-" "-"]}) => 0
      (bkc/score-frame-alone {:rolls ["F" 9]}) => 9
      (bkc/score-frame-alone {:rolls [4 "-"]}) => 4
      (bkc/score-frame-alone {:rolls [6 2]}) => 8
      (bkc/score-frame-alone {:rolls ["X"]}) => 10
      (bkc/score-frame-alone {:rolls [5 "/"]}) => 10)


;; (facts "correctly calculate open frames"
;;   (fact "correctly calculate frame with gutter ball"
;;     (bkc/score-frame 3 {3 {:rolls ["-" "-"]}}) => 0
;;     (bkc/score-frame 7 {7 {:rolls ["-" 3]}}) => 3
;;     (bkc/score-frame 4 {4 {:rolls [9 "-"]}}) => 9)
;;   (fact "correctly calculate frame with foul ball"
;;     (bkc/score-frame 3 {3 {:rolls ["F" "F"]}}) => 0
;;     (bkc/score-frame 7 {7 {:rolls ["F" 3]}}) => 3
;;     (bkc/score-frame 4 {4 {:rolls [9 "F"]}}) => 9)
;;   (fact "correctly calculate unmarked frame"
;;     (bkc/score-frame 2 {}) => nil
;;     (bkc/score-frame 2 {2 {}}) => nil
;;     (bkc/score-frame 2 {2 {:rolls []}}) => nil
;;     (bkc/score-frame 2 {2 {:rolls [3]}}) => nil))


(facts "correctly calculate spare frames")

(facts "correctly calculate strike frames")

(facts "correctly calculate 'future' frames")
