<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>${param.title }</title> <!-- input form은 request. 으로 받고 param으로 들어온 건 param으로 받음 -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

<!-- DB에 저장이 잘 되었다면 alert창 띄우기 -->
<c:if test="${not empty msg }">
	<script type="text/javascript">
		alert('${msg}');
	</script>
</c:if>

</head>
<body>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>

	<header>
		<br>
		<h1 align="center">${param.title }</h1>
		<br><br>
		<nav class="navbar navbar-expand-lg bg-light">
		  <div class="container-fluid">
		    <a class="navbar-brand" href="#">
		    	<img src="${pageContext.request.contextPath}/resources/img/spring.png" alt="spring" width="50" height="35">
		    </a>
		    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
		      <span class="navbar-toggler-icon"></span>
		    </button>
		    <div class="collapse navbar-collapse" id="navbarSupportedContent">
		      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
		        <li class="nav-item">
		          <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }">Home</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="${pageContext.request.contextPath }/board/boardList.bo">게시판</a>
		        </li>
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
		            Demo
		          </a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/demo/devForm.do">Demo등록</a></li>
		            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/demo/devList.do">Demo목록</a></li>
		          </ul>
		        </li>
		      </ul>
		      <%-- <button class="btn btn-outline-success" type="button" onclick="location.href='${pageContext.request.contextPath}/member/memberLogin.me'">로그인</button>&nbsp;--%>
		      																						<!-- 경로 이렇게 설정하면 get방식이 됨 -->

		    <!-- 로그인이 되어있지 않으면 로그인창 -->
		      <c:if test="${empty loginMember }">
		      	<button class="btn btn-outline-success" type="button" 
		      		data-bs-toggle="modal" data-bs-target="#loginModal">로그인</button>&nbsp;
		      	<!-- 토글은 한 번 눌렀으면 보여지고 다시 누르면 안 보이는 기능인데 모달 창에서 버튼을 누르면 다른 모달창으로 넘어갈 수 있게 구현한 것임 -->																
		      	<button class="btn btn-outline-success" type="button"
		      		onclick="location.href='${pageContext.request.contextPath}/member/memberEnroll.me'">회원가입</button>
		      	<!-- onclikc locatio.href으로 했으니 get방식이 됨 -->
		      </c:if>
		      
		      <!-- 로그인이 되었으면 -->
		      <c:if test="${not empty loginMember }">
		      	<a href="${pageContext.request.contextPath }/member/memberDetail.me">${loginMember.userName }님 로그인 되었습니다</a>&emsp;
		      	<button class="btn btn-outline-success" type="button"
		      		onclick="location.href='${pageContext.request.contextPath}/member/memberLogout.me'">로그아웃</button>
		      </c:if> 
		    </div>
		  </div>
		</nav>
		
		<!-- 로그인 모달창 -->
		<div class="modal" tabindex="-1" id="loginModal">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title">로그인</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      
		      <form action="${pageContext.request.contextPath }/member/memberLogin.me" method="post">
			      <div class="modal-body">
					<div class="mb-3 row">
						<label for="name" class="col-sm-2 col-form-label">ID</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" name="userId" required>
						</div>
					</div>
						<div class="mb-3 row">
							<label for="career" class="col-sm-2 col-form-label">PW</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" name="userPwd" required>
							</div>
						</div>
			      </div>
			      
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
		        <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">로그인</button>
		      </div>
		      </form>
		    </div>
		  </div>
		</div>
	</header>
	<section>

</body>
</html>