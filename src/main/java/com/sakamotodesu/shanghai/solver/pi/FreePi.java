package com.sakamotodesu.shanghai.solver.pi;

import com.sakamotodesu.shanghai.solver.pitype.PiType;

import static com.sakamotodesu.shanghai.solver.pitype.Nashi.nashi;

public class FreePi {

    private static final Pi INSTANCE = new Pi(false);

    private FreePi() {

    }

    public static Pi getInstance() {
        return INSTANCE;
    }

    public PiType getPiType() {
        return nashi;
    }

    @Override
    public String toString() {
        return "FreePi";
    }
}
