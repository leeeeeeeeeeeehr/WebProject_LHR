package utils;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieManager {
	
	// 쿠키 생성
    public static void makeCookie(HttpServletResponse response,
    									String cName, String cValue, int cTime) {

    	Cookie cookie = new Cookie(cName, cValue);
    	// 경로 설정
    	cookie.setPath("/");
        // 유효시간 설정 
        cookie.setMaxAge(cTime);

        response.addCookie(cookie);
    }
    
    // 쿠키값 읽기
    public static String readCookie(HttpServletRequest request, String cName) {
       
    	String cookieValue = "";
    	
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {  
                String cookieName = c.getName();
                if (cookieName.equals(cName)) {
                    cookieValue = c.getValue();
                }
            }
        }
        return cookieValue; 
    }
    
    // 쿠키 삭제
    public static void deleteCookie(HttpServletResponse response, String cName) {    	
        makeCookie(response, cName, "", 0);
    }
}