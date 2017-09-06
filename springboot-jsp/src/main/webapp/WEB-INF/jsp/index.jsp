<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Springboot + Jsp</title>
</head>
<body>
    ${hello}
    <p>启动方式</p>

    <ol>
        <li>spring-boot:run</li>
        <li>打包成war，通过 java -jar demo-0.0.1-SNAPSHOT.war启动</li>
    </ol>
    <p>jar包运行的时候会404错误，因为默认jsp不会被拷贝到程序包中，而war包里面有包含了jsp，所以没问题。</p>
    <p>另外springboot官方并不推荐使用jsp</p>
</body>
</html>