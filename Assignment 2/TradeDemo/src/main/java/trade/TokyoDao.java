package trade;

import javax.sql.DataSource;

import ds.SqlServerDataSource;

public class TokyoDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new SqlServerDataSource();
	}

}
