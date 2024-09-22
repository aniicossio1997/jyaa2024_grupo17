package com.app;

import com.app.JwtTokenHolder;
import com.app.annotations.Secured;
import com.app.services.AuthService;
import com.app.viewModels.ErrorResponse;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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

@WebFilter("/ui/*")
public class AngularFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Lógica de filtro
        System.out.println("Request to /ui/*");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();

        // Verificar si la solicitud no es un recurso estático
        if ((path.startsWith("/ui/") || path.startsWith("/SalaDeElaboracion/ui/")) && !path.contains(".")) {
            String contextPath = path.replaceFirst("^(/SalaDeElaboracion)?(/ui/)?", "");
            // Redirigir a index.html
            String finalPath = "/ui/index.html";
            if (!contextPath.isEmpty()) {
                finalPath += "#" + contextPath;
            }
            httpResponse.sendRedirect(httpRequest.getContextPath() + finalPath);
            return; // Terminar el filtro aquí
        }

        // Continuar con la cadena de filtros si no es una solicitud que redirige
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}
