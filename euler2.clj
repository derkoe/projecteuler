(def fib-seq (lazy-cat [0 1] (map + (rest fib-seq) fib-seq)))

(def euler2
  (reduce + (filter even? (take-while (partial > 4000000) fib-seq)))
)

(println euler2)