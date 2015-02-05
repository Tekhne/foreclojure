(ns foreclojure.core)

; Write a function which takes a collection of integers as an argument. Return
; the count of how many elements are smaller than the sum of their squared
; component digits. For example: 10 is larger than 1 squared plus 0 squared;
; whereas 15 is smaller than 1 squared plus 5 squared.

; (= 8 (__ (range 10)))

; (= 19 (__ (range 30)))

; (= 50 (__ (range 100)))

; (= 50 (__ (range 1000)))

; Mine:

(defn sum-square-digits [xs]
  (count
   (filter
    (fn [x] (< x
               (reduce (fn [acc i] (+ acc (* i i)))
                       0
                       (map (fn [s] (Integer. s))
                            (rest (clojure.string/split  (str x) #""))))))
    xs)))


;; Other's:

(fn [xs]
  (count
   (filter
    (fn [x] (< x (reduce + (map #(* % %) (map (comp read-string str) (str x))))))
    xs)))
