<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../Project_HS/include/body_header_sub.jsp" %>
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
            <table>
              <thead>
                <tr>
                  <th>번호</th>
                  <th>제목</th>
                  <th>작성자</th>
                  <th>조회수</th>
                  <th>작성일</th>
                </tr>
              </thead>
              <tr>
                <td>000</td>
                <td class="td_left"><a class="view_btn" href="../HS/view.do">제목입니다~</a></td>
                <td>XXX</td>
                <td>00</td>
                <td>2024.07.15</td>
              </tr>
              <tr>
                <td colspan="5">
                  <a class="write_btn" href="../HS/write.do">글쓰기</a>
                </td>
              </tr>
            </table>
            <div class="board_pagination">
              <a class="page_btn first" href="#"><span class="blind">첫 페이지</span></a>
              <a class="page_btn prev" href="#"><span class="blind">이전</span></a>
              <span class="num active">1</span>
              <a class="num" href="#">2</a>
              <a class="page_btn next" href="#"><span class="blind">다음</span></a>
              <a class="page_btn last" href="#"><span class="blind">마지막 페이지</span></a>
            </div>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../Project_HS/include/body_footer.jsp" %>
  </div>
</body>

</html>
