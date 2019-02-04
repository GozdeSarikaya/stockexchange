package com.netas.interview.rest.authentication;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;

public class JWTManager {
    public static String signWithKey = "netas2018"; //TODO Key
    public static String generateToken(String loginname, String userType){
        String token = Jwts.builder()
                .setIssuer("GozdeSarikaya")
                .setId(String.valueOf(loginname))
                .setSubject(String.valueOf(userType))
                .signWith(SignatureAlgorithm.HS512, signWithKey)
                .compact();

        return token;
    }

    public static void validateToken(HttpServletRequest servletRequest, String token) throws Exception{
        Jws<Claims> jws;
        UserSessionView tokenUserSessionView;
        try {
            jws = Jwts.parser().setSigningKey(signWithKey).parseClaimsJws(token);
        } catch (Exception ex) {
            throw new Exception("Token bilgisi geçerli değildir",ex);
        }

        try {
            tokenUserSessionView = (UserSessionView)servletRequest.getAttribute("token");
            tokenUserSessionView.setLoginname(String.valueOf(jws.getBody().getId()));
            tokenUserSessionView.setUserType(String.valueOf(jws.getBody().getSubject()));
        } catch (Exception ex) {
            throw new Exception("İstek kullanıcı bilgileri hazırlama işleminde hata oluştu ",ex);
        }
    }
}

