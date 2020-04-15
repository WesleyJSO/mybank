(defproject mybank "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler mybank.core/app
        :auto-reload? true
        :auto-refresh? false}
  :dependencies [[org.clojure/clojure "1.10.1"]
                                  ;; in collection under :dependencies key
[com.datomic/client-pro "0.9.41" :exclusions [org.eclipse.jetty/jetty-http 
                                              org.clojure/core.async 
                                              org.eclipse.jetty/jetty-io
                                              org.clojure/tools.analyzer.jvm]]
                 [ring "1.7.1"]
                 [ring/ring-core "1.7.1"]
                 [ring/ring-devel "1.7.1"]
                 [ring/ring-jetty-adapter "1.7.1"]
                 [ring/ring-servlet "1.7.1"]
                 [ring/ring-json "0.5.0" :exclusions [ring/ring-codec
                                                      commons-codec]]
                 [hiccup "2.0.0-alpha2"]
                 [garden "1.3.9"]
                 [compojure "1.6.1"]]
  :repl-options {:init-ns mybank.core})
