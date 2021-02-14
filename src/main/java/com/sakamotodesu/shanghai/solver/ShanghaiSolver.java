package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;

import java.util.*;
import java.util.stream.Collectors;

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
    // 　牌の配置は上下左右にずれることができるので、起点からDAG(有向非巡回グラフ)ができる。
    // 　そのため、DAGの中で起点牌と同じ牌を見つける作業が必要になる。
    // 　重なりの調査ならDAGの中に起点と同じ牌を見つけた時点で相互リンクにして終了するが、左右の調査はその起点と終点の間にある牌を調べる必要がある。
    // 　終点からさらにその先にDAGを構築し、起点・終点の間にある牌がそのDAGの中に存在すれば1212のパターンになっている。


    // 詰みパターン調査の実装
    // 　重なり
    // 　　全ての牌について、DAG探索->rootと同じ牌が見つかったら相互リンク1:n
    // 　左右


    // 小さい問題に分割しよう

    public void updateDeadlock(List<Pi> piList) {
        updateDeadlockFloor(piList);
        updateDeadlockRightSide(piList);
        updateDeadlockRightSideContinuous(piList);
    }

    /**
     * @param piList 問題
     */
    public void updateDeadlockFloor(List<Pi> piList) {
        for (Pi pi : piList) {
            ShanghaiDAG floorDag = ShanghaiDAG.getFloorDAG(pi);
            floorDag.search().forEach(pi::linkFloorDeadlockPi);
        }
    }


    /**
     * 左右の詰みパターン検索
     * 1212のパターン
     * 起点から右側を見るだけでいい
     *
     * @param piList 問題
     */
    public void updateDeadlockRightSide(List<Pi> piList) {
        for (Pi rootPi : piList) {
            ShanghaiDAG rightSideDag = ShanghaiDAG.getRightSideDAG(rootPi);
            List<Pi> samePiList = rightSideDag.search();
            for (Pi samePiAsRoot : samePiList) {
                ShanghaiDAG partialDag = rightSideDag.partialDag(samePiAsRoot);
                List<Pi> sandPiList = partialDag.getVertexList().stream().filter(qi -> qi.getPiType() != samePiAsRoot.getPiType()).collect(Collectors.toList());
                for (Pi sandPi : sandPiList) {
                    ShanghaiDAG samePiRightSideDag = ShanghaiDAG.getRightSideDAG(samePiAsRoot);
                    List<Pi> samePiAsSandList = samePiRightSideDag.getVertexList().stream().filter(ri -> ri.getPiType() == sandPi.getPiType()).collect(Collectors.toList());
                    for (Pi samePiAsSand : samePiAsSandList) {
                        rootPi.linkSideDeadlockPi(samePiAsRoot);
                        rootPi.linkSideDeadlockPi(sandPi);
                        sandPi.linkSideDeadlockPi(samePiAsSand);
                        sandPi.linkSideDeadlockPi(samePiAsRoot);
                    }
                }
            }

        }
    }


    /**
     * 左右の詰みパターン検索
     * 1122のパターン
     *
     * @param piList 問題
     */
    public void updateDeadlockRightSideContinuous(List<Pi> piList) {

    }

    public boolean solve(List<Pi> piList) {
        return solve(piList, false);
    }

    public boolean solve(List<Pi> piList, boolean debug) {
        List<Pi> solvedList = new ArrayList<>();
        updateNeighborhood(piList);
        updateDeadlock(piList);
        boolean ret = solve(piList, solvedList, 0, debug);
        System.out.println(solvedList);
        return ret;
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
        List<PiPair> piPairList = new ArrayList<>();
        for (Map.Entry<PiType, List<Pi>> entry : piTowMap.entrySet()) {
            if (entry.getValue().size() == 2) {
                piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
            } else if (entry.getValue().size() == 3) {
                piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(2)));
                piPairList.add(new PiPair(entry.getValue().get(1), entry.getValue().get(2)));
            }
        }
        for (PiPair pair : piPairList) {
            // pairを取ったら詰むならスキップ
            if (isCheckmate(piList, pair)) {
                if (debug) {
                    System.out.println("checkmate:" + pair);
                }
                continue;
            }
            List<Pi> recRemovedList = new ArrayList<>(piList);
            recRemovedList.remove(pair.getFrom());
            recRemovedList.remove(pair.getTo());
            solvedList.add(pair.getFrom());
            solvedList.add(pair.getTo());
            removedCount += 2;
            if (debug) {
                System.out.println("removed:" + pair.getFrom());
                System.out.println("removed:" + pair.getTo());
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

    /**
     * 牌をとったら詰むかチェック
     *
     * @param piList 問題
     * @param pair   削除候補
     * @return true:詰んだ false:詰んでない
     */
    private boolean isCheckmate(List<Pi> piList, PiPair pair) {
        // floor lockのチェック
        List<Pi> checkList = new ArrayList<>(piList);
        checkList.remove(pair.getFrom());
        checkList.remove(pair.getTo());
        List<Pi> restPiList = checkList.stream().filter(pi -> pi.getPiType() == pair.getFrom().getPiType()).collect(Collectors.toList());

        // 牌をとったら、同種の牌は2個か0個のどちらか。0個なら詰みはない。
        if (restPiList.size() == 0) {
            return false;
        }
        // 残った2個が相互にdeadlockListに入ってたら詰み
        if (restPiList.get(0).getFloorDeadlockList().contains(restPiList.get(1)) && restPiList.get(1).getFloorDeadlockList().contains(restPiList.get(0))) {
            return true;
        }

        // side lockのチェック
        // restPiから他のside lock piを探して、そいつらが残り2個になってないかチェックする
        if (restPiList.get(0).getSideDeadlockList().contains(restPiList.get(1)) && restPiList.get(1).getSideDeadlockList().contains(restPiList.get(0))) {
            // 削除候補でない牌が詰みになっているか？4個残ってれば詰みではない
            List<Pi> otherLockPiList = restPiList.get(0).getSideDeadlockList().stream().filter(pi -> pi.getPiType() != pair.getFrom().getPiType()).collect(Collectors.toList());
            for (Pi otherPi : otherLockPiList) {
                // 2個しか残ってないなら詰み
                if (piList.stream().filter(pi -> pi.getPiType() == otherPi.getPiType()).count() == 2) {
                    return true;
                }
            }
        }
        return false;
    }
}
