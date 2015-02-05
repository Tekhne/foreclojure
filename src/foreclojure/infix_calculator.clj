(ns foreclojure.core)

;; Your friend Joe is always whining about Lisps using the prefix
;; notation for math. Show him how you could easily write a function
;; that does math using the infix notation. Is your favorite language
;; that flexible, Joe? Write a function that accepts a variable length
;; mathematical expression consisting of numbers and the operations +,
;; -, *, and /. Assume a simple calculator that does not do precedence
;; and instead just calculates left to right.

;; (= 7  (__ 2 + 5))

;; (= 42 (__ 38 + 48 - 2 / 2))

;; (= 8  (__ 10 / 2 - 1 * 2))

;; (= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))

;; Mine (ugly):

(defn infix [& xs]
  (loop [result 0
         f nil
         x (first xs)
         more (rest xs)]
    (cond
      (nil? x) result
      (number? x) (if f
                    (recur (f result x)
                           nil
                           (first more)
                           (rest more))
                    (recur x
                           nil
                           (first more)
                           (rest more)))
      :else (recur result
                   x
                   (first more)
                   (rest more)))))

;; Other's (nice):

;; (fn [& xs]
;;   (reduce #((first %2) %1 (last %2))
;;           (first xs)
;;           (partition 2 (rest xs))))

