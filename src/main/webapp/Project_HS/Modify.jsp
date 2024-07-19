<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

<script>
function validate(form) {
	if (form.user_id.value == '') {
		alert('변경할 아이디를 입력해주세요.');
		form.user_id.focus();
		return false;
	}
	if (form.user_pwd.value == '') {
		alert('변경할 비밀번호를 입력해주세요.');
		form.user_pwd.focus();
		return false;
	}
	if (form.user_email.value == '') {
		alert('변경할 이메일 입력해주세요.');
		form.user_email.focus();
		return false;
	}
	if (form.user_name.value == '') {
		alert('변경할 이름을 입력해주세요.');
		form.user_name.focus();
		return false;
	}
	if (form.user_phone.value == '') {
		alert('변경할 전화번호를 입력해주세요.');
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
    <main id="contaniner" class="modify_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="modify_area">
            <h2>회원정보 수정</h2>
<form action="../HS/modify.do" method="post" name="modifyForm" onsubmit="return validate(this);">
			  <fieldset>
			    <legend>회원정보 수정</legend>
		    	<div class="row input_wrap1">
<input type="text" name="user_id" value="${ sessionScope.userId }" readonly>
		    	</div>
			    <div class="row input_wrap2">
<input type="text" name="user_pwd" value="${ sessionScope.userPwd }">
			    </div>
			    <div class="row input_wrap3">
<input type="text" name="user_name" value="${ sessionScope.userName }">
			    </div>
			    <div class="row input_wrap4">
<input type="text" name="user_email" value="${ sessionScope.userEmail }">
			    </div>
			    <div class="row input_wrap5">
<input type="text" name="user_phone" value="${ sessionScope.userPhone }">
			    </div>
<input type="hidden" name="modify" value="true" />
<input class="complete_btn" type="submit" value="수정 완료" />
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
