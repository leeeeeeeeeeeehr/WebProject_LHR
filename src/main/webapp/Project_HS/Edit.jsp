<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../Project_HS/include/common_head.jsp" %>

<body>
  <div id="skip_navi">
    <a href="#container">본문바로가기</a>
  </div>
  <div id="wrap">
    <%@ include file="../Project_HS/include/body_header_sub.jsp" %>
    <main id="container" class="edit_page sub_container">
      <div class="contents">
        <div class="inner">
          <div class="board_write">
            <div class="board_box">
              <div class="board_write_wrap ">
                <table>
                  <caption class="nohead">문의사항 글쓰기</caption>
                  <tbody>
                    <tr>
                      <th class="name">*이름</th>
                      <td><input type="text" class="size1"></td>
                    </tr>
                    <tr>
                      <th>*이메일</th>
                      <td class="email">
                        <input type="text" class="size3"><span>@</span><input type="text" class="size2">
                        <div class="mail_select select_wrap">
                          <select>
                            <option>naver.com</option>
                            <option>gmail.com</option>
                            <option>nate.com</option>
                            <option>daum.net</option>
                          </select>
                        </div>
                      </td>
                    </tr>
                    <tr>
                      <th>*연락처</th>
                      <td><input type="text" class="size2"> - <input type="text" class="size2"> - <input type="text" class="size2">  </td>
                    </tr>
                    <tr>
                      <th>주소</th>
                      <td><input type="text" class="size4 address" placeholder="제품 불편문의 접수시, 원활한 상담을 위해 지역을 기입해 주시기 바랍니다."></td>
                    </tr>
                    <tr>
                      <th>*제목</th>
                      <td><input type="text" class="size4"></td>
                    </tr>
                    <tr>
                      <th>*내용</th>
                      <td><textarea rows="10" placeholder="주민등록번호 등의 개인정보는 절대 노출하지마세요."></textarea></td>
                    </tr>
                    <tr>
                      <th class="file">첨부파일</th>
                      <td>
                        <div class="file_wrap">
                          <input type="text" class="size4">
                        <a href="#">찾아보기</a>
                        </div>
                        <div class="file_wrap">
                          <input type="text" class="size4">
                        <a href="#">찾아보기</a>
                        </div>
                        <div class="file_wrap">
                          <input type="text" class="size4">
                          <a href="#">찾아보기</a>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </div>
            <div class="btn_wrap">
              <a href="#">수정하기</a>
              <a class="point_btn3" href="../HS/list.do">뒤로가기</a>
            </div>
          </div>
        </div>
      </div>
    </main>
    <%@ include file="../Project_HS/include/body_footer.jsp" %>
  </div>
</body>

</html>
