package com.heekwoncompany.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.heekwoncompany.freeboard.command.BCommand;
import com.heekwoncompany.freeboard.command.BlistCommand;
import com.heekwoncompany.freeboard.command.BwriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();	//클라이언트가 요청한 URI 전부 가져오기
		String conPath = request.getContextPath(); //context path 가져오기
		String comm = uri.substring(conPath.length()); // 전체 uri에서 context path 경로 길이만큼 빼기
		
		BCommand command = null;
		
		if(comm.equals("/write.do")) {
			System.out.println("write.do 요청!");
			
			command = new BwriteCommand();
			command.execute(request, response);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.do");
			dispatcher.forward(request, response);
		}
		
		else if(comm.equals("/list.do")) {
			System.out.println("list.do 요청!");
			
			command = new BlistCommand();
			command.execute(request, response);
			// request 객체에 글 리스트가 셋팅됨.
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
			dispatcher.forward(request, response);
			// 셋팅된 글 리스트 전송
		}
		
		else if(comm.equals("/write_form.do")) {
			System.out.println("write_form.do 요청!");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/write_form.jsp");
			dispatcher.forward(request, response);
		}

	
	}
	
}
