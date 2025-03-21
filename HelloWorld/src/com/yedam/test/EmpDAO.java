package com.yedam.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// 목록 가져오기, 등록
public class EmpDAO {
	// Connection 생성.
	static Connection getConnect() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userId = "scott";
		String userPw = "tiger";

		try {
			Connection conn = DriverManager.getConnection(url, userId, userPw);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 추가
	public boolean insert(Employee emp) {
		Connection conn = getConnect();
		String sql = "insert into TBL_EMP (emp_no, emp_name, phone, hire_date, salary)\r\n" + "values ( ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getEmp_no());
			stmt.setString(2, emp.getEmp_name());
			stmt.setInt(3, emp.getPhone());
			stmt.setString(4, emp.getHire_date());
			stmt.setInt(5, emp.getSalary());

			int r = stmt.executeUpdate(sql);
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // 등록실패.
	}

	// 수정.
	public boolean update(Employee emp) {
		Connection conn = getConnect();
		String sql = "update TBL_EMP " + "set     emp_no = nvl(?, emp_no) " + "    ,emp_name  = nvl(?, emp_name) "
				+ "    ,phone     = ? " + "    ,hire_date    = nvl(?, hire_date) " + "    ,salary    = ? "
				+ "    where  hire_date  = ?";
		try {

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getEmp_no());
			stmt.setString(2, emp.getEmp_name());
			stmt.setInt(3, emp.getPhone());
			stmt.setString(4, emp.getHire_date());
			stmt.setInt(5, emp.getSalary());

			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// 삭제.
	public boolean delete(String Hire_date) {
		Connection conn1 = getConnect();
		String sql = "delete from TBL_EMP" + "where hire_date='" + Hire_date + "'";
		try {
			Statement dstmt = conn1.createStatement();
			int d = dstmt.executeUpdate(sql);
			if (d > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	   // 조회.
	public static List<Employee> search (Employee emp) {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnect();
		String sql = "select * from TBL_EMP" + "where employee = nvl( ?, employee) " + "order by hire_date";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, sql);

			ResultSet rs = psmt.executeQuery(); // 조회.
			while (rs.next()) {
				Employee emp1 = new Employee();
				emp1.setEmp_no(rs.getString("emp_no"));
				emp1.setEmp_name(rs.getString("emp_name"));
				emp1.setPhone(rs.getInt("phone"));
				emp1.setHire_date(rs.getString("hire_date"));
				emp1.setSalary(rs.getInt("salary"));
				list.add(emp1); // 컬렉션 저장.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // 목록.

	public List<Employee> list(String employee) {
		List<Employee> list = new ArrayList<Employee>();
		Connection conn = getConnect();
		String sql = "select * from TBL_EMP" + "where employee = nvl( ?, employee) ";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, employee);

			ResultSet rs = psmt.executeQuery(); // 조회.
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmp_no(rs.getString("emp_no"));
				emp.setEmp_name(rs.getString("emp_name"));
				emp.setPhone(rs.getInt("phone"));
				emp.setHire_date(rs.getString("hire_date"));
				emp.setSalary(rs.getInt("salary"));
				list.add(emp); // 컬렉션 저장.
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	} // end of 목록.
}