package com.sakamotodesu.shanghai.solver;

import org.junit.Test;

import static com.sakamotodesu.shanghai.solver.Manzu.*;
import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class ShanghaiTest {

    Pi[][] layer = new Pi[][]{{eMan, nashi}
            , {nashi, ryanMan}
            , {eMan, nashi}
            , {nashi, ryanMan}
    };

    Pi[][] layer2 = new Pi[][]{{eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
    };

    Pi[][] layer3 = new Pi[][]{{eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {eMan, ryanMan, sanWan}
            , {nashi, nashi, nashi}
            , {suWan, uWan, roWan}
            , {nashi, nashi, nashi}
            , {suWan, uWan, roWan}
            , {nashi, nashi, nashi}
    };

    @Test
    public void printStage() {
        Shanghai shanghai = new Shanghai();
        shanghai.printStage(layer3);
    }

    @Test
    public void solve() {
        Shanghai shanghai = new Shanghai();
        shanghai.solve(layer3);
    }
}