package ood;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyHashTableTest {

    private MyHashTable<String, Integer> sut = new MyHashTable<>();
    
    @Test
    public void test() {
        assertTrue(sut.isEmpty());
        assertEquals(0, sut.size());
        
        assertTrue(sut.put("Justin", 1000));
        
        assertFalse(sut.isEmpty());
        assertEquals(1, sut.size());
        
        assertTrue(sut.containsKey("Justin"));
        assertFalse(sut.containsKey("Justing"));
        
        sut.put("Justin", 10);
        sut.put("Jingwei", 20);
        sut.put("Song", 30);
        sut.put("song", 40);
        sut.put("SONG", 50);
        
        assertEquals(10, sut.get("Justin").intValue());
        
        assertEquals(5, sut.size());
        
        assertEquals(50, sut.remove("SONG").intValue());
        assertEquals(4, sut.size());
    }

}
