; http://projecteuler.net/problem=12
; What is the value of the first triangle number to have over five hundred divisors?

(defn factors [num]
  (loop [n 2
         fset #{1 num}]
    (if (= (mod num n) 0)
      (if (contains? fset n)
        fset
        (recur (inc n) (conj fset n))
      )
      (recur (inc n) fset)
    )
  )
)

(defn count-factors [num]
  (count (factors num))
)

(def euler12
  (loop [num 1000] 
    (let [triangle (reduce + (range 1 num))
          triangle-factors (count-factors triangle)]
      (do (println triangle triangle-factors)
      (if (>= triangle-factors 500)
        triangle
        (recur (inc num))
      )
    ))
  )
)

(println euler12)
