$(function () {
  // 헤더_lang_btn
  $('#header .lang_btn').on('click', function () {
    $('#header .lang_wrap').toggleClass('on');
  });

  // 헤더_bottom_스와이퍼
  let depth2History = new Swiper('.depth2_history .swiper', {
    loop: true,

    pagination: {
      el: '.swiper-pagination',
    },
  });

  // 헤더_fixed
  $(window).on('scroll', function () {
    let st = $(window).scrollTop();
    let mb = $('.main_business').offset().top;

    if (st >= mb) {
      $('#header').addClass('fixed');
    } else {
      $('#header').removeClass('fixed');
    }
  });

  // 헤더_on
  $('#header .gnb').on('mouseenter', function () {
    $('#header').addClass('on');
  });

  $('#header').on('mouseleave', function () {
    $('#header').removeClass('on');
  });

  $('#header .open_btn').on('click', function () {
    $('#header').addClass('on');
  });

  // 모바일_메뉴
  $('#header .open_btn').on('click', function () {
    $('#header .m_gnb_wrap').addClass('on');
  });
  $('#header .m_gnb_close').on('click', function () {
    $('#header .m_gnb_wrap').removeClass('on');
  });

  // 모바일_메뉴_언어
  $('#header .m_gnb_lang>li').on('click', function () {
    $(this).children().addClass('active');
    $(this).siblings().children().removeClass('active');
  });

  // 아코디언_메뉴
  $('.m_gnb>li>a').on('click', function (e) {
    e.preventDefault();
    $(this).parent().toggleClass('on');
    $(this).parent().siblings().removeClass('on');
  });

  AOS.init({
    duration: 500,
  });

  // 지속가능경영_스와이퍼
  let mainManage = new Swiper('.main_manage .swiper', {
    slidesPerView: 1,

    breakpoints: {
      1201: {
        slidesPerView: 'auto',
        centeredSlides: true,
      },
    },

    autoplay: {
      delay: 3000,
      disableOnInteraction: false,
    },

    pagination: {
      el: '.swiper-pagination',
      clickable: true,
    },

    navigation: {
      nextEl: '.swiper-button-next',
      prevEl: '.swiper-button-prev',
    },
  });

  // 지속가능경영_스와이퍼_자동재생
  $('.main_manage .autoplay_btn').on('click', function () {
    $(this).toggleClass('on');

    if ($(this).hasClass('on')) {
      mainManage.autoplay.stop();
    } else {
      mainManage.autoplay.start();
    }
  });

  // 푸터_패밀리사이트
  $('#footer .family_wrap').on('click', function () {
    $(this).toggleClass('on');
  });
});
