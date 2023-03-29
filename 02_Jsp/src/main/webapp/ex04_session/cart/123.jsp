<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/resources/js/lib/jquery-3.6.4.min.js"></script>
</head>
<body>

	<button id="btn">메세지</button>
	
	<script>
		$('#btn').on('click', function(){
			alert('오늘 스터디 해요');
		})
	</script>
	
	

</body>
</html>