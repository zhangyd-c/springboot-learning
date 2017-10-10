<!DOCTYPE html>
<html lang="en">
<head>
    <title>SpringBoot - validator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
</head>
<body>
<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
<div class="body">
    <form action="/saveUser" method="post">
        <table>
            <tbody>
            <tr>
                <td>姓名</td>
                <td><input type="text" name="username" value="${user.username?if_exists}"></td>
            </tr>
            <tr>
                <td>性别</td>
                <td><input type="text" name="gender" value="${user.gender?if_exists}"></td>
            </tr>
            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" value="${user.age?if_exists}"></td>
            </tr>
            <tr>
                <td>生日</td>
                <td><input type="text" name="birthday" value="${user.birthday?if_exists}"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" value="${user.email?if_exists}"></td>
            </tr>
            <tr>
                <td>网址</td>
                <td><input type="text" name="url" value="${user.url?if_exists}"></td>
            </tr>

            <tr>
                <td>身份证</td>
                <td><input type="text" name="idcard" value="${other.idcard?if_exists}"></td>
            </tr>

            <tr>
                <td>手机</td>
                <td><input type="text" name="phone" value="${other.phone?if_exists}"></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="提交"></td>
            </tr>
            </tbody>
        </table>
    </form>

    <div style="background-color: #F1F1F1;width: 80%;height: 200px">
        user: ${user?if_exists}
        <br>
        other: ${other?if_exists}
        <br>
    <#if errorList?exists>
        <ul>
            <#list errorList as error>
                <li>${error.field}-${error.message}</li>
            </#list>
        </ul>
    </#if>
    </div>
</div>
</body>
</html>
