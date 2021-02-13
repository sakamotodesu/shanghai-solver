package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;

import java.util.*;

public final class ShanghaiSolver {

    // TODO logger

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
    public void updateNeighborhood(List<Pi> piList) {
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

    // 詰み回避探索
    // 方法論
    // 　上海では、残された牌の配置によりそれ以上ゲームを進められない詰みパターンが存在する。
    // 　その詰みパターンが発生しないように牌を選ぶのが攻略法になるので、その思考回路を探索にも適用する。
    // 　このアルゴリズムでは事前に全ての牌の情報がわかっている(完全情報ゲームである)前提になっているので、まず事前に詰みパターンを調べておくことができる。
    // 　詰みパターンは重なっているもの、左右で1212のようにデッドロックしているもの、1122のようにデッドロックしているものに分類される。
    // 　いずれも間に他の牌が挟まっていても詰みとなる。また重なりと左右のデッドロックの詰みを同じ牌に同時に発生させることもできる。
    // 　これらの詰みパターンを事前に調べておき、探索で撮る牌を選んだ時点で詰みパターンに陥るか検査し、陥るならそのルートをスキップする。
    // 詰みパターンを考慮した探索の実装
    // 　ステージから詰みの組み合わせを事前に調べておいて牌に詰みペアを相互リンクしておく
    //　 　ステージにつき1回だけ計算する
    //　　　詰みリンクは重なりと左右それぞれ持つ
    // 　取る牌を選択した時点でその牌を取ったせいで詰みが発生するか都度調べる
    // 　　牌を取った後に残った2牌が重なりor左右いずれかの詰みパターンのペアになってたらアウト
    // 　　　詰みリンクは持ってるけどリンク先が残された牌でなければセーフ
    // 詰みパターン調査方法
    // 　重なりの調査も左右の調査もある牌を起点に牌の取得を阻害する配列を作り、その中に起点と同じ牌があるかを調べる必要がある。
    // 　ただ牌の配置は上下左右にずれることができるので、起点からDAG(有向非巡回グラフ)ができてしまう。
    // 　そのため、DAGの中で起点牌と同じ牌を見つける作業が必要になる。
    // 　重なりの調査ならDAGの中に起点と同じ牌を見つけた時点で相互リンクにして終了するが、左右の調査はその起点と終点の間にある牌を調べる必要がある。
    // 　起点と終点を結ぶ全配列パターンについて、その配列中の牌を機転に再度DAGを切り出し、1212の構造になるパターンを探す。


    // 詰みパターン調査の実装
    // 　重なり
    // 　　全ての牌について、DAG探索->rootと同じ牌が見つかったら相互リンク1:n
    // 　左右


    // 小さい問題に分割しよう

    public void updateDeadlock(List<Pi> piList) {
        updateDeadlockOnBlocks(piList);
        updateDeadlockSideBlocks(piList);
        updateDeadlockSideBlocksContinuous(piList);

    }

    /**
     * @param piList 問題
     */
    public void updateDeadlockOnBlocks(List<Pi> piList) {

    }


    /**
     * 左右の詰みパターン検索
     * 1212のパターン
     *
     * @param piList 問題
     */
    public void updateDeadlockSideBlocks(List<Pi> piList) {

    }
    // 起点からTree探索で同じ牌を探しに行って、見つけてからどうする？どうやって最短の戻り経路を探す？あーそもそも複数経路あるのか最短経路も
    //   どっちの経路にあるかわからないな
    private void treeSearchSideBlocksRec(Pi piRoot) {

    }

    /**
     * 左右の詰みパターン検索
     * 1122のパターン
     *
     * @param piList 問題
     */
    public void updateDeadlockSideBlocksContinuous(List<Pi> piList) {

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
     * @param piList        問題
     * @param solvedList    解答
     * @param rollbackCount 解答を巻き戻す牌の数
     * @param debug         true:詳細プリント
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

        updateNeighborhood(piList);

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
