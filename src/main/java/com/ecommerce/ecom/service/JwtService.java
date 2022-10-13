package com.ecommerce.ecom.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtService {

	static final long EXPIRATIONTIME = 86400000; 
//	1 DAY IN MS
	static final String PREFIX ="Bearer";
//	now generate secret key 
	static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
//generate jwt token
	
}
