package com.sakamotodesu.shanghai.solver.pi;

import org.junit.Test;

import static com.sakamotodesu.shanghai.solver.pitype.Manzu.eMan;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PlacedPiTest {

    @Test
    public void removal() {
        Pi pi = new Pi(eMan, 0, 0, 0);
        Pi qi = new Pi(eMan, 0, 2, 0);
        pi.setMiddleRight(qi);
        assertThat(pi.isRemoval(), is(true));
    }
}
