<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Calculator</title>
</head>
<body>
<h1>Calculator</h1>
<form action="calculate" method="get">
  <input type="text" name="number1st" value="${number1st}">
  <input type="text" name="number2nd" value="${number2nd}">
  <p>
    <input type="submit" name="calculation" value="Addition(+)">
    <input type="submit" name="calculation" value="Subtraction(-)">
    <input type="submit" name="calculation" value="Multiplication(X)">
    <input type="submit" name="calculation" value="Division(/)">
  </p>
</form>
<h2>Result ${cal}: ${result}</h2>
</body>
</html>