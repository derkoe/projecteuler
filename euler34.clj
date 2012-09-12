; Project Euler - Problem 34
; Find the sum of all numbers which are equal to the sum of the factorial of their digits.

(defn factorial [n] 
  (reduce *' (range 1 (inc n)))
)

(defn digits [n] 
  (map #(Character/getNumericValue %) (str n))
)

(defn is-curious? [n]
  (= n (reduce + (map factorial (digits n))))
)

(def euler34
  (reduce + (filter is-curious? (range 3 999999)))
)

(println euler34)
