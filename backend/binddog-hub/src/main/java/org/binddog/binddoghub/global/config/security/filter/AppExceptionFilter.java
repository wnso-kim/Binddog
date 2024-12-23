package org.binddog.binddoghub.global.config.security.filter;

import static org.binddog.binddoghub.global.enums.ErrorCode.*;

import java.io.IOException;

import org.binddog.binddoghub.global.handler.AppException;
import org.binddog.binddoghub.global.utils.JsonResponseUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class AppExceptionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		try {
			log.info("AppExceptionFilter processing...");
			filterChain.doFilter(request, response);
			log.info("AppExceptionFilter process completed");
		} catch (JwtException e) {
			log.error("JWT token error: {}", e.getMessage());
			JsonResponseUtils.writeHttpErrorResponse(response, TOKEN_INVALID);
		} catch (AppException e) {
			log.error("AppException error: {}", e.getMessage());
			JsonResponseUtils.writeHttpErrorResponse(response, e.getErrorCode());
		}
	}

}