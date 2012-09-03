; http://projecteuler.net/problem=15
; How many routes are there through a 20x20 grid?

(defn factorial [n]
  (reduce *' (range 1 (inc n)))
)

(defn binomial [n k]
  (/ (factorial n) (*' (factorial k) (factorial (- n k))))
)

(def euler15
  (binomial 40 20)
)

(println (str euler15))
