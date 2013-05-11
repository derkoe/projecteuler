; Project Euler - Problem 19
; How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?

(def euler19
  (count 
    (filter #(= java.util.Calendar/SUNDAY (.get % java.util.Calendar/DAY_OF_WEEK))
      (let [day (doto (java.util.Calendar/getInstance) (.set java.util.Calendar/DAY_OF_MONTH 1))]
        (for [year (range 1901 2001)
              month (range 0 12)]
          (.clone (doto day (.set java.util.Calendar/YEAR year) (.set java.util.Calendar/MONTH month))) ;clone is important!!
        )
      )
    )
  )
)

(println euler19)
