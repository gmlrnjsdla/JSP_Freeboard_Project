package com.heekwoncompany.freeboard.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heekwoncompany.freeboard.dao.BoardDao;
import com.heekwoncompany.freeboard.dto.BoardDto;

public class BcontentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String bid = request.getParameter("bid");
		
		BoardDao dao = new BoardDao();
		BoardDto dto = dao.content_view(bid);
		
		request.setAttribute("content", dto);
	}

}
