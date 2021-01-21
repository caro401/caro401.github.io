(defn- render-backlinks
  [backlinks-ul]
  (when (some? backlinks-ul) ; SCI doesn't have when-some :(
    (list ; https://purelyfunctional.tv/mini-guide/hiccup-tips/
      [:hr]
      [:h2.firn-backlinks "Backlinks"]
      backlinks-ul)))


(defn default
  [{:keys [title render partials date-created date-updated build-url] :as config}]
  (let [{:keys [head nav]} partials
        backlinks (render :backlinks)]
    [:html
     (head config)
     [:body
      (nav build-url)
      [:main
       [:article.content
        [:h1 title]
          [:p.frontmatter
           (when date-created (str "Created: " date-created " "))
           (when (and date-updated (not (= date-updated date-created)))
            (str "Last updated: " date-updated))]
       (render :file)
      (render-backlinks backlinks)]]]]))
