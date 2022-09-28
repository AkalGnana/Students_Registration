package com.studentmanagement.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		
		//int search=Integer.parseInt(request.getParameter("search"));
		String grade=request.getParameter("grade");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db", "root","root");
			PreparedStatement ps=con.prepareCall("select* from student_details where grade=?");
			//ps.setInt(1, search);
			ps.setString(1, grade);
			out.print("<table width=75% border=1>");
			out.print("<caption>Student Details:</caption>");
			
			ResultSet rs=ps.executeQuery();
			
		    ResultSetMetaData rsmd=rs.getMetaData();
			int totalColumn=rsmd.getColumnCount();
			out.print("<tr>");
			for(int i=1;i<=totalColumn;i++) {
				out.print("<th>"+rsmd.getColumnName(i)+"</th>");//out.print("<th>"+rsmd.getColumnName(i)+"</th>");
			}
			out.print("</tr>");
			while(rs.next()) {
				out.print("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td><td>"+rs.getString(6)+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td><td>"+rs.getString(9)+"</td><td>"+rs.getString(10)+"</td><td>"+rs.getString(11));
			}
			out.print("</table>");
			
			
		} catch (Exception e) {
			out.print(e);;
		}
		
		
		
	}

}
