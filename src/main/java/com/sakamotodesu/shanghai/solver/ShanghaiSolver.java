package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;

import java.util.*;

public class ShanghaiSolver {


    public void validate(List<Pi> piList) throws InvalidLayoutException {

        if (piList.size() % 2 == 1) {
            throw new InvalidLayoutException("The count of Pis is odd number.:" + piList.size());
        }
        //4つずつある？
        Map<PiType, List<Pi>> piMap = new HashMap<>();
        for (Pi pi : piList) {
            if (!piMap.containsKey(pi.getPiType())) {
                piMap.put(pi.getPiType(), new ArrayList<>());
            }
            piMap.get(pi.getPiType()).add(pi);
        }
        for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
            if (entry.getValue().size() != 4) {
                throw new InvalidLayoutException("The count of " + entry.getKey().toString() + " is not 4.:" + entry.getValue().size());
            }
        }
        char[][][] layout = new char[32][32][32];
        for (char[][] printLayer : layout) {
            for (char[] printLayoutLine : printLayer) {
                Arrays.fill(printLayoutLine, ' ');
            }
        }

        for (Pi pi : piList) {
            if (layout[pi.getK()][pi.getI()][pi.getJ()] != ' '
                    || layout[pi.getK()][pi.getI() + 1][pi.getJ()] != ' '
                    || layout[pi.getK()][pi.getI() + 1][pi.getJ()] != ' '
                    || layout[pi.getK()][pi.getI() + 1][pi.getJ() + 1] != ' ') {
                throw new InvalidLayoutException("Pi location(i:j:k) mistake?" + pi.toString());
            }
            layout[pi.getK()][pi.getI()][pi.getJ()] = pi.getPiType().getName();
            layout[pi.getK()][pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
            layout[pi.getK()][pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
            layout[pi.getK()][pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
        }
    }

    //TODO 毎回全部updateする必要ある？
    // 1回removalと判定されたらそのあともremovalのままだよね
    // removalがnot removalに戻ることはない
    public void update(List<Pi> piList) {
        for (Pi pi : piList) {
            pi.init();
            for (Pi qi : piList) {
                if (pi.getK() == qi.getK()) {
                    if (pi.getJ() - 2 == qi.getJ()) {
                        if (pi.getI() - 1 == qi.getI()) {
                            pi.setUpperLeft(qi);
                        } else if (pi.getI() == qi.getI()) {
                            pi.setMiddleLeft(qi);
                        } else if (pi.getI() + 1 == qi.getI()) {
                            pi.setLowerLeft(qi);
                        }
                    } else if (pi.getJ() + 2 == qi.getJ()) {
                        if (pi.getI() - 1 == qi.getI()) {
                            pi.setUpperRight(qi);
                        } else if (pi.getI() == qi.getI()) {
                            pi.setMiddleRight(qi);
                        } else if (pi.getI() + 1 == qi.getI()) {
                            pi.setLowerRight(qi);
                        }
                    }
                } else if (pi.getK() + 1 == qi.getK()) {
                    if (pi.getJ() - 1 == qi.getJ()) {
                        if (pi.getI() - 1 == qi.getI()) {
                            pi.setOnUpperLeft(qi);
                        } else if (pi.getI() == qi.getI()) {
                            pi.setOnMiddleLeft(qi);
                        } else if (pi.getI() + 1 == qi.getI()) {
                            pi.setOnLowerLeft(qi);
                        }
                    } else if (pi.getJ() == qi.getJ()) {
                        if (pi.getI() - 1 == qi.getI()) {
                            pi.setOnUpper(qi);
                        } else if (pi.getI() == qi.getI()) {
                            pi.setOnMiddle(qi);
                        } else if (pi.getI() + 1 == qi.getI()) {
                            pi.setOnLower(qi);
                        }
                    } else if (pi.getJ() + 1 == qi.getJ()) {
                        if (pi.getI() - 1 == qi.getI()) {
                            pi.setOnUpperRight(qi);
                        } else if (pi.getI() == qi.getI()) {
                            pi.setOnMiddleRight(qi);
                        } else if (pi.getI() + 1 == qi.getI()) {
                            pi.setOnLowerRight(qi);
                        }
                    }
                }
            }
        }
    }

    public void printStage(List<Pi> piList) {

        char[][] printLayout = new char[16][32];
        for (char[] printLayoutLine : printLayout) {
            Arrays.fill(printLayoutLine, ' ');
        }

        for (Pi pi : piList) {
            if (pi.getK() == 0) {
                printLayout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
                printLayout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
                printLayout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
                printLayout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
            }
        }
        for (Pi pi : piList) {
            if (pi.getK() == 1) {
                printLayout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
                printLayout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
                printLayout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
                printLayout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
            }
        }
        for (Pi pi : piList) {
            if (pi.getK() == 2) {
                printLayout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
                printLayout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
                printLayout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
                printLayout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
            }
        }
        for (Pi pi : piList) {
            if (pi.getK() == 3) {
                printLayout[pi.getI()][pi.getJ()] = pi.getPiType().getName();
                printLayout[pi.getI()][pi.getJ() + 1] = pi.getPiType().getName();
                printLayout[pi.getI() + 1][pi.getJ()] = pi.getPiType().getType();
                printLayout[pi.getI() + 1][pi.getJ() + 1] = pi.getPiType().getType();
            }
        }
        for (char[] printLayoutLine : printLayout) {
            for (char printChar : printLayoutLine) {
                System.out.print(printChar);
            }
            System.out.println();
        }
    }

    public void solve(List<Pi> piList) {
        List<Pi> solvedList = new ArrayList<>();
        Collections.shuffle(piList);
        solve(piList, solvedList, 0);
        System.out.println(solvedList);

    }

    // 計算量えぐめ
    // 牌が108個あったとして都度取得可能な牌の数=nとするとC2パターンがかかり、再起したらまたnC2
    // すでにunsolvedだったルートも再計算してる

    /**
     * @param piList 問題
     * @return true:解けた false:詰んだ
     */
    public boolean solve(List<Pi> piList, List<Pi> solvedList, int rollbackCount) {
        if (piList.size() == 0) {
            System.out.println("solved.");
            return true;//解けた
        }

        printStage(piList);
        update(piList);

        int removedCount = 0;

        // 4個とれるときは優先してとる
        // TODO Unsolvedだったルートを再計算しない
        Map<PiType, List<Pi>> piMap = new HashMap<>();
        for (Pi pi : piList) {
            if (pi.isRemoval()) {
                if (!piMap.containsKey(pi.getPiType())) {
                    piMap.put(pi.getPiType(), new ArrayList<>());
                }
                piMap.get(pi.getPiType()).add(pi);
            }
        }
        Map<PiType, List<Pi>> piTowMap = new HashMap<>(piMap);
        List<Pi> removedList = new ArrayList<>(piList);
        // 4個セットは特別扱いして根こそぎとる
        for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
            if (entry.getValue().size() == 4) {
                removedList.removeAll(entry.getValue());
                solvedList.addAll(entry.getValue());
                piTowMap.remove(entry.getKey());
                removedCount += 4;
                System.out.println("removed:" + entry.getValue());
            }
        }
        // 4個セットで取ったら再度アップデートしたい
        if (removedCount != 0) {
            if (solve(removedList, solvedList, removedCount)) {
                return true;
            }
        }

        // 細かく探索
        // 同じ牌で3C2のペアと2C1のペア網羅パターン作れればパターン網羅できそう
        Map<Pi, Pi> piPairMap = new HashMap<>();
        for (Map.Entry<PiType, List<Pi>> entry : piTowMap.entrySet()) {
            if (entry.getValue().size() == 2) {
                List<Pi> piValueList = entry.getValue();
                Pi p = entry.getValue().get(0);
                Pi q = entry.getValue().get(1);
                piPairMap.put(p, q);
            } else if (entry.getValue().size() == 3) {
                piPairMap.put(entry.getValue().get(0), entry.getValue().get(1));
                piPairMap.put(entry.getValue().get(0), entry.getValue().get(2));
                piPairMap.put(entry.getValue().get(1), entry.getValue().get(2));
            }
        }
        for (Map.Entry<Pi, Pi> pair : piPairMap.entrySet()) {
            List<Pi> recRemovedList = new ArrayList<>(piList);
            recRemovedList.remove(pair.getKey());
            recRemovedList.remove(pair.getValue());
            solvedList.add(pair.getKey());
            solvedList.add(pair.getValue());
            removedCount += 2;
            System.out.println("removed:" + pair.getKey());
            System.out.println("removed:" + pair.getValue());
            if (solve(recRemovedList, solvedList, removedCount)) {
                return true;
            }
        }

        System.out.println("unsolved.");
        if (solvedList.size() >= rollbackCount) {
            for (int i = 0; i < rollbackCount; i++) {
                solvedList.remove(solvedList.size() - 1);
            }
        }
        return false;
    }
}
