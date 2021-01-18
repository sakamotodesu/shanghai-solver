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
    public void setUpperLeft(Pi upperLeft) {

    }

    @Override
    public void setMiddleLeft(Pi middleLeft) {

    }

    @Override
    public void setLowerLeft(Pi lowerRight) {

    }

    @Override
    public void setUpperRight(Pi upperRight) {

    }

    @Override
    public void setMiddleRight(Pi middleRight) {

    }

    @Override
    public void setLowerRight(Pi lowerRight) {

    }

    @Override
    public void setOnUpperLeft(Pi onUpperLeft) {

    }

    @Override
    public void setOnMiddleLeft(Pi onMiddleLeft) {

    }

    @Override
    public void setOnLowerLeft(Pi onLowerLeft) {

    }

    @Override
    public void setOnUpper(Pi onUpper) {

    }

    @Override
    public void setOnMiddle(Pi onMiddle) {

    }

    @Override
    public void setOnLower(Pi onLower) {

    }

    @Override
    public void setOnUpperRifgt(Pi onUpperRifgt) {

    }

    @Override
    public void setOnMiddlRight(Pi onMiddlRight) {

    }

    @Override
    public void setOnLowerRight(Pi onLowerRight) {

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
