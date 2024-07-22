<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/common_head.jsp" %>

<script>
function validate(form) {
	if (form.user_id.value == '') {
		alert('아이디를 입력해주세요.');
		form.user_id.focus();
		return false;
	}
	if (form.user_pwd.value == '') {
		alert('비밀번호를 입력해주세요.');
		form.user_pwd.focus();
		return false;
	}
}
</script>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../include/body_header_sub.jsp" %>
    <main id="contaniner" class="login_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="login_area sub_area">
            <h2>ID 로그인</h2>
<!-- 세션 확인 -->
${ sessionScope.userName }
<form action="../HS/login.do" method="post" name="loginForm" onsubmit="return validate(this);">
              <fieldset>
                <legend>로그인</legend>
                <div class="row input_wrap1">
<input type="text" name="user_id" placeholder="아이디">
                </div>
                <div class="row input_wrap2">
<input type="password" name="user_pwd" placeholder="비밀번호">
                </div>
<input class="login_btn" type="submit" value="로그인" />
              </fieldset>
</form>
          </div>
          <div class="etc_area">
            <li>
              <a class="find_pass" href="../HS/find.do">비밀번호 찾기</a>
            </li>
            <li>
              <a class="regist_acc" href="../HS/regist.do">회원가입</a>
            </li>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../include/body_footer.jsp" %>
  </div>
</body>

</html>
