; http://projecteuler.net/problem=42
; How many triangle words does the list of common English words contain?

(defn word-value [w]
  (reduce + (map #(- (int %) 64) w))
)

(defn is-triangle-number [n]
  (loop [i 1]
	(let [triangle-num (/ (* i (inc i)) 2)]
	  (cond 
	    (> triangle-num n) false
	    (= n triangle-num) true
	    :else (recur (inc i))
      )
	)
  )
)

(defn is-triangle-word [w]
  (is-triangle-number (word-value w))
)

(def words
  (seq (.split (.replaceAll (slurp "http://projecteuler.net/project/words.txt") "\"" "") ","))
)

(def euler42
  (count (filter is-triangle-word words))
)

(println euler42)