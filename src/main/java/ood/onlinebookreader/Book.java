package ood.onlinebookreader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Book implements Readable {

	private List<Page> pages = new ArrayList<>();
	
	@Override
	public int getNumberOfPages() {
		return 0;
	}

	@Override
	public BigDecimal getCost() {
		return null;
	}

	@Override
	public String getAuthor() {
		return null;
	}

	@Override
	public int getNumberOfHits() {
		return 0;
	}

	@Override
	public String getTitle() {
		return null;
	}

	@Override
	public List<Page> getPages() {
		return Collections.unmodifiableList(pages);
	}

	@Override
	public Page getPage(int pageNumber) {
		return null;
	}

}
