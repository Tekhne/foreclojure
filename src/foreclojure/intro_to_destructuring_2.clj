(ns foreclojure.core)

; Sequential destructuring allows you to bind symbols to parts of sequential
; things (vectors, lists, seqs, etc.): (let [bindings* ] exprs*) Complete the
; bindings so all let-parts evaluate to 3.

(= 3
   (let [[f xs] [+ (range 3)]] (apply f xs))
   (let [[[f xs] b] [[+ 1] 2]] (f xs b))
   (let [[f xs] [inc 2]] (f xs)))

