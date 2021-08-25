(ns javierweiss.languageFuncs
  (:require [clojure.string :as s])
  (:gen-class))


(defn isVowel?
  [c]
  (let [coll (into [] (re-seq #"[aeiouy]" c))]
    (if (empty? coll)
      false
      true)))

(defn sylsplit
  "Splits words into syllables."
  [w]
  ())

(defn -main
  "Run program"
  [& args]
  (sylsplit args))


;;;;;;;;;;;;;;;;;;;;; RICH COMMENTS ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(def z "wording")

(re-matches #"[aeiou]" z)
(re-find #"[aeiou]" z)
(re-seq #"[aeiou]" z)
(isVowel? "a")
(isVowel? "b")
(isVowel? "y")

(partition-all 2 z)

(def characters (s/split z #"(?=\w+)"))
(type (s/split z #"(?=\w+)"))

(filter #(isVowel? %) (s/split z #"(?=\w+)"))

(split-with #(not (isVowel? %)) characters)

(split-with #(isVowel? %) characters)

(split-with (partial isVowel?) characters)

(partition-by #(re-seq #"[aeiou]" %)  characters)

(re-pattern #"\w{1,2}[aeiouy]??|[aeiouy]\w{1}")

(partition-by #(re-seq #"\w{1,2}[aeiouy]??|[aeiouy]\w{1}" %) characters)

(partition-by #(re-seq #"\w{1,2}[aeiouy]?" %) characters)

(re-seq #"\w{0,2}[aeiouy]\w{1,2}" z)

(re-seq #"\w{1,2}[aeiouy]\w{1,2}" "Cheatsheet")

(re-seq #"\w{1,2}[aeiouy]\w{1,3}" "Basketball")

(re-seq #"\w[aeiouy]\w{0,3}[aeiouy]" "Basketball")

(re-seq #"\w{1,2}[aeiouy]\w{1,3}" "Bulletin")

(re-seq #"\w{0,1}[aeiouy]\w" "Basketball")






(comment
  " Making a syllable algorithm:"
  " 1 . Most words have between 1 and 6 syllables (source: https://www.phonics-literacy.com/syllable-rules.html).
   We could use this information to partition the word into a maximum of six chunks.
   2. Then we should filter valid syllables. For that we need a set of functions.
     2.1. First, we should identify diphthongs. Because they always belong to a syllable or make short words monosyllabic.
     2.3. Second, we should identify combination of letters that represent a single phoneme. Namely, th, ph, gh and so on, 
shall count as one.
   3. Every syllable has at least one vowel. In English the letter y behaves like a vowel. From here the
 rule can follow that a syllable consist of a sandwich of consonant-vovel-consonant or vowel-consonant.
     3.1 If a word has only one vowel, therefore it is monosyllabic
   4. Take exceptions into account: silent vowels do not count.
   5. Compound words represent also represent a particular case.
   6. You can divide a word into two syllables if there is a consonant in the middle, for instance, o/pen ba/by.
   7. If there are two consecutive consonants split the word between the consonants
   ...There are just too many rules.")