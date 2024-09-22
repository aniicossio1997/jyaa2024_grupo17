package com.app;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.*;

@WebFilter("/*") // Filtra todas las solicitudes
public class DefaultRedirectToUIFilter implements Filter {

    private Set<String> basePaths = new HashSet<>(Set.of("/api", "/swagger", "/ui", "/openapi", "/TestingServlet"));

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        boolean isGetRequest = Objects.equals(httpRequest.getMethod(), "GET");
        if (!isGetRequest) {
            chain.doFilter(request, response);
            return;
        }
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        String path = httpRequest.getRequestURI();
        String contextPath = httpRequest.getContextPath();
        String pathWithoutContext = path.replaceFirst(contextPath, "");

        boolean redirectToUI = basePaths.stream().noneMatch(pathWithoutContext::startsWith);

        if (redirectToUI) {
            // Redirigir a ui
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/ui" + pathWithoutContext);
            return; // Terminar el filtro aquí
        }

        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {
    }
}