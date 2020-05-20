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
            border: 1.2px solid #7596ff;
        }

        table {
            margin: 45px auto;
            color: #7596ff;
        }

        th {
            text-align: center;
        }

        h2 {
            color: #7596ff;
        }

        input {
            padding: 6px;
            margin-bottom: 9px;
            border: 1px solid #7596ff;
            border-radius: 5px;
        }

        .last {
            margin: 20px 20px 0 0;
            padding: 6px 12px;
            border: 1px solid #7596ff;
            border-radius: 8px;
            outline: none;
        }
        a {
            text-decoration: none;
            color: black;
            display: inline-block;
        }

        .last {
            margin-top: 7px;
            padding: 7px 14px;
            border: 1px solid #7596ff;
            border-radius: 8px;
            outline: none;
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
    <legend>欢迎注册留言版</legend>
    <form action="register.action" method="post">
        <table>
            <tr>
                <td>用户名:</td>
                <td><input type="text" name="username" maxlength="25"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:fielderror fieldName="username"/>
                    <s:fielderror fieldName="nameError"/>
                </td>
            </tr>
            <tr>
                <td>密&nbsp;&nbsp;&nbsp;码:</td>
                <td><input type="password" name="passwd" maxlength="25"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:fielderror fieldName="passwd"/>
                </td>
            </tr>
            <tr>
                <td>确认密码:</td>
                <td><input type="password" name="repasswd"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <s:fielderror fieldName="passwdError"/>
                </td>
            </tr>
            <tr>
                <td align="center">
                    <button class="last" type="submit">注册</button>
                </td>
                <td align="center">
                    <button class="last" type="button"><a href="index.jsp">返回</a></button>
                </td>
            </tr>
        </table>
    </form>
</fieldset>
</body>
</html>
