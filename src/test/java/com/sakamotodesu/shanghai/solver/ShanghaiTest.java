package com.sakamotodesu.shanghai.solver;

import org.junit.Test;

import static com.sakamotodesu.shanghai.solver.Manzu.*;
import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class ShanghaiTest {

    PiType[][] layer = new PiType[][]{{eMan, nashi}
            , {nashi, ryanMan}
            , {eMan, nashi}
            , {nashi, ryanMan}
    };

    PiType[][] layer2 = new PiType[][]{{eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
    };

    PiType[][] layer3 = new PiType[][]{{eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {suWan, uWan, roWan}
            , {nashi, nashi, nashi}
            , {suWan, uWan, roWan}
            , {nashi, nashi, nashi}
    };

    PiType[][] layer4 = new PiType[][]{{eMan, nashi, nashi}
            , {nashi, ryanMan, nashi}
            , {nashi, nashi, sanWan}
    };

    @Test
    public void printStage() {
        Shanghai shanghai = new Shanghai();
        shanghai.printStage(layer);
        shanghai.printStage(layer2);
        shanghai.printStage(layer3);
        shanghai.printStage(layer4);
    }

    @Test
    public void getRemovalList() {
        Shanghai shanghai = new Shanghai();
        System.out.println(shanghai.getRemovalList(layer));
        System.out.println(shanghai.getRemovalList(layer));
        System.out.println(shanghai.getRemovalList(layer3));
        System.out.println(shanghai.getRemovalList(layer4));
    }
}