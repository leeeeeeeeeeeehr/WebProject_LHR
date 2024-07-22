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
                <td class="column">번호</td>
                <td class="post">${ freedto.num }</td>
                <td class="column">작성자</td>
                <td class="post">${ freedto.id }</td>
              </tr>
              <tr>
                <td class="column">작성일</td>
                <td class="post">${ freedto.postdate }</td>
                <td class="column">조회수</td>
                <td class="post">${ freedto.visitCount }</td>
              </tr>
              <tr>
                <td class="column">제목</td>
                <td class="post" colspan="3">${ freedto.title }</td>
              </tr>
              <tr>
                <td class="column">내용</td>
                <td class="post post_content" colspan="3">${ freedto.content }</td>
              </tr>
              <tr>
                <td class="column">첨부파일</td>
                <td class="post">
               	<c:choose>
               		<c:when test="${ empty freedto.ofile }">
               			첨부된 파일이 없습니다.
               		</c:when>
               		<c:otherwise>
	                	<c:if test="${ not empty freedto.ofile }">
       		        		${ freedto.ofile }
               				<a href="../HS/download.do?ofile=${ freedto.ofile }&sfile=${ freedto.sfile }&num=${ freedto.num }">[다운로드]</a>
               			</c:if>
               		</c:otherwise>
               	</c:choose>
                </td>
                <td class="column">다운로드 수</td>
                <td class="post">${ freedto.downCount }</td>
              </tr>
            </table>
			<div class="etc_area">
			<c:if test="${ sessionScope.userId != null && sessionScope.userId == freedto.id }">
				<button type="button" onclick="location.href='../HS/pass.do?mode=edit&num=${ param.num }';">
					수정하기
				</button>
				<button type="button" onclick="location.href='../HS/pass.do?mode=delete&num=${ param.num }';">
				    삭제하기
				</button>
			</c:if>
				<button type="button" onclick="location.href='../HS/list-free.do';">
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
