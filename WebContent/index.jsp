<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Guestbook</title>
</head>
<body bgcolor="#8AE68A">
<p align=center>A very fancy guestbook</p>
<form action="ShowEntries">
<p align=center><input type="submit" value="show entries" /></p>
</form>
<form action="InsertEntry">
<p align=center>name: <input type="text" name="login" /></p>
<p align=center>message: <input type="text" name="message" /></p>
<p align=center><input type="submit" value="insert your entry" /></p>
</form>
</body>
</html>