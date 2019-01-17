package com.Val.servlets;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Val.beans.SubtitlesReader;

@WebServlet("/EditSubtitle")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String FILE_NAME = "/WEB-INF/subtitles.srt";

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final ServletContext context = this.getServletContext();
		System.out.println(context.getRealPath(FILE_NAME));
		final SubtitlesReader subtitles = new SubtitlesReader(context.getRealPath(FILE_NAME));

		request.setAttribute("subtitles", subtitles.getSubtitles());

		this.getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
