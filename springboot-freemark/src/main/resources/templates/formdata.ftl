<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link href="http://cdn.bootcss.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://cdn.bootcss.com/font-awesome/4.0.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<form id="submitForm" enctype="multipart/form-data">
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
		<input type="file" name="file"> <br>
        <input type="text" name="name">
		<button type="button" id="submitBtn">提交</button>
	</form>
</body>
<script src="http://cdn.bootcss.com/jquery/1.11.1/jquery.min.js" type="text/javascript"></script>

<script type="text/javascript">
$("#submitBtn").click(function(){
    var url = "/formdata";
    var data = new FormData(document.querySelector("form"));
    console.log(data.toString());
    $.ajax({
        type: "POST",
        url: url,
        data: data,
        processData: false,  // 不处理数据
        contentType: false,   // 不设置内容类型
        success: function(msg){
            console.log('===' + msg);
        },
        error: function(msg){
            console.log('++++' + msg);
        }
    });
});

</script>
</html>