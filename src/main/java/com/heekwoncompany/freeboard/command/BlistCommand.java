package com.heekwoncompany.freeboard.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heekwoncompany.freeboard.dao.BoardDao;
import com.heekwoncompany.freeboard.dto.BoardDto;

public class BlistCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		BoardDao dao = new BoardDao();
		
		ArrayList<BoardDto> dtos = dao.list();
		//dto 들의 컬렉션인 dtos(ArryList 타입)이 반환됨
		
		request.setAttribute("list", dtos);
		
	}

}
