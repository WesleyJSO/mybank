(ns mybank.core
  (:use compojure.core
        ring.util.response
        ring.middleware.json)
  (:require [ring.util.response :refer [response]]
            [ring.middleware.json :refer [wrap-json-response]]
            [ring.middleware.params :refer [wrap-params]]
            [compojure.route :as route]
            [mybank.view :as view]))

(defn index [request]
  {:status 200}
  :headers {"Content-Type" "text/html"}
  :params {:teste "vaavvava"}
  :body (view/index-page))

(defroutes my_routes
  (GET "/" [] index)
  (POST "/save" {:keys [form-params]} (response form-params))
  (route/not-found "Erro página não encontrada!"))

(def app 
  (-> my_routes
      (wrap-params {:encoding "UTF-8"}) ;; allow me to get data from the request
      wrap-json-response))