package com.sakamotodesu.shanghai.solver;

import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class FreePi implements Pi {

    private static final FreePi INSTANCE = new FreePi();

    private FreePi() {
    }

    public static FreePi getInstance() {
        return INSTANCE;
    }

    @Override
    public int getI() {
        return 0;
    }

    @Override
    public int getJ() {
        return 0;
    }

    @Override
    public int getK() {
        return 0;
    }

    @Override
    public PiType getPiType() {
        return nashi;
    }
}
