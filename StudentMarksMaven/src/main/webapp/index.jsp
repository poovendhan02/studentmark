<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html><html><head><title>Student Marks Calculator</title><meta name="viewport" content="width=device-width, initial-scale=1">
<style>
*{box-sizing:border-box}body{font-family:Arial;background:#eef2ff;margin:0;padding:30px 15px}.box{max-width:500px;margin:30px auto;background:white;padding:30px;border-radius:15px;box-shadow:0 8px 25px #0001}h1{text-align:center;color:#263579}label{display:block;margin-top:18px;font-weight:bold}input{width:100%;padding:12px;margin-top:7px;border:1px solid #ccd2e0;border-radius:7px}button{width:100%;padding:13px;margin-top:25px;background:#3949ab;color:white;border:0;border-radius:7px;font-size:16px;cursor:pointer}
</style></head><body><div class="box"><h1>Student Marks Calculator</h1><p>Enter student details and marks for three subjects.</p>
<form action="${pageContext.request.contextPath}/calculate" method="post">
<label for="name">Student Name</label><input id="name" name="name" maxlength="100" required>
<label for="subject1">Subject 1 Marks</label><input type="number" id="subject1" name="subject1" min="0" max="100" step="1" required>
<label for="subject2">Subject 2 Marks</label><input type="number" id="subject2" name="subject2" min="0" max="100" step="1" required>
<label for="subject3">Subject 3 Marks</label><input type="number" id="subject3" name="subject3" min="0" max="100" step="1" required>
<button type="submit">Calculate Results</button></form></div></body></html>
