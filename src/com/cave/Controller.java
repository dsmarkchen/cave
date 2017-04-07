package com.cave;

import com.cave.word.WordConsts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static com.cave.Motion.D;

public class Controller {
    static int LOC_LIGHTED = 1;   /* bit position for a location isn't dark*/
    static int LOC_OIL = 2;   /* bit position for presence of oil */
    static int LOC_LIQUID = 4;   /* bit position for presensce of liquid (oil or water) */
    static int CAV_HINT = 8;   /* hint about trying to get in the cave */
    static int BIRD_HINT = 16;  /* hint about catch the bird */
    static int SNAKE_HINT = 32;  /* hint about dealing with the sname */
    static int TWIST_HINT = 64;  /* hint about being lost in the maze */
    static int DARK_HINT = 128; /* hint about the dark room */
    static int WITT_HINT = 256; /* hint about Witt's end */

    static int TRAVEL_SIZE = 740; /* at most this many instructions */
    static int REM_SIZE = 15;  /* at most this many remarks */
    static int MAX_LOC = 140;
    Instruction[] _travales;

    List<LocationEntity> _locationEntityList;

    private List<ObjectEntity> _objectEntityList;
    private List<ObjectsInLocation> _objectsInLocationList;


    public Controller() {
        _travales = new Instruction[TRAVEL_SIZE];
        _locationEntityList = new ArrayList<>();

        _objectsInLocationList = getObjectInLocationList();
        _objectEntityList = getObjectEntityList();
    }


    private List<ObjectsInLocation> getObjectInLocationList() {
        return Arrays.asList(
                new ObjectsInLocation(Location.house)
                        .drop(Object.KEYS, 0)
                        .drop(Object.LAMP, 0)
                        .drop(Object.FOOD, 0)
                        .drop(Object.BOTTLE, 0),
                new ObjectsInLocation(Location.cobbles)
                        .drop(Object.CAGE, 0),
                new ObjectsInLocation(Location.debris)
                        .drop(Object.ROD, 0),
                new ObjectsInLocation(Location.outside)
                        .drop(Object.GRATE, 0)
        );
    }

    private List<ObjectEntity> getObjectEntityList() {
        return Arrays.asList(
                new ObjectEntity(Object.GRATE)
                        .addNote("the grate is locked.")
                        .addNote("the grate is open.")
                        .setObjectState(ObjectEntity.ObjectState.STATE_CLOSE),
                new ObjectEntity(Object.ROD)
                        .addNote("A three-foot black rod with a rusty star on an end lies nearby."),
                new ObjectEntity(Object.CAGE)
                        .addNote("There is a small wicker cage discarded nearby."),
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

    public ObjectsInLocation getObjectInLocation(Location place) {
        Iterator<ObjectsInLocation> iter = _objectsInLocationList.iterator();
        while (iter.hasNext()) {
            ObjectsInLocation res = iter.next();
            if (res.place() == place) {
                return res;
            }
        }
        return null;
    }

    public void open(Location place) {
        Object target = Object.NOTHING;
        Iterator<ObjectsInLocation> iter = _objectsInLocationList.iterator();
        while (iter.hasNext()) {
            ObjectsInLocation res = iter.next();
            if (res.place() == place) {
                target = res.first();
                break;
            }
        }
        if(target != Object.NOTHING)
            setObjectOpen(target);
    }
    private void setObjectOpen(Object object) {
        Iterator<ObjectEntity> iter = _objectEntityList.iterator();
        while (iter.hasNext()) {
            ObjectEntity item = iter.next();
            if (item.object() == object) {
                item.setObjectState(ObjectEntity.ObjectState.STATE_OPEN);
            }
        }
    }




    public void take(Location place, Object obj) {
        Iterator<ObjectsInLocation> iter = _objectsInLocationList.iterator();
        while (iter.hasNext()) {
            ObjectsInLocation res = iter.next();
            if (res.place() == place) {
                res.take(obj);
                updateTakenState(obj);
            }
        }
    }

    private void updateTakenState(Object object) {
        Iterator<ObjectEntity> iter = _objectEntityList.iterator();
        while (iter.hasNext()) {
            ObjectEntity item = iter.next();
            if (item.object() == object) {
                item.setObjectState(ObjectEntity.ObjectState.STATE_TAKEN);
                break;
            }
        }

    }

    public String describeLocationObjectNotes(ObjectsInLocation objectsInLocation) {
        int offset;
        StringBuilder sb = new StringBuilder();
        if (objectsInLocation == null) return "";
        Iterator<ObjectEntity> iter = _objectEntityList.iterator();
        while (iter.hasNext()) {
            ObjectEntity entity = iter.next();
            if (!objectsInLocation.at(entity.object())) {
                continue;
            }
            offset = objectsInLocation.getOffsets(entity.object());
            if (offset >= 0) {
                sb.append(entity.getNote(offset));
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public int q = 0;
    public int _locIndex = 0;

    private void makeInstruction(Motion motion, int cond, Location dest) {
        _travales[q] = new Instruction(motion, cond, dest);
        q++;
    }


    private LocationEntity makeLocation(Location loc, String longDesc, String shortDesc, int flag, int q) {
        return new LocationEntity(loc, longDesc, shortDesc, flag, q);
    }

    private void ditto(Motion motion) {
        _travales[q] = new Instruction(motion, _travales[q - 1].condition(), _travales[q - 1].dest());
        q++;
    }

    final boolean debugInstruction = false;
    final boolean debugLocationEntityList = false;

    @Override
    public String toString() {
        List<Integer> listPostions = new ArrayList<>();

        StringBuilder sb = new StringBuilder();

        if(debugLocationEntityList) {
            for (LocationEntity loc : _locationEntityList) {
                sb.append(loc.toString() + "\n");
                listPostions.add(loc.start());
            }
        }

        for (ObjectEntity objectEntity : _objectEntityList) {
            sb.append(objectEntity.toString() + "\n");
        }
        if (debugInstruction) {
            int i = 0;
            for (Instruction ins : _travales) {
                if (ins != null) {
                    String flag = " ";
                    if (listPostions.contains(i)) flag = "*";
                    sb.append(String.format("%s%03d %s %s\n", flag, i++, ins.motion(), ins.dest().toString()));
                }
            }
        }
        return sb.toString();
    }

    public void build() {
        buildRoad();
        buildHill();
        buildHouse();
        buildValley();
        buildForestAndWoods();

        _locationEntityList.add(_locIndex++, makeLocation(Location.slit,
                WordConsts.LONG_SLIT,
                WordConsts.SHORT_SLIT,
                0,
                q));
        makeInstruction(Motion.HOUSE, 0, Location.road);
        makeInstruction(Motion.UPSTREAM, 0, Location.valley);
        ditto(Motion.N);
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.E);
        ditto(Motion.W);
        makeInstruction(Motion.DOWNSTREAM, 0, Location.outside);
        ditto(Motion.ROCK);
        ditto(Motion.BED);
        ditto(Motion.S);

        _locationEntityList.add(_locIndex++, makeLocation(Location.outside,
                WordConsts.LONG_OUTSIDE,
                WordConsts.SHORT_OUTSIDE,
                0,
                q));
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.E);
        ditto(Motion.W);
        ditto(Motion.S);
        makeInstruction(Motion.UPSTREAM, 0, Location.slit);
        ditto(Motion.N);
        makeInstruction(Motion.HOUSE, 0, Location.road);
        makeInstruction(Motion.ENTER, 300 + Object.GRATE.getIndex() + 100 * 0, Location.inside);
        ditto(Motion.ENTER);
        ditto(Motion.D);
        ditto(Motion.IN);

        _locationEntityList.add(_locIndex++, makeLocation(Location.inside,
                WordConsts.LONG_INSIDE,
                WordConsts.SHORT_INSIDE,
                0,
                q));
        makeInstruction(Motion.OUT, 0, Location.outside);
        makeInstruction(Motion.U, 0, Location.outside);
        makeInstruction(Motion.CRAWL, 0, Location.cobbles);
        ditto(Motion.COBBLES);
        ditto(Motion.IN);
        ditto(Motion.W);
        makeInstruction(Motion.PIT, 0, Location.spit);
        makeInstruction(Motion.DEBRIS, 0, Location.debris);

        _locationEntityList.add(_locIndex++, makeLocation(Location.cobbles,
                WordConsts.LONG_COBBLES,
                WordConsts.SHORT_COBBLES,
                0,
                q));


        _locationEntityList.add(_locIndex++, makeLocation(Location.debris,
                WordConsts.LONG_DEBRIS,
                WordConsts.SHORT_DEBRIS,
                0,
                q));

        _locationEntityList.add(_locIndex++, makeLocation(Location.awk,
                WordConsts.LONG_AWKWARD,
                "",
                0,
                q));

        _locationEntityList.add(_locIndex++, makeLocation(Location.bird,
                WordConsts.LONG_BIRD,
                WordConsts.SHORT_BIRD,
                0,
                q));

        buildRestLocations();
    }

    private void buildRoad() {
        _locationEntityList.add(_locIndex++, makeLocation(Location.road,
                WordConsts.LONG_ROAD,
                WordConsts.SHORT_ROAD,
                0,
                q));
        makeInstruction(Motion.W, 0, Location.hill);
        ditto(Motion.U);
        ditto(Motion.ROAD);

        makeInstruction(Motion.E, 0, Location.house);
        ditto(Motion.IN);
        ditto(Motion.HOUSE);
        ditto(Motion.ENTER);

        makeInstruction(Motion.S, 0, Location.valley);
        ditto(D);
        ditto(Motion.GULLY);
        ditto(Motion.STREAM);
        ditto(Motion.DOWNSTREAM);

        makeInstruction(Motion.N, 0, Location.forest);
        ditto(Motion.WOODS);

        makeInstruction(Motion.DEPRESSION, 0, Location.outside);

    }

    private void buildHill() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.hill,
                        WordConsts.LONG_HILL,
                        WordConsts.SHORT_HILL,
                        0,
                        q));

        makeInstruction(Motion.ROAD, 0, Location.road);
        ditto(Motion.HOUSE);
        ditto(Motion.FORWARD);
        ditto(Motion.E);
        ditto(D);
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.N);
        ditto(Motion.S);
    }

    private void buildHouse() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.house,
                        WordConsts.LONG_HOUSE,
                        WordConsts.SHORT_HOUSE,
                        0,
                        q));

        makeInstruction(Motion.ENTER, 0, Location.road);
        ditto(Motion.OUT);
        ditto(Motion.OUTDOORS);
        ditto(Motion.W);
        makeInstruction(Motion.DOWNSTREAM, 0, Location.sewer);
    }

    private void buildValley() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.valley,
                        WordConsts.LONG_VALLEY,
                        WordConsts.SHORT_VALLEY,
                        0,
                        q));
        makeInstruction(Motion.UPSTREAM, 0, Location.road);
        ditto(Motion.HOUSE);
        ditto(Motion.N);
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.E);
        ditto(Motion.W);
        ditto(Motion.U);
        makeInstruction(Motion.DOWNSTREAM, 0, Location.slit);
        ditto(Motion.S);
        ditto(Motion.D);
        makeInstruction(Motion.DEPRESSION, 0, Location.outside);
    }

    private void buildForestAndWoods() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.forest,
                        WordConsts.LONG_FOREST,
                        WordConsts.SHORT_FOREST,
                        0,
                        q));
        makeInstruction(Motion.S, 0, Location.road); // don knuth's code dont have this??
        makeInstruction(Motion.VALLEY, 0, Location.valley);
        ditto(Motion.E);
        ditto(Motion.D);
        makeInstruction(Motion.WOODS, 50, Location.forest);
        ditto(Motion.FORWARD);
        ditto(Motion.N);

        _locationEntityList.add(_locIndex++,
                makeLocation(Location.woods,
                        WordConsts.LONG_WOODS,
                        WordConsts.SHORT_FOREST, // woods is part of forest
                        0,
                        q));
        makeInstruction(Motion.ROAD, 0, Location.road);
        ditto(Motion.N);
        makeInstruction(Motion.VALLEY, 0, Location.valley);
        ditto(Motion.E);
        ditto(Motion.W);
        ditto(Motion.D);
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.S);
    }

    private void buildRestLocations() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.sewer,
                        WordConsts.LONG_SEWER,
                        "",
                        0,
                        q));
        makeInstruction(Motion.FORCE, 0, Location.house);

    }

    public String longDesc(Location loc) {
        for (LocationEntity entity : _locationEntityList) {
            if (entity.location() == loc) {
                return entity.longDesc();
            }
        }
        return "";
    }

    public String shortDesc(Location loc) {
        for (LocationEntity entity : _locationEntityList) {
            if (entity.location() == loc) {
                return entity.shortDesc();
            }
        }
        return "";
    }

    private boolean check(int condition) {

        if (condition == 0) {
            return true;
        }
        if (condition > 300) {
            int x = condition;
            int k = (x - 300) / 100;
            int o = x - 300 - 100 * k;
            Object obj = Object.getValue(o);
            System.out.println(obj.toString());
            for (ObjectEntity objectEntity : _objectEntityList) {
                if(objectEntity.object() == obj) {
                   if(objectEntity.getObjectState()  == ObjectEntity.ObjectState.STATE_OPEN) {
                       return true;
                   }
                   else {
                       return false;
                   }
                }
             }




        }
        return false;
    }

    public Location move(Motion motion, Location loc) {
        int start = -1;
        int end = -1;
        boolean stopit = false;
        Location origLocation = Location.inhand;


        for (LocationEntity locationEntity : _locationEntityList) {
            if (stopit == true) {
                end = locationEntity.start();
            }
            if (locationEntity.location() == loc) {

                origLocation = loc;
                if (motion == Motion.LOOK) {
                    System.out.println(longDesc(loc));
                    return loc;
                }

                start = locationEntity.start();
                stopit = true;
            }
        }

        for (int i = start; i < end; i++) {
            if (_travales[i].motion() == motion) {
                if (_travales[i].condition() != 0) {
                    if (!check(_travales[i].condition())) {
                        return origLocation;
                    }
                }
                String shortDesc = shortDesc(_travales[i].dest());
                if (!shortDesc.isEmpty()) System.out.println(shortDesc);
                return _travales[i].dest();
            }
        }
        return Location.inhand;
    }
}
