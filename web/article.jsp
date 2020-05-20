<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <style type="text/css">
        fieldset {
            margin: 0 auto;
            width: 50%;
            height: 700px;
            border: 1.2px solid #7596ff;
            overflow: auto;

        }

        form:after {
            content: "";
            display: block;
            clear: both;
        }

        .username {
            font-weight: 600;
            color: dodgerblue;
        }

        textarea {
            resize: none;
            width: 96%;
            height: 55px;
            padding: 10px;
            outline: none;
            border-radius: 7px;
            border: 1px solid #7596ff;
        }

        a {
            text-decoration: none;
        }

        button {
            margin: 18px 20px 0 0;
            padding: 6px 12px;
            border: 1px solid #7596ff;
            border-radius: 8px;
            font-size: 16px;
            outline: none;
            float: right;
        }
        button:hover {
            cursor: pointer;
        }

        legend {
            margin-left: 20px;
            color: #7596ff;
            font-size: 18px;
        }

        li p:nth-child(1) {
            color: #7596ff;
        }

        hr {
            border: 1px solid #7596ff;
        }

        .errorMessage {
            color: red;
        }
    </style>
</head>
<body>
<fieldset>
    <legend>
        <p>
            欢迎您:<s:property value="#session['user'].username" default="请登录"/>&ensp;&ensp;&ensp;
            <a href="logout.action">退出登录</a>
        </p>
    </legend>
    <div class="box1">
        <p>
            <s:fielderror value="txt"/>
        <form action="article" method="post">
            <textarea rows="2" maxlength="200" name="text"></textarea>
            <button type="submit">添加留言</button>
        </form>
        </p>
        <ul>
            <s:iterator value="#session['articles']" var="text">
                <li>
                    <p class="username"><s:property value="#text.username"/></p>
                    <p><s:property value="#text.article"/></p>
                    <p>
                        <s:date name="#text.publicTime" format="YYYY-MM-dd HH:mm:ss"/> &ensp;&ensp;
                        <s:if test="#session['user'].username == #text.username">
                            <a href="<s:url action="delete"><s:param name="id" value="#text.id"></s:param></s:url>">删除留言</a>
                        </s:if>
                    </p>
                </li>
                <hr/>
            </s:iterator>
        </ul>
    </div>
</fieldset>
</body>
</html>

