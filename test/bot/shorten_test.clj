(ns bot.shorten-test
  (:require [clojure.test :refer :all])
  (:require [bot.shorten :refer :all]))

(deftest shorten-test
  (testing "shorten not cap lines that fit"
    (is (= (shorten "0"          10) "0"))
    (is (= (shorten "01"         10) "01"))
    (is (= (shorten "012"        10) "012"))
    (is (= (shorten "0123"       10) "0123"))
    (is (= (shorten "01234"      10) "01234"))
    (is (= (shorten "012345"     10) "012345"))
    (is (= (shorten "0123456"    10) "0123456"))
    (is (= (shorten "01234567"   10) "01234567"))
    (is (= (shorten "012345678"  10) "012345678"))
    (is (= (shorten "0123456789" 10) "0123456789")))
  (testing "shorten cap lines that exceed limit"
    (is (= (shorten "0123456789a" 10) "0123456..."))
    (is (= (shorten "0123456789a"  9) "012345..."))
    (is (= (shorten "0123456789a"  8) "01234..."))
    (is (= (shorten "0123456789a"  7) "0123..."))
    (is (= (shorten "0123456789a"  6) "012..."))
    (is (= (shorten "0123456789a"  5) "01..."))
    (is (= (shorten "0123456789a"  4) "0..."))
    (is (= (shorten "0123456789a"  3) "..."))
    (is (= (shorten "0123456789a"  2) ".."))
    (is (= (shorten "0123456789a"  1) "."))
    (is (= (shorten "0123456789a"  0) "")))
  (testing "shorten cap lines that exceed limit with continue"
    (is (= (shorten "abcdef" 3 "->") "a->"))))
