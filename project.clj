(defproject bot "1.0.0-SNAPSHOT"
  :description "A bot that will tweet on behave of @ClojureNauts."
  :url "https://github.com/ClojureNauts/clojurenauts-twitter-bot"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [environ "0.5.0"]
                 [twitter-api "0.7.8"]
                 [org.clojure/tools.logging "0.3.1"]
                 [org.slf4j/slf4j-log4j12 "1.7.12"]
                 [log4j/log4j "1.2.17"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "clojurenauts-twitter-bot.jar"
  :profiles {
             :uberjar {:aot :all}
             :dev {:plugins [[com.jakemccrary/lein-test-refresh "0.8.0"]]}
             :production {:env {:production true}}}
  :main ^:skip-aot bot.core
  :target-path "target/%s")
