; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
; Find the sum of all the primes below two million.

; primes taken from https://github.com/thattommyhall/primes/blob/master/src/primes/core.clj
(def primes
     (concat
      [2 3 5 7]
      (lazy-seq
       (let [primes-from
             (fn primes-from [n [f & r]]
               (if (some #(zero? (rem n %))
                         (take-while #(<= (* % %) n) primes))
                 (recur (+ n f) r)
                 (lazy-seq (cons n (primes-from (+ n f) r)))))
             wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2
                           6 4 6 8 4 2 4 2 4 8 6 4 6 2 4 6
                           2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
         (primes-from 11 wheel)))))

; then it's trivial to get the sum of all below 2 million
(defn euler10 []
  (reduce + (take-while #(< % 2000000) primes))
)


(println (euler10))