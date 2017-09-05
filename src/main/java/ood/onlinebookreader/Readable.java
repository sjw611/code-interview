package ood.onlinebookreader;

import java.math.BigDecimal;
import java.util.List;

public interface Readable {
	int getNumberOfPages();
	BigDecimal getCost();
	String getAuthor();
	int getNumberOfHits();
	String getTitle();
	List<Page> getPages();
	Page getPage(int pageNumber);
}
