package com.barry.security.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class TimeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //logger.info("<=======TimeFilter init==========>");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = System.currentTimeMillis();
        //logger.info("<=======TimeFilter doFilter==========>耗时:"+(end-start));
    }

    @Override
    public void destroy() {
        logger.info("<=======TimeFilter destroy==========>");
    }
}
