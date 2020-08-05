<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <div>
        <h2>LOGOUT</h2>
        <@l.logout/>
        <h2>Создать новое сообщение</h2>
        <form action="/" method="POST">
            <input type="text" name="text" placeholder="Type your message">
            <input type="text" name="tag" placeholder="Type your tag">
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Add message</button>
        </form>
    </div>
    <h2>Фильтр по тегу</h2>
    <form method="GET" action="/main">
        <input type="text" name="filter" value="${filter!}">
        <button type="submit">Find</button>
    </form>
    <h2>Список сообщений</h2>
    <#list messages as message>
        <div style="padding: 10px">
            <b>${message.id!""}</b>
            <span style="font-size: 20px">${message.text!""}</span>
            <i>${message.tag!""}</i>
            <strong>${message.authorName!""}</strong>
        </div>
    <#else>
        <p>No messages</p>
    </#list>
</@c.page>