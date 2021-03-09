package com.sakamotodesu.shanghai.solver.pi;

import com.sakamotodesu.shanghai.solver.pitype.PiType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.pitype.Nashi.nashi;


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
        "onLowerRight",
        "floorDeadlockList",
        "sideDeadlockList"})
public class Pi {

    private PiType piType = nashi;
    // レイアウト上の座標
    private int i = 0; //たて 増加で下に伸びる
    private int j = 0; //よこ 増加で右に伸びる
    private int k = 0; //高さ
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

    private boolean isExist = true;
    // toString高速化
    private String toString;

    /**
     * 重なってる牌のロックリスト
     */
    private List<Pi> floorDeadlockList = new ArrayList<>();

    /**
     * 左右でロックになってる牌のリスト。自分以外の牌も置かれる
     */
    private List<Pi> sideDeadlockList = new ArrayList<>();


    public Pi(PiType piType, int i, int j, int k) {
        this.piType = piType;
        this.i = i;
        this.j = j;
        this.k = k;
        this.toString = i + ":" + j + ":" + k + ":" + piType.toString();
    }

    public Pi(boolean isExist) {
        this.isExist = isExist;
        this.toString = i + ":" + j + ":" + k + ":" + piType.toString();
    }

    @Override
    public String toString() {
        return this.toString;
    }

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

    public boolean isRemoval() {
        if (onUpperLeft.isExist()
                || onMiddleLeft.isExist()
                || onLowerLeft.isExist()
                || onUpper.isExist()
                || onMiddle.isExist()
                || onLower.isExist()
                || onUpperRight.isExist()
                || onMiddleRight.isExist()
                || onLowerRight.isExist()) {
            return false;
        }
        return (!upperLeft.isExist() && !middleLeft.isExist() && !lowerLeft.isExist())
                || ((!upperRight.isExist() && !middleRight.isExist() && !lowerRight.isExist()));
    }


    public void linkFloorDeadlockPi(Pi pi) {
        floorDeadlockList.add(pi);
        pi.getFloorDeadlockList().add(this);
    }

    public void linkSideDeadlockPi(Pi pi) {
        sideDeadlockList.add(pi);
        pi.getSideDeadlockList().add(this);
    }

    public boolean isExist() {
        return isExist;
    }
}
