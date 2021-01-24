package com.sakamotodesu.shanghai.solver.pi;

import com.sakamotodesu.shanghai.solver.pitype.PiType;

import static com.sakamotodesu.shanghai.solver.pitype.Nashi.nashi;

public class FreePi implements Pi {

    private static final FreePi INSTANCE = new FreePi();

    private FreePi() {
    }

    public static FreePi getInstance() {
        return INSTANCE;
    }

    @Override
    public void init() {

    }

    @Override
    public Pi getUpperLeft() {
        return null;
    }

    @Override
    public void setUpperLeft(Pi upperLeft) {

    }

    @Override
    public Pi getMiddleLeft() {
        return null;
    }

    @Override
    public void setMiddleLeft(Pi middleLeft) {

    }

    @Override
    public Pi getLowerLeft() {
        return null;
    }

    @Override
    public void setLowerLeft(Pi lowerRight) {

    }

    @Override
    public Pi getUpperRight() {
        return null;
    }

    @Override
    public void setUpperRight(Pi upperRight) {

    }

    @Override
    public Pi getMiddleRight() {
        return null;
    }

    @Override
    public void setMiddleRight(Pi middleRight) {

    }

    @Override
    public Pi getLowerRight() {
        return null;
    }

    @Override
    public void setLowerRight(Pi lowerRight) {

    }

    @Override
    public Pi getOnUpperLeft() {
        return null;
    }

    @Override
    public void setOnUpperLeft(Pi onUpperLeft) {

    }

    @Override
    public Pi getOnMiddleLeft() {
        return null;
    }

    @Override
    public void setOnMiddleLeft(Pi onMiddleLeft) {

    }

    @Override
    public Pi getOnLowerLeft() {
        return null;
    }

    @Override
    public void setOnLowerLeft(Pi onLowerLeft) {

    }

    @Override
    public Pi getOnUpper() {
        return null;
    }

    @Override
    public void setOnUpper(Pi onUpper) {

    }

    @Override
    public Pi getOnMiddle() {
        return null;
    }

    @Override
    public void setOnMiddle(Pi onMiddle) {

    }

    @Override
    public Pi getOnLower() {
        return null;
    }

    @Override
    public void setOnLower(Pi onLower) {

    }

    @Override
    public Pi getOnUpperRight() {
        return null;
    }

    @Override
    public void setOnUpperRight(Pi onUpperRight) {

    }

    @Override
    public Pi getOnMiddleRight() {
        return null;
    }

    @Override
    public void setOnMiddleRight(Pi onMiddlRight) {

    }

    @Override
    public Pi getOnLowerRight() {
        return null;
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

    @Override
    public boolean isRemoval() {
        return false;
    }

    @Override
    public boolean isFree() {
        return true;
    }

    @Override
    public String toString() {
        return "FreePi";
    }
}
