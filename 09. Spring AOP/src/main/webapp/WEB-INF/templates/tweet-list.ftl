<#list tweets as tweet>
<p><a href="tweets/${tweet.id}">${tweet.text}</a></p>
<p>${tweet.createdAt} by <a href="/users/${tweet.user.id}">${tweet.user.username}</a></p>
<hr>
</#list>