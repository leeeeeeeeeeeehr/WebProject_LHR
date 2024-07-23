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
    <main id="container" class="edit_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="board_edit edit_area">
          <h2 class="question">Q&A</h2>
<form name="editqnaFrm" method="post" enctype="multipart/form-data"
      action="../HS/edit-qna.do" onsubmit="return validateForm(this);">
<input type="hidden" name="num" value="${ qnadto.num }" />
<table class="edit_form">
    <tr class="line">
        <td class="column">작성자</td>
        <td><input class="user" type="text" value="${ sessionScope.userId }" readonly /></td>
    </tr>
    <tr class="line">
        <td class="column">제목</td>
        <td><input type="text" name="title" value="${ qnadto.title }" /></td>
    </tr>
    <tr class="line">
        <td class="column">내용</td>
        <td><textarea name="content">${ qnadto.content }</textarea></td>
    </tr>
</table>    
              <div class="etc_area">
                <li>
                  <input type="hidden" name="edit" value="true" />
                  <input class="complete_btn" type="submit" value="수정하기" />
                </li>
                <li>
                  <button class="complete_btn" type="reset">리셋하기</button>
                </li>
                <li>
                  <button class="complete_btn" onclick="location.href='../HS/view-qna.do?num=${ param.num }';">뒤로가기</button>
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
