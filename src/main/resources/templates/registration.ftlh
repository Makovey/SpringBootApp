<#import "parts/common.ftlh" as c>
<#import "parts/login.ftlh" as l>

<@c.page>
    <h1>Registration</h1>
    ${message!}
    <@l.login "/registration" />
    <a href="/login">Login</a>
</@c.page>