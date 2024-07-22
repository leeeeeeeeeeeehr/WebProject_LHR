<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../include/body_header_sub.jsp" %>
    <main id="contaniner" class="list_page sub_container">
      <div class="sub_visual free_visual">
        <div class="inner">
          <div class="visual_wrap">
            <div class="tit_wrap">
              <h2>자유게시판</h2>
              <p>사람과 기술을 잇는<br>글로벌 화승을 만납니다.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="contents">
        <div class="inner">
          <div class="board_list">
			<!-- 검색창 -->
			<form method="get">  
				<table class="search">
					<tr>
					    <td align="center">
					        <select class="select_wrap" name="searchField">
					            <option value="title">제목</option>
					            <option value="content">내용</option>
					            <option value="id">작성자</option>
					        </select>
					        <input type="text" name="searchWord" value="검색어를 입력해주세요." />
					        <input class="submit_btn" type="submit" value="검색하기" />
					    </td>
					</tr>
				</table>
			</form>
            <table>
              <thead>
                <tr>
                  <th class="col1">번호</th>
                  <th>제목</th>
                  <th class="col3">작성자</th>
                  <th class="col1">조회수</th>
                  <th class="col3">작성일</th>
                </tr>
              </thead>
				<c:choose>
					<c:when test="${ empty freeboard }">
						<tr>
				            <td colspan="6" align="center">
				                등록된 게시물이 없습니다.
				            </td>
				        </tr>
					</c:when>
					<c:otherwise>
						<c:forEach items="${ freeboard }" var="row" varStatus="loop">
				        <tr>
				            <td>${ map.totalCount - (((map.pageNum - 1) * map.pageList) + loop.index)}</td>
				            <td class="td_left"><a class="view_btn" href="../HS/view-free.do?num=${ row.num }">${ row.title }</a></td> 
				            <td>${ row.id }</td>
				            <td>${ row.visitCount }</td>
				            <td>${ row.postdate }</td>
				        </tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</table>
			<table width="90%">
				<tr align="center">
					<td>${ map.paging }</td>
					<c:if test="${ sessionScope.userId != null }">
					<td width="100"><button class="write_btn" type="button" onclick="location.href='../HS/write-free.do';">글쓰기</button></td>
					</c:if>
				</tr>
			</table>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../include/body_footer.jsp" %>
  </div>
</body>

</html>
