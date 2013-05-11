; http://projecteuler.net/problem=40
; Finding the nth digit of the fractional part of the irrational number.

(def euler40
  (loop [n 1
         digitcount 0
         digits [1 1]]
    (let [numstr (str n)
          numstrlen (count numstr)
          nextdigitcount (+ digitcount numstrlen)]
      (cond
        (> nextdigitcount 1100000) digits
        (and (<= digitcount 1000000) (> nextdigitcount 1000000)) (recur (inc n) nextdigitcount (conj digits (get numstr (- nextdigitcount 1000000))))
        (and (<= digitcount 100000) (> nextdigitcount 100000)) (recur (inc n) nextdigitcount (conj digits (get numstr (- nextdigitcount 100000))))
        (and (<= digitcount 10000) (> nextdigitcount 10000)) (recur (inc n) nextdigitcount (conj digits (get numstr (- nextdigitcount 10000))))
        (and (<= digitcount 1000) (> nextdigitcount 1000)) (recur (inc n) nextdigitcount (conj digits (get numstr (- nextdigitcount 1000))))
        (and (<= digitcount 100) (> nextdigitcount 100)) (recur (inc n) nextdigitcount (conj digits (get numstr (- nextdigitcount 100))))
        :else (recur (inc n) nextdigitcount digits)
      )
    )
  )
)

(println euler40)