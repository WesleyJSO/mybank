(ns mybank.view
  (:use hiccup.page hiccup.element hiccup.form)
  (:require [garden.core :refer [css]]
            [mybank.data :as data]))

(def pagestyle
  [[:*
    {:font "700 18px Verdana, Geneva, sans-serif"}
    {:color "#dedede"}
    {:margin "0"}
    {:padding "0"}
    {:outline "0"}
    {:box-sizing "border-box"}]
   [:body
    {:-webkit-font-smothing "antialiased"}
    {:background-color "#282828"}
    {:text-align "center"}]
   [:.container
    {:width "100%"}
    {:max-width "1180px"}
    {:padding "96px"}
    {:margin "32px auto"}]
   [:input :button
    {:border-radius "4px"}
    {:margin-top "16px"}
    {:width "100%"}
    {:height "40px"}]
   [:input
    {:background-color "#373737"}
    {:padding "0 16px"}
    {:border "0px"}]
   [:button 
    [:&:hover {:filter "brightness(85%)"}]
    {:cursor "pointer"}
    {:background "#8a05be"}
    {:border "0"}
    {:color "#FFF"}
    {:display "inline-block"}
    {:transition "filter 0.2s"}]
   [:.form-container
    {:width "31%"}]
   [:div
    {:padding "10px"}]
   [:.description 
    {:font-size "30px"}]
   [:.info
    {:font-size "14px"}]
   [:ul
    {:display "grid"}
    {:list-style "none"}
    {:grid-gap "24px"}
    {:grid-template-columns "repeat(3, 1fr)"}]
   [:.card
    [:&:hover {:filter "brightness(105%)"} {:box-shadow "0px 4px 8px 3px #171717"}]
    {:cursor "pointer"}
    {:height "200px"}
    {:width "100%"}
    {:border-radius "4px"}
    {:background-color "#373737"}
    {:transition "filter 0.2s"}
    {:box-shadow "0px 2px 5px 1px #171717"}]])

(defn items [title desc]
  [:li
   [:div.card
    [:div [:label.description (last title)]]
    [:div [:label.info (last desc)]]]])

(defn index-page []#{}
  (html5
   [:html 
    [:head
     [:meta {:charset "UTF-8"}]]
     [:style (css pagestyle)]
    [:body 
     [:div.container
      [:ul
       (map #(items (first %) (second %)) (data/all))]
      (form-to [:post "/save"]
               [:div.form-container
                [:input#test {:placeholder "Insira o valor" :name "test"}]
                [:button "Salvar"]])]]]))

