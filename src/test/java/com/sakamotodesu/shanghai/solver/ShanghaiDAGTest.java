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

public class ShanghaiDAGTest {

    List<Pi> deadlockOnBlocksSandWitch;
    List<Pi> deadlockOnBlocksBranch;

    @Before
    public void setUp() {
        deadlockOnBlocksSandWitch = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 0, 0),
                new PlacedPi(ryanMan, 1, 1, 1),
                new PlacedPi(ryanMan, 2, 2, 2),
                new PlacedPi(eMan, 3, 3, 3)));

        deadlockOnBlocksBranch = new ArrayList<>(Arrays.asList(new PlacedPi(eMan, 0, 1, 0),
                new PlacedPi(eMan, 0, 0, 1),
                new PlacedPi(ryanMan, 0, 2, 1),
                new PlacedPi(eMan, 0, 1, 2),
                new PlacedPi(ryanMan, 0, 3, 2),
                new PlacedPi(eMan, 0, 4, 3)));
    }

    @Test
    public void getOnDAG() {
        ShanghaiSolver solver = new ShanghaiSolver();
        solver.updateNeighborhood(deadlockOnBlocksBranch);
        ShanghaiDAG dag = ShanghaiDAG.getOnDAG(deadlockOnBlocksBranch.get(0));
        assertThat(dag.getVertexList().size(), is(6));
        assertThat(dag.getEdgeList().size(), is(6));

    }

    @Test
    public void search() {
    }
}