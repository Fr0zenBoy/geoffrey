(ns geoffrey.diplomat.http-out
  (:require [org.httpkit.client :as http]
            [cheshire.core :refer [generate-string]]
            [clojure.string :as string]))

(def ^:private api-url "https://discordapp.com/api/v6/")

(def ^:private api-client (System/getenv "API_USER"))

(def ^:private api-token {"Authorization:" (str "Bot" (System/getenv "API_TOKEN"))})

(defn- base-url [request]
  (str api-url request))

(defn- make-url [request args]
  (cond
    (not (clojure.string/includes? request "?"))
      (base-url request)
    :else
      (recur (clojure.string/replace-first request "?" (first args)) (rest args))))

(defn discord-post [endpoint args payload]
  (http/request {:url    (make-url endpoint args)
                 :method  :post
                 :headers api-token
                 :body    (generate-string payload)}))

(defn discord-get [endpoint args]
  (http/request {:url    (make-url endpoint args)
                 :method :post
                 :headers api-token}))

(defn discord-put [endpoint args]
  (http/request {:url   (make-url endpoint args)
                 :method :put
                 :headers api-token}))