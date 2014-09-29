(defproject om-server-render "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"

  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.clojure/core.async "0.1.267.0-0d7780-alpha"]
                 [om "0.7.3"]
                 [hiccup "1.0.5"]
                 [compojure "1.1.8"]
                 [com.cognitect/transit-cljs "0.8.158"]
                 [com.cognitect/transit-clj "0.8.229"]
                 [org.clojure/data.codec "0.1.0"]
                 [clj-http "0.9.2"]
                 [com.facebook/react "0.11.2"]]

  :plugins [[lein-cljsbuild "1.0.4-SNAPSHOT"]
            [lein-ring "0.8.11"]]

  :source-paths ["src/clj"]

  :ring {:handler om-server-render.core/app}

  :cljsbuild {
              :builds [{:id "om-server-render"
                        :source-paths ["src"]
                        :compiler {:output-to "om_server_render.js"
                                   :output-dir "out"
                                   :optimizations :simple
                                   :preamble ["react/react.min.js"]
                                   :externs ["react/externs/react.js"]}}
                       {:id "server"
                        :source-paths ["src" "cljs-server"]
                        :compiler {:output-to "server/server.js"
                                   :output-dir "server-out"
                                   :optimizations :simple
                                   :target :nodejs
                                   :preamble ["react/react.min.js"]
                                   :externs ["react/externs/react.js"]}}]})
