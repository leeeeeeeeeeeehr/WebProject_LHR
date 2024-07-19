<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../Project_HS/include/body_header_sub.jsp" %>
    <main id="container" class="view_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="board_view">
            <table border="1">
              <tr>
                <td>번호</td>
                <td>000</td>
                <td>작성자</td>
                <td>XXX</td>
              </tr>
              <tr>
                <td>작성일</td>
                <td>2024.07.15</td>
                <td>조회수</td>
                <td>00</td>
              </tr>
              <tr>
                <td>제목</td>
                <td colspan="3">제목입니다~</td>
              </tr>
              <tr>
                <td>내용</td>
                <td colspan="3" height="100">내용입니다~~</td>
              </tr>
              <tr>
                <td>첨부파일</td>
                <td>image.jpb</td>
                <td>다운로드 수</td>
                <td>00</td>
              </tr>
              <tr>
                <td>
                  <a class="edit_btn" href="../HS/edit.do">수정하기</a>
                  <a class="delete_btn" href="#">삭제하기</a>
                  <a class="list_btn" href="../HS/list.do">목록 바로가기</a>
                </td>
              </tr>
            </table>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../Project_HS/include/body_footer.jsp" %>
  </div>
</body>

</html>
