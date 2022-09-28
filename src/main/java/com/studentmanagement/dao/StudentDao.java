package com.studentmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.studentmanagement.bean.Student;



public class StudentDao {

		private String dbUrl = "jdbc:mysql://localhost:3306/school_db";
		private String dbUname = "root";
		private String dbPassword = "root";
		private String dbDriver = "com.mysql.jdbc.Driver";
		
		private static final String INSERT_STUDENT_SQL = "INSERT INTO student_details" + "(id,fname,lname,dob,age,phone,address,gender,grade,email,admission)Values" + "(null,?,?,?,?,?,?,?,?,?,?);";
		
		private static final String SELECT_STUDENT_BY_ID="select id,fname,lname,dob,age,phone,address,gender,grade,email,admission from student_details where id=?";
		private static final String SELECT_ALL_STUDENT = "select * from student_details";
		private static final String DELETE_STUDENT_SQL = "delete from student_details where id=?;";
		private static final String UPDATE_STUDENT_SQL = "update student_details set fname=?,lname=?,dob=?,age=?,phone=?,address=?,gender=?,grade=?,email=?,admission=? where id=?;";
		
		
		public StudentDao() {
			
		}

		protected Connection getConnection() {
			Connection connection = null;
			try {
				Class.forName(dbDriver);
				connection = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}

			return connection;

		}
		
		
		//insert Student
		public void insertStudent(Student student) throws SQLException {
			System.out.println(INSERT_STUDENT_SQL);
			try(Connection connection=getConnection();
					PreparedStatement preparedStatement=connection.prepareStatement(INSERT_STUDENT_SQL)) {
				preparedStatement.setString(1, student.getFname());
				preparedStatement.setString(2, student.getLname());
				preparedStatement.setString(3, student.getDob());
				preparedStatement.setString(4, student.getAge());
				
				preparedStatement.setString(5, student.getPhone());
				preparedStatement.setString(6, student.getAddress());
				preparedStatement.setString(7, student.getGender());
				preparedStatement.setString(8, student.getGrade());
				preparedStatement.setString(9, student.getEmail());
				preparedStatement.setString(10, student.getAdmission());
				System.out.println(preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				printSQLException(e);
			}
		}

		
		
		
		// select Student by id
		public Student selectStudent(int id) {
			Student student=null;
			//1. establishing connection
			try(Connection connection=getConnection();
					//2. create statement
					PreparedStatement preparedstatement=connection.prepareStatement(SELECT_STUDENT_BY_ID);) {
				preparedstatement.setInt(1,id);
				System.out.println(preparedstatement);
				//3. execute the query
				ResultSet rs=preparedstatement.executeQuery();
				
				while(rs.next()) {
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String dob = rs.getString("dob");
					String age = rs.getString("age");
					
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					String gender = rs.getString("gender");
					String grade = rs.getString("grade");
					
					String email = rs.getString("email");
					String admission = rs.getString("admission");
					student=new Student(id,fname,lname,dob,age,phone,address,gender,grade,email,admission);
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			return student;
		}
		
		
		
		
		
		
		
			//select all student
		
		public List<Student> selectAllStudent() {
			List<Student> student=new ArrayList<>();
			//1. establishing connection
			try(Connection connection=getConnection();
					//2. create statement
					PreparedStatement preparedstatement=connection.prepareStatement(SELECT_ALL_STUDENT);) {
				//preparedstatement.setInt(1,id);
				System.out.println(preparedstatement);
				//3. execute the query
				ResultSet rs=preparedstatement.executeQuery();
				
				while(rs.next()) {
					int id=rs.getInt("id");
					String fname = rs.getString("fname");
					String lname = rs.getString("lname");
					String dob = rs.getString("dob");
					String age = rs.getString("age");
					
					String phone = rs.getString("phone");
					String address = rs.getString("address");
					String gender = rs.getString("gender");
					String grade = rs.getString("grade");
					
					String email = rs.getString("email");
					String admission = rs.getString("admission");
					student.add(new Student(id,fname,lname,dob,age,phone,address,gender,grade,email,admission));
				}
			} 
			catch (SQLException e) {
				printSQLException(e);
			}
			return student;
		}
		
		
		
		
		
			//update student
		public boolean updateStudent(Student student)throws SQLException {
			boolean rowUpdated;
			try(Connection connection=getConnection();
					//2. create statement
					PreparedStatement statement=connection.prepareStatement(UPDATE_STUDENT_SQL);) {
				System.out.println("updated Student:"+statement);
				statement.setString(1, student.getFname());
				statement.setString(2, student.getLname());
				statement.setString(3, student.getDob());
				statement.setString(4, student.getAge());
				
				statement.setString(5, student.getPhone());
				statement.setString(6, student.getAddress());
				statement.setString(7, student.getGender());
				statement.setString(8, student.getGrade());
				statement.setString(9, student.getEmail());
				statement.setString(10, student.getAdmission());
				//System.out.println(statement);
				statement.setInt(11, student.getId());
				rowUpdated=statement.executeUpdate()>0;			
			}
			return rowUpdated; 
		}
		
		
		
		
		
		
		
			//delete student
		public boolean deleteStudent(int id) throws SQLException {
			boolean rowDeleted;
			try (Connection connection=getConnection();
					//2. create statement
					PreparedStatement statement=connection.prepareStatement(DELETE_STUDENT_SQL);){
				statement.setInt(1, id);
				rowDeleted=statement.executeUpdate()>0;
			}
			return rowDeleted;
		}
		
		
		
		
		
		
		
		
		
		private void printSQLException(SQLException ex) {
			for(Throwable e:ex) {
				if(e instanceof SQLException) {
					e.printStackTrace(System.err);
					System.err.println("SQLState:"+((SQLException)e).getSQLState());
					System.err.println("Error Code:"+((SQLException)e).getErrorCode());
					System.err.println("Message: "+e.getMessage());
					Throwable t=ex.getCause();
					while(t !=null) {
						System.out.println("Cause:"+t);
						t=t.getCause();
					}
				}
				
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}



