package com.mentor.link.auth;

import com.mentor.link.persistence.model.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationContext {

    public static void setAuthUser(HttpServletRequest request, AuthUserDetails authUserDetails) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authUserDetails, null, authUserDetails.getAuthorities());
        usernamePasswordAuthenticationToken
                .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }

    public static AuthUserDetails getAuthUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (AuthUserDetails) authentication.getPrincipal();
    }

    public static User getUser() {
        return getAuthUser().getUser();
    }
}
