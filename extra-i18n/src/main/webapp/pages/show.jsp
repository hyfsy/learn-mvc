<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>i18n</title>
</head>
<body>
<%--<fmt:message key="messages.username"/>--%>
<fmt:message key="language.username"/>：<input type="text" name="username"/><br/>
<fmt:message key="language.password"/>：<input type="text" name="password"/><br/>


Language:
<a href="?locale=zh_CN">中文</a>&nbsp;&nbsp;
<a href="?locale=en_US">英文</a><br/>
<%-- 此处没有值显示，不知道为什么 --%>
当前语言: ${pageContext.response.locale}<br/>
${requestScope.testAttr}
</body>
</html>