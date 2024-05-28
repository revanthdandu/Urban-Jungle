package com.example.UJ.UrbanJungle.security;

import com.example.UJ.UrbanJungle.model.User;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtHelper {


    public String decodeJwt(String token){
        return new String(Base64.getDecoder().decode((token).split("\\.")[1]), StandardCharsets.UTF_8);
    }

    public User extractUserDetails(String token){
        String res = decodeJwt(token);
        JSONObject root = new JSONObject(res);
        User user = new User();
        user.setEmail(root.getString("email"));
        user.setName(root.getString("given_name"));
        user.setFullname(root.getString("name"));
        return user;
    }


    public Boolean isTokenExpired(String token){
        String res = decodeJwt(token);
        JSONObject root = new JSONObject(res);
        long expiry = root.getLong("exp");
//        long expiry;
//        expiry = new Date(String.valueOf(a));
        boolean result = false;
        long epoch = System.currentTimeMillis()/1000;
        if(expiry < epoch){
            result = true;
        }
        return result;
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = extractUserDetails(token).getEmail();
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }


}
