<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

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
	if (form.user_email.value == '') {
		alert('이메일 입력해주세요.');
		form.user_email.focus();
		return false;
	}
	if (form.user_name.value == '') {
		alert('이름을 입력해주세요.');
		form.user_name.focus();
		return false;
	}
	if (form.user_phone.value == '') {
		alert('전화번호를 입력해주세요.');
		form.user_phone.focus();
		return false;
	}
}
</script>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../Project_HS/include/body_header_sub.jsp" %>
    <main id="contaniner" class="regist_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="regist_area">
            <h2>회원가입</h2>
<form action="../HS/regist.do" method="post" name="registForm" onsubmit="return validate(this);">
  <fieldset>
    <legend>회원가입</legend>
    <div class="row input_wrap1">
      <input type="text" name="user_id" placeholder="아이디">
    </div>
    <div class="row input_wrap2">
      <input type="text" name="user_pwd" placeholder="비밀번호">
    </div>
    <div class="row input_wrap3">
      <input type="text" name="user_name" placeholder="이름">
    </div>
    <div class="row input_wrap4">
      <input type="text" name="user_email" placeholder="이메일">
    </div>
    <div class="row input_wrap5">
      <input type="text" name="user_phone" placeholder="전화번호">
    </div>
    <input class="complete_btn" type="submit" value="가입 완료" />
  </fieldset>
</form>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../Project_HS/include/body_footer.jsp" %>
  </div>
</body>

</html>
