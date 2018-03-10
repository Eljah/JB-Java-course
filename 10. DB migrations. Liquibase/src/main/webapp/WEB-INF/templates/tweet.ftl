<#include "main-template.ftl"/>

<#macro m_body>
<script>
    var userId = ${tweet.user.id}
    var tweetId = ${tweet.id}
</script>
<h3>${tweet.user.username}</h3>

<p>${tweet.text}</p>

<p>${tweet.createdAt}</p>

<div class="col-lg-6 col-lg-offset-3">
    <textarea id="js-comment-text" class="form-control" rows="3" title="comment"></textarea>
    <input type="submit" id="js-sendcomment">
</div>

<div id="js-comments">

</div>

</#macro>

<@main title="${tweet.user.username}" customScripts=["resources/js/comment.js"]/>