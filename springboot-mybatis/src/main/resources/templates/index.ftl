<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>Spring Boot 集成Mybatis 测试例子</title>
</head>
<body>
<h1>Spring Boot 集成Mybatis 测试例子</h1>
<em>${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</em>
<#if page.list?exists>
<br>
当前页共 <b>${page.list?size }</b>条记录
<table style="border: 1px solid lightgray;width: 100%">
    <#assign index = 1> <#list page.list as message>
    <tr
        <#if index%2 == 0>style="background-color: lightgray;"</#if>>
        <td>${message.id}</td>
        <td>${message.ip}</td>
        <td>${message.nickName}</td>
        <td>${message.insertTime?date}</td>
    </tr>
    <#assign index = index + 1> </#list>
    <tr>
        <td colspan="4">
            <ul>
                <#list 1..page.pages as pageNumber>
                    <li style="float: left;width: 20px;list-style: none;">
                        <a href="http://localhost:8080/${pageNumber }/${page.pageSize}"
                           style="${(currentPage == pageNumber)?string('color:red;font-size:17px;font-weight: bold;','')}">${pageNumber }</a>
                    </li>
                </#list>
            </ul>
        </td>
    </tr>
</table>
</#if>
<p>Author:Flyat</p>
</body>
</html>
