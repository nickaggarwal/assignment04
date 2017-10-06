package com.greglturnquist.payroll.security.auth ;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greglturnquist.payroll.model.Account;
import com.greglturnquist.payroll.model.UserTokenState;
import com.greglturnquist.payroll.security.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${jwt.expires_in}")
    private int EXPIRES_IN;

    @Value("${jwt.cookie}")
    private String TOKEN_COOKIE;

    @Value("${app.user_cookie}")
    private String USER_COOKIE;

    @Autowired
    TokenHelper tokenHelper;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        clearAuthenticationAttributes(request);
        Account user = (Account) authentication.getPrincipal();

        String jws = tokenHelper.generateToken( user.getUsername() );
        Cookie authCookie = new Cookie(TOKEN_COOKIE, (jws));
        authCookie.setPath("/");
        authCookie.setHttpOnly( true );
        authCookie.setMaxAge(EXPIRES_IN);

        Cookie userCookie = new Cookie( USER_COOKIE, (user.getFirstName())) ;
        userCookie.setPath("/");
        userCookie.setMaxAge(EXPIRES_IN);

        response.addCookie(authCookie);
        response.addCookie(userCookie);

        UserTokenState userTokenState = new UserTokenState(jws , (long)EXPIRES_IN );
        String jwtResponse = objectMapper.writeValueAsString( userTokenState ) ;
        response.setContentType("application/json");
        response.getWriter().write( jwtResponse );
    }
}
