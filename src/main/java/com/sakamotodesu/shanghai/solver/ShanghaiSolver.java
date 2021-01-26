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
