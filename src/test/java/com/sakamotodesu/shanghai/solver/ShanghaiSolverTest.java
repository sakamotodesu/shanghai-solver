package com.sakamotodesu.shanghai.solver;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.Manzu.eMan;

public class ShanghaiSolverTest {


    List<Pi> twoPiesMiddleRight = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
            new PlacedPi(eMan, 0, 2, 0)));

    List<Pi> twoPiesLowerRight = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
            new PlacedPi(eMan, 1, 2, 0)));

    @Test
    public void printStage() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.printStage(twoPiesMiddleRight);
        solver.printStage(twoPiesLowerRight);
    }
}