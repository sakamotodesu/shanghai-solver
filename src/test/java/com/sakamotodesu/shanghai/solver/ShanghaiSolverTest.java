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
    List<Pi> dendo;


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
                new PlacedPi(nan, 2, 16, 0),

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
                new PlacedPi(ryanSou, 7, 19, 0),

                new PlacedPi(uWan, 8, 8, 0),
                new PlacedPi(ryanSou, 8, 10, 0),
                new PlacedPi(sanSou, 8, 17, 0),

                new PlacedPi(chiSou, 10, 9, 0),

                new PlacedPi(nan, 11, 2, 0),

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
                new PlacedPi(sanSou, 3, 11, 1),

                new PlacedPi(ryu, 5, 7, 1),
                new PlacedPi(sha, 5, 9, 1),
                new PlacedPi(ryu, 5, 11, 1),

                new PlacedPi(roSou, 7, 9, 1),
                new PlacedPi(uWan, 7, 17, 1),

                new PlacedPi(roSou, 12, 2, 1)

        ));

        dendo = new ArrayList<>(Arrays.asList(new PlacedPi(nan, 0, 8, 0),
                new PlacedPi(suPin, 0, 10, 0),
                new PlacedPi(chiSou, 0, 12, 0),

                new PlacedPi(roPin, 2, 5, 0),
                new PlacedPi(haku, 2, 7, 0),
                new PlacedPi(sha, 2, 9, 0),
                new PlacedPi(ryu, 2, 11, 0),
                new PlacedPi(suWan, 2, 13, 0),
                new PlacedPi(sha, 2, 15, 0),

                new PlacedPi(nan, 4, 4, 0),
                new PlacedPi(season, 4, 6, 0),
                new PlacedPi(quPin, 4, 8, 0),
                new PlacedPi(chun, 4, 10, 0),
                new PlacedPi(pe, 4, 12, 0),
                new PlacedPi(chiSou, 4, 14, 0),
                new PlacedPi(pe, 4, 16, 0),

                new PlacedPi(eSou, 6, 2, 0),
                new PlacedPi(suWan, 6, 4, 0),
                new PlacedPi(ryanMan, 6, 6, 0),
                new PlacedPi(ryanMan, 6, 8, 0),
                new PlacedPi(haku, 6, 10, 0),
                new PlacedPi(ryanPin, 6, 12, 0),
                new PlacedPi(haku, 6, 14, 0),
                new PlacedPi(roWan, 6, 16, 0),
                new PlacedPi(quPin, 6, 18, 0),

                new PlacedPi(pe, 7, 0, 0),
                new PlacedPi(season, 7, 20, 0),

                new PlacedPi(ton, 8, 2, 0),
                new PlacedPi(ePin, 8, 4, 0),
                new PlacedPi(chun, 8, 6, 0),
                new PlacedPi(uSou, 8, 8, 0),
                new PlacedPi(ton, 8, 10, 0),
                new PlacedPi(chun, 8, 12, 0),
                new PlacedPi(uSou, 8, 14, 0),
                new PlacedPi(ton, 8, 16, 0),
                new PlacedPi(eMan, 8, 18, 0),

                new PlacedPi(sanWan, 9, 0, 0),
                new PlacedPi(sanPin, 9, 20, 0),

                new PlacedPi(pe, 10, 2, 0),
                new PlacedPi(suWan, 10, 6, 0),
                new PlacedPi(eMan, 10, 14, 0),
                new PlacedPi(suPin, 10, 18, 0),

                new PlacedPi(chun, 11, 4, 0),
                new PlacedPi(quPin, 11, 8, 0),
                new PlacedPi(ryanMan, 11, 10, 0),
                new PlacedPi(suPin, 11, 12, 0),
                new PlacedPi(eMan, 11, 16, 0),

                new PlacedPi(sanWan, 1, 10, 1),

                new PlacedPi(nan, 2, 7, 1),
                new PlacedPi(roPin, 2, 13, 1),

                new PlacedPi(sanWan, 3, 5, 1),
                new PlacedPi(ton, 3, 9, 1),
                new PlacedPi(uWan, 3, 11, 1),
                new PlacedPi(chiSou, 3, 15, 1),

                new PlacedPi(roWan, 6, 2, 1),
                new PlacedPi(eMan, 6, 4, 1),
                new PlacedPi(haku, 6, 6, 1),
                new PlacedPi(eSou, 6, 8, 1),
                new PlacedPi(season, 6, 10, 1),
                new PlacedPi(ryu, 6, 12, 1),
                new PlacedPi(ryanPin, 6, 14, 1),
                new PlacedPi(haku, 6, 16, 1),
                new PlacedPi(eSou, 6, 18, 1),

                new PlacedPi(chiSou, 7, 0, 1),
                new PlacedPi(quSou, 7, 20, 1),

                new PlacedPi(uPin, 8, 2, 1),
                new PlacedPi(ryu, 8, 4, 1),
                new PlacedPi(ePin, 8, 6, 1),
                new PlacedPi(sanWan, 8, 8, 1),
                new PlacedPi(ryanPin, 8, 10, 1),
                new PlacedPi(quPin, 8, 12, 1),
                new PlacedPi(hatsu, 8, 14, 1),
                new PlacedPi(ePin, 8, 16, 1),
                new PlacedPi(uPin, 8, 18, 1),

                new PlacedPi(suSou, 9, 0, 1),
                new PlacedPi(nan, 9, 20, 1),

                new PlacedPi(uPin, 10, 2, 1),
                new PlacedPi(suPin, 10, 6, 1),
                new PlacedPi(uSou, 10, 14, 1),
                new PlacedPi(ryanPin, 10, 18, 1),

                new PlacedPi(hatsu, 11, 4, 1),
                new PlacedPi(haku, 11, 8, 1),
                new PlacedPi(season, 11, 10, 1),
                new PlacedPi(roPin, 11, 12, 1),
                new PlacedPi(ePin, 11, 16, 1),

                new PlacedPi(ryanMan, 0, 2, 1)));
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
        solver.validate(twoPiesMiddleRight);
        solver.validate(twoPiesLowerRight);
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
    public void solvedNormalTest() {
        ShanghaiSolver solver = new ShanghaiSolver();
        List<Pi> solvedList = new ArrayList<>();
        System.out.println(normal.size());

        solver.solve(normal, solvedList);
        System.out.println(solvedList);
    }
}