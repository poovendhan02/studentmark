<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html><html><head><title>Student Result</title><meta name="viewport" content="width=device-width, initial-scale=1">
<style>body{font-family:Arial;background:#eef2ff;padding:30px 15px}.card{max-width:500px;margin:30px auto;padding:30px;background:white;border-radius:15px;box-shadow:0 8px 25px #0001}h1{text-align:center;color:#263579}table{width:100%;border-collapse:collapse}td{padding:14px 8px;border-bottom:1px solid #ddd}td:first-child{font-weight:bold}.grade{text-align:center;font-size:24px;font-weight:bold;color:#283593;margin:25px 0}a{display:block;text-align:center;background:#3949ab;color:white;padding:13px;border-radius:7px;text-decoration:none}</style>
</head><body><div class="card"><h1>Student Result</h1><table>
<tr><td>Student Name</td><td><c:out value="${studentName}"/></td></tr>
<tr><td>Subject 1</td><td>${mark1} / 100</td></tr><tr><td>Subject 2</td><td>${mark2} / 100</td></tr><tr><td>Subject 3</td><td>${mark3} / 100</td></tr>
<tr><td>Total Marks</td><td>${total} / 300</td></tr><tr><td>Average Marks</td><td>${average}</td></tr></table>
<div class="grade">Grade: ${grade}</div><a href="${pageContext.request.contextPath}/index.jsp">Calculate Another Result</a></div></body></html>
