/**
 * yingyinglicai.com Inc.
 * Copyright (c) 2013-2013 All Rights Reserved.
 */
package com.seek.soft.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.filter.RequestContextFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestDigestFilter extends RequestContextFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger("CICADA-DIGEST");

    /**
     * @see org.springframework.web.filter.RequestContextFilter#doFilterInternal(HttpServletRequest, HttpServletResponse, FilterChain)
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        boolean hasError = false;
        StringBuffer serviceMessage = new StringBuffer();
        long startTime = System.currentTimeMillis();
        try {
            serviceMessage.append("(").append(request.getRequestURI()).append(",")
                    .append(request.getParameter("token")).append(",").append(request.getMethod())
                    .append(",");

            filterChain.doFilter(request, response);
        } catch (Exception e) {
            hasError = true;
        } finally {
            if (LOGGER.isInfoEnabled()) {
                if (hasError) {
                    serviceMessage.append("N");
                } else {
                    serviceMessage.append("Y");
                }
                long spaceTime = System.currentTimeMillis() - startTime;
                serviceMessage.append(",").append(spaceTime).append("ms").append(")");
                LOGGER.info(serviceMessage.toString());
            }

        }
    }

}
