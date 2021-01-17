package com.sakamotodesu.shanghai.solver;

import java.util.Arrays;
import java.util.List;

public class ShanghaiSolver {

    // レイアウトはある状態からスタート
    // 牌ごとに自分をブロックしてるやつを把握する
    // ここから探索スタート
    // 牌ごとに取れるか計算する
    //   取れる牌がなければ別ルート
    // 牌を選択して取る
    // 　取った順番を記録？


    public void printStage(List<Pi> piList) {

        char[][] printLayout = new char[16][16];
        for (char[] printLayoutLine : printLayout) {
            Arrays.fill(printLayoutLine, ' ');
        }

        for (Pi pi : piList) {
            printLayout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
            printLayout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
            printLayout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
            printLayout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
        }
        for (char[] printLayoutLine : printLayout) {
            for (char printChar : printLayoutLine) {
                System.out.print(printChar);
            }
            System.out.println();
        }
    }
}
