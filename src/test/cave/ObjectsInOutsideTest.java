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

public class ObjectsInOutsideTest {
    private List<ObjectEntity> _objectEntity;
    private ObjectsInLocation _objectsInHouse= new ObjectsInLocation(Location.house);
    private ObjectsInLocation _objectsInOutside = new ObjectsInLocation(Location.outside);

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
                        .addNote("There is a bottle of oil here. "),
                new ObjectEntity(Object.GRATE)
                        .setObjectState(ObjectEntity.ObjectState.STATE_CLOSE)
                        .addNote("The grate is locked.")
                        .addNote("The grate is open."));
        _objectsInHouse.drop(Object.KEYS, 0);
        _objectsInHouse.drop(Object.LAMP, 0);
        _objectsInHouse.drop(Object.FOOD, 0);
        _objectsInHouse.drop(Object.BOTTLE, 0);
        _objectsInOutside.drop(Object.GRATE, 0);
    }

    @Test
    public void dropGrateStateIsLocked() throws Exception {
        int offset;
        StringBuilder sb = new StringBuilder();
        Iterator<ObjectEntity> iter = _objectEntity.iterator();
        while (iter.hasNext()) {
            ObjectEntity entity = iter.next();

            sb.append(entity.object() + " at location: " + _objectsInOutside.at(entity.object()) + ", ");

            // update house
            if (_objectsInOutside.place() == Location.house && _objectsInOutside.at(entity.object()) == false) {
                entity.setObjectState(ObjectEntity.ObjectState.STATE_TAKEN);
            }

            sb.append("state:  " + entity.getObjectState().toString() + "\n");

            offset = _objectsInOutside.getOffsets(entity.object());
            if (offset >= 0) {
                sb.append(entity.getNote(offset));
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}
