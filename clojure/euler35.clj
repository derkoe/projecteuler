; http://projecteuler.net/problem=35
; How many circular primes are there below one million?

(def prime-seq
  (let [primes (atom [])]
    (for [n (iterate inc 2)
             :when (not-any? #(zero? (rem n %))
                             (filter #(<= % (Math/sqrt n)) 
                                     @primes))]
         (do (swap! primes conj n)
             n)
    )
  )
)

(def primes-below
  (take-while #(< % 100) prime-seq)
)

(defn circle [n]
  (let [nstr (str n)
        nlength (count nstr)]
    (for [x (range 0 nlength)]
	  (Integer/parseInt (str (subs nstr x) (subs nstr 0 x)))
	)
  )
)

(def euler35
  (filter (fn [p] (every? #(contains? primes-below %) (circle p))) primes-below)
)

(println euler35)