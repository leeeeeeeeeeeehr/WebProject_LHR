<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../include/body_header_sub.jsp" %>
    <main id="container" class="view_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="board_view">
            <table>
              <tr>
                <td class="column">작성일</td>
                <td class="post">${ qnadto.postdate }</td>
                <td class="column">조회수</td>
                <td class="post">${ qnadto.visitCount }</td>
              </tr>
              <tr>
                <td class="column">제목</td>
                <td class="post">${ qnadto.title }</td>
                 <td class="column">작성자</td>
                <td class="post">${ qnadto.id }</td>
              </tr>
              <tr>
                <td class="column">내용</td>
                <td class="post post_content" colspan="3">${ qnadto.content }</td>
              </tr>
            </table>
			<div class="etc_area">
			<c:if test="${ sessionScope.userId != null && sessionScope.userId == qnadto.id }">
				<button type="button" onclick="location.href='../HS/edit-qna.do?num=${ param.num }';">
					수정하기
				</button>
				<button type="button" onclick="location.href='../HS/delete-qna.do?num=${ param.num }';">
				    삭제하기
				</button>
			</c:if>
				<button type="button" onclick="location.href='../HS/list-qna.do';">
				  	목록 바로가기
				</button>
			</div>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../include/body_footer.jsp" %>
  </div>
</body>

</html>
