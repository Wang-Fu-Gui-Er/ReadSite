<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>檀香小筑</title>
<link rel="shortcut icon" href="images/favicon.png">
<link rel="icon" href="images/favicon.png" type="image/x-icon">
<link type="text/css" rel="stylesheet" href="css/style.css">
  <script type="text/javascript" src="js/jquery-1.11.0.js"></script>
  <script type="text/javascript">
    $(function () {
        $("#reg").click(function () {
            var userName = $("#userName");
            var userPwd = $("#userPwd");
            var userEmail = $("#userEmail");
            var rePwd = $("#rePwd");
            if (userName.val() == "") {
                alert("用户名不能为空！");
                return false;
            } else if (userPwd.val() == ""){
                alert("密码不能为空！");
                return false;
            } else if (userEmail.val() == ""){
                alert("邮箱不能为空！");
                return false;
            } else if (rePwd.val() == ""){
                alert("确认密码不能为空！");
                return false;
            } else if (userPwd.val() != rePwd.val()){
                alert("两次密码不一致！");
                return false;
            }
        });
    })
  </script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="list_content">
  <div class="web_center">
    <div class="position fn-clear">
      <span><a href="index.jsp">首页</a> > 注册</span>
      <em>用户注册</em>
    </div>
    <div class="login_box fn-clear">

      <form action="/user?action=register" method="post" class="regform">
        <div class="inputbox fn-clear">
          <label>账号</label>
          <input type="text" class="ctext w260" name="userName"id="userName" placeholder="账号"><span>2-16位字母、数字、下划线!</span>
        </div>
        <div class="inputbox fn-clear">
          <label>邮箱</label>
          <input type="text" class="ctext w260" name="userEmail" id="userEmail" placeholder="邮箱地址"><span>请填写正确的邮箱</span>
        </div>
        <div class="inputbox fn-clear">
          <label>密码</label>
          <input type="password" class="ctext w260" name="userPwd" id="userPwd" placeholder="密码"><span>5-16位字母、数字、下划线!</span>
        </div>
        <div class="inputbox fn-clear">
          <label>确认密码</label>
          <input type="password" class="ctext w260" name="rePwd" id="rePwd" placeholder="确认您的密码">
        </div>
        <%--<div class="inputbox fn-clear">--%>
          <%--<label>验证码</label>--%>
          <%--<input type="text" class="ctext w100" name="yzm" placeholder="验证码">--%>
          <%--<img src="images/verify.jpg" class="fn-left" width="150" height="38" title="点击刷新" />--%>
        <%--</div>--%>
        <div class="inputbox butbox fn-clear">
          <button type="submit" class="cbut w272" id="reg" name="reg">立即注册</button>
        </div>
      </form>


      <div class="login_tip">
        <h5>已有帐号？ <a href="login.jsp">直接登录</a></h5>
        <dl>
          <dt>为什么要注册？</dt>
          <dd>下载与分享您认为不错的书籍</dd>
          <dd style="color: red"><font size="5"><%=request.getAttribute("regMsg")!=null?request.getAttribute("regMsg"):""%></font></dd>
        </dl>
      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
