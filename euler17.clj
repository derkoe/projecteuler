; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

(defn digit-text [n]
  (case n
    0 "zero"
    1 "one"
	2 "two"
	3 "three"
	4 "four"
	5 "five"
	6 "six"
	7 "seven"
	8 "eight"
	9 "nine"
  )
)

(defn number-text [n]
  (cond 
    (< n 10) (digit-text n)
	(< n 100) "nope"
	(< n 1000) (reduce str (cons (digit-text (quot n 100)) (cons " hundred and " (number-text (rem n 100)))))
	:else "no way"
  )
)

(println (number-text 304))