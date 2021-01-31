package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;

import java.util.*;

import static com.sakamotodesu.shanghai.solver.pitype.Nashi.nashi;

public final class ShanghaiSolver {


    public static long unsolvedCount = 0;

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

    // 詰み探索
    // ステージから詰みの組み合わせをリストとして見つける
    // ステージにつき1回だけ計算する
    // 探索を進めて詰みが解決したら消していく


    public List<List<Pi>> blocks(List<Pi> piList, boolean debug) {

        List<List<Pi>> blocks = new ArrayList<>();
        // 重なってるパターン
        // 自分の上にいるやつを永遠と探せばいい
        // やっぱ厳密な位置をメンバ変数で持たせるの意味ないかなあ載ってるか左か右かだけでよさそう
        // まず自分に載っかってるやつを全部引っ張ってきて、その中に自分と同じタイプがいるか調べればいいか
        for (Pi pi : piList) {
            List<Pi> piOnBlocks = new ArrayList<>();
            List<Pi> piOnDeadLocks = new ArrayList<>();
            onBlocks(piOnBlocks, pi);
            for (Pi onPi : piOnBlocks) {
                if (onPi.getPiType() == pi.getPiType()) {
                    piOnDeadLocks.add(onPi);
                }
            }
            if (piOnDeadLocks.size() != 0) {
                blocks.add(piOnDeadLocks);
            }
        }

        // 横でデッドロックしてるパターン
        // 自分の横にいるやつのうちデッドロックになってるのを探せばいい
        // 左右に伸びたリストを作る、片側だけだと見逃しが出る
        //    自分と同じ牌を探す
        //      会ったらその間の牌がそのリストの自分を超えてもう1個あるか探す
        //    Upper Lowerにずれていくリストにどう対処するか？
        //  Tree構造を左右それぞれに切り出す
        //    root側に戻ってたどれるように親ノードが1個になるよう刈り取って切り出す
        //    Tree内に自分(root)と同じ牌(leaf)を探索する
        //      見つけたらrootとleafまでの最短経路をリストとして切り出す
        //        そのリストのなかでrootとleafの間の牌をリストアップする
        //          間の牌がleafより先に存在しているか探索する
        //            存在していたらデッドロック構造を発見したことになる
        //

        return blocks;
    }

    private void onBlocks(List<Pi> piOnBlocks, Pi pi) {
        if (pi.getOnUpperLeft().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnLower());
            onBlocks(piOnBlocks, pi.getOnLower());
        }
        if (pi.getOnMiddleLeft().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnMiddleLeft());
            onBlocks(piOnBlocks, pi.getOnMiddleLeft());
        }
        if (pi.getOnLowerLeft().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnLowerLeft());
            onBlocks(piOnBlocks, pi.getOnLowerLeft());
        }
        if (pi.getOnUpper().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnUpper());
            onBlocks(piOnBlocks, pi.getOnUpper());
        }
        if (pi.getOnMiddle().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnMiddle());
            onBlocks(piOnBlocks, pi.getOnMiddle());
        }
        if (pi.getOnLower().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnLower());
            onBlocks(piOnBlocks, pi.getOnLower());
        }
        if (pi.getOnUpperRight().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnUpperRight());
            onBlocks(piOnBlocks, pi.getOnUpperRight());
        }
        if (pi.getOnMiddleRight().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnMiddleRight());
            onBlocks(piOnBlocks, pi.getOnMiddleRight());
        }
        if (pi.getOnLowerRight().getPiType() != nashi) {
            piOnBlocks.add(pi);
            piOnBlocks.add(pi.getOnLowerRight());
            onBlocks(piOnBlocks, pi.getOnLowerRight());
        }
    }


    public void solve(List<Pi> piList) {
        solve(piList, false);
    }

    public void solve(List<Pi> piList, boolean debug) {
        List<Pi> solvedList = new ArrayList<>();
        solve(piList, solvedList, 0, debug);
        System.out.println(solvedList);
    }

    // 計算量えぐめ
    // 牌が108個あったとして都度取得可能な牌の数=nとするとC2パターンがかかり、再起したらまたnC2
    // nC2は最後の問題が解ける瞬間までほとんど1より大きいはずなので再起回数を54とすると2^54=1京
    // すでにunsolvedだったルートも再計算してる?->そんなことはなさそう
    //  今の計算量を調べる -> 3分で13700000unsolvedなので7000年かかるね
    //  並列にできるか検討する -> 並列にしても1000年かかるんじゃね
    // TODO もう詰んでることを検知して早めに探索を切り上げる。すべての詰みパターンを検知する必要はない
    // TODO ほかに刈り込みする案ないかねえ

    /**
     * @param piList 問題
     * @return true:解けた false:詰んだ
     */
    public boolean solve(List<Pi> piList, List<Pi> solvedList, int rollbackCount, boolean debug) {
        if (piList.size() == 0) {
            System.out.println("solved.");
            return true;//解けた
        }

        if (debug) {
            printStage(piList);
        }

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
                if (debug) {
                    System.out.println("removed:" + entry.getValue());
                }
            }
        }
        // 4個セットで取ったら再度アップデートしたい
        if (removedCount != 0) {
            if (solve(removedList, solvedList, removedCount, debug)) {
                return true;
            }
        }

        // 細かく探索
        // 同じ牌で3C2のペアと2C1のペア網羅パターン作れればパターン網羅できそう
        Map<Pi, Pi> piPairMap = new HashMap<>();
        for (Map.Entry<PiType, List<Pi>> entry : piTowMap.entrySet()) {
            if (entry.getValue().size() == 2) {
                piPairMap.put(entry.getValue().get(0), entry.getValue().get(1));
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
            if (debug) {
                System.out.println("removed:" + pair.getKey());
                System.out.println("removed:" + pair.getValue());
            }
            if (solve(recRemovedList, solvedList, removedCount, debug)) {
                return true;
            }
        }

        unsolvedCount++;
        if (debug) {
            System.out.println("unsolved.");
        }
        if (unsolvedCount % 1000 == 0) {
            System.out.println(unsolvedCount);
        }
        if (solvedList.size() >= rollbackCount) {
            for (int i = 0; i < rollbackCount; i++) {
                solvedList.remove(solvedList.size() - 1);
            }
        }
        return false;
    }
}
