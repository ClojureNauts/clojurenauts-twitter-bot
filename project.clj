(defproject bot "1.0.0-SNAPSHOT"
  :description "A bot that will tweet on behave of @ClojureNauts."
  :url "https://github.com/ClojureNauts/clojurenauts-twitter-bot"
  :license {:name "The MIT License (MIT)"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [environ "0.5.0"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "clojurenauts-twitter-bot.jar"
  :profiles {:uberjar {:aot :all} :production {:env {:production true}}}
  :main ^:skip-aot bot.core
  :target-path "target/%s")
