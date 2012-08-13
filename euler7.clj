; prime-seq taken from http://stackoverflow.com/questions/1590716/clojure-prime-numbers-lazy-sequence
(def prime-seq
  (let [primes (atom [])]
    (for [n (iterate inc 2)
             :when (not-any? #(zero? (rem n %))
                             (filter #(<= % (Math/sqrt n)) 
                                     @primes))]
         (do (swap! primes conj n)
             n))))

; then it's trivial to get the 10001st
(defn euler7 []
  (first (drop 10000 prime-seq))
)

(println (euler7))