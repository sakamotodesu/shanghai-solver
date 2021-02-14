package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pi.PlacedPi;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.pitype.Manzu.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ShanghaiDAGTest {

    List<Pi> deadlockRightSide;
    List<Pi> deadlockFloor;

    @Before
    public void setUp() {
        deadlockRightSide = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 6, 0, 0),
                new PlacedPi(ryanMan, 5, 2, 0),
                new PlacedPi(ryanMan, 7, 2, 0),

                new PlacedPi(eMan, 5, 4, 0),
                new PlacedPi(eMan, 7, 4, 0),

                new PlacedPi(eMan, 4, 6, 0),
                new PlacedPi(sanWan, 6, 6, 0),
                new PlacedPi(sanWan, 8, 6, 0),

                new PlacedPi(ryanMan, 3, 8, 0),
                new PlacedPi(sanWan, 5, 8, 0),
                new PlacedPi(ryanMan, 7, 8, 0),
                new PlacedPi(sanWan, 9, 8, 0)));

        deadlockFloor = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 1, 0),
                new PlacedPi(eMan, 0, 0, 1),
                new PlacedPi(ryanMan, 0, 2, 1),
                new PlacedPi(eMan, 0, 1, 2),
                new PlacedPi(ryanMan, 0, 3, 2),
                new PlacedPi(eMan, 0, 4, 3)));
    }

    @Test
    public void getFloorDAG() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.updateNeighborhood(deadlockFloor);
        ShanghaiDAG dag = ShanghaiDAG.getFloorDAG(deadlockFloor.get(0));
        assertThat(dag.getVertexList().size(), is(6));
        assertThat(dag.getEdgeList().size(), is(6));

    }

    @Test
    public void getRightSideDAG() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.updateNeighborhood(deadlockRightSide);
        solver.printStage(deadlockRightSide);
        ShanghaiDAG dag = ShanghaiDAG.getRightSideDAG(deadlockRightSide.get(0));
        assertThat(dag.getVertexList().size(), is(12));
        assertThat(dag.getEdgeList().size(), is(14));

    }

    @Test
    public void search() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.updateNeighborhood(deadlockFloor);
        ShanghaiDAG dag = ShanghaiDAG.getFloorDAG(deadlockFloor.get(0));
        assertThat(dag.search().size(), is(3));

    }
}