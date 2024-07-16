package com.app;

import io.jsonwebtoken.Claims;

public class JwtTokenHolder {
    private static final ThreadLocal<Claims> claimsHolder = new ThreadLocal<>();

    public static void setClaims(Claims claims) {
        claimsHolder.set(claims);
    }

    public static Claims getClaims() {
        return claimsHolder.get();
    }

    public static void clear() {
        claimsHolder.remove();
    }
}