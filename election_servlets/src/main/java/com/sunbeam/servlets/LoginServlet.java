package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.daos.UserDao;
import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = req.getParameter("email");
		String password = req.getParameter("passwd");
		System.out.println("Email: " + email + " and Password: " + password);
		// authetication using UserDao
		
		try(UserDao userDao=new UserDaoImpl()) 
		{
			User user = userDao.findByEmail(email);
			System.out.println("Found User: " + user);
            if(user != null && user.getPassword().equals(password)) {
            	HttpSession session=req.getSession();
            	session.setAttribute("curUser", user);
            	if(user.getRole().equals("admin")) 
            		resp.sendRedirect("result");
            	else 
            		resp.sendRedirect("candlist");
            }else {
            	resp.setContentType("text/html");
            	PrintWriter out=resp.getWriter();
            	out.println("<html>");
				out.println("<head>");
				out.println("<title>Login Failed</title>");
				out.println("</head>");
				out.println("<body>");
				out.println("<h5>Invalid email or password</h5>");
				out.println("<a href='index.html'>Login again</a>");
				out.println("</body>");
				out.println("</html>");
            }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
	}
	
	
}
