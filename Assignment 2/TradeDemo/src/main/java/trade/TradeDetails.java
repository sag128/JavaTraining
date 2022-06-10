package trade;

public class TradeDetails {

	private long tradeId;
	private Region region;

	public TradeDetails(long tradeId, Region region, int status) {
		this.tradeId = tradeId;
		this.region = region;
		this.status = status;
	}
	public TradeDetails() {

	}

	private int status;
	
	public long getTradeId() {
		return tradeId;
	}
	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TradeDetails [tradeId=" + tradeId + ", region=" + region
				+ ", status=" + status + "]";
	}
}
