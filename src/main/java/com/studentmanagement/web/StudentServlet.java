package com.studentmanagement.web;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentmanagement.bean.Student;
import com.studentmanagement.dao.StudentDao;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDao studentDao;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		studentDao = new StudentDao();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		switch (action) {
		case "/new":
			showNewForm(request, response);
			break;
		case "/insert":
			// insertStudent(request, response);
			try {
				insertStudent(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/delete":
			// deleteStudent(request, response);
			try {
				deleteStudent(request, response);
			} catch (SQLException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "/edit":
			try {
				showEditForm(request, response);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			break;
		case "/update":
			try {
				updateStudent(request, response);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
//			
			break;

		default:
			try {
				listStudent(request, response);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			// handle list
			break;
		}
	}

	// new
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
		dispatcher.forward(request, response);
	}

	// insert
	private void insertStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String age = request.getParameter("age");

		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");

		String email = request.getParameter("email");
		String admission = request.getParameter("admission");
		Student newstudent = new Student(fname, lname, dob, age, phone, address, gender, grade, email, admission);

		studentDao.insertStudent(newstudent);
		response.sendRedirect("list");

	}

	// delete
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		try {
			studentDao.deleteStudent(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect("list");

	}

	// Edit

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Student existingStudent;// =studentDao.selectStudent(id);
		try {
			existingStudent = studentDao.selectStudent(id);
			RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
			request.setAttribute("student", existingStudent);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//update
	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dob = request.getParameter("dob");
		String age = request.getParameter("age");

		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String gender = request.getParameter("gender");
		String grade = request.getParameter("grade");

		String email = request.getParameter("email");
		String admission = request.getParameter("admission");

		Student student = new Student(id, fname, lname, dob, age, phone, address, gender, grade, email, admission);
		studentDao.updateStudent(student);
		response.sendRedirect("list");

	}

	// default
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
