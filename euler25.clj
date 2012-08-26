; Project Euler - Problem 25
; What is the first term in the Fibonacci sequence to contain 1000 digits?

(def fib-seq (lazy-cat [1 1] (map +' (rest fib-seq) fib-seq)))

(def fib-seq-indexed (map-indexed (fn [idx itm] [(inc idx) itm]) fib-seq))

(def euler25
  (first (drop-while #(< (second %) (reduce *' (repeat 999 10))) fib-seq-indexed))
)

(println euler25)