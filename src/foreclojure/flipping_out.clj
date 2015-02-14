(ns foreclojure.core)

; Flipping out

; Write a higher-order function which flips the order of the arguments of an
; input function.

(defn flip [f] (fn [& xs] (apply f (reverse xs))))

(= 3 ((flip nth) 2 [1 2 3 4 5]))

(= true ((flip >) 7 8))

(= 4 ((flip quot) 2 8))

(= [1 2 3] ((flip take) [1 2 3 4 5] 3))
