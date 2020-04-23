(ns geoffrey.logic.time
  (:require [clj-time.local :as l]))

(defn time-now []
  (l/local-now))