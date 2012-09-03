; http://projecteuler.net/problem=12
; What is the value of the first triangle number to have over five hundred divisors?

(defn factors [x]
"integer -> vector[integers]"
  (loop [xf [] i 2]
    (if (> (* i i) x)
      (vec (sort (distinct xf)))
      (if (zero? (rem x i))
        (recur (conj xf i (/ x i)) (inc i))
        (recur xf (inc i))))))

(defn count-factors [num]
  (count (factors num))
)

(def euler12
  (loop [num 29] 
    (let [triangle (reduce + (range 1 num))
          triangle-factors (count-factors triangle)]
      (if (> triangle-factors 500)
        triangle
        (recur (inc num))
      )
    )
  )
)

(println euler12)
