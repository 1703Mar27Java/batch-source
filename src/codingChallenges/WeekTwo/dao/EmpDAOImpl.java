package codingChallenges.WeekTwo.dao;

import java.sql.*;

import codingChallenges.WeekTwo.util.ConnectionUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void giveRaise(int deptID, int raiseAmt) {
		Connection con;
		try {
			con = ConnectionUtil.getConnection();
			// (DEPT_ID IN NUMBER, RAISE_AMT IN NUMBER, NEW_AVERAGE OUT NUMBER,
			// IS_VALID_DEPT OUT NUMBER, TEXT_OUT OUT VARCHAR)
			String sql = "BEGIN SP_GIVE_RAISE(?, ?, ?, ?, ?); END;";
			CallableStatement cstmt = con.prepareCall(sql);
			cstmt.setInt(1, deptID);
			cstmt.setInt(2, raiseAmt);
			cstmt.registerOutParameter(3, Types.DOUBLE);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.registerOutParameter(5, Types.VARCHAR);
			cstmt.execute();
			//invalid deptID
			if(cstmt.getInt(4)==0){
				System.out.println(cstmt.getString(5));
			}
			else{
				System.out.println(cstmt.getString(5)+" with a new average of " + cstmt.getDouble(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
