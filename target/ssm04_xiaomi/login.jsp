<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>" />
    <meta charset="UTF-8">
    <title>小米商城登录</title>
    <link rel="stylesheet" href="css/login.css">
    <link rel="stylesheet" href="js/bootstrap-3.3.7-dist/css/bootstrap.min.css">
</head>
<body>
    <div id="container">
        <header>
            <!-- 1140x98 -->
            <img src="images/loginlogo.png" alt="">
        </header>
        <div id="loginbox">
            <!-- 100% 588 -->
            <div id="mainbox">
                <div id="maintitle">
                    <div id="account">帐号登录</div>
                    <span></span>
                    <div id="saoma">扫码登录</div>
                </div>
                <div id="maininput">
                    <input type="text" name="username" id="username" placeholder="邮箱/手机号码/小米ID">
                    <span id="error-username">填写邮箱、手机号码或者小米ID登录</span>
                    <input type="password" name="password" id="password" placeholder="密码">
                    <span id="error-password">密码不能为空</span>
                    <input type="submit" id="login-btn" value="登录">
                </div>
                <div id="mainother">
                    <div>手机短信登录/注册</div>
                    <div>立即注册| 忘记密码？</div>
                </div>
                <div id="otherlogin">
                    <div id="oth_title">
                    </div>
                    <div id="oth_desc">
                        其他方式登录
                    </div>
                    <div id="oth_logo">
                        <a href="#"><em></em></a>
                        <a href="#"><em></em></a>
                        <a href="#"><em></em></a>
                        <a href="#"><em></em></a>
                    </div>
                </div>
            </div>
        </div>
        <footer>
            <!-- 100% 180 p100 -->
            <a href="#">简体</a>| <a href="#">繁体</a>| <a href="#">English</a>| <a href="#">常见问题</a>| <a href="#">隐私政策</a>
            <br />
            <p>小米公司版权所有-京ICP备10046444-<img src="images/ghs.png" alt="">京公网安备11010802020134号-京ICP证110507号</p>
        </footer>
    </div>
    <script type="text/javascript" src="js/jquery/jquery-3.4.1.js"></script>
    <script>
        $(function () {
            $("#login-btn").click(function () {
                var username = $("#username").val();
                var password = $("#password").val();
                console.log("点击了登录按钮!用户名:"+username+",密码:"+password);
                $.ajax({
                    url:"/consumer/login/auth",
                    data:{
                        username:username,
                        password:password,
                    },
                    dataType: "json",
                    type:"POST",
                    success:function (data) {
                        console.log("请求发送成功");
                        console.log(data);
                        if(data.code === 400){
                            console.log("登录失败");
                            $("#error-username").text("账户或者密码错误,请重新登录").css({"color":"red"})
                        }else{
                            alert("登录成功");
                            window.location = "index.jsp";
                        }
                    },
                    error:function () {
                        console.log("请求发送失败");

                    }
                })
            })
        })
    </script>
</body>
</html>