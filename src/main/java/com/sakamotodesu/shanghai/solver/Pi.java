package com.sakamotodesu.shanghai.solver;

public interface Pi {

    void init();

    Pi getUpperLeft();

    void setUpperLeft(Pi upperLeft);

    Pi getMiddleLeft();

    void setMiddleLeft(Pi middleLeft);

    Pi getLowerLeft();

    void setLowerLeft(Pi lowerRight);

    Pi getUpperRight();

    void setUpperRight(Pi upperRight);

    Pi getMiddleRight();

    void setMiddleRight(Pi middleRight);

    Pi getLowerRight();

    void setLowerRight(Pi lowerRight);

    Pi getOnUpperLeft();

    void setOnUpperLeft(Pi onUpperLeft);

    Pi getOnMiddleLeft();

    void setOnMiddleLeft(Pi onMiddleLeft);

    Pi getOnLowerLeft();

    void setOnLowerLeft(Pi onLowerLeft);

    Pi getOnUpper();

    void setOnUpper(Pi onUpper);

    Pi getOnMiddle();

    void setOnMiddle(Pi onMiddle);

    Pi getOnLower();

    void setOnLower(Pi onLower);

    Pi getOnUpperRight();

    void setOnUpperRight(Pi onUpperRight);

    Pi getOnMiddleRight();

    void setOnMiddleRight(Pi onMiddlRight);

    Pi getOnLowerRight();

    void setOnLowerRight(Pi onLowerRight);

    int getI();

    int getJ();

    int getK();

    PiType getPiType();

    boolean isRemoval();

    boolean isFree();

}
