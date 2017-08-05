package treegraph;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrefixTreeTest {

	private PrefixTree sut = new PrefixTree();
	
	@Test
	public void test() {
		sut.insert("MANY");
		
		System.out.println(sut.root);
		
		sut.insert("MY");
		
		System.out.println(sut.root);
		
		sut.insert("LIE");
		
		System.out.println(sut.root);
		
		sut.insert("A");
		
		System.out.println(sut.root);
		
		sut.insert("MAN");
		
		System.out.println(sut.root);
		
		assertTrue(sut.lookup("M"));
		assertTrue(sut.lookup("MA"));
		assertTrue(sut.lookup("MAN"));
		assertTrue(sut.lookup("MANY"));
		assertFalse(sut.lookup("MK"));
	}

}
