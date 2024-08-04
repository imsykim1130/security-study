package syk.study.security.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.core.Authentication;
import java.io.IOException;

public class MyLoginSuccessHandler implements org.springframework.security.web.authentication.AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // authentication 안에 로그인한 사용자 정보가 들어있다
        HttpSession session = request.getSession();
        session.setAttribute("greeting", authentication.getName() +"님 환영합니다.");
        response.sendRedirect("/"); // 로그인 성공 뒤 리다이렉트 될 url
    }
}
