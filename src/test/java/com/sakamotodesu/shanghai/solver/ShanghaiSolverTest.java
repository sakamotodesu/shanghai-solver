package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pi.PlacedPi;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.pitype.Manzu.eMan;
import static com.sakamotodesu.shanghai.solver.pitype.Manzu.ryanMan;
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
        solver.validate(StageData.getNormal());
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
        solver.solve(fourPiesPartialRemoval);

        solver.solve(fourPiesImpossible);

        solver.solve(sixPiesOnlyOneWayPossible);

        solver.solve(twoFloor);
    }

    @Test
    public void solvedNormalTest() throws InvalidLayoutException {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.validate(StageData.getNormal());
        solver.solve(StageData.getNormal());
    }
}