(ns geoffrey.controllers.channel
  (:require [geoffrey.diplomat.http-out :as http-out]
            [geoffrey.schemata.channel :as schema.channel]
            [schema.core :as s]))

(def ^:private channel-bookmarks
  {:pinned-messages "channels/?/pins"
   :channel "channels/?"
   :channel-invites "channels/?/invites"
   :pin-message "channels/?/pins/?"
   :trigger-typing "channels/?/typing"
   :create-message "channels/?/messages"})

(s/defn get-pinned-messages [channel-id :- s/Str]
  (http-out/discord-get (channel-bookmarks :pinned-messages) channel-id))

(s/defn get-channel [channel-id :- s/Str]
  (http-out/discord-get (channel-bookmarks :channel) channel-id))

(s/defn create-channel-invite [channel-id :- s/Str 
                               payload :- schema.channel/channel-invite])

