; The following iterative sequence is defined for the set of positive integers:
; n -> n/2 (n is even)
; n -> 3n + 1 (n is odd)
;
; Using the rule above and starting with 13, we generate the following sequence:
; 13  40  20  10  5  16  8  4  2  1
; It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. 
; Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
; Which starting number, under one million, produces the longest chain?

; Elegant to use memoizeed functions
(def collatz-sequence (memoize (fn [n] 
  (if (= n 1)
    '(1)
	(cons n
      (if (even? n)
	    (collatz-sequence (quot n 2))
		(collatz-sequence (inc (* 3 n)))
      )
    )
  )
)))

; let's loop
(defn max-length-collatz-below [n]
  (loop [cur-num 1
         max-num 1
         max-length 0]
    (if (> cur-num n)
	  max-num
      (let [cur-length (count (collatz-sequence cur-num))]
	    (if (> cur-length max-length)
		  (recur (inc cur-num) cur-num cur-length)
		  (recur (inc cur-num) max-num max-length)
		)
	  )
	)
  )
)

(println (max-length-collatz-below 1000000))