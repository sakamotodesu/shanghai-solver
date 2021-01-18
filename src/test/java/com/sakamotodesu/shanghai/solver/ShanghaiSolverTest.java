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

    List<Pi> twoPiesInvalid = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
            new PlacedPi(eMan, 1, 1, 0)));

    @Test
    public void printStage() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.printStage(twoPiesMiddleRight);
        solver.printStage(twoPiesLowerRight);
    }

    @Test
    public void validate() throws InvalidLayout {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.validate(twoPiesMiddleRight);
        solver.validate(twoPiesLowerRight);
    }

    @Test(expected = InvalidLayout.class)
    public void throwInvalidException() throws InvalidLayout {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.validate(twoPiesInvalid);
    }

    @Test
    public void update(){
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.update(twoPiesMiddleRight);
        solver.update(twoPiesMiddleRight);
    }

}