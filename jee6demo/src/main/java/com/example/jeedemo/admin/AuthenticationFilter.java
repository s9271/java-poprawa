package com.example.jeedemo.admin;

import java.io.IOException;
import java.util.logging.LogRecord;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import com.example.jeedemo.admin.AuthenticationBean;

public class AuthenticationFilter implements Filter {
	@SuppressWarnings("unused")
	private FilterConfig config;

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		if (AuthenticationBean.zalogowany == false) {
			// plik do ktorego bedzie przenosic przy probie wejscia w plik z
			// folderu dla admina
			((HttpServletResponse) resp).sendRedirect("../admin.jsf");
		} else {
			chain.doFilter(req, resp);
		}

	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config;
	}

	public void destroy() {
		config = null;
	}

	public boolean isLoggable(LogRecord record) {
		// TODO Auto-generated method stub
		return false;
	}
}