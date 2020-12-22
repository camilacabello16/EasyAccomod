package com.easyaccomod.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easyaccomod.model.UserModel;
import com.easyaccomod.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext servletContext;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.servletContext = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if (url.startsWith("/easy-accomod-jdbc/admin")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if(user != null) {
				if(user.getRole().getRoleCode().equals("ADMIN") || user.getRole().getRoleCode().equals("COMPANY")) {
					chain.doFilter(request, response);
				} else if(user.getRole().getRoleCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login");
			}
		} else if (url.startsWith("/easy-accomod-jdbc/company")) {
			UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if(user != null) {
				if(user.getRole().getRoleCode().equals("COMPANY")) {
					chain.doFilter(request, response);
				} else if(user.getRole().getRoleCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission");
				} else if(user.getRole().getRoleCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login");
			}
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
