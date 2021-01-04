/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.sakamotodesu.shanghai.solver;

import static com.sakamotodesu.shanghai.solver.Manzu.*;
import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class App {
    public static void main(String[] args) {

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

        Shanghai shanghai = new Shanghai();
        shanghai.printStage(layer);
        shanghai.solve(layer);

    }

    public String getGreeting() {
        return "Hello world.";
    }
}
