<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<style>
	#container{width:500px; margin:auto;}
	th, td{height:30px;}
	input{width:250px;}
	.guide {display:none;}
	.ok {color:green;}
	.error {color:red;}
</style>
<jsp:include page="/WEB-INF/views/common/header.jsp">
	<jsp:param value="회원가입" name="title"/>
</jsp:include>
	<div id="container">
		<form action="${pageContext.request.contextPath}/member/memberEnroll.me" method="post" name="enrollfrm">
			<table class="table">
				<tr>
					<th scope="col">아이디</th>
					<td scope="col">
						<input name="userId" placeholder="4글자이상" id="userId" required>
						<span class="guide ok">아이디 사용가능</span>
						<span class="guide error">아이디 사용불가</span>
					</td>
				</tr>
				<tr>
					<th scope="col">비밀번호</th>
					<td scope="col">
						<input type="password" name="userPwd" placeholder="영문,특수문자 포함" required>
					</td>
				</tr>
				<tr>
					<th scope="col">비밀번호 확인</th>
					<td scope="col">
						<input type="password" name="pwdCheck" required>
					</td>
				</tr>
					<tr>
					<th scope="col">이름</th>
					<td scope="col">
						<input name="userName" placeholder="한글로 2글자 이상" required>
					</td>
				</tr>
					<tr>
					<th scope="col">이메일</th>
					<td scope="col">
						<input type="email" name="email">
					</td>
				</tr>
					<tr>
					<th scope="col">생년월일</th>
					<td scope="col">
						<input type="date" name="birthday" required>
					</td>
				</tr>
					<tr>
					<th scope="col">전화번호</th>
					<td scope="col">
						<input name="phone" placeholder="010-1234-5678">
					</td>
				</tr>
			</table>
			<button class="btn btn-outline-success" type="submit" >회원가입</button>&emsp;
			<button class="btn btn-outline-success" type="reset">초기화</button>
		</form>
	</div>
	<script type="text/javascript">
		document.querySelector("#userId").addEventListener("keyup",(e) => { //문서가 올라오면 바로 실행
			const ok = document.querySelector(".ok"); //클래스 이름이 ok인 것
			const error = document.querySelector(".error");
			const userId = e.target;
			
			if(userId.value.length < 4) {
				ok.style.display = "none";
				error.style.display = "none";
				return;
			}
			
			$.ajax({
				url : "${pageContext.request.contextPath}/member/checkId.do",
				data : {userId : userId.value},
				dataType : "json",
				success(result) {
					console.log(result);
					const {userId, available} = result; //언팩킹: 각각의 변수에 담아주는 것()
					
					if(available) {
						ok.style.display = "inline";
						error.style.display = "none";
					} else {
						ok.style.display = "none";
						error.style.display = "inline";
					}
				},
				error : console.log
			});
		}); 
	</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp" />