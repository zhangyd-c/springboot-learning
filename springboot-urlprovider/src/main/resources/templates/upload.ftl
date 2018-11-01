<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.0.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="${urls.getForLookupPath('/css/jquery-confirm.min.css') }" rel="stylesheet" type="text/css" />
</head>
<body>
	<form id="submitForm" enctype="multipart/form-data">
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
		<button type="button" id="submitBtn">提交</button>
	</form>
</body>
<script type="text/javascript" src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="${urls.getForLookupPath('/js/jquery-confirm.min.js') }"></script>
<script type="text/javascript" src="${urls.getForLookupPath('/js/jquery-form.js') }"></script>
<script type="text/javascript" src="${urls.getForLookupPath('/js/jquery.js') }"></script>
<script type="text/javascript">
$("#submitBtn").click(function(){
    var url = "/upload";
    var data = {
        name:"1233"
    };
    $("#submitForm").ajaxSubmit({
        type: "POST",
        url: url,
        data: data,
        success: function(msg){
        	$.alert(msg);
        },
        error: function(msg){
            $.alert("error.异常了！");
        }
    });
});

</script>
</html>