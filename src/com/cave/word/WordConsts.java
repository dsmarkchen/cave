package com.cave.word;

public class WordConsts {

    public static int HELP_INDEX = 0;
    public static int INFO_INDEX = 1;
    public static int TREE_INDEX = 2;
    public static int SWIM_INDEX = 9;


    public static String HELP = "I know of places, actions, and things.  Most of my vocabulary\n" +
            "describes places and is used to move you there.  To move, try words\n" +
            "like forest, building, downstream, enter, east, west, north, south,\n" +
            "up, or down.  I know about a few special objects, like a black rod\n" +
            "hidden in the cave.  These objects can be manipulated using some of\n" +
            "the action words that I know.  Usually you will need to give both the\n" +
            "object and action words (in either order), but sometimes I can infer\n" +
            "the object from the verb alone.  Some objects also imply verbs; in\n" +
            "particular, \"inventory\" implies \"take inventory\", which causes me to\n" +
            "give you a list of what you're carrying.  The objects have side\n" +
            "effects; for instance, the rod scares the bird.  Usually people having\n" +
            "trouble moving just need to try a few more words.  Usually people\n" +
            "trying unsuccessfully to manipulate an object are attempting something\n" +
            "beyond their (or my!) capabilities and should try a completely\n" +
            "different tack.  To speed the game you can sometimes move long\n" +
            "distances with a single word.  For example, \"building\" usually gets\n" +
            "you to the building from anywhere above ground except when lost in the\n" +
            "forest.  Also, note that cave passages turn a lot, and that leaving a\n" +
            "room to the north does not guarantee entering the next from the south.\n" +
            "Good luck!";

    public static String INFO = "If you want to end your adventure early, say \"quit\".  To get full\n" +
            "credit for a treasure, you must have left it safely in the building,\n" +
            "though you get partial credit just for locating it.  You lose points\n" +
            "for getting killed, or for quitting, though the former costs you more.\n" +
            "There are also points based on how much (if any) of the cave you've\n" +
            "managed to explore; in particular, there is a large bonus just for\n" +
            "getting in (to distinguish the beginners from the rest of the pack),\n" +
            "and there are other ways to determine whether you've been through some\n" +
            "of the more harrowing sections.  If you think you've found all the\n" +
            "treasures, just keep exploring for a while.  If nothing interesting\n" +
            "happens, you haven't found them all yet.  If something interesting\n" +
            "DOES happen, it means you're getting a bonus and have an opportunity\n" +
            "to garner many more points in the master's section.\n" +
            "I may occasionally offer hints if you seem to be having trouble.\n" +
            "If I do, I'll warn you in advance how much it will affect your score\n" +
            "to accept the hints.  Finally, to save paper, you may specify \"brief\",\n" +
            "which tells me never to repeat the full description of a place\n" +
            "unless you explicitly ask me to.";

    public static String TREES = "The trees of the forest are large hardwood oak and maple, with an\n" +
            "occasional grove of pine or spruce.  There is quite a bit of under-\n" +
            "growth, largely birch and ash saplings plus nondescript bushes of\n" +
            "various sorts.  This time of year visibility is quite restricted by\n" +
            "all the leaves, but travel is quite easy if you detour around the\n" +
            "spruce and berry bushes.";

    public static String SWIM = "I don't know how.";


    public static String LONG_ROAD = "You are standing at the end of a road before a small brick building.\n" +
            "Around you is a forest.  A small stream flows out of the building and\n" +
            "down a gully.";
    public static String SHORT_ROAD = "You're at end of road again.";

    public static String LONG_HILL = "You have walked up a hill, still in the forest.  The road slopes back\n" +
            "down the other side of the hill.  There is a building in the distance.";
    public static String SHORT_HILL = "You're at hill in road.";

    public static String LONG_HOUSE = "You are inside a building, a well house for a large spring.";
    public static String SHORT_HOUSE = "You're inside building.";

    public static String LONG_VALLEY = "You are in a valley in the forest beside a stream tumbling along a\n" +
            "rocky bed.";
    public static String SHORT_VALLEY = "You're in valley.";

    public static String LONG_FOREST = "You are in open forest, with a deep valley to one side.";
    public static String LONG_WOODS = "You are in open forest near both a valley and a road.";
    public static String SHORT_FOREST = "You're in forest.";

    public static String LONG_SLIT = "At your feet all the water of the stream splashes into a 2-inch slit\n"
            + "in the rock.  Downstream the streambed is bare rock.";
    public static String SHORT_SLIT = "You're at slit in streambed.";

    public static String LONG_OUTSIDE = "You are in a 20-foot depression floored with bare dirt.  Set into the\n"
            + "dirt is a strong steel grate mounted in concrete.  A dry streambed\n"
            + "leads into the depression.";
    public static String SHORT_OUTSIDE = "You're outside grate.";

    public static String LONG_INSIDE = "You are in a small chamber beneath a 3x3 steel grate to the surface."
            + "A low crawl over cobbles leads inwards to the west.";
    public static String SHORT_INSIDE = "You're below the grate.";

    public static String LONG_COBBLES = "You are crawling over cobbles in a low passage.  There is a dim light\n"
            + "at the east end of the passage.";
    public static String SHORT_COBBLES = "You're in cobble crawl.";

    public static String LONG_DEBRIS = "You are in a debris room filled with stuff washed in from the surface.\n"
            + "A low wide passage with cobbles becomes plugged with mud and debris\n"
            + "here, but an awkward canyon leads upward and west.  A note on the wall\n"
            + "says \"MAGIC WORD XYZZY\".";
    public static String SHORT_DEBRIS = "You're in debris room.";


    public static String LONG_AWKWARD = "You are in an awkward sloping east/west canyon.";

    public static String LONG_BIRD = "You are in a splendid chamber thirty feet high.  The walls are frozen\n"
            + "rivers of orange stone.  An awkward canyon and a good passage exit\n"
            + "from east and west sides of the chamber.";
    public static String SHORT_BIRD = "You're in bird chamber.";


    public static String LONG_SEWER = "The stream flows out through a pair of 1-foot-diameter sewer pipes.\n" +
            "It would be advisable to use the exit.";
}
