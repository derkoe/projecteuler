; http://projecteuler.net/problem=37
; Find the sum of all eleven primes that are both truncatable from left to right and right to left.

(defn exp [n m]
  (reduce *' (repeat m n))
)

; this is cool - with using Java
(defn is-prime? [n]
  (.isProbablePrime (BigInteger/valueOf n) 5)
)

(defn right-truncatable-prime? [n]
  (cond
    (< n 2) false
    (< n 10) (is-prime? n)
    (is-prime? n) (right-truncatable-prime? (quot n 10))
    :else false
  )
)

(defn left-truncatable-prime? [n]
  (cond
    (< n 2) false
    (< n 10) (is-prime? n)
    (is-prime? n) (left-truncatable-prime? (rem n (exp 10 (dec (count (str n))))))
    :else false
  )
)

(defn truncatable-prime? [n]
  (and (right-truncatable-prime? n) (left-truncatable-prime? n))
)

(def euler37
  (reduce + (take 11 (filter truncatable-prime? (iterate #(+ 2 %) 11))))
)

(println euler37)
