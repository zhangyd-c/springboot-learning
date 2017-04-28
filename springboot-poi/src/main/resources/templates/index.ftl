<!DOCTYPE html>
<html lang="en">
<head>
<title>SpringBoot + Freemarker</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="https://cdn.bootcss.com/bootstrap/3.3.4/css/bootstrap.min.css" rel="stylesheet">
<style type="text/css">
	.container-header {
	    padding-bottom: 1.25rem;
	    margin-bottom: 2rem;
	    border-bottom: .05rem solid #eee;
	}
	.container-title {
	    margin-bottom: 5px;
	    font-size: 3rem;
	    font-weight: normal;
	}
	.container-description {
	    font-size: 2rem;
	    color: #999;
	}
	.container-help {
	    font-size: 1.5rem;
	    color: red;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="container-header">
	        <h1 class="container-title">绩效考核</h1>
	        <#assign month = (.now?string('MM'))>
			<#if (month?number > 1 && month?number &lt;= 3)>
				<#assign quarter = '四'>
			<#elseif (month?number > 3 && month?number &lt;= 6)>
				<#assign quarter = '一'>
			<#elseif (month?number > 6 && month?number &lt;= 9)>
				<#assign quarter = '二'>
			<#else>
				<#assign quarter = '三'>
			</#if>
	        <p class="container-description"><strong>${.now?string('yyyy年')}第${quarter }季度</strong>产研技术岗绩效考核</p>
	        <div class="container-help">
				<ul>
					<li>在文本域(<code>textarea</code>)中使用回车键进行<code>换行</code>并默认<code>缩进</code>四个空格，<span class="label label-warning">不可删除</span></li>
					<li>在文本域(<code>textarea</code>)中使用组合键(<code>Alt + s</code>)进行<code>缩进</code>(自动添加四个空格，<span class="label label-warning">不可删除</span>)</li>
				</ul>
			</div>
	    </div>
		<form class="form-horizontal" action="/build" method="post">
			<div class="form-group">
				<label for="date" class="col-sm-2 control-label">当前时间</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="date" value="${.now?string('yyyy年MM月dd日')}" readonly>
					<input type="hidden" name="year" value="${.now?string('yyyy')}">
					<input type="hidden" name="month" value="${month}">
					<input type="hidden" name="day" value="${.now?string('dd')}">
					<input type="hidden" name="quarter" value="${quarter}">
				</div>
			</div>
			<div class="form-group">
				<label for="company" class="col-sm-2 control-label">公司</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="company" name="company" value="${company }" readonly>
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-2 control-label">名字</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="name" name="name" placeholder="输入名字" maxlength="3" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="depart" class="col-sm-2 control-label">部门</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="depart" name="depart" placeholder="输入所属部门" maxlength="5" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="position" class="col-sm-2 control-label">职位</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="position" name="position" placeholder="输入职位" maxlength="7" required="required">
				</div>
			</div>
			<div class="form-group">
				<label for="jobContent" class="col-sm-2 control-label">工作职责</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="jobContent" name="jobContent" placeholder="输入个人工作职责" required="required"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="performance" class="col-sm-2 control-label">个人业绩</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="performance" name="performance" placeholder="输入个人业绩和效率情况" required="required"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="power" class="col-sm-2 control-label">能力情况</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="power" name="power" placeholder="输入个人专业技能和职业能力发展情况" required="required"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="learnSituation" class="col-sm-2 control-label">学习情况</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="learnSituation" name="learnSituation" placeholder="输入个人学习情况" required="required"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="suggestion" class="col-sm-2 control-label">对公司建议</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" id="suggestion" name="suggestion" placeholder="输入对公司的建议"></textarea>
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-success">生成</button>
				</div>
			</div>
		</form>
	</div>

	<script src="https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	<script type="text/javascript">
	$(function(){
		$(document).keydown(function(event){ 
			/* var keyCode = event.keyCode || event.which || event.charCode;
	        var ctrlKey = event.altKey || event.metaKey;
	        if(ctrlKey && keyCode == 83) {
	            alert('save');
	        } */
		});
		$("textarea").keydown(function(event){  
			var $this = $(this);
			var value = $this.val();
			var keyCode = event.keyCode || event.which || event.charCode;
	        var ctrlKey = event.altKey || event.metaKey;
		    // 按回车键
		    if(keyCode == 13){  
		    	value = value + "\r    ";
		    	$this.val(value);
		    	event.preventDefault();
		    }
		    // 按alt + s组合键
		    if(ctrlKey && keyCode == 83) {
		    	value = value + "    ";   
		    	$this.val(value);
		    	event.preventDefault();
		    }  
		});  
	});
	</script>
</body>
</html>
