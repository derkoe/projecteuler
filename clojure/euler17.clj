; Project Euler - Problem 17
; If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
; If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

(defn digit-text [n]
  (case n
    0 nil
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
(defn dec-text [n]
  (case n
    10 "ten"
    11 "eleven"
    12 "twelve"
    13 "thirteen"
    14 "fourteen"
    15 "fifteen"
    16 "sixteen"
    17 "seventeen"
    18 "eighteen"
    19 "nineteen"
    (reduce str (cons
      (case (quot n 10)
        2 "twenty"
        3 "thirty"
        4 "forty"
        5 "fifty"
        6 "sixty"
        7 "seventy"
        8 "eighty"
        9 "ninety"
      )
      (digit-text (rem n 10))
      )
    )
  )
)

(defn number-text [n]
  (cond 
    (= n 0) "zero"
    (= n 1000) "onethousand"
    (< n 10) (digit-text n)
    (< n 100) (dec-text n)
    (= (rem n 100) 0) (reduce str (cons (digit-text (quot n 100)) "hundred"))
    (< n 1000) (reduce str (cons (digit-text (quot n 100)) (cons "hundredand" (number-text (rem n 100)))))
    :else "no way"
  )
)

(def euler17
  (count (mapcat number-text (range 1 1001)))
)

(println euler17)
