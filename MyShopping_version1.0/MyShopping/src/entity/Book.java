package entity;

public class Book {

	private Integer bid;
	private String btitle;
	private String bauthor;
	private String bpublisher;
	private Double bprice;
	private String bimgurl;
	
	public Book() {
		
	}

	public Book(Integer bid, String btitle, String bauthor, String bpublisher,
			Double bprice, String bimgurl) {
		
		this.bid = bid;
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bprice = bprice;
		this.bimgurl = bimgurl;
	}

	public Book(String btitle, String bauthor, String bpublisher,
			Double bprice, String bimgurl) {
	
		this.btitle = btitle;
		this.bauthor = bauthor;
		this.bpublisher = bpublisher;
		this.bprice = bprice;
		this.bimgurl = bimgurl;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBauthor() {
		return bauthor;
	}

	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}

	public String getBpublisher() {
		return bpublisher;
	}

	public void setBpublisher(String bpublisher) {
		this.bpublisher = bpublisher;
	}

	public Double getBprice() {
		return bprice;
	}

	public void setBprice(Double bprice) {
		this.bprice = bprice;
	}

	public String getBimgurl() {
		return bimgurl;
	}

	public void setBimgurl(String bimgurl) {
		this.bimgurl = bimgurl;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", btitle=" + btitle + ", bauthor="
				+ bauthor + ", bpublisher=" + bpublisher + ", bprice=" + bprice
				+ ", bimgurl=" + bimgurl + "]";
	}
	
	
	
	
	
}
