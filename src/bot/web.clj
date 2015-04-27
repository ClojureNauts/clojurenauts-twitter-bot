(ns bot.web
  (:require [compojure.core :refer [defroutes GET PUT POST DELETE ANY]]
            [compojure.route :as route]
            [clojure.java.io :as io]
            [clojure.tools.logging :as log]
            [bot.tweet :as twitter]))

(defn splash []
  {:status 200
   :headers {"Content-Type" "text/plain"}
   :body (pr-str ["Hello" :from 'ClojureNauts])})

(defn webhook [request]
  "handles POST request from GitHub webhooks"
  (do
    (log/info "Received request" request)
    (twitter/tweet "GitHub informed me something changed over at https://github.com/ClojureNauts")
    {:status 200
       :headers {"Content-Type" "text/plain"}
       :body "OK"}))

(defroutes app
  (GET "/" []
       (splash))
  (POST "/" request
        (webhook request))
  (ANY "*" []
       (route/not-found (slurp (io/resource "404.html")))))
