<!DOCTYPE html> 
<html lang="en">
<head>
	<title>SpringBoot + Freemarker</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>Hello boy,</h1><br>
	<p>当前时间：${.now?string("yyyy-MM-dd HH:mm:ss.sss")}</p>
	<div class="body">
		<h2>Eclipse中如何打开ftl文件？</h2>
		<ul>
			<li>
				打开eclipse，点击window菜单，选择preferences，如图，搜索<code>File Association</code>：
				<br>
				<img src="/img/1.png">
			</li>
			<li>
				点击file types 右边的add按钮，出现如下图的对话框，输入*.ftl，如图
				<br>
				<img src="/img/2.png">
			</li>
			<li>
				选中file types列表中新加的*.ftl然后点击下方Associated editors右边的add按钮，出现文件关联类型，选择JSP Editor
				<br>
				<img src="/img/3.png">
			</li>
			<li>
				搜索content Types 选中Text-JSP-JSP Fragment按下路添加
				<br>
				<img src="/img/4.png">
			</li>
			<li>
				大功告成了，重新打开ftl文件试试吧
			</li>
		</ul>
	</div>
</body>
</html>
