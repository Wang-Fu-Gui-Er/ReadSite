<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        $("#login").click(function () {
            var userName = $("#userName");
            var userPwd = $("#userPwd");
            if (userName.val() == "") {
                alert("用户名不能为空！");
                return false;
            } else if (userPwd.val() == ""){
                alert("密码不能为空！");
                return false;
            }
        });
    });
  </script>
</head>

<body>
<jsp:include page="header.jsp"></jsp:include>

<div class="list_content">
  <div class="web_center">
    <div class="position fn-clear">
      <span><a href="index.jsp">首页</a> > 登录</span>
      <em>用户登录</em>
    </div>
    <div class="login_box fn-clear">
      <form action="/user?action=login" method="post" class="loginform">
        <div class="inputbox fn-clear">
          <label>账号</label>
          <input type="text" class="ctext w260" name="userName" id="userName" placeholder="账号">
        </div>
        <div class="inputbox fn-clear">
          <label>密码</label>
          <input type="password" class="ctext w260" name="userPwd" id="userPwd" placeholder="密码">
        </div>
        <!--<div class="inputbox fn-clear">-->
          <!--<label>验证码</label>-->
          <!--<input type="text" class="ctext w100 mr10" name="verify" placeholder="验证码" />-->
          <!--<img src="images/verify.jpg" class="fn-left" width="150" height="38" title="点击刷新" />-->
        <!--</div>-->
        <div class="inputbox butbox fn-clear">
          <button type="submit" class="cbut w272" id="login">现在登录</button>
        </div>
      </form>
      <div class="login_tip">
        <h5><a href="forget.jsp">忘记密码？</a></h5>
        <h5>没有帐号？ <a href="register.jsp">注册一个</a></h5>
        <dl>
          <dt>登录后可以？</dt>
          <dd>下载您认为不错的书籍</dd>
          <dd style="color: red"><font size="5"><%=request.getAttribute("regMsg")!=null?request.getAttribute("regMsg"):""%></font></dd>
        </dl>
      </div>
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
