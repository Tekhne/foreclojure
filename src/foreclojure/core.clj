(ns foreclojure.core)

; Debugging macro. Prints out forms and results.
(defmacro dbg [x] `(let [x# ~x] (println '~x "=" x#) x#))
