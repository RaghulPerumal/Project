package com.example.Learning.Filter;

import jakarta.servlet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CommonFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info(getClass().getName() + " Entered");
        chain.doFilter(request, response);
        logger.info(getClass().getName() + " Exit");
    }

}
