; Project Euler - Problem 9
; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
; Find the product abc.

(def tuples
  (let [uv (range 1 31)]
    (for [u uv v uv :when (> u v)] [u v])
  )
)

; Triples are built with: x = u^2-v^2, y = 2uv, z = u^2+v^2  (with u,v in N and u > v)
; https://en.wikipedia.org/wiki/Pythagorean_triple
(defn euler9 []
  (loop [t tuples]
    (let [u (first (first t)) 
          v (second (first t))]
      (let [a (- (* u u) (* v v))
            b (* 2 u v)
            c (+ (* u u) (* v v))]
        (if (= 1000 (+ a b c))
          (* a b c)
          (recur (rest t))
        ) 
      )
    )
  )
)

(println (euler9))