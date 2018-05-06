<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>$.get()/$.post()方法</title>
<style type="text/css">
.centent{
margin:0 auto;
color:red;
text-align:center;
width:600px;
height:300px;
border:2px solid red;
background-color:black;
font-family: "Microsoft YaHei";
}
.tit{
border-bottom:2px solid red;
padding:5px 0px;
font-size:20px;
font-weight: 400;
}
table{
width:100%;
background-color:black;
}
</style>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	/*jquery对AJAX的支持-->jquery的$.get()或$.post()或$.ajax({})方法*/
	$(function(){
		setInterval(quoto,4000);
	})
	/* function quoto(){
		$.post("quoto.do",function(data){
			//data代表服务器返回的数据，如果是json字符串，会自动转换成相应的javascript对象
			//清除内容*
			$(".roll").empty();
			for(var i=0;i<data.length;i++){
				var s=data[i];
				$(".roll").append(
				'<tr><td>'+s.code+'</td>'+
				'<td>'+s.name+'</td><td>'+s.price+'</td></tr>'
				);
			}
		},"json");//返回字符串格式
	} */
	function quoto(){
		$.ajax({
			url:"quoto.do",//请求路径名
			type:"post",//请求的类型
			dataType:"json",//服务端返回的数据类型
			//请求成功回调函数
			success:function(data){
				$(".roll").empty();
				for(var i=0;i<data.length;i++){
					var s=data[i];
					$(".roll").append(
					'<tr><td>'+s.code+"</td><td>"+s.name+
					'</td><td>'+s.price+'</td></tr>'
					);
				}
			},
			error:function(){
				//请求失败回调函数
			}
		});
	}
</script>
</head>
<body>
	<div class="centent">
		<div class="tit">股票实时详情</div>
		<table>
			<thead>
				<tr>
					<td>代码</td>
					<td>名称</td>
					<td>价格</td>
				</tr>
			</thead>
			<tbody class="roll">

			</tbody>
		</table>
	</div>
</body>
</html>