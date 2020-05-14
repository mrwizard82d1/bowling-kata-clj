(ns bowling-kata.core)


(defn score-roll [score]
  (case score
    ("-" "F") 0
    score))


(defn score-rolls [rolls]
  (when (and (first rolls) (second rolls))
    (apply + (map score-roll rolls))))


(defn score-frame [frame-number game]
  (when-let [rolls (get-in game [frame-number :rolls])]
    (score-rolls rolls)))
