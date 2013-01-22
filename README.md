Twitter背景画像作成ツール
========================================

概要
----------------------------------------

楽天市場の商品画像を連結して画像を生成し、
Twitterの背景画像に設定します。

本アプリは、[楽天APIワークショップ](http://atnd.org/event/rakutenapi/0)にて
作成した作品です。

[LTスライド](http://www.slideshare.net/hirokazunishioka/rakuten-ap-iworkshop)


How to develop
----------------------------------------

```conf/application.conf```に
[楽天ウェブサービス](http://webservice.rakuten.co.jp/)の
applicationIdを、
```Procfile```にTwitterAPIの各種認証情報を記入してください。

あとは[heroku](http://www.heroku.com/)上にデプロイすると動くと思います。

また、開発のためにローカルで動かしたい場合は、
[sbt](http://www.scala-sbt.org/)をインストールし、
以下のコマンドを実行すると動きます。

```
sbt -Doauth.consumerKey=*** -Doauth.consumerSecret=*** -Doauth.accessToken=*** -Doauth.accessTokenSecret=*** run
```


注意事項
----------------------------------------

本アプリは、楽天市場の商品画像を無断で取得・加工・二次利用するものですので、
著作権等の関係で、実運用は事実上不可能かと思われます。

テスト実行する際にもその点十分にご注意ください。

