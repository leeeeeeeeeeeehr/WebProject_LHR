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
          <h2>※ 게시물 수정 시 첨부할 파일이 있으면 재업로드 해주세요.</h2>
<form name="editfileFrm" method="post" enctype="multipart/form-data"
      action="../HS/edit-file.do" onsubmit="return validateForm(this);">
<input type="hidden" name="num" value="${ filedto.num }" />
<input type="hidden" name="prevOfile" value="${ filedto.ofile }" />
<input type="hidden" name="prevSfile" value="${ filedto.sfile }" />
<table class="edit_form">
    <tr class="line">
        <td class="column">작성자</td>
        <td><input type="text" value="${ sessionScope.userId }" readonly /></td>
    </tr>
    <tr class="line">
        <td class="column">제목</td>
        <td><input type="text" name="title" value="${ filedto.title }" /></td>
    </tr>
    <tr class="line">
        <td class="column">내용</td>
        <td><textarea name="content">${ filedto.content }</textarea></td>
    </tr>
    <tr class="line">
        <td class="column">첨부 파일</td>
        <td><input type="file" name="ofile" /></td>
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
                  <button class="complete_btn" onclick="location.href='../HS/view-file.do?num=${ param.num }';">뒤로가기</button>
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
