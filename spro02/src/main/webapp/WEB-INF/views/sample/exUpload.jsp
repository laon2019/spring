<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드</title>
</head>
<body>
<form action="/sample/exUploadPost" method="post" enctype="multipart/form-data">
	<input type="file" name="files"><br>
	<input type="file" name="files"><br>
	<input type="file" name="files"><br>
	<input type="file" name="files"><br>
	<input type="file" name="files"><br>

	<input type="submit" value="저장">

</form>

</body>
</html>