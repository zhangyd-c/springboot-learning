<!DOCTYPE html> 
<html lang="en"> 
<head> 
	<title>SpringBoot -- 负载均衡与session同步</title> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> 
	<style type="text/css">
	/*<![CDATA[*/
	tr {
	    text-align: center;
	    COLOR: #0076C8;
	    BACKGROUND-COLOR: #F4FAFF;
	}
	/*]]>*/
	</style>
	<script src="//cdn.bootcss.com/angular.js/1.5.6/angular.min.js"></script>
	<script type="text/javascript">
	    /*<![CDATA[*/
	    var app = angular.module('app', []);
	    app.controller('RenderController', function($rootScope, $scope, $http) {
	
	        $scope.value = 'springboot';
	
	        $scope.setSession = function() {
	            $http({
	                url : '/setSession?value=' + $scope.value,
	                method : 'POST'
	            });
	        }
	
	        $scope.getSession = function() {
	            $http({
	                url : '/getSession',
	                method : 'POST'
	            }).success(function(r) {
	                $scope.sesssionId = r.id
	                $scope.sesssion = r.value
	                $scope.port = r.port
	            });
	        }
	    });
	
	    /*]]>*/
	</script>
</head> 
<body ng-app="app" ng-controller="RenderController">
    <h1>参考原文：<a href="http://www.cnblogs.com/GoodHelper/p/6263240.html" target="_blank">玩转spring boot——负载均衡与session同步</a></h1>
    <input type="text" ng-model="value" />
    <input type="button" value="设置" ng-click="setSession()" />
    <br />
    <input type="button" value="获取" ng-click="getSession()" />
    <br />
    <h3>结果：</h3>
    <table cellspacing="1" style="background-color: #a0c6e5">
        <thead>
            <tr>
                <td>属性</td>
                <td>值</td>
            </tr>
        </thead>
        <tr>
            <td>session id</td>
            <td>{{sesssionId}}</td>
        </tr>
        <tr>
            <td>session值</td>
            <td>{{sesssion}}</td>
        </tr>
        <tr>
            <td>本地端口</td>
            <td>{{port}}</td>
        </tr>
    </table>
</body>
</html>
