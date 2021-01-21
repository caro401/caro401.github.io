(defn index
  [{:keys [render partials build-url] :as config}]
  (let [{:keys [head nav]} partials]
    [:html
     (head config)
     [:body
      (nav build-url)
      [:main
        [:article.content
          [:h1 "Caro does code"]
          [:p "and sometimes writes about it: "]
          (render :sitemap {:sort-by :newest})]]]]))