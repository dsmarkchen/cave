package test.cave;

import com.cave.Location;
import com.cave.Object;
import com.cave.ObjectEntity;
import com.cave.ObjectsInLocation;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class ObjectsInLocationTest {
    private List<ObjectEntity> _objectEntity;
    private ObjectsInLocation _objectsInLocation = new ObjectsInLocation(Location.house);

    @Before
    public void setUp() throws Exception {
        _objectEntity = Arrays.asList(
                new ObjectEntity(Object.KEYS)
                        .addNote("There are some keys on the ground here."),
                new ObjectEntity(Object.LAMP)
                        .addNote("There is a shiny brass lamp nearby. ")
                        .addNote("There is lamp shining nearby."),
                new ObjectEntity(Object.FOOD)
                        .addNote("There is food here. "),
                new ObjectEntity(Object.BOTTLE)
                        .addNote("There is a bottle of water here. ")
                        .addNote("There is a empty bottle here. ")
                        .addNote("There is a bottle of oil here. "));
    }

    @Test
    public void takeBottle_noBottle() throws Exception {
        _objectsInLocation.drop(Object.KEYS, 0);
        _objectsInLocation.drop(Object.LAMP, 0);
        _objectsInLocation.drop(Object.FOOD, 0);
        _objectsInLocation.drop(Object.BOTTLE, 0);
        _objectsInLocation.take(Object.BOTTLE);
        assertFalse(_objectsInLocation.at(Object.BOTTLE));
        int offset;
        StringBuilder sb = new StringBuilder();
        Iterator<ObjectEntity> iter = _objectEntity.iterator();
        while (iter.hasNext()) {
            ObjectEntity entity = iter.next();
            if (!_objectsInLocation.at(entity.object())) {
                continue;
            }
            offset = _objectsInLocation.getOffsets(entity.object());
            if (offset >= 0) {
                sb.append(entity.getNote(offset));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        assertFalse(sb.toString().contains("bottle"));

    }

    @Test
    public void default_containsKeysLampFoodandBottle() throws Exception {
        _objectsInLocation.drop(Object.KEYS, 0);
        _objectsInLocation.drop(Object.LAMP, 0);
        _objectsInLocation.drop(Object.FOOD, 0);
        _objectsInLocation.drop(Object.BOTTLE, 0);
        assertTrue(_objectsInLocation.at(Object.BOTTLE));


        int offset;
        StringBuilder sb = new StringBuilder();
        Iterator<ObjectEntity> iter = _objectEntity.iterator();
        while (iter.hasNext()) {
            ObjectEntity entity = iter.next();
            if (!_objectsInLocation.at(entity.object())) {
                continue;
            }
            offset = _objectsInLocation.getOffsets(entity.object());
            if (offset >= 0) {
                sb.append(entity.getNote(offset));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
        assertTrue(sb.toString().contains("food"));
        assertTrue(sb.toString().contains("lamp"));
        assertTrue(sb.toString().contains("keys"));
        assertTrue(sb.toString().contains("bottle"));
    }

}