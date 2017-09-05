package ood.onlinebookreader;

public class Page {
	private String content;
	private int pageNumber;

	public Page(int pageNumber, String content) {
		this.content = content;
		this.pageNumber = pageNumber;
	}

	public String getContent() {
		return content;
	}

	public int getPageNumber() {
		return pageNumber;
	}
}
