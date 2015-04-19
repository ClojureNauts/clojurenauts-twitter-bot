(ns bot.tweet
  (:use [environ.core :only [env]]
        [bot.shorten :only [shorten]]
        [twitter.oauth]
        [twitter.api.restful]))

(def ^:dynamic *app-consumer-key* (env :consumer-key))
(def ^:dynamic *app-consumer-secret* (env :consumer-secret))
(def ^:dynamic *user-access-token* (env :access-token))
(def ^:dynamic *user-access-token-secret* (env :access-token-secret))

(def ^:dynamic *credentials* (make-oauth-creds *app-consumer-key*
                                               *app-consumer-secret*
                                               *user-access-token*
                                               *user-access-token-secret*))
(defn tweet [message]
  "tweets a message, shortening the message if it is over 140 characters"
  (let [shortened-message (shorten message)]
    (statuses-update :oauth-creds *credentials* :params {:status shortened-message})))
