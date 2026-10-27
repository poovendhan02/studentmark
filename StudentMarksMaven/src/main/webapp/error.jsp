<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head><title>Result Error</title><style>body{font-family:Arial;background:#fff1f2;padding:40px 15px}.box{max-width:500px;margin:auto;padding:30px;background:white;border-radius:12px;text-align:center}h2{color:#b91c1c}a{color:#3949ab}</style></head>
<body><div class="box"><h2>Unable to Process Result</h2><p><c:out value="${errorMessage}"/></p><a href="${pageContext.request.contextPath}/index.jsp">Return to Form</a></div></body></html>
