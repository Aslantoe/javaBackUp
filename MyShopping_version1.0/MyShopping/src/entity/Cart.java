package entity;

public class Cart {

	private Integer cid;
	private String bimgurl;
	private String btitle;
	private Double bprice;
	private Integer bcount;
	private Integer bid;
	
	public Cart() {
		
	}
	
	public Cart(Integer bcount, Integer bid) {
		
		this.bcount = bcount;
		this.bid = bid;
	}

	public Cart( String bimgurl, String btitle, Double bprice,
			Integer bcount, Integer bid) {
		
		this.bimgurl = bimgurl;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bcount = bcount;
		this.bid = bid;
	}

	public Cart(Integer cid, String bimgurl, String btitle, Double bprice,
			Integer bcount, Integer bid) {
	
		this.cid = cid;
		this.bimgurl = bimgurl;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bcount = bcount;
		this.bid = bid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public Integer getBcount() {
		return bcount;
	}

	public void setBcount(Integer bcount) {
		this.bcount = bcount;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	@Override
	public String toString() {
		return "Cart [cid=" + cid + ", bimgurl=" + bimgurl + ", btitle="
				+ btitle + ", bprice=" + bprice + ", bcount=" + bcount
				+ ", bid=" + bid + "]";
	}
	
	
	
	
	
}
