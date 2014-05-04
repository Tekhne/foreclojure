(ns foreclojure.core)

;; Least Common Multiple

;; Write a function which calculates the least common multiple. Your
;; function should accept a variable number of positive integers or
;; ratios.

;; (== (__ 2 3) 6)

;; (== (__ 5 3 7) 105)

;; (== (__ 1/3 2/5) 2)

;; (== (__ 3/4 1/6) 3/2)

;; (== (__ 7 5/7 2 3/5) 210)

;; Mine:

(defn lcm [& xs]
  (reduce
   #(/ (* %1 %2)
      (loop [a %1 b %2]
        (cond
         (= a b) a
         (> a b) (recur (- a b) b)
         :else (recur a (- b a)))))
   xs))

;; Other's:

(fn [& xs]
  (/ (apply * xs)
     (reduce #(if (zero? %2) % (recur %2 (mod % %2))) xs)))
