(defproject bot "1.0.0-SNAPSHOT"
  :description "A bot that will tweet on behave of @ClojureNauts."
  :url "https://github.com/ClojureNauts/clojurenauts-twitter-bot"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :main ^:skip-aot bot.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
