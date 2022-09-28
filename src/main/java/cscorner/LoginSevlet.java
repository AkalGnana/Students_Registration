package cscorner;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.bean.Student;
import com.studentmanagement.dao.StudentDao;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/LoginSevlet")
public class LoginSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;
	
	
	
	public void init() throws ServletException {
		studentDao = new StudentDao();
	}
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out=response.getWriter();
			response.setContentType("text/html");
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school_db","root","");
			String name=request.getParameter("uname");
			String pw=request.getParameter("password");
			
			PreparedStatement PreparedStatment=conn.prepareStatement("select uname from login where uname=? and password=?");
			PreparedStatment.setString(1, name);
			PreparedStatment.setString(2, pw);
			
			ResultSet rs=PreparedStatment.executeQuery();
			
			if(rs.next()) {
				//RequestDispatcher rd=request.getRequestDispatcher("student-list.jsp");
				//rd.forward(request, response);
				listStudent(request, response);
				
				
				
				//<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					//	New Students</a>
				
				
				//<a href="<%=request.getContextPath()%>/list"
					//	class="nav-link">Students</a>
				
			}
			else {
				out.println("<font color=red size=18>Login Failed!!<br>");
				out.println("<a href=LoginPage.jsp>Try Again!!</a>");
			}
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}		
		
		
		
		
		
	}
	
	
	
	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		try {
			List<Student> listStudent = studentDao.selectAllStudent();
			request.setAttribute("listStudent", listStudent);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
			dispatcher.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
