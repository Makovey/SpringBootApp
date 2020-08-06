<#import "parts/common.ftlh" as c>

<@c.page>
    <h2>User Editor</h2>
    <form action="/user" method="POST">
        <input type="text" name="username" value="${user.username}">
        <#list roles as role>
            <div>
                <label for="${role}"><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}</label>
            </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Save</button>
    </form>
</@c.page>