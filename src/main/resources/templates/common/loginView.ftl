<html>
<head>
	<meta charset="utf-8">
	<title>卖家管理系统后台</title>
	<link rel="stylesheet" href="/sell/css/style.css">
	<link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>


<div class="container login" style="margin-top:100px;">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<div class="col-md-12 column"><h1>卖家后台管理系统</h1></div>
			<form class="form-horizontal">
				<div class="form-group">
					<label for="inputPhone3" class="col-sm-2 control-label">手机号</label>
					<div class="col-sm-6">
						<input type="number" class="form-control inputname" id="inputPhone3"
							   name="username"
							   title="提示"
							   data-container="body"
							   data-toggle="popover" data-placement="top"
							   data-content="请输入11位手机号"/>
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
					<div class="col-sm-6">
						<input type="password" name="password" class="form-control"
							   id="inputPassword3"/>
					</div>
				</div>

			</form>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-default" id="loginBtn">登录</button>
				</div>
			</div>
		</div>
	</div>
</div>

</body>
<!-- JavaScript -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<#--自动机定义的本地js请求-->
<script src="../../js/login.js" th:src="@{/js/login.js}"></script>
</html>