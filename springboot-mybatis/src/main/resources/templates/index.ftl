<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Spring Boot 集成Mybatis 测试例子</title>
<style>
	a{color:black;}
</style>
</head>
<body>
	<h1>Spring Boot 集成Mybatis 测试例子</h1>
	<em>${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</em> <#if list?exists>
	<br> 
	当前页共 <b>${list?size }</b>条记录
	<table style="border: 1px solid red;width: 100%">
		<#assign index = 1> <#list list as message>
		<tr
			<#if index%2 == 0>style="color: red;"</#if>>
			<td>${message.id}</td> 
			<td>${message.ip}</td> 
			<td>${message.nickName}</td> 
			<td>${message.insertTime?date}</td> 
		</tr>
		<#assign index = index + 1> </#list>
		<tr>
			<td colspan="4">
				<ul>
					<#list 1..totalPage as pageNumber>
						<li style="float: left;width: 20px;list-style: none;">
							<a href="http://localhost:8080/${pageNumber }/${pageSize}" style="${(currentPage == pageNumber)?string('color:red;font-size:17px;font-weight: bold;','')}">${pageNumber }</a>
						</li> 
					</#list>
				</ul>
			</td>
		</tr>
	</table>
	</#if>
</body>
</html>
