package com.sakamotodesu.shanghai.solver.pi;

import com.sakamotodesu.shanghai.solver.pitype.PiType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;


@Data
@EqualsAndHashCode(exclude = {"upperLeft",
        "middleLeft",
        "lowerLeft",
        "upperRight",
        "middleRight",
        "lowerRight",
        "onUpperLeft",
        "onMiddleLeft",
        "onLowerLeft",
        "onUpper",
        "onMiddle",
        "onLower",
        "onUpperRight",
        "onMiddleRight",
        "onLowerRight"})
public class PlacedPi implements Pi {


    private PiType piType;
    // レイアウト上の座標
    private int i; //たて 増加で下に伸びる
    private int j; //よこ 増加で右に伸びる
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
    private Pi onUpperRight = FreePi.getInstance();
    private Pi onMiddleRight = FreePi.getInstance();
    private Pi onLowerRight = FreePi.getInstance();

    /**
     * 重なってる牌のロックリスト
     */
    private List<Pi> floorDeadlockList = new ArrayList<>();

    /**
     * 左右でロックになってる牌のリスト。自分以外の牌も置かれる
     */
    private List<Pi> sideDeadlockList = new ArrayList<>();


    public PlacedPi(PiType piType, int i, int j, int k) {
        this.piType = piType;
        this.i = i;
        this.j = j;
        this.k = k;
    }

    @Override
    public String toString() {
        return i + ":" + j + ":" + k + ":" + piType.toString();
    }

    @Override
    public void init() {
        this.upperLeft = FreePi.getInstance();
        this.middleLeft = FreePi.getInstance();
        this.lowerLeft = FreePi.getInstance();
        this.upperRight = FreePi.getInstance();
        this.middleRight = FreePi.getInstance();
        this.lowerRight = FreePi.getInstance();
        this.onUpperLeft = FreePi.getInstance();
        this.onMiddleLeft = FreePi.getInstance();
        this.onLowerLeft = FreePi.getInstance();
        this.onUpper = FreePi.getInstance();
        this.onMiddle = FreePi.getInstance();
        this.onLower = FreePi.getInstance();
        this.onUpperRight = FreePi.getInstance();
        this.onMiddleRight = FreePi.getInstance();
        this.onLowerRight = FreePi.getInstance();
    }

    @Override
    public boolean isRemoval() {
        if (!onUpperLeft.isFree()
                || !onMiddleLeft.isFree()
                || !onLowerLeft.isFree()
                || !onUpper.isFree()
                || !onMiddle.isFree()
                || !onLower.isFree()
                || !onUpperRight.isFree()
                || !onMiddleRight.isFree()
                || !onLowerRight.isFree()) {
            return false;
        }
        return (upperLeft.isFree() && middleLeft.isFree() && lowerLeft.isFree())
                || ((upperRight.isFree() && middleRight.isFree() && lowerRight.isFree()));
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public void linkFloorDeadlockPi(Pi pi) {
        floorDeadlockList.add(pi);
        pi.getFloorDeadlockList().add(this);
    }

    @Override
    public void linkSideDeadlockPi(Pi pi) {
        sideDeadlockList.add(pi);
        pi.getSideDeadlockList().add(this);
    }

    @Override
    public boolean isExist() {
        return true;
    }
}
