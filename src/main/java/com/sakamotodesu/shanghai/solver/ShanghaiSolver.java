package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;

import java.util.ArrayList;
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


    public void validate(List<Pi> piList) throws InvalidLayoutException {
        char[][] layout = new char[16][16];
        for (char[] printLayoutLine : layout) {
            Arrays.fill(printLayoutLine, ' ');
        }

        for (Pi pi : piList) {
            if (layout[pi.getI()][pi.getJ()] != ' '
                    || layout[pi.getI() + 1][pi.getJ()] != ' '
                    || layout[pi.getI() + 1][pi.getJ()] != ' '
                    || layout[pi.getI() + 1][pi.getJ() + 1] != ' ') {
                throw new InvalidLayoutException(pi.toString());
            }
            layout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
            layout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
            layout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
            layout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
        }
    }

    public void update(List<Pi> piList) {
        for (Pi pi : piList) {
            pi.init();
            for (Pi qi : piList) {
                if (qi.getJ() + 2 == pi.getJ()) {
                    if (qi.getI() + 1 == pi.getI()) {
                        pi.setUpperLeft(qi);
                    } else if (qi.getI() == pi.getI()) {
                        pi.setMiddleLeft(qi);
                    } else if (qi.getI() - 1 == pi.getI()) {
                        pi.setLowerLeft(qi);
                    }
                } else if (qi.getJ() - 2 == pi.getJ()) {
                    if (qi.getI() + 1 == pi.getI()) {
                        pi.setUpperRight(qi);
                    } else if (qi.getI() == pi.getI()) {
                        pi.setMiddleRight(qi);
                    } else if (qi.getI() - 1 == pi.getI()) {
                        pi.setLowerRight(qi);
                    }
                }
            }
        }
    }

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

    /**
     * @param piList 問題
     * @return true:解けた false:詰んだ
     */
    public boolean solve(List<Pi> piList, List<Pi> solvedList) {
        if (piList.size() == 0) {
            System.out.println("solved.");
            return true;//解けた
        }

        printStage(piList);
        update(piList);

        List<Pi> removalList = new ArrayList<>();
        for (Pi pi : piList) {
            if (pi.isRemoval()) {
                removalList.add(pi);
            }
        }

        for (Pi pi : removalList) {
            for (Pi qi : removalList) {
                if (pi.getPiType() == qi.getPiType() && !pi.equals(qi)) {
                    List<Pi> removedList = new ArrayList<>(piList);
                    removedList.remove(pi);
                    removedList.remove(qi);
                    solvedList.add(pi);
                    solvedList.add(qi);
                    System.out.println("removed:" + pi);
                    System.out.println("removed:" + qi);
                    if (solve(removedList, solvedList)) {
                        return true;
                    }
                }
            }
        }
        System.out.println("unsolved.");
        if (solvedList.size() >= 2) {
            solvedList.remove(solvedList.size() - 1);
            solvedList.remove(solvedList.size() - 1);
        }
        return false;
    }
}
