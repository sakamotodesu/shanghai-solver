package com.sakamotodesu.shanghai.solver;

import org.junit.Test;

import static com.sakamotodesu.shanghai.solver.Manzu.eMan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlacedPiTest {

    @Test
    public void removal() {
        Pi pi = new PlacedPi(eMan, 0, 0, 0);
        Pi qi = new PlacedPi(eMan, 0, 2, 0);
        pi.setMiddleRight(qi);
        assertThat(pi.isRemoval(), is(true));
    }
}
