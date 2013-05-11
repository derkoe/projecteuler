; http://projecteuler.net/problem=98
; Investigating words, and their anagrams, which can represent square numbers.

(defn word-value [w]
  (reduce + (map #(- (int %) 64) w))
)

(defn anagrams? [w1 w2]
  (= (sort (seq w1)) (sort (seq w2)))
)

(defn find-anagrams [word words]
  (for [w words
        :when (anagrams? word w)]
    w
  )
)

(defn get-words []
  (seq (.split (.replaceAll (slurp "http://projecteuler.net/project/words.txt") "\"" "") ","))
)

(def words (memoize get-words))

(def anagrams (distinct (filter #(> (count %) 1) (map #(find-anagrams % (words)) (words)))))

(println anagrams)