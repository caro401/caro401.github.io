(defn nav
  [build-url]
  (let [links [[(build-url "/")      "Home"]
               [(build-url "/about") "About"]
               [(build-url "/tags")  "Tags"]
               ["https://github.com/caro401/caro401.github.io" "GitHub"]]]
    [:nav.nav
     (for [l links]
         [:a.nav-links-item {:href (first l)}
          [:span (second l)]])]))