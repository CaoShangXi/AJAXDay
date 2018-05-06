<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>jquery对AJAX的支持-->jquery的$.load()方法</title>
<style type="text/css">
table{
width:400px;
height:200px;
text-align:center;
margin:0 auto;
border-spacing: 0;
border-collapse: collapse;
}
td{
border:1px solid black;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
$(function(){
	$(".s1").click(function(){
		//获取员工id
		var eId=$(this).parent().siblings().eq(0).text();
		/*$.load()方法  */
		$(this).next().load("salary.do","eId="+eId);
	});
});
</script>
</head>
<body>
<table>
<tr>
<td>员工号</td>
<td>员工姓名:</td>
<td>&nbsp;</td>
</tr>
<tr>
<td>T001</td>
<td>张三</td>
<td><a href="javascript:;" style="text-decoration: none;" class="s1">查看工资详细</a>
<div></div>
</td>
</tr>
<tr>
<td>T002</td>
<td>李四</td>
<td><a href="javascript:;" style="text-decoration: none;" class="s1">查看工资详细</a>
<div></div>
</td>
</tr>
</table>
</body>
</html>