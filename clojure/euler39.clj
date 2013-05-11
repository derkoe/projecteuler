; http://projecteuler.net/problem=39
; If p is the perimeter of a right angle triangle, {a, b, c}, which value, for p = 1000, has the most solutions?

(defn gcd [a b] (if (zero? b) a (recur b (mod a b))))

(defn primitive-pythagorean-triplets-hypo-below [n]
  (for [p (take-while (fn [p] (<= (inc (* p p)) n)) (range))
        q (take-while (fn [q] (<= (+ (* p p) (* q q)) n)) (range 1 p))
        :when (and (odd? (+ p q)) (= (gcd p q) 1))]
    [(- (* p p) (* q q)) (* 2 p q) (+ (* p p) (* q q))]
  )
)

(defn pythagorean-triplets-hypo-below [n]
  (for [t (primitive-pythagorean-triplets-hypo-below n)
        k (range 1 (quot n (last t)))]
	(map #(* k %) t)
  )
)

(defn count-triples-with-sum [triplets]
  (let [sum-map (frequencies (map #(reduce + %) triplets))]
	(sort (map (fn [e] [(second e) (first e)]) sum-map))
  )
)

(def euler39
  (last (last (count-triples-with-sum (pythagorean-triplets-hypo-below 500))))
)

(println euler39)
