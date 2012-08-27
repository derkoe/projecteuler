; Project Euler - Problem 30
; Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.

(defn exp [n m]
  (reduce *' (repeat m n))
)

(defn digits [n] 
  (map #(Character/getNumericValue %) (str n))
)

(def euler29
  (filter (fn [n] (= n (reduce + (map #(exp % 5) (digits n))))) (range 2 354295))
)

(println (reduce + euler29))
