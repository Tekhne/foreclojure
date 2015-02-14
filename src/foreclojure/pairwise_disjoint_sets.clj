(ns foreclojure.core)

; Pairwise Disjoint Sets

; Given a set of sets, create a function which returns true if no two of those
; sets have any elements in common (such sets are usually called pairwise
; disjoint or mutually disjoint. ) and false otherwise. Some of the test cases
; are a bit tricky, so pay a little more attention to them.

; Mine:

(defn pds [sos]
  (let [ps (into #{} (for [x sos y sos :when (not= x y)] #{x y}))]
    (every? #(empty? (apply clojure.set/intersection %)) ps)))

; Other's:

#(apply distinct? (apply concat %))

; Tests:

(= (pds #{#{\U} #{\s} #{\e \R \E} #{\P \L} #{\.}})
   true)

(= (pds #{#{:a :b :c :d :e}
         #{:a :b :c :d}
         #{:a :b :c}
         #{:a :b}
         #{:a}})
   false)

(= (pds #{#{[1 2 3] [4 5]}
         #{[1 2] [3 4 5]}
         #{[1] [2] 3 4 5}
         #{1 2 [3 4] [5]}})
   true)

(= (pds #{#{'a 'b}
         #{'c 'd 'e}
         #{'f 'g 'h 'i}
         #{''a ''c ''f}})
   true)

(= (pds #{#{'(:x :y :z) '(:x :y) '(:z) '()}
         #{#{:x :y :z} #{:x :y} #{:z} #{}}
         #{'[:x :y :z] [:x :y] [:z] [] {}}})
   false)

(= (pds #{#{(= "true") false}
         #{:yes :no}
         #{(class 1) 0}
         #{(symbol "true") 'false}
         #{(keyword "yes") ::no}
         #{(class '1) (int \0)}})
   false)

(= (pds #{#{distinct?}
         #{#(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}
         #{#(-> %) #(-> %) #(-> %)}})
   true)

(= (pds #{#{(#(-> *)) + (quote mapcat) #_ nil}
         #{'+ '* mapcat (comment mapcat)}
         #{(do) set contains? nil?}
         #{, , , #_, , empty?}})
   false)
