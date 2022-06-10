package trade;

import javax.sql.DataSource;

import ds.MySqlDataSource;

public class LondonDao extends RegionalDao {

	@Override
	public DataSource getDataSource() {
		return new MySqlDataSource();
	}

}
