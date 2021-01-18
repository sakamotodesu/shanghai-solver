package com.sakamotodesu.shanghai.solver;

public interface Pi {

    void setUpperLeft(Pi upperLeft);

    void setMiddleLeft(Pi middleLeft);

    void setLowerLeft(Pi lowerRight);

    void setUpperRight(Pi upperRight);

    void setMiddleRight(Pi middleRight);

    void setLowerRight(Pi lowerRight);

    void setOnUpperLeft(Pi onUpperLeft);

    void setOnMiddleLeft(Pi onMiddleLeft);

    void setOnLowerLeft(Pi onLowerLeft);

    void setOnUpper(Pi onUpper);

    void setOnMiddle(Pi onMiddle);

    void setOnLower(Pi onLower);

    void setOnUpperRifgt(Pi onUpperRifgt);

    void setOnMiddlRight(Pi onMiddlRight);

    void setOnLowerRight(Pi onLowerRight);

    int getI();

    int getJ();

    int getK();

    PiType getPiType();


}
