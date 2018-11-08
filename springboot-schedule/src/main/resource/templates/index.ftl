<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>动态修改cron</title>
</head>
<body>

<div>
    <input type="text" name="cron" id="cron" value="0/2 * * * * ?" title="cron">
    <button type="button" id="submitBtn">提交</button>

    <dl id="parserBox">
        <dt>最近5次运行的时间</dt>
    </dl>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script>
    $(function () {
        $("#submitBtn").click(function () {
            var cron = $("#cron").val();
            $.post("/updateTask", {cron: cron});
            $.getJSON("/parseCron?cron=" + encodeURIComponent(cron), function (rs) {
                var html = '';
                $.each(rs, function (i, v) {
                    html += '<dd>' + v + '</dd>';
                });
                var $parserBox = $("#parserBox");
                $parserBox.children("dd").remove();
                $parserBox.append(html);
            })
        });
    })
</script>
</body>
</html>