<#include "main-template.ftl"/>

<#macro m_body>
<div class="col-lg-6 col-lg-offset-3">
    <textarea id="js-tweet-text" class="form-control" rows="3" title="tweet"></textarea>
    <input type="submit" id="js-sendtweet">
</div>

<#list tweets as tweet>
<p><a href="tweets/${tweet.id}">${tweet.text}</a></p>
<p>${tweet.createdAt} by <a href="/users/${tweet.user.id}">${tweet.user.username}</a></p>
<hr>
</#list>

<a href="tweets/pages/1">First</a>
<a href="tweets/pages/${currentIndex - 1}">Prev</a>
<a href="tweets/pages/${currentIndex + 1}">Next</a>
<a href="tweets/pages/${endIndex}">Last</a>

</div>

</#macro>

<@main title="Главная" customScripts=["resources/js/tweet.js"]/>


