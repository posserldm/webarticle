<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="utf-8">
  <title></title>
  <style>

    body {
      padding-top: 55px;
      outline: none;
    }
    fieldset{
      margin: 0 auto;
      width: 50%;
      height: 300px;
      border: 1.2px solid #7596ff;
    }
    table {
      margin: 17px auto;
      color: #7596ff;
    }
    button {
      margin: 40px 20px 0 0;
      padding: 6px 12px;
      color: black;
      border: 1px solid #7596ff;
      border-radius: 8px;
      font-size: 18px;
      outline: none;
    }
    a {
      text-decoration: none;
      color: black;
    }
    legend {
      margin-left: 20px;
      color: #7596ff;
      font-size: 18px;
    }
  </style>
</head>
<body>
<fieldset>
  <legend>欢迎您的畅所欲言</legend>
  <table>
    <th colspan="2"><h1>欢迎来到留言版的欢迎页</h1></th>
    <tr>
      <td align="right"><button type="button"><a href="login.jsp">登录</a></button></td>
      <td align="left"><button type="button"><a href="register.jsp">注册</a></button></td>
    </tr>
  </table>
</fieldset>
</body>
</html>
