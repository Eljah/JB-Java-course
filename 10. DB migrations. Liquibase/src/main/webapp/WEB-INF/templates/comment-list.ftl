<#list comments as comment>
<p> ${comment.text}</p>
<hr/>
<p><a href="users/${comment.user.id}">${comment.user.username}</a></p>
</#list>