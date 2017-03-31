package com.cave;

import java.util.ArrayList;
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


    public Controller() {
        _travales = new Instruction[TRAVEL_SIZE];
        _locationEntityList = new ArrayList<>();
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

    @Override
    public String toString() {
        List<Integer> listPostions = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        for (LocationEntity loc : _locationEntityList) {
            sb.append(String.format("%s: %03d\n", loc.location().toString(), loc.start()));
            listPostions.add(loc.start());
        }

        int i = 0;
        for (Instruction ins : _travales) {
            if (ins != null) {
                String flag = " ";
                if (listPostions.contains(i)) flag = "*";
                sb.append(String.format("%s%03d %s %s\n", flag, i++, ins.motion(), ins.dest().toString()));
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
    }

    private void buildRoad() {
        _locationEntityList.add(_locIndex++, makeLocation(Location.road,
                "you are standing...",
                "you are at end of road again",
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
                        "you are walking up hill...",
                        "you are at hill",
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
                        "you are inside a building...",
                        "you are inside",
                        0,
                        q));

        makeInstruction(Motion.ENTER, 0, Location.road);
        ditto(Motion.OUT);
        ditto(Motion.OUTDOORS);
        ditto(Motion.W);
    }

    private void buildValley() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.valley,
                        "you are in a valley in the forest...",
                        "you're in valley",
                        0,
                        q));
        makeInstruction(Motion.UPSTREAM, 0, Location.road);
        ditto(Motion.HOUSE);
        ditto(Motion.N);
        makeInstruction(Motion.WOODS, 0, Location.forest);
        ditto(Motion.E);
        ditto(Motion.W);
        ditto(Motion.U);
    }

    private void buildForestAndWoods() {
        _locationEntityList.add(_locIndex++,
                makeLocation(Location.forest,
                        "you are in open forest beside a stream...",
                        "you're in forest.",
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
                        "you are in open woods near both a valley and a road...",
                        "you're in forest",
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

    public Location move(Motion motion, Location loc) {
        int start = -1;
        int end = -1;
        boolean stopit = false;

        for (LocationEntity locationEntity : _locationEntityList) {
            if (stopit == true) {
                end = locationEntity.start();
            }
            if (locationEntity.location() == loc) {
                start = locationEntity.start();
                stopit = true;
            }
        }
        for (int i = start; i < end; i++) {
            if (_travales[i].motion() == motion) {
                return _travales[i].dest();
            }
        }
        return Location.inhand;
    }
}
