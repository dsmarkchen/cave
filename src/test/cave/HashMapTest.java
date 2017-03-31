package test.cave;

import com.cave.Motion;
import com.cave.hash.HashMap;
import com.cave.word.WordType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HashMapTest {
    private HashMap _hashMap;

    @Before
    public void setUp() throws Exception {
        _hashMap = new HashMap();
    }

    @Test
    public void get() throws Exception {
        _hashMap.put("north", WordType.motion_type, Motion.N.ordinal());
        _hashMap.put("south", WordType.motion_type, Motion.S.ordinal());

        int i = _hashMap.get("north");
        assertTrue(i > 0);
        int j = _hashMap.get("south");
        assertTrue(j > 0);
        assertTrue(i != j);
    }

    @Test
    public void get2() throws Exception {
        _hashMap.put("north", WordType.motion_type, Motion.N.ordinal());
        _hashMap.put("n", WordType.motion_type, Motion.N.ordinal());
        _hashMap.put("south", WordType.motion_type, Motion.S.ordinal());
        _hashMap.put("s", WordType.motion_type, Motion.S.ordinal());

        int i = _hashMap.get("north");
        assertTrue(i > 0);
        int i2 = _hashMap.get("n");
        assertTrue(i2 > 0);
        int j = _hashMap.get("south");
        assertTrue(j > 0);
        int j2 = _hashMap.get("s");
        assertTrue(j2 > 0);
        assertTrue(i != j);


    }


}