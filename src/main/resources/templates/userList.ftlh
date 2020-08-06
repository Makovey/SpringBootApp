<#import "parts/common.ftlh" as c>

<@c.page>
    <h2>List of Users</h2>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Role</th>
            <th>Command</th>
        </tr>
        </thead>
        <tbody>
        <#list users as user>
        </tbody>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">Edit</a></td>
        </tr>
        </#list>
    </table>
</@c.page>