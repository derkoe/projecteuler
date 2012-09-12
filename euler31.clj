; http://projecteuler.net/problem=31
; With English coins 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
; How many different ways can £2 be made using any number of coins?

; (defn euler31
  ; ([] (cons [200] (euler31 [200])))
  ; ([lst]
    ; (if (= (filter #(= 1 %) lst) lst)
      ; nil
      ; (let [cur (replace {200 [100 100], 100 [50 50], 50 [20 20 10], 20 [10 10], 10 [5 5], 5 [2 2 1], 2 [1 1]} lst)]
        ; (cons cur (euler31 cur))
      ; )
    ; )
  ; )
; )

(def euler31
  (loop [res [[200]]
         cur [200]]
    (if (= (filter #(= 1 %) cur) cur)
      nil
      (let [newcur (flatten (replace {200 [100 100], 100 [50 50], 50 [20 20 10], 20 [10 10], 10 [5 5], 5 [2 2 1], 2 [1 1]} cur))]
        (do (println newcur) (recur (cons newcur res) newcur))
      )
    )
  )
)

(println euler31)