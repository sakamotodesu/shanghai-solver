package com.sakamotodesu.shanghai.solver;

import lombok.Data;


@Data
public class PlacedPi implements Pi {


    private PiType piType;
    // レイアウト上の座標
    private int i; //たて
    private int j; //よこ
    private int k; //高さ
    // 取れないようにロックしてくる牌の位置
    private Pi upperLeft = FreePi.getInstance();
    private Pi middleLeft = FreePi.getInstance();
    private Pi lowerLeft = FreePi.getInstance();
    private Pi upperRight = FreePi.getInstance();
    private Pi middleRight = FreePi.getInstance();
    private Pi lowerRight = FreePi.getInstance();
    private Pi onUpperLeft = FreePi.getInstance();
    private Pi onMiddleLeft = FreePi.getInstance();
    private Pi onLowerLeft = FreePi.getInstance();
    private Pi onUpper = FreePi.getInstance();
    private Pi onMiddle = FreePi.getInstance();
    private Pi onLower = FreePi.getInstance();
    private Pi onUpperRifgt = FreePi.getInstance();
    private Pi onMiddlRight = FreePi.getInstance();
    private Pi onLowerRight = FreePi.getInstance();

    public PlacedPi(PiType piType, int i, int j, int k) {
        this.piType = piType;
        this.i = i;
        this.j = j;
        this.k = k;
    }
}
