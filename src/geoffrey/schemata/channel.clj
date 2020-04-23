(ns geoffrey.schemata.channel
  (:require [schema.core :as s]))

(def ^:private channel-invite-skeleton
  {(s/optional-key :max_age)   s/Int
   (s/optional-key :max_uses)  s/Int
   (s/optional-key :temporary) s/Bool
   (s/optional-key :unique)    s/Bool
   (s/required-key :target_user?) s/Str})

(s/defschema channel-invite channel-invite-skeleton)

(def ^:private message-skeleton
  {(s/required-key :content) s/Str
   (s/optional-key :tts) s/Bool
   (s/optional-key :embed) {(s/required-key :title)       s/Str
                            (s/required-key :description) s/Str}})

(s/defschema message message-skeleton)