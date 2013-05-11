; Project Euler - Problem 23
; Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.

(defn factors [num]
  (if (= 1 num) 
    #{1}
    (loop [n 2
           fset #{1 num}]
      (if (= (mod num n) 0)
        (if (contains? fset n)
          fset
          (recur (inc n) (conj fset n))
        )
        (recur (inc n) fset)
      )
    )
  )
)

; I use factors from problem 12 and remove the number itself (maybe I could've done it the other way round)
(defn proper-divisors [n]
  (disj (factors n) n)
)

(defn is-abundant? [n] 
  (> (reduce + (proper-divisors n)) n)
)

(def abundant-nums
  (filter is-abundant? (rest (range)))
)

(defn cannot-be-written-as-as-sum-abundant-nums? [n]
  nil
)

(def euler23
  (reduce + (filter cannot-be-written-as-as-sum-abundant-nums? (range 1 28124)))
)

(println (take 50 abundant-nums))