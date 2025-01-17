<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../include/body_header_sub.jsp" %>
    <main id="contaniner" class="logout_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="logout_area sub_area">
<form action="../HS/islogin.do" method="get">
   <fieldset>
		${ sessionScope.userName }님, 안녕하세요.
		<input type="hidden" name="logout" value="true" />
		<button class="logout_btn" type="submit">로그아웃</button>
   </fieldset>          	
</form>
          </div>
          <div class="etc_area">
          	<li>
			<c:if test="${ sessionScope.userId != null }">
          		<a class="modify_acc" href="../HS/modify.do">회원정보 수정</a>
	        </c:if>
          	</li>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../include/body_footer.jsp" %>
  </div>
</body>

</html>
