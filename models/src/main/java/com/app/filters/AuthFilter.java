package com.app.filters;

import com.app.JwtTokenHolder;
import com.app.annotations.Secured;
import com.app.services.AuthService;
import com.app.viewModels.ErrorResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.container.ResourceInfo;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Optional;

@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthFilter implements ContainerRequestFilter {

    @Inject
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Method resourceMethod = resourceInfo.getResourceMethod();

        boolean methodSecured = resourceMethod != null && resourceMethod.isAnnotationPresent(Secured.class);

        Class<?> resourceClass = resourceInfo.getResourceClass();
        boolean classSecured = false;
        // Verificar las superclases recursivamente
        while (resourceClass != null && !classSecured) {
            if (resourceClass.isAnnotationPresent(Secured.class)) {
                classSecured = true;
            } else {
                resourceClass = resourceClass.getSuperclass();
            }
        }

        if (!classSecured && !methodSecured) {
            return;
        }
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            abortWithUnauthorized(requestContext);
            return;
        }

        String token = authorizationHeader.substring("Bearer".length()).trim();
        Optional<Claims> claims = getClaimsFromToken(token);
        if (claims.isEmpty()) {
            abortWithUnauthorized(requestContext);
            return;
        }
        JwtTokenHolder.setClaims(claims.get());
        requestContext.setProperty("claims", claims.get());
    }

    private Optional<Claims> getClaimsFromToken(String token) {
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(AuthService.secretKey)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return Optional.ofNullable(claims);
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {
        Response unauthorizedResponse = Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(new ErrorResponse("unauthorized", 401)) // Aquí defines el JSON de error
                .type(MediaType.APPLICATION_JSON)
                .build();

        requestContext.abortWith(unauthorizedResponse);
    }
}
