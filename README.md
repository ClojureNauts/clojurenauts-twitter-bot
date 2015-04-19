ClojureNauts twitter-bot [![Build Status](https://travis-ci.org/ClojureNauts/clojurenauts-twitter-bot.svg?branch=master)](https://travis-ci.org/ClojureNauts/clojurenauts-twitter-bot)
========================

A bot that will tweet on behave of [@ClojureNauts][].

Goal
----

For this project I would like to explore the following subjects

1. [Travis CI][travisci] Automatically test our code on each commit.
2. [Heroku][heroku] as a deployment platform.
3. [GitHub Webhooks][webhooks] as a source of events to tweet about.
4. [Twitter API][twitter] for the actual tweeting.


### Travis CI

> Travis CI is a hosted continuous integration service.

Travis CI is configured with a [`.travis.yml`][.travis.yml] file. See the [documentation][travis-docs] for more information.

### Heroku

> Heroku (pronounced her-OH-koo) is a cloud application platform – a new way of building and deploying web apps.

We followed the [tutorial][heroku-tutorial] and adopted it to the project.

### Twitter API

> To give everyone the power to create and share ideas and information instantly, without barriers.

The [Twitter developer documentation][twitter-docs] lists [adamwynne/twitter-api][] as Clojure [API library][twitter-api-libraries].

To use it you need to configure security tokens found at [https://dev.twitter.com/apps/](https://dev.twitter.com/apps/) in `profiles.clj`, but make sure that the actual secrets do not end up in the repo. You can tell `git` to ignore the changes with the following command

```sh
git update-index --assume-unchanged profiles.clj
```

[@ClojureNauts]: https://twitter.com/ClojureNauts
[travisci]: https://travis-ci.org/
[heroku]: https://www.heroku.com/
[webhooks]: https://developer.github.com/webhooks/
[twitter]: https://dev.twitter.com/rest/public
[.travis.yml]: https://github.com/ClojureNauts/clojurenauts-twitter-bot/blob/master/.travis.yml
[travis-docs]: http://docs.travis-ci.com/
[heroku-tutorial]: https://devcenter.heroku.com/articles/getting-started-with-clojure#introduction
[twitter-docs]: https://dev.twitter.com/overview/documentation
[adamwynne/twitter-api]: https://github.com/adamwynne/twitter-api
[twitter-api-libraries]: https://dev.twitter.com/overview/api/twitter-libraries
