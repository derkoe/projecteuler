(defn euler1 [n]
  (let [m (dec n)]
    (if (> m 0)
      (+  (cond 
            (= (mod m 3) 0) m
            (= (mod m 5) 0) m 
            :else 0) 
          (euler1 (dec n))
      )
      0
    )
  )
)

(println (euler1 1000))