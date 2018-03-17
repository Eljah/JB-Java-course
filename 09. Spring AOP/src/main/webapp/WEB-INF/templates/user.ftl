<#include "main-template.ftl"/>

<#macro m_body>

<h3>${user.username}</h3>
<h3>${user.email}</h3>
<#include "tweet-list.ftl"/>

</#macro>

<@main title="${user.username}"/>