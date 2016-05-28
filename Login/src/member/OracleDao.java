package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DataSourceUtils;

public class OracleDao implements Dao {
	private Connection conn;
	private PreparedStatement pstmt = null;
	private DataSource dataSource;

	public OracleDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into member4 values(?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getMsg());
			pstmt.executeUpdate();
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
			discon();
		}
	}

	@Override
	public Member select(String id) {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from member4 where id = ?";
		ResultSet rs = null;
		Member m = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				m = new Member(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
			discon();
		}
		return m;
	}

	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "update member4 set pwd = ?, name = ?,msg = ? where id=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getMsg());
			pstmt.setString(4, m.getId());
			pstmt.executeUpdate();
			pstmt.close();
			System.out.println("���� �Ϸ�");
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
			discon();
		}
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete from member4 where id = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeQuery();
			pstmt.close();
			discon();
		} catch (SQLException e) {
			e.printStackTrace();
			discon();
		}
		
	}

	@Override
	public void con() {
		// TODO Auto-generated method stub
		conn = DataSourceUtils.getConnection(dataSource);
		//Spring IOC�����̳ʰ� ������ (������ ���Ͽ���)
	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		DataSourceUtils.releaseConnection(conn, dataSource);
	}

}
