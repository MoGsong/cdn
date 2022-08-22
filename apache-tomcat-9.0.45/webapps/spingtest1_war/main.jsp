
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
  <title>Title</title>
  <script src="<%=basePath%>jQuery3.6.js"></script>
  <script>
    $(document).ready(function(){
      $("#name").blur(function(){
        var name = $("#name").val();
        $.ajax({
          async:	true,			//默认为true，即请求为异步请求
          timeout:5000,			//设置请求超时时间（毫秒）
          dataType:"json",		//返回的数据类型
          type:	"post",			//设置请求方式
          url:	"zzz",		//设置请求URL
          data:	"name="+name,	//设置传递的参数值
          success:function(msg){		//设置响应成功之后执行的回调函数
            //alert(msg.result);
            if(msg.result) {
              $("#msg").text("<p style='color: red'>已存在，不可用</p>");
            }else {
              $("#msg").text("可用");
            }
          },
          error:function(){		//设置响应失败之后执行的回调函数
            alert("失败喽");
          }
        });
      });
    });
  </script>
</head>
<body>
菜单名称：<input type="text" textfield="name" id="name" /> <span id="msg"></span><br/>
<input type="button" id="btn" value="确定">
</body>
</html>
