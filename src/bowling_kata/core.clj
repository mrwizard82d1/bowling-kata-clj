(ns bowling-kata.core)


(defn score-mapper [score]
  (case score
    ("-" "F") 0
    score))


(defn pinfall [frame]
  (when (and (first frame) (second frame))
    (apply + (map score-mapper frame))))


(defn score-frame [frame-number game]
  (when-let [rolls (get-in game [frame-number :rolls])]
    (pinfall rolls)))
