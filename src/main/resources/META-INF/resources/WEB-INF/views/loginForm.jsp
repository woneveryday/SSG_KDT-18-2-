<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인홈페이지</title>
<style type="text/css">
	 .App {
	  text-align: center;
	  font-size: 20px;
	}
 
    label, input, button {
    margin: 10px;
    padding: 5px;
    }

	footer {
	    bottom: 0;
	    position: absolute;
	    width: 90%;
	    height: 40px;
	}
 </style>
 <link href="webjars/bootstrap/5.3.3/css/bootstrap.min.css"  rel="stylesheet" >
</head>
<body>
 <div class="App">
	  <!-- header 보여주기 -->
	 	<jsp:include page="common/header.jsp" />
	 
	    <!-- content 보여주기 -->
	 	<jsp:include page="member/loginForm.jsp" />
 </div>
</body>
</html>