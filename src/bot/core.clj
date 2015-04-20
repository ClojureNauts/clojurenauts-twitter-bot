(ns bot.core
  (:use [bot.web :only [app]]
        [environ.core :only [env]]
        [compojure.handler :only [site]])
  (:require [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn -main [& [port]]
  "respond to requests"
  (let [port (Integer. (or port (env :port) 5000))]
    (jetty/run-jetty (site #'app) {:port port :join? false})))

;; For interactive development:
;; (.stop server)
;; (def server (-main))
