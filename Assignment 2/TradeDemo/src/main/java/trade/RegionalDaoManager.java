package trade;

public class RegionalDaoManager {
	
	public RegionalDao getRegionalDao(Region region) {
		switch(region) {
		case LONDON:
			return new LondonDao();
		case NEWYORK:
			return new NewyorkDao();
		case TOKYO:
			return new TokyoDao();
		}
		throw new IllegalArgumentException("Unexpected error!");
	}
}
