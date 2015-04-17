(ns bot.shorten)

(defn shorten
  ([sentence]
   "Caps sentence to 140 characters"
   (shorten sentence 140))
  ([sentence limit]
   "Caps sentence to limit characters"
   (shorten sentence limit "..."))
  ([sentence limit continue]
   "Caps sentence to limit characters ending with continue"
   (cond
     (> (count continue) limit) (subs continue 0 limit)
     (> (count sentence) limit) (str (subs sentence 0 (- limit (count continue))) continue)
     :else sentence)))
