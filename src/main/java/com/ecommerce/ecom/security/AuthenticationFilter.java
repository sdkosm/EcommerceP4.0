package com.ecommerce.ecom.security;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ecommerce.ecom.service.JwtService;

import io.jsonwebtoken.io.IOException;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
	@Autowired
	private JwtService jwtService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, 
			HttpServletResponse response, 
			FilterChain filterChain)
					throws ServletException, IOException {

		// Get token from Authorization header
		String jws = request.getHeader(HttpHeaders.AUTHORIZATION);			

		if (jws != null) {
			// Verify token and get user
			String user = jwtService.getAuthUser(request);

			// Authenticate
			Authentication authentication = 
					new UsernamePasswordAuthenticationToken(user, null, java.util.Collections.emptyList());

			SecurityContextHolder.getContext().setAuthentication(authentication);

		}

		try {
			filterChain.doFilter(request, response);
		} catch (java.io.IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}