package trade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

public abstract class RegionalDao {
	
	public abstract DataSource getDataSource();
	
	public TradeDetails getTradeDetails(long tradeId) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = getDataSource().getConnection();
			String sql = "select status from trades where tradeId = ?";
			pst = conn.prepareStatement(sql);
			pst.setLong(1, tradeId);
			rs = pst.executeQuery();

			if(rs.next()) {
				TradeDetails tradeDetails = new TradeDetails();
				tradeDetails.setTradeId(tradeId);
				tradeDetails.setStatus(rs.getInt("status"));
				return tradeDetails;
			}
			throw new RuntimeException("No record found!");
		}
		catch(SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			try { rs.close(); pst.close(); conn.close(); } catch(Exception e) { }
		}
	}
}
