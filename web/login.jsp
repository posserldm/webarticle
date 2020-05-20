<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        body {
            padding-top: 55px;
        }

        fieldset {
            margin: 0 auto;
            width: 50%;
            height: 300px;
            border: 1px solid #7596ff;
        }

        table {
            margin: 50px auto;
            color: #7596ff;
        }

        a {
            text-decoration: none;
            color: black;
        }

        h2 {
            color: #7596ff;
        }

        input {
            padding: 6px;
            margin-bottom: 10px;
            border: 1px solid #7596ff;
            border-radius: 5px;
        }

        button {
            margin: 20px 20px 0 0;
            padding: 6px 12px;
            border: 1px solid #7596ff;
            border-radius: 8px;
            outline: none;
        }
        button:hover {
            cursor: pointer;
        }

        legend {
            margin-left: 20px;
            color: #7596ff;
            font-size: 18px;
        }

        .errorMessage {
            color: red;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>欢迎登录留言版</legend>
    <form action="login.action" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:fielderror fieldName="existError"/>
                    <s:fielderror fieldName="username"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                </td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;码:</td>
                <td><input type="password" name="passwd"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:fielderror fieldName="passwdError"/>
                    <s:fielderror fieldName="passwd"/>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit">登录</button>&ensp;&ensp;
                    <button type="button"><a href="register.jsp">注册</a></button>
                </td>
            </tr>

        </table>
    </form>
</fieldset>
</body>
</html>
