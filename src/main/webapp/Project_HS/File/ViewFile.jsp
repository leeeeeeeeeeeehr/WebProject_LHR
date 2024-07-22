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
                <td class="post">${ filedto.num }</td>
                <td class="column">작성자</td>
                <td class="post">${ filedto.id }</td>
              </tr>
              <tr>
                <td class="column">작성일</td>
                <td class="post">${ filedto.postdate }</td>
                <td class="column">조회수</td>
                <td class="post">${ filedto.visitCount }</td>
              </tr>
              <tr>
                <td class="column">제목</td>
                <td class="post" colspan="3">${ filedto.title }</td>
              </tr>
              <tr>
                <td class="column">내용</td>
                <td class="post post_content" colspan="3">
                	${ filedto.content }
                	<br><br><br>
                	
                	<c:if test="${ not empty filedto.ofile }">
					<c:choose>
					<c:when test='${ ext == ".png" or ext == ".gif" or ext == ".jpg" }'>
						<img src="../Project_HS/UploadsFile/${ filedto.sfile }" style="max-width:350px;" />
					</c:when>
					<c:when test='${ ext == ".mp3" or ext == ".wav" }'>
						<audio src="../Project_HS/UploadsFile/${ filedto.sfile }" controls="controls"></audio>
					</c:when>
					<c:when test='${ ext == ".mp4" or ext == ".avi" or ext == ".wmv" }'>
						<video src="../Project_HS/UploadsFile/${ filedto.sfile }" style="max-width:350px;" autoplay="autoplay"></video>
					</c:when>
					<c:otherwise>
						<a href="../HS/download-file.do?ofile=${ filedto.ofile }&sfile=${ filedto.sfile }&num=${ filedto.num }">[다운로드]</a>
					</c:otherwise>
					</c:choose>       	
        			</c:if>
               	</td>
              </tr>
              <tr>
                <td class="column">첨부파일</td>
                <td class="post">
               		<c:if test="${ not empty filedto.ofile }">
       		        		${ filedto.ofile }
               				<a class="download_btn" href="../HS/download-file.do?ofile=${ filedto.ofile }&sfile=${ filedto.sfile }&num=${ filedto.num }">[다운로드]</a>
           			</c:if>
                </td>
                <td class="column">다운로드 수</td>
                <td class="post">${ filedto.downCount }</td>
              </tr>
            </table>
			<div class="etc_area">
			<c:if test="${ sessionScope.userId != null && sessionScope.userId == filedto.id }">
				<button type="button" onclick="location.href='../HS/edit-file.do?num=${ param.num }';">
					수정하기
				</button>
				<button type="button" onclick="location.href='../HS/delete-file.do?num=${ param.num }';">
				    삭제하기
				</button>
			</c:if>
				<button type="button" onclick="location.href='../HS/list-file.do';">
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
