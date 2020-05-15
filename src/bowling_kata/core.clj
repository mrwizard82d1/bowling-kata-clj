(ns bowling-kata.core)


;; (defn score-roll [score]
;;   (case score
;;     ("-" "F") 0
;;     score))


;; (defn score-rolls [rolls])
;;   (when (and (first rolls) (second rolls))
;;     (apply + (map score-roll rolls)))


(defn score-roll [roll]
  (case roll
      ("-" "F") 0
      "/" 10
      "X" 10
      roll))
