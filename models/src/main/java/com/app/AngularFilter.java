package com.app;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class AngularFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // No initialization required
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Get the requested path
        String path = req.getRequestURI();

        // Check if the request is not for a static file (like .js, .css, images, etc.)
        if (path.startsWith("/ui") && !path.contains(".") && !path.endsWith("/")) {
            // Forward the request to index.html
            req.getRequestDispatcher("/ui/index.html").forward(req, res);
        } else {
            // If it's a static file, just continue with the chain
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // No cleanup required
    }
}
