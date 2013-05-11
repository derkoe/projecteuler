; http://projecteuler.net/problem=48
; Find the last ten digits of the series, 1^1 + 2^2 + 3^3 + ... + 1000^1000.

(defn exp [n m]
  (reduce *' (repeat n m))
)

(def euler48
  (let [resultstr (str (reduce + (for [x (range 1 1001)] (exp x x))))]
    (subs resultstr (- (count resultstr) 10))
  )
)

(println euler48)
