<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/common_head.jsp" %>

<script>
function validateForm(form) {
    if (form.title.value == "") {
        alert("제목을 입력하세요.");
        form.title.focus();
        return false;
    }
    if (form.content.value == "") {
        alert("내용을 입력하세요.");
        form.content.focus();
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
    
    <main id="container" class="write_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="board_write write_area">
         	 <h2>게시글 작성</h2>
<form name="writefileFrm" method="post" enctype="multipart/form-data"
      action="../HS/write-file.do" onsubmit="return validateForm(this);">
<table class="write_form">
    <tr class="line">
        <td class="column">작성자</td>
        <td><input type="text" value="${ sessionScope.userId }" readonly /></td>
    </tr>
    <tr class="line">
        <td class="column">제목</td>
        <td><input type="text" name="title" /></td>
    </tr>
    <tr class="line">
        <td class="column">내용</td>
        <td><textarea name="content"></textarea></td>
    </tr>
    <tr class="line">
        <td class="column">첨부 파일</td>
        <td><input type="file" name="ofile" /></td>
    </tr>
</table>    
          
              <div class="etc_area">
                <li>
                  <input type="hidden" name="write" value="true" />
                  <input class="complete_btn" type="submit" value="등록하기" />
                </li>
                <li>
                  <a class="cancel_btn" href="../HS/list-file.do">뒤로가기</a>
                </li>
             </div>
</form>
            </div>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../include/body_footer.jsp" %>
  </div>
</body>
</html>
