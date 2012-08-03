(defn primefactors 
  ([n] 
    (primefactors n 2 '()))
  ([n candidate acc]
    (cond (<= n 1) (reverse acc)
          (zero? (rem n candidate)) (recur (/ n candidate) candidate (cons candidate acc))
          :else (recur n (inc candidate) acc))))

(def euler3
  (last (primefactors 600851475143))
)

(println euler3)