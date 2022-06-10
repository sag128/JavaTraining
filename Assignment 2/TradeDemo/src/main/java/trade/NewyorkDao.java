package trade;

import javax.sql.DataSource;

import ds.OracleDataSource;

public class NewyorkDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new OracleDataSource();
	}

}
