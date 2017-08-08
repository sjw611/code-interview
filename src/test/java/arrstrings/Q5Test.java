package arrstrings;

import static org.junit.Assert.*;

import org.junit.Test;

public class Q5Test {

    private Q5 sut = new Q5();
    
    @Test(expected = NullPointerException.class)
    public void inputValidationSrcNull() {
        sut.isOneEditAway(null, "Hello");
    }
    
    @Test(expected = NullPointerException.class)
    public void inputValidationDestNull() {
        sut.isOneEditAway("Hello", null);
    }
    
    @Test(expected = NullPointerException.class)
    public void inputValidationBothNull() {
        sut.isOneEditAway(null, null);
    }

    @Test
    public void oneEditAway() {
        assertTrue(sut.isOneEditAway("pale", "ple"));
        assertTrue(sut.isOneEditAway("ple", "pale"));
        assertTrue(sut.isOneEditAway("pales", "pale"));
        assertTrue(sut.isOneEditAway("pale", "bale"));
    }
    
    @Test
    public void same() {
        assertTrue(sut.isOneEditAway("pale", "pale"));
    }
    
    @Test
    public void moreEdits() {
        assertFalse(sut.isOneEditAway("pale", "bake"));
        assertFalse(sut.isOneEditAway("pale", "pablec"));
    }
}
