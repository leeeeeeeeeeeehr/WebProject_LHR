<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
    
<header id="header" class="sub_header">
     <div class="inner">
       <h1 class="logo">
         <a href="../HS/main.do">
           <span class="blind">화승</span>
         </a>
       </h1>
       <nav class="gnb_wrap">
         <ul class="gnb">
           <li><a href="#">화승</a></li>
           <li><a href="#">사업분야</a></li>
           <li><a href="../HS/list-free.do">PR ROOM</a></li>
           <li><a href="#">지속가능경영</a></li>
         </ul>
       </nav>
       <div class="btn_wrap">
       <c:if test="${ sessionScope.userId != null }">
      <p class="session_check">
       ${ sessionScope.userName }님, 환영합니다 :) 
      </p>        
    </c:if>
      <a class="login" href="../HS/login.do">
        <span class="blind">로그인</span>
      </a>
      <div class="lang_wrap">
        <button class="lang_btn" type="button"></button>
        <ul class="lang">
          <li><a href="#">ENGLISH</a></li>
        </ul>
      </div>
      <button class="open_btn" type="button">
        <span class="blind">메뉴열기</span>
        <i></i>
        <i></i>
        <i></i>
      </button>
    </div>
  </div>
  <div class="header_bottom">
    <div class="depth2_inner">
      <ul class="depth2_wrap">
        <li>
          <a href="#">화승</a>
          <ul class="depth2">
            <li><a href="#">그룹개요</a></li>
            <li><a href="#">가치체계</a></li>
            <li><a href="#">CI</a></li>
            <li><a href="#">계열사 위치</a></li>
          </ul>
        </li>
        <li>
          <a href="#">사업분야</a>
          <ul class="depth2">
            <li><a href="#">자동차 부품</a></li>
            <li><a href="#">종합무역</a></li>
            <li><a href="#">소재</a></li>
            <li><a href="#">화학</a></li>
            <li><a href="#">스포츠패션ODM</a></li>
          </ul>
        </li>
        <li>
          <a href="../HS/list-free.do">PR ROOM</a>
          <ul class="depth2">
            <li><a href="../HS/list-free.do">자유게시판</a></li>
            <li><a href="../HS/list-qna.do">QnA</a></li>
            <li><a href="../HS/list-file.do">자료실</a></li>
          </ul>
        </li>
        <li>
          <a href="#">지속가능경영</a>
          <ul class="depth2">
            <li><a href="#">나눔경영</a></li>
            <li><a href="#">환경경영</a></li>
            <li><a href="#">사회경영</a></li>
            <li><a href="#">투명경영</a></li>
          </ul>
        </li>
      </ul>
      <div class="depth2_history">
        <div class="swiper">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <a href="#">
                <img src="../Project_HS/images/history.png" alt="">
              </a>
            </div>
            <div class="swiper-slide">
              <a href="#">
                <img src="../Project_HS/images/history.png" alt="">
              </a>
            </div>
            <div class="swiper-slide">
              <a href="#">
                <img src="../Project_HS/images/history.png" alt="">
              </a>
            </div>
          </div>
          <div class="swiper-pagination"></div>
        </div>
      </div>
    </div>
  </div>
  <aside class="m_gnb_wrap">
    <div class="m_gnb_top">
      <div class="m_gnb_home">
        <a href="../HS/main.do">
          <span class="blind">홈으로</span>
        </a>
      </div>
      <ul class="m_gnb_lang">
        <li>
          <a href="#" class="active">KR</a>
        </li>
        <li>
          <a href="#">EN</a>
        </li>
      </ul>
      <a class="m_login" href="../HS/login.do">
        <span class="blind">로그인</span>
      </a>
      <button class="m_gnb_close" type="button">
        <span class="blind">메뉴 닫기</span>
      </button>
    </div>
    <ul class="m_gnb">
      <li>
        <a href="#">화승</a>
        <ul class="m_depth2">
          <li><a href="#">그룹개요</a></li>
          <li><a href="#">가치체계</a></li>
          <li><a href="#">CI</a></li>
          <li><a href="#">계열사 위치</a></li>
        </ul>
      </li>
      <li>
        <a href="#">사업분야</a>
        <ul class="m_depth2">
          <li><a href="#">자동차 부품</a></li>
          <li><a href="#">종합무역</a></li>
          <li><a href="#">소재</a></li>
          <li><a href="#">화학</a></li>
          <li><a href="#">스포츠패션ODM</a></li>
        </ul>
      </li>
      <li>
        <a href="../HS/list-free.do">PR ROOM</a>
        <ul class="m_depth2">
          <li><a href="../HS/list-free.do">자유게시판</a></li>
            <li><a href="../HS/list-qna.do">QnA</a></li>
            <li><a href="../HS/list-file.do">자료실</a></li>
        </ul>
      </li>
      <li>
        <a href="#">지속가능경영</a>
        <ul class="m_depth2">
          <li><a href="#">나눔경영</a></li>
          <li><a href="#">환경경영</a></li>
          <li><a href="#">사회경영</a></li>
          <li><a href="#">투명경영</a></li>
        </ul>
      </li>
    </ul>
    <div class="m_gnb_history">
      <a href="#">
        <img src="../Project_HS/images/history.png" alt="">
      </a>
    </div>
  </aside>
</header>