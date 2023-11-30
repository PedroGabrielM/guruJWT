package br.com.project.backendspring.port.impl;

import br.com.project.backendspring.security.ApiSecurityConstants;
import br.com.project.domain.UserModel;
import br.com.project.implementation.port.JwtService;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class JwtServiceImpl implements JwtService {
    @Override
    public String getJwtToken(UserModel user) {

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_" + user.getType()));

        try {
            final String token = Jwts.builder()
                    .setId("PROJECT_JWT")
                    .setSubject(user.getEmail())
                    .claim(ApiSecurityConstants.AUTHORITIES, grantedAuthorities.stream()
                            .map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + convertToMinutes(10)))
                    .signWith(ApiSecurityConstants.KEY)
                    .compact();
            return token;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }  // https://pastebin.com/UKhaAqKU
    }

    private int convertToMinutes(int minutes) {
        return minutes * 60 * 1000;
    }
}
