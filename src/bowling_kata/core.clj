(ns bowling-kata.core)


(defn score-roll [roll]
  (case roll
      ("-" "F") 0
      "/" 10
      "X" 10
      roll))


(defn spare-frame? [frame]
  (= "/" (second (:rolls frame))))


(defn strike-frame? [frame]
  (= "X" (first (:rolls frame))))


(defn mark-frame? [frame]
  (or (spare-frame? frame)
      (strike-frame? frame)))


(def open-frame? (complement mark-frame?))


(defn score-frame-alone [frame]
  (if (not (spare-frame? frame))
    (apply + (map score-roll (:rolls frame)))
    (score-roll (second (:rolls frame)))))


(defn frame [game frame-number]
  (get game frame-number))


(defn bonus-pins [game frame-number])


(defn score-frame [game frame-number]
  (let [frame-to-score (frame game frame-number)
        frame-score (score-frame-alone frame-number)]
    (cond
      (open-frame? frame-to-score) frame-score
      (mark-frame? frame-to-score) (+ frame-score (bonus-pins game frame-number)))))


(defn score-game [game]
  (apply + (map #(score-frame game %) (range 1 (inc 10)))))
