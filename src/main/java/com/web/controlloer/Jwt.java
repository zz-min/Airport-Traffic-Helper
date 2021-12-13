package com.web.controlloer;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

public class Jwt {
	final String key = "S+1hqCpoEnYpEosqMLysEEX9EpfdXf2jftJk48wBHwY=";
	//https://cognito-idp.ap-northeast-2.amazonaws.com/{userPoolId}/.well-known/jwks.json
	//토큰 검증
    public Map<String, Object> verifyJWT(String jwt) throws UnsupportedEncodingException {
        Map<String, Object> claimMap = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(key.getBytes("UTF-8")) // Set Key
                    .parseClaimsJws(jwt) // 파싱 및 검증, 실패 시 에러
                    .getBody();

            claimMap = claims;

            Date expiration = claims.get("exp", Date.class);
            String data = claims.get("data", String.class);
            
            System.out.println(expiration);
            System.out.println(data);
            
        } catch (ExpiredJwtException e) { // 토큰이 만료되었을 경우
            System.out.println(e);
        } catch (Exception e) { // 그외 에러났을 경우
            System.out.println(e);
        }
        return claimMap;
    }    
}
