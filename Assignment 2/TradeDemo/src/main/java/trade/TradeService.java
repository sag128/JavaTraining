package trade;

//Sample Trade Ids:
//London : 121456903
//Newyork : 12232140
//Tokyo : 12345678
public class TradeService {

	public TradeService(RegionalDaoManager regionalDaoManager) {
		this.regionalDaoManager = regionalDaoManager;
	}
	public TradeService() {

	}

	private RegionalDaoManager regionalDaoManager;
	
	public TradeDetails getTradeDetails(long tradeId) {
		Region region = getTradeRegion(tradeId);
		RegionalDao regionalDao = regionalDaoManager.getRegionalDao(region);
		TradeDetails tradeDetails = regionalDao.getTradeDetails(tradeId);
		tradeDetails.setRegion(region);
		return tradeDetails;
	}

	protected Region getTradeRegion(long tradeId) {
		int regionCode = Integer.parseInt(String.valueOf(String.valueOf(tradeId).charAt(2)));
		switch (regionCode) {
		case 1:
			return Region.LONDON;
		case 2:
			return Region.NEWYORK;
		case 3:
			return Region.TOKYO;
		}
		throw new IllegalArgumentException("Invalid TradeId");
	}
}
