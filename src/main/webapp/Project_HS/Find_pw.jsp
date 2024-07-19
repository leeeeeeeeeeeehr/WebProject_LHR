<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../Project_HS/include/body_header_sub.jsp" %>
    <main id="container" class="find_page sub_container">
      <div class="contents">
        <div class="inner">
          <!-- /Logo -->
          <h2 class="mb-2">Forgot Password? 🔒</h2>
          <p class="mb-4">Enter your email and we'll send you instructions to reset your password</p>
          <form id="formAuthentication" class="mb-3" action="../HS/main.do">
            <div class="mb-3">
              <label for="email" class="form-label">Email</label>
              <input type="text" class="form-control" id="email" name="email" placeholder="Enter your email" autofocus>
            </div>
            <button class="btn btn-primary d-grid w-100">Send Reset Link</button>
          </form>
          <div class="text-center">
            <a href="../HS/login.do" class="d-flex align-items-center justify-content-center">
              Back to login
            </a>
          </div>
        </div>
      </div>
    </main>
	<%@ include file="../Project_HS/include/body_footer.jsp" %>
  </div>
</body>

</html>
