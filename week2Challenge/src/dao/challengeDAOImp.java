package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import domain.Department;
import util.ConnectionUtil;

public class challengeDAOImp implements challengeDAO {
	
	@Override
	public ArrayList<Department> getDepartments(){
		ArrayList<Department> deps = new ArrayList<Department>();
		try (Connection con = ConnectionUtil.getConnection()) {
			String userQuery = "SELECT DEPARTMENT_NAME, AVG(SALARY) FROM EMPLOYEE "
					+ "INNER JOIN DEPARTMENT ON EMPLOYEE.DEPARTMENT_ID = DEPARTMENT.DEPARTMENT_ID GROUP BY DEPARTMENT_NAME";

			PreparedStatement pstmt = con.prepareStatement(userQuery);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				deps.add(new Department(rs.getString(1), rs.getInt(2)));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deps;
	}
	
	@Override
	public void callRaise(int id, double raise){
		try (Connection con = ConnectionUtil.getConnection()) {
			String depositCall = "{CALL SP_GIVE_RAISE (?, ?)}";

			CallableStatement cstmt = con.prepareCall(depositCall);
			cstmt.setInt(1, id);
			cstmt.setDouble(2, raise);
			cstmt.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
