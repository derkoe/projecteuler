(defn sum-square [nums]
  (apply + (map #(* % %) nums))
)

(defn square-sum [nums]
  (let [sum (apply + nums)]
	(* sum sum)
  )
)

(defn euler6 [num]
  (let [nums (range (inc num))]
	(- (square-sum nums) (sum-square nums))
  )
)

(println (euler6 100))