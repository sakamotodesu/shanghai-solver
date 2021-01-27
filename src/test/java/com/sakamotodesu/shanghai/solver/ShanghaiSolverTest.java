package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pi.PlacedPi;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.pitype.Manzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Pinzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Souzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Zihai.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class ShanghaiSolverTest {
    List<Pi> twoPiesMiddleRight;
    List<Pi> twoPiesLowerRight;
    List<Pi> twoPiesInvalid;
    List<Pi> fourPiesAllRemoval;
    List<Pi> fourPiesPartialRemoval;
    List<Pi> fourPiesImpossible;
    List<Pi> sixPiesOnlyOneWayPossible;
    List<Pi> twoFloor;
    List<Pi> normal;


    @Before
    public void setup() {
        twoPiesMiddleRight = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 0, 2, 0)));
        twoPiesLowerRight = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 1, 2, 0)));
        twoPiesInvalid = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 1, 1, 0)));
        fourPiesAllRemoval = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 0, 2, 0),
                new PlacedPi(ryanMan, 2, 0, 0),
                new PlacedPi(ryanMan, 2, 2, 0)));
        fourPiesPartialRemoval = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(ryanMan, 0, 2, 0),
                new PlacedPi(ryanMan, 0, 4, 0),
                new PlacedPi(eMan, 0, 6, 0)));
        fourPiesImpossible = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(ryanMan, 0, 2, 0),
                new PlacedPi(eMan, 0, 4, 0),
                new PlacedPi(ryanMan, 0, 6, 0)));
        sixPiesOnlyOneWayPossible = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 0, 2, 0),
                new PlacedPi(eMan, 2, 0, 0),
                new PlacedPi(ryanMan, 2, 2, 0),
                new PlacedPi(eMan, 2, 4, 0),
                new PlacedPi(ryanMan, 2, 6, 0)));
        twoFloor = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(eMan, 0, 2, 0),
                new PlacedPi(ryanMan, 0, 0, 1),
                new PlacedPi(ryanMan, 0, 2, 1)));

        normal = new ArrayList<>(Arrays.asList(new PlacedPi(chiSou, 0, 4, 0),
                new PlacedPi(eSou, 0, 6, 0),
                new PlacedPi(chiSou, 0, 12, 0),
                new PlacedPi(ePin, 0, 14, 0),

                new PlacedPi(season, 2, 2, 0),
                new PlacedPi(chiSou, 2, 4, 0),
                new PlacedPi(ryanPin, 2, 6, 0),
                new PlacedPi(ePin, 2, 8, 0),
                new PlacedPi(suWan, 2, 10, 0),
                new PlacedPi(suWan, 2, 12, 0),
                new PlacedPi(ryanPin, 2, 14, 0),
                new PlacedPi(sha, 2, 16, 0),

                new PlacedPi(ryanPin, 4, 4, 0),
                new PlacedPi(ePin, 4, 6, 0),
                new PlacedPi(suWan, 4, 8, 0),
                new PlacedPi(suWan, 4, 10, 0),
                new PlacedPi(ePin, 4, 12, 0),
                new PlacedPi(eSou, 4, 14, 0),

                new PlacedPi(season, 6, 6, 0),
                new PlacedPi(eSou, 6, 8, 0),
                new PlacedPi(ryanPin, 6, 10, 0),
                new PlacedPi(ton, 6, 12, 0),
                new PlacedPi(ton, 6, 17, 0),

                new PlacedPi(roSou, 7, 15, 0),
                new PlacedPi(ryu, 7, 19, 0),

                new PlacedPi(uWan, 8, 8, 0),
                new PlacedPi(ryu, 8, 10, 0),
                new PlacedPi(sanSou, 8, 17, 0),

                new PlacedPi(chiSou, 10, 9, 0),

                new PlacedPi(sha, 11, 2, 0),

                new PlacedPi(season, 12, 0, 0),
                new PlacedPi(sanSou, 12, 4, 0),

                new PlacedPi(sanSou, 13, 2, 0),

                new PlacedPi(ton, 1, 5, 1),
                new PlacedPi(uWan, 1, 13, 1),

                new PlacedPi(roSou, 2, 3, 1),
                new PlacedPi(season, 2, 15, 1),

                new PlacedPi(uWan, 3, 5, 1),
                new PlacedPi(ton, 3, 7, 1),
                new PlacedPi(eSou, 3, 9, 1),
                new PlacedPi(sha, 3, 11, 1),
                new PlacedPi(sanSou, 3, 13, 1),

                new PlacedPi(ryu, 5, 7, 1),
                new PlacedPi(sha, 5, 9, 1),
                new PlacedPi(ryu, 5, 11, 1),

                new PlacedPi(roSou, 7, 9, 1),
                new PlacedPi(uWan, 7, 17, 1),

                new PlacedPi(roSou, 12, 2, 1)

        ));


    }

    @Test
    public void printStageTest() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.printStage(twoPiesMiddleRight);
        solver.printStage(twoPiesLowerRight);
        solver.printStage(twoFloor);
    }

    @Test
    public void validateTest() throws InvalidLayoutException {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.validate(normal);
    }

    @Test(expected = InvalidLayoutException.class)
    public void throwInvalidExceptionTest() throws InvalidLayoutException {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.validate(twoPiesInvalid);
    }

    @Test
    public void updateTest() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.update(twoPiesMiddleRight);
        assertThat(twoPiesMiddleRight.get(0).getMiddleRight().getPiType(), is(eMan));
        assertThat(twoPiesMiddleRight.get(1).getMiddleLeft().getPiType(), is(eMan));

        solver.update(twoPiesLowerRight);
        assertThat(twoPiesLowerRight.get(0).getLowerRight().getPiType(), is(eMan));
        assertThat(twoPiesLowerRight.get(1).getUpperLeft().getPiType(), is(eMan));

        solver.update(fourPiesAllRemoval);
        assertThat(fourPiesAllRemoval.get(0).getMiddleRight().getPiType(), is(eMan));
        assertThat(fourPiesAllRemoval.get(1).getMiddleLeft().getPiType(), is(eMan));
        assertThat(fourPiesAllRemoval.get(2).getMiddleRight().getPiType(), is(ryanMan));
        assertThat(fourPiesAllRemoval.get(3).getMiddleLeft().getPiType(), is(ryanMan));

        solver.update(fourPiesPartialRemoval);
        assertThat(fourPiesPartialRemoval.get(0).getMiddleRight().getPiType(), is(ryanMan));
        assertThat(fourPiesPartialRemoval.get(1).getMiddleLeft().getPiType(), is(eMan));
        assertThat(fourPiesPartialRemoval.get(1).getMiddleRight().getPiType(), is(ryanMan));
        assertThat(fourPiesPartialRemoval.get(2).getMiddleLeft().getPiType(), is(ryanMan));
        assertThat(fourPiesPartialRemoval.get(2).getMiddleRight().getPiType(), is(eMan));
        assertThat(fourPiesPartialRemoval.get(3).getMiddleLeft().getPiType(), is(ryanMan));

        solver.update(twoFloor);
        assertThat(twoFloor.get(0).getOnMiddle().getPiType(), is(ryanMan));
        assertThat(twoFloor.get(1).getOnMiddle().getPiType(), is(ryanMan));
    }

    @Test
    public void removalTest() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.update(fourPiesAllRemoval);
        assertThat(fourPiesAllRemoval.get(0).isRemoval(), is(true));
        solver.update(fourPiesPartialRemoval);
    }

    @Test
    public void solvedTest() {
        ShanghaiSolver solver = new ShanghaiSolver();
        List<Pi> solvedList = new ArrayList<>();
        solver.solve(fourPiesPartialRemoval, solvedList);
        System.out.println(solvedList);

        solvedList.clear();
        solver.solve(fourPiesImpossible, solvedList);
        System.out.println(solvedList);

        solvedList.clear();
        solver.solve(sixPiesOnlyOneWayPossible, solvedList);
        System.out.println(solvedList);

        solvedList.clear();
        solver.solve(twoFloor, solvedList);
        System.out.println(solvedList);
    }

    @Test
    public void solvedNormalTest() throws InvalidLayoutException {
        ShanghaiSolver solver = new ShanghaiSolver();
        List<Pi> solvedList = new ArrayList<>();
        solver.validate(normal);

        solver.solve(normal, solvedList);
        System.out.println(solvedList);
    }
}