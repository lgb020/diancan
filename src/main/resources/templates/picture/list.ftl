<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">

	<#--边栏sidebar-->
	<#include "../common/nav.ftl">

	<#--主要内容content-->
	<div id="page-content-wrapper">
		<div class="container-fluid">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<table class="table table-bordered table-condensed">
						<thead>
						<tr>
							<th>图片id</th>
							<th>图片描述</th>
							<th>创建时间</th>
							<th>图片url</th>
							<th>操作</th>
						</tr>
						</thead>
						<tbody>

						<#list categoryList as category>
							<tr>
								<td>${category.picId}</td>
								<td>${category.picMessage}</td>
								<td>${category.picCreate}</td>
								<td>${category.picUrl}</td>
								<td><a href="/sell/picture/index?picId=${category
									.picId}">修改</a></td>
							</tr>
						</#list>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>

</div>
</body>
</html>