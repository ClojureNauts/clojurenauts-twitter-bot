(ns bot.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.route :as route]
            [clojure.java.io :as io]))

(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (pr-str ["Hello" :from 'ClojureNauts])})

(defn webhook []
  "handles POST request from GitHub webhooks"
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body "OK"})

(defroutes app
  (GET "/" []
       (splash))
  (POST "/" []
        (webhook))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))
