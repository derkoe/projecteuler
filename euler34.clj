; Project Euler - Problem 34
; Find the sum of all numbers which are equal to the sum of the factorial of their digits.

(defn faculty [n] 
  (reduce *' (range 1 (inc n)))
)

(defn digits [n] 
  (map #(Character/getNumericValue %) (str n))
)

(defn is-curious? [n]
  (= n (reduce + (map faculty (digits n))))
)

(def euler34
  (filter is-curious? (range 3 10000)) 
)

(println euler34)
