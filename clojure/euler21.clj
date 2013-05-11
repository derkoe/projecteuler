; Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
; If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
; For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284. The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
; Evaluate the sum of all the amicable numbers under 10000.

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

; the d function is the sum of the proper divisors
(def d #(reduce + (proper-divisors %)))

(def dmem (memoize d))

(defn is-amicable-number? [n]
  (let [dn (dmem n)]
    (and (not= n dn) (= n (dmem dn)))
  )
)

(def amicable-numbers 
  (filter is-amicable-number? (drop 2 (range)))
)

(def euler21
  (reduce + (take-while #(< % 10000) amicable-numbers))
)

(println euler21)
