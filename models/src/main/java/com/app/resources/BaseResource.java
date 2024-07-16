package com.app.resources;


import com.app.JwtTokenHolder;
import com.app.annotations.Secured;
import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@Secured
@SecurityRequirement(name = "bearerAuth")
public abstract class BaseResource {

    protected Long getUsuarioId() {
        Claims claims = JwtTokenHolder.getClaims();
        Integer id = claims.get("id", Integer.class);
        return id.longValue();
    }
}
