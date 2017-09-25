package entity;

public class Cart {

	private Integer cid;
	private String btitle;
	private String bimgurl;
	private Integer bcount;
	private Integer bid;
	
	public Cart() {}

	public Cart( String btitle, String bimgurl, Integer bcount,
			Integer bid) {
		this.btitle = btitle;
		this.bimgurl = bimgurl;
		this.bcount = bcount;
		this.bid = bid;
	}

	public Cart(Integer cid, String btitle, String bimgurl, Integer bcount,
			Integer bid) {
		
		this.cid = cid;
		this.btitle = btitle;
		this.bimgurl = bimgurl;
		this.bcount = bcount;
		this.bid = bid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
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
		return "Cart [cid=" + cid + ", btitle=" + btitle + ", bimgurl="
				+ bimgurl + ", bcount=" + bcount + ", bid=" + bid + "]";
	}
  
	
	

	
	
	
}
