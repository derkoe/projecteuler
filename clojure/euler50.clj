; Project Euler - Problem 50
; Which prime, below one-million, can be written as the sum of the most consecutive primes?

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

(def primes-below-one-million (take-while #(< % 1000000) primes))

; (defn prime-sum-elements [p]
  ; (defn f [n primes-rest]
    ; (cond 
      ; (n 0)
      
    ; )
  ; )
  ; (loop [n 0
         ; sum 0
         ; elements #{}]
    ; (cond 
      ; (= sum p) elements
      ; (> sum p) nil
      ; :else (recur (inc n) (+ sum ) )
    ; )
  ; )
; )

(def euler50
  nil
)

(println (take 21 primes))
(println (reduce + (take 21 (drop 3 primes))))