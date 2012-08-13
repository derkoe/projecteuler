(defn ispalindromstr? [^long n]
  (let [s (str n)]
    (= (seq s) (reverse s))
  )
)

(defn ispalindromenum? [^long num]
  (loop [rev 0
         temp num]
    (if (> temp 0)
      (recur (+ (* rev 10) (mod temp 10)) (quot temp 10))
      (= rev num)
    )
  )
)

(defn euler4 [palifunc]
  (reduce max
    (for [i (range 999 0 -1) 
          j (range 999 0 -1)
          :let [num (* i j)]
          :when (palifunc num)]
      num
    )
  )
)

(println (euler4 ispalindromstr?)) ; with string based palifunc
(println (euler4 ispalindromenum?)) ; with num based palifunc
