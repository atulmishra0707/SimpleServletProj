package org.java.atul;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

/**
 * Servlet implementation class SimpleServlet
 */
//@WebServlet(description = "A Simple Servlet", urlPatterns = { "/SimpleServletPath" })
public class XmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at XML Servlet doGet method: ").append(request.getContextPath());
		PrintWriter w = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session= request.getSession();
		ServletContext ctx=  request.getServletContext();
		if(userName !=null && !userName.isEmpty()){
			session.setAttribute("userName", userName);
			ctx.setAttribute("userName", userName);
			
		}
		w.print("<HTML><h3>Hello User "+ userName +"</h3></HTML>");
		w.print("<HTML><h3>Hello Session User "+ session.getAttribute("userName") +"</h3></HTML>");
		w.print("<HTML><h3>Hello Context User "+ ctx.getAttribute("userName") +"</h3></HTML>");
		System.out.println("Hello from XML Servlet GET method");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		response.getWriter().append("Served at doPost method: ").append(request.getContextPath());
		PrintWriter w = response.getWriter();
		String userName = request.getParameter("userName");
		w.print("<HTML><h3>Post Hello User "+ userName +"</h3></HTML>");
		String[] option = request.getParameterValues("option");
		w.print("length :" +option.length);
		for(int i =0; i < option.length ;i++){
			w.print("option :" +option[i]);
		}
		
		System.out.println("Hello from Servlet POST method");
	}

}
