<!DOCTYPE HTML>
<html>
<head>
    <title>WebSocket测试 | 聊天小程序</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0-beta/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <div class="col">
            <form>
                <div class="form-group">
                    <label for="comment">聊天框:</label> <textarea class="form-control" rows="5" id="text">你好啊</textarea>
                </div>
                <div class="form-group">
                    <button onclick="send()" type="button" class="btn btn-primary">发送</button>
                    <button onclick="closeWebSocket()" type="button" class="btn btn-danger">关闭</button>
                </div>
                <div>
                    <ul class="list-group" id="message"></ul>
                </div>
            </form>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">
    var websocket = null;

    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
        websocket = new WebSocket("ws://localhost:8083/websocket");
        //连接发生错误的回调方法
        websocket.onerror = function () {
            setMessageInnerHTML("与服务器连接失败...");
        };

        //连接成功建立的回调方法
        websocket.onopen = function (event) {
            setMessageInnerHTML("与服务器连接成功...");
        }

        //接收到消息的回调方法
        websocket.onmessage = function (event) {
            setMessageInnerHTML(event.data);
        }

        //连接关闭的回调方法
        websocket.onclose = function () {
            setMessageInnerHTML("已关闭当前链接");
        }

        //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
        window.onbeforeunload = function () {
            websocket.close();
        }
    } else {
        alert('Not support websocket');
    }

    //将消息显示在网页上
    function setMessageInnerHTML(innerHTML) {
        $("#message").append("<li class=\"list-group-item\">" + innerHTML + "</li>");
    }

    //关闭连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        websocket.send($("#text").val());
    }
</script>
</html>