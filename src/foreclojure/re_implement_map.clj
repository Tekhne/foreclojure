(ns foreclojure.core)

;; Re-implement Map

;; Map is one of the core elements of a functional programming
;; language. Given a function f and an input sequence s, return a lazy
;; sequence of (f x) for each element x in s.

;; Special Restrictions
;; map
;; map-indexed
;; mapcat
;; for

;; (= [3 4 5 6 7]
;;    (__ inc [2 3 4 5 6]))

;; (= (repeat 10 nil)
;;    (__ (fn [_] nil) (range 10)))

;; (= [1000000 1000001]
;;    (->> (__ inc (range))
;;         (drop (dec 1000000))
;;                 (take 2)))

;; Mine;

(defn new-map [f s]
  (if (seq s)
    (cons (f (first s)) (lazy-seq (new-map f (rest s))))
    s))

;; Other's:

(fn [f x] (rest (reductions #(f %2) nil x)))
