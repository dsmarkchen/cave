package com.cave;

import java.util.ArrayList;
import java.util.List;

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

    public int q = 1;
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


    public void build() {
        _locationEntityList.add(_locIndex++, makeLocation(Location.road,
                "you are standing...",
                "you are at end of road again",
                0,
                0));
        makeInstruction(Motion.W, 0, Location.hill);
        ditto(Motion.U);
        ditto(Motion.ROAD);

        makeInstruction(Motion.E, 0, Location.house);
        ditto(Motion.IN);
        ditto(Motion.HOUSE);
        ditto(Motion.ENTER);

        makeInstruction(Motion.S, 0, Location.valley);
        ditto(Motion.D);
        ditto(Motion.GULLY);
        ditto(Motion.STREAM);
        ditto(Motion.DOWNSTREAM);

        makeInstruction(Motion.N, 0, Location.forest);
        ditto(Motion.WOODS);

        makeInstruction(Motion.DEPRESSION, 0, Location.outside);
    }

    public String desc(Location loc) {
        for(LocationEntity entity : _locationEntityList) {
            if(entity.location() == loc) {
                return entity.longDesc();
            }
        }
        return "";
    }

}
