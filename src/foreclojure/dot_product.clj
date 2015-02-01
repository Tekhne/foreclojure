(ns foreclojure.core)

; Create a function that computes the dot product of two sequences. You may
; assume that the vectors will have the same length.

(defn dot-product [s1 s2] (reduce + (map * s1 s2)))

; Tests ...

(= 0 (dot-product [0 1 0] [1 0 0]))

(= 3 (dot-product [1 1 1] [1 1 1]))

(= 32 (dot-product [1 2 3] [4 5 6]))

(= 256 (dot-product [2 5 6] [100 10 1]))
