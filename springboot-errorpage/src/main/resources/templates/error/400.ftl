<!DOCTYPE html>
<html lang="en">
<head>
<title>${status?if_exists }</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<style type="text/css">
body {
	margin-left: 200px
}
span {
	font-size: 25px;
	font-weight: bold;
	margin-right: 10px
}
</style>
</head>
<body>
	<h1>这是400异常页面</h1>
	<br>
	<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
	<div class="body">
		<span>timestamp:</span>${timestamp?string("yyyy-MM-dd HH:mm:ss.sss") }<br>
		<span>status:</span><span style="color: red">${status?if_exists }</span><br>
		<span>error:</span>${error?if_exists }<br> <span>message:</span>${message?if_exists }<br>
		<span>path:</span>${path?if_exists }<br>
	</div>
</body>
</html>
