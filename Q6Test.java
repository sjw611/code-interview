package arrstr;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q6Test {

    private Q6 sut = new Q6();
    
    @Test(expected = NullPointerException.class)
    public void nullCheck() {
        sut.compress(null);
    }

    @Test
    public void empty() {
        assertEquals("", sut.compress(""));
    }
    
    @Test
    public void noCompression() {
        assertEquals("jack", sut.compress("jack"));
        assertEquals("aabbcc", sut.compress("aabbcc"));
    }
    
    @Test
    public void compress() {
        assertEquals("j1a1c1k6", sut.compress("jackkkkkk"));
        assertEquals("a2b1c5a3", sut.compress("aabcccccaaa"));
    }
}
