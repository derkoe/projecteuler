;;; A bit slow but it works ...

(defn are-all-divisible? [^long number
                          ^long max]
  (or
    (< max 2)
    (and 
  	  (= 0 (mod number max))
  	  (are-all-divisible? number (dec max))
    )
  )
)

(defn euler4 []
  (first
    (drop-while #(not (are-all-divisible? % 20)) (rest (range)))
  )
)

(println (euler4))