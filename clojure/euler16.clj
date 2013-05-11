; 2^15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
; What is the sum of the digits of the number 2^1000?

(defn exp [n m]
  (reduce *' (repeat m n))
)

(defn digit-sum [n] (reduce + (map #(Character/getNumericValue %) (str n))))

(def euler16
  (digit-sum (exp 2 1000))
)

(println euler16)