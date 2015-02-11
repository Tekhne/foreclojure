(ns foreclojure.core)

; Beauty is Symmetry

; Let us define a binary tree as "symmetric" if the left half of the tree is
; the mirror image of the right half of the tree. Write a predicate to
; determine whether or not a given binary tree is symmetric. (see To Tree, or
; not to Tree for a reminder on the tree representation we're using).

(defn stree? [[_ l r]]
  (= (map first (tree-seq #(not (nil? %)) #(rest %) l))
     (map first (tree-seq #(not (nil? %)) #(reverse (rest %)) r))))

(= (stree? '(:a (:b nil nil) (:b nil nil))) true)

(= (stree? '(:a (:b nil nil) nil)) false)

(= (stree? '(:a (:b nil nil) (:c nil nil))) false)

(= (stree? [1
            [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)

(= (stree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

(= (stree? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
            [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)

