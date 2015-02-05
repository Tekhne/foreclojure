(ns foreclojure.core)

;; Enter a value which satisfies the following:

;; (let [x __]
;;     (and (= (class x) x) x))

(let [x java.lang.Class]
  (and (= (class x) x) x))
