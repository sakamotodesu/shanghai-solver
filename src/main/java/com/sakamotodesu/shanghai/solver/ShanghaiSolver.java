package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;
import org.jgrapht.Graph;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DirectedAcyclicGraph;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

public final class ShanghaiSolver {


    public static long unsolvedCount = 0;
    private final Logger logger = LoggerFactory.getLogger(getClass());

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
                    || layout[pi.getK()][pi.getI()][pi.getJ() + 1] != ' '
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
            logger.debug(String.valueOf(printLayoutLine));
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
    // TODO 重なり詰みパターンで1の上に2、2の上に1というパターンもあった。重なりと左右それぞれ類似のロックがありそう


    // 詰みパターン調査の実装
    // 　重なり
    // 　　全ての牌について、DAG探索->rootと同じ牌が見つかったら相互リンク1:n
    // 　左右


    // 小さい問題に分割しよう
    // 動的計画法むいてなさそう
    // 　途中の経路全部覚えてなきゃいけないから計算結果の再利用とかないんだよね
    // 　再起するにしてもすでに解いた問題に出会うことはないし
    // 　問題を分割する方法もない

    // 改めて問題の性質分析
    //   探索問題
    // 　　局面を頂点、取った牌を辺にして初期値->牌ゼロのDAGができる
    // 　　　ただこのDAGをそもそも作るのが大変という問題なので探索すべき
    // 　　探索する空間
    // 　　　ゴールまでのステップ数は最短・最長ともに牌の数/2
    // 　　　　局面ごとに取れる辺のパターンは1-10くらいまで変化する。10ってのは適当な数字。
    // 　　　　　108牌で選択肢を2とすると2^54で1京ぐらい。これは総当たりすべき数字ではない。
    // 　　探索戦略
    // 　　　同じ局面からの再探索はしない
    // 　　　詰みパターンからの逆算により探索不要なルートを刈り取る
    // 　　　評価値みたいな仕組みで優先探索したい
    // 　　　　詰みパターンを優先的に潰したり、詰みパターンの牌に近くルートを優先的に試したりしたい
    // 　　　　　深さ優先で掘り下げ、情報集まったら手前から再分岐する？
    // 　　　　　　実際上海をプレイする時もそんな感じ。詰みを見つけたら解消を優先し、詰みにくいようにプレイし、
    // 　　　　局面、その次の手に評価点をつける
    // 　　　　　評価点の高い局面、次の手を選ぶ
    // 　　　　　　再帰敵に分岐パターンが残っている局面をリストアップし、再度評価点の高いてを選ぶ
    // 　　　　　　局面リストに対して網羅的に分岐はしない
    // 　　　　　　　局面のリストアップ方法変えないと。いまはそこから先の辺がない局面としてるけど今後は未分岐ありなし、評価点を知る必要がある
    // 　　　　　　　　局面クラスに配列、評価点、を残すのはいいけど未分岐の情報はグラフが壊れるなあ
    // 　　　　　　　　　未分岐の辺があることをどうやって知る？未分岐未探索ルートリストは辺の集合として別管理する？
    // 　　　　　　　　　　単に分岐先を未探索局面として管理しておけばよさそう
    // 　　　　　　　　　　　でも分岐元とセットで管理しないとダメか。辺が作れない。
    // 　　　　　詰みパターンに絡んでる牌は点数を加点する？その牌に絡んでる牌も点数をちょっと加点し選ばれやすくする？
    // 　　　　　　詰みパターンの厳密な検知は残しておいて、詰み牌からのデッドロックDAGを生成してその中にあるものをちょっと加点したりとか
    // 　　　　　　　詰みがなくなった局面は最優先したい。とけちゃうはずだし。局面ごとに詰みパターンが何個あるかで優先度変わる？
    //
    // 　　　　　単に牌が少ない局面も優先する
    // 　　　　　　でもそうすると単なる深さ優先探索になるよね
    // 　　　　　　　unsolvedになったときは次に選ぶ局面に対して特別なロジックを選ぶ
    // 　　　　　　　　unsolvedにぶち当たるまでは牌が少ない&評価点高いベースで潜って、ぶち当たったら牌の少なさは無視して評価点だけで再度選ぶ・・・とかできるかなあ
    // 　　　　　　　　　ぶち当たったら再度評価点を再計算できると良いんだけど難しいな。あーでもPiは共通のオブジェクト使ってるからできちゃう？
    // 　　　　　局面の牌の数、評価点、詰みパターンの有無で優先度が変わる？
    // 　　　　　　早く解くには、詰みパターンを積極的に減らして、ゼロになったらひたすら牌を取る
    // 　　探索戦略2
    // 　　　詰みになったら残った牌を加点する？
    // 　　　　詰みになったときに、removalなのに1個しかない牌があれば加点する
    // 　　　　　実際の思考回路に近いな
    // 　　　

    // なんでパズルっぽく解けないんだろうな
    // 　手を確定する、みたいな手段がないよね
    // 　　これを取るためにはこれを取らなきゃ、とかも双方向になっちゃう


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
            floorDag.searchRootPi().forEach(pi::linkFloorDeadlockPi);
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
            List<Pi> samePiList = rightSideDag.searchRootPi();
            for (Pi samePiAsRoot : samePiList) {
                ShanghaiDAG partialDag = rightSideDag.partialDag(samePiAsRoot);
                List<Pi> sandPiList = partialDag.getVertexList().stream().filter(qi -> qi.getPiType() != samePiAsRoot.getPiType()).collect(Collectors.toList());
                for (Pi sandPi : sandPiList) {
                    ShanghaiDAG samePiRightSideDag = ShanghaiDAG.getRightSideDAG(samePiAsRoot);
                    List<Pi> samePiAsSandList = samePiRightSideDag.getVertexList().stream().filter(ri -> ri.getPiType() == sandPi.getPiType()).collect(Collectors.toList());
                    for (Pi samePiAsSand : samePiAsSandList) {
                        // TODO これでロック情報網羅してるか怪しいなあ
                        rootPi.linkSideDeadlockPi(samePiAsRoot);
                        rootPi.linkSideDeadlockPi(sandPi);
                        sandPi.linkSideDeadlockPi(samePiAsSand);
                        sandPi.linkSideDeadlockPi(samePiAsRoot);
                    }
                }
            }

        }
    }

    // TODO 並列化できないかなあ
    // 　　　solveByGraph単位でできそう。floorの処理を別スレッドにして、各スレッドはGraphの最新状態からスタートする

    /**
     * 左右の詰みパターン検索
     * 1122のパターン
     * TODO テストかく
     *
     * @param piList 問題
     */
    public void updateDeadlockRightSideContinuous(List<Pi> piList) {
        for (Pi rootPi : piList) {
            // 11を探す
            ShanghaiDAG rightSideDag = ShanghaiDAG.getRightSideDAG(rootPi);
            List<Pi> samePiList = rightSideDag.searchRootPi();
            for (Pi samePiAsRoot : samePiList) {
                // 22を探す
                List<Pi> samePiNextPiRootList = rightSideDag.getEdgeList().stream()
                        .filter(pair -> pair.getFrom().getPiType() == samePiAsRoot.getPiType())
                        .map(PiPair::getTo).collect(Collectors.toList());
                for (Pi nextRoot : samePiNextPiRootList) {
                    ShanghaiDAG nextRootDag = ShanghaiDAG.getRightSideDAG(nextRoot);
                    Map<PiType, List<Pi>> piMap = new HashMap<>();
                    nextRootDag.getVertexList().forEach(pi -> {
                        if (!piMap.containsKey(pi.getPiType())) {
                            piMap.put(pi.getPiType(), new ArrayList<>());
                        }
                        piMap.get(pi.getPiType()).add(pi);
                    });
                    // 4個並んでたらそもそも解答不能な問題のはず
                    for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
                        if (entry.getValue().size() == 2) {
                            Pi pi = entry.getValue().get(0);
                            ShanghaiDAG dag = ShanghaiDAG.getRightSideDAG(pi);
                            List<Pi> pairList = dag.searchRootPi();
                            if (pairList.size() != 0) {
                                // みつかった
                                rootPi.linkSideDeadlockPi(samePiAsRoot);
                                rootPi.linkSideDeadlockPi(pi);
                                pi.linkSideDeadlockPi(pairList.get(0));
                                pi.linkSideDeadlockPi(samePiAsRoot);
                            }
                            Pi pi2 = entry.getValue().get(0);
                            ShanghaiDAG dag2 = ShanghaiDAG.getRightSideDAG(pi2);
                            List<Pi> pairList2 = dag2.searchRootPi();
                            if (pairList2.size() != 0) {
                                // みつかった
                                rootPi.linkSideDeadlockPi(samePiAsRoot);
                                rootPi.linkSideDeadlockPi(pi2);
                                pi2.linkSideDeadlockPi(pairList2.get(0));
                                pi2.linkSideDeadlockPi(samePiAsRoot);
                            }

                        }
                    }
                }
            }

        }
    }

    public boolean solve(List<Pi> piList) {
        List<Pi> solvedList = new ArrayList<>();
        updateNeighborhood(piList);
        updateDeadlock(piList);
        boolean ret = solve(piList, solvedList, 0);
        logger.info(solvedList.toString());
        return ret;
    }

    // 計算量えぐめ
    // 牌が108個あったとして都度取得可能な牌の数=nとするとC2パターンがかかり、再起したらまたnC2
    // nC2は最後の問題が解ける瞬間までほとんど1より大きいはずなので再起回数を54とすると2^54=1京
    // すでにunsolvedだったルートも再計算してる?->そんなことはなさそう
    //  今の計算量を調べる -> 3分で13700000unsolvedなので7000年かかるね
    //  並列にできるか検討する -> 並列にしても1000年かかるんじゃね
    // TODO ほかに刈り込みする案ないかねえ
    // もう詰んでることを検知して早めに探索を切り上げる。すべての詰みパターンを検知する必要はない
    // 　実装したけど効果薄め。詰みの手を選ぶのが終盤になり、総当たりの初期の分岐時点で刈り取られないから探索範囲がごっそり減らない
    // 　全ての牌をDAGにしてトポロジカルそーとしてからとけばいい？！重み付けedgeにすれば取れる牌は区別できそう
    // 　　牌列はDAGではないし無向グラフとして扱ってもロックの概念をグラフに落とし込めない
    // 　やはりロックが肝では？ゲームの本質もいかにロックを避けるかというゲーム。
    // 　　ロック部分だけ切り出して解法を探索する？そのあとその形になるように逆算して牌を取る？
    // 　　　とにかくキーになる牌があるんだよな。これは絶対この順番でとらないとだめってやつ。それを割り出せないかな
    // 　　　　ひょっとして直接詰みパターンじゃない牌がキーになることもあるのかな
    // 　　　　　詰みパターンを考慮するとこの順番で取らないとダメ。そのためにはこれを取らないとダメ。みたいなDAGを生成してみる？
    // 　　　　　　そのDAGを最後くっつければそれが解答になる？いけそう
    // 　　　　　　　牌が頂点ではなく取る牌のペアが頂点になる
    // 　　　　　　　　部分解答DAGをたくさん集めてその組み合わせで全解答DAGを作る。壮大。
    // 　　　　　　　　　部分解答DAGは結果が同じになるならマージできるね
    // 　　　　　　　　　　そこは別においしくないか。先に詰みパターンを解決するDAGを作って、そこに骨継ぎしていく。
    // 　深さ優先で探索してるけど幅優先でやった方がいい？牌を取る順番が前後しても結果が同じになるのを刈り取る？


    // 完全情報であることを利用して賢く解きたい
    // 　1人有限確定完全情報ゲームらしい
    // 　　牌を取る度に局面が進み、局面を頂点としたDAGになる
    // 　　　解析済みの局面をメモする？動的計画法使える？
    // 　　　　後退解析？
    // 　　　勝敗が決している場面から出発して、後ろから遡るように探索する
    // 　評価関数の出番？
    // 　小さい問題から解析してみるか
    // 　　解析ってなんだ？
    // 　　　想定より難しい問題に手を出してしまったらしい
    // TODO ローカル環境以外でも放置して動かせるようにする


    /**
     * @param piList        問題
     * @param solvedList    解答
     * @param rollbackCount 解答を巻き戻す牌の数
     * @return true:解けた false:詰んだ
     */
    public boolean solve(List<Pi> piList, List<Pi> solvedList, int rollbackCount) {
        if (piList.size() == 0) {
            logger.info("solved.");
            return true;//解けた
        }
        logger.info(solvedList.toString());
        if (logger.isDebugEnabled()) {
            printStage(piList);
        }

        updateNeighborhood(piList);

        int removedCount = 0;

        // 4個とれるときは優先してとる
        // TODO Unsolvedだったルートを再計算しない
        Map<PiType, List<Pi>> piMap = getRemovablePiMap(piList);
        Map<PiType, List<Pi>> piTowMap = new HashMap<>(piMap);
        List<Pi> removedList = new ArrayList<>(piList);
        // 4個セットは特別扱いして根こそぎとる
        for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
            if (entry.getValue().size() == 4) {
                removedList.removeAll(entry.getValue());
                solvedList.addAll(entry.getValue());
                piTowMap.remove(entry.getKey());
                removedCount += 4;
                logger.debug("removed:" + entry.getValue());
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
                logger.debug("checkmate:" + pair);
                continue;
            }
            List<Pi> recRemovedList = new ArrayList<>(piList);
            recRemovedList.remove(pair.getFrom());
            recRemovedList.remove(pair.getTo());
            solvedList.add(pair.getFrom());
            solvedList.add(pair.getTo());
            removedCount += 2;
            logger.debug("removed:" + pair.getFrom());
            logger.debug("removed:" + pair.getTo());
            if (solve(recRemovedList, solvedList, removedCount)) {
                return true;
            }
        }

        unsolvedCount++;
        logger.debug("unsolved.");
        if (unsolvedCount % 1000 == 0) {
            logger.info(String.valueOf(unsolvedCount));
        }
        if (solvedList.size() >= rollbackCount) {
            for (int i = 0; i < rollbackCount; i++) {
                solvedList.remove(solvedList.size() - 1);
            }
        }
        return false;
    }

    private boolean isCheckmate(List<Pi> candidateList, List<Pi> piList, PiPair pair) {
        List<Pi> list = new ArrayList<>(piList);
        list.removeAll(candidateList);
        return isCheckmate(list, pair);
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
            logger.info("checkmate.");
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
                    logger.info("checkmate.");
                    return true;
                }
            }
        }
        return false;
    }

    // 幅優先探索
    // 幅優先で探索して、牌を取った後に同じ盤面になるパターンをマージする
    // 　その後１段下げて探索する
    // 　　

    public boolean solveByBreadthStart(List<Pi> piList) {
        List<CandidateAnswer> candidateAnswerList = new ArrayList<>();
        candidateAnswerList.add(new CandidateAnswer(new ArrayList<>(), piList));
        return solveByBreadth(candidateAnswerList);
    }

    /**
     * 幅優先。探索中の解答候補+取れる牌の配列を育てていく
     *
     * @param candidateAnswerList 探索中の解答候補
     * @return true:とけた
     */
    public boolean solveByBreadth(List<CandidateAnswer> candidateAnswerList) {
        if (candidateAnswerList.stream().anyMatch(candidateAnswer -> candidateAnswer.getAnalysysPiList().size() == 0)) {
            logger.info("solved.");
            logger.info(candidateAnswerList.stream().filter(c -> c.getAnalysysPiList().size() == 0).collect(Collectors.toList()).get(0).getCandidateAnswerList().toString());
            return true;//解けた
        }

        List<CandidateAnswer> fatCandidateAnswerList = new ArrayList<>();
        candidateAnswerList.forEach(candidateAnswer -> {

            updateNeighborhood(candidateAnswer.getAnalysysPiList());

            // 4個とれるときは優先してとる
            Map<PiType, List<Pi>> piMap = getRemovablePiMap(candidateAnswer.getAnalysysPiList());

            // 4個セットは特別扱いして根こそぎとる
            List<Pi> removedFourPies = piMap.entrySet().stream()
                    .filter(e -> e.getValue().size() == 4)
                    .flatMap(e -> e.getValue().stream())
                    .collect(Collectors.toList());
            if (removedFourPies.size() != 0) {
                candidateAnswer.addAll(removedFourPies);
                CandidateAnswer newCandidateAnswer = new CandidateAnswer(candidateAnswer);
                fatCandidateAnswerList.add(newCandidateAnswer);
                logger.debug("removed:" + removedFourPies);
            } else {

                // 2個とるパターンを網羅
                List<PiPair> piPairList = new ArrayList<>();
                for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
                    if (entry.getValue().size() == 2) {
                        piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                    } else if (entry.getValue().size() == 3) {
                        piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                        piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(2)));
                        piPairList.add(new PiPair(entry.getValue().get(1), entry.getValue().get(2)));
                    }
                }

                piPairList.stream().filter(p -> !isCheckmate(candidateAnswer.getCandidateAnswerList(), candidateAnswer.getAnalysysPiList(), p)).forEach(pair -> {
                    CandidateAnswer newCandidateAnswer = new CandidateAnswer(candidateAnswer);
                    newCandidateAnswer.addAll(pair.toList());
                    fatCandidateAnswerList.add(newCandidateAnswer);
                });
            }
        });

        // fatをダイエット
        // TODO 4個を根こそぎ取るロジックのせいでダイエットうまく行ってないよねえ。4個とった場合と取らない場合の分岐があるならリストの長さ変わるよね。とはいえ4個ロジックをやめると計算量えぐくてnormalもとけない
        List<CandidateAnswer> nextCandidateAnswerList = new ArrayList<>();
        fatCandidateAnswerList.forEach(fatList -> {
            if (nextCandidateAnswerList.stream().noneMatch(nextList -> equalsCandidateAnswer(fatList, nextList))) {
                nextCandidateAnswerList.add(fatList);
            }
        });
        logger.info("diet:" + fatCandidateAnswerList.size() + "->" + nextCandidateAnswerList.size());
        if (nextCandidateAnswerList.size() == 0) {
            logger.debug("unsolved");
            return false;
        } else {
            return solveByBreadth(nextCandidateAnswerList);
        }
    }

    public boolean equalsCandidateAnswer(CandidateAnswer candidateAnswer, CandidateAnswer candidateAnswer2) {
        return candidateAnswer.getAnalysysPiList().equals(candidateAnswer2.getAnalysysPiList());
    }

    // DAG生成＋探索
    //   局面を頂点、取った牌を辺とする
    // 　　whileで回す
    // 　　　初期状態からスタートし取得可能な牌のパターンだけ分岐する
    // 　　　　詰みパターンを作成する分岐は刈り取る
    // 　　　　新しい頂点一覧ができる
    // 　　　　　すでに分岐済みの局面に帰着したらそこで終わり
    // 　　　　　　未探索(未分岐)の頂点かどうか判定する
    // 　　　　　　　jGraphでいけるかなあ。同一頂点の判定、出ていく辺を持っているかの判定とか？

    public boolean solverByGraph(List<Pi> piList) {

        Graph<List<Pi>, DefaultEdge> graph = new DirectedAcyclicGraph<>(DefaultEdge.class);
        AtomicBoolean solved = new AtomicBoolean(false);
        int floor = 0;
        graph.addVertex(piList);

        while (!solved.get()) {
            // graphから行き先がない頂点を取る
            List<List<Pi>> targetVertexList = graph.edgeSet().stream().map(graph::getEdgeTarget).collect(Collectors.toList());
            if (targetVertexList.size() == 0) {
                targetVertexList.add(piList);
            }
            List<List<Pi>> sourceVertexList = graph.edgeSet().stream().map(graph::getEdgeSource).collect(Collectors.toList());
            targetVertexList.removeAll(sourceVertexList);

            targetVertexList.forEach(targetVertex -> {
                if (targetVertex.size() == 0) {
                    solved.set(true);
                    logger.info("solved");
                    printAnswer(graph, piList, targetVertex);
                }
                updateNeighborhood(targetVertex);

                Map<PiType, List<Pi>> piMap = getRemovablePiMap(targetVertex);

                List<Pi> removedFourPies = piMap.entrySet().stream()
                        .filter(e -> e.getValue().size() == 4)
                        .flatMap(e -> e.getValue().stream())
                        .collect(Collectors.toList());
                if (removedFourPies.size() != 0) {
                    addVertex(graph, targetVertex, removedFourPies);
                } else {
                    List<PiPair> piPairList = new ArrayList<>();
                    for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
                        if (entry.getValue().size() == 2) {
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                        } else if (entry.getValue().size() == 3) {
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(2)));
                            piPairList.add(new PiPair(entry.getValue().get(1), entry.getValue().get(2)));
                        }
                    }
                    piPairList.stream().filter(p -> !isCheckmate(targetVertex, p)).forEach(pair -> addVertex(graph, targetVertex, pair.toList())
                    );
                }
            });
            floor++;
            logger.info("floor:vertex:" + floor + ":" + graph.vertexSet().size());
        }

        return solved.get();
    }

    /**
     * 取り除き可能な牌種とそのリストを取得する
     *
     * @param piList 局面配列
     * @return 取り除き可能な牌種とそのリスト
     */
    private Map<PiType, List<Pi>> getRemovablePiMap(List<Pi> piList) {
        Map<PiType, List<Pi>> piMap = new HashMap<>();
        piList.stream().filter(Pi::isRemoval).forEach(pi -> {
            if (!piMap.containsKey(pi.getPiType())) {
                piMap.put(pi.getPiType(), new ArrayList<>());
            }
            piMap.get(pi.getPiType()).add(pi);
        });
        return piMap;
    }

    /**
     * 重複チェックしつつ頂点を追加
     *
     * @param graph         解答探索グラフ
     * @param targetVertex  辺の出発点
     * @param removalPiList 取り除く牌
     */
    private void addVertex(Graph<List<Pi>, DefaultEdge> graph, List<Pi> targetVertex, List<Pi> removalPiList) {
        List<Pi> nextVertex = new ArrayList<>(targetVertex);
        nextVertex.removeAll(removalPiList);
        graph.addVertex(nextVertex);
        graph.addEdge(targetVertex, nextVertex);
    }

    private void printAnswer(Graph<List<Pi>, DefaultEdge> graph, List<Pi> startVertex, List<Pi> endVertex) {
        DijkstraShortestPath<List<Pi>, DefaultEdge> dijkstraAlg =
                new DijkstraShortestPath<>(graph);
        ShortestPathAlgorithm.SingleSourcePaths<List<Pi>, DefaultEdge> iPaths = dijkstraAlg.getPaths(startVertex);
        List<List<Pi>> a = iPaths.getPath(endVertex).getVertexList();
        List<Pi> preList = startVertex;
        for (List<Pi> currentList : a) {
            if (!preList.equals(currentList)) {
                List<Pi> answer = new ArrayList<>(preList);
                answer.removeAll(currentList);
                logger.info(answer.toString());
                preList = currentList;
            }
        }

    }

    /**
     * 評価点方式で解く
     * 深さ優先で探索し、詰んだらその時取れなかった牌の評価を加点し、その牌を優先的に取るルートから再探索する
     * @param piList 問題
     * @param breadth 探索幅
     * @return true:解けた
     */
    public boolean solveByPoint(List<Pi> piList, int breadth) {
        Graph<List<Pi>, ShanghaiEdge> graph = new DirectedAcyclicGraph<>(ShanghaiEdge.class);
        // 出発頂点、到達頂点、取る牌のペア
        List<ShanghaiEdge> edgeList = new ArrayList<>();
        Map<PiType, Integer> pointMap = new HashMap<>();
        AtomicBoolean solved = new AtomicBoolean(false);
        int floor = 0;
        graph.addVertex(piList);
        List<List<Pi>> targetVertexList;
        Comparator<ShanghaiEdge> edgeComparator = Comparator.comparingInt(o -> o.getPoint(pointMap));

        while (!solved.get()) {

            // 評価点の高いedgeが第一優先で、評価点が同じなら牌の数が少ないVertexが優先
            if (edgeList.stream().map(e -> e.getPoint(pointMap)).distinct().count() == 1) {
                // 評価点が全部同じなのでVertexの牌の数が少ないやつ優先
                targetVertexList = edgeList.stream()
                        .map(graph::getEdgeTarget)
                        .sorted(Comparator.comparingInt(List::size))
                        .collect(Collectors.toList());
                if (targetVertexList.size() > breadth) {
                    targetVertexList = targetVertexList.subList(0, breadth);
                }
                // edgeListから取り除きたい
                List<ShanghaiEdge> removalEdge = new ArrayList<>();
                for (ShanghaiEdge edge : edgeList) {
                    if (targetVertexList.contains(graph.getEdgeTarget(edge))) {
                        removalEdge.add(edge);
                    }
                }
                edgeList.removeAll(removalEdge);
            } else {
                // 評価点優先
                List<ShanghaiEdge> priorityEdge = edgeList.stream().sorted(edgeComparator.reversed()).collect(Collectors.toList());
                if (edgeList.size() > breadth) {
                    priorityEdge = priorityEdge.subList(0, breadth);
                }
                targetVertexList = priorityEdge.stream().map(graph::getEdgeTarget).collect(Collectors.toList());
                edgeList.removeAll(priorityEdge);
            }
            if (edgeList.isEmpty() && targetVertexList.isEmpty()) {
                targetVertexList.add(piList);
            }

            for (List<Pi> targetVertex : targetVertexList) {
                logger.debug(String.valueOf(targetVertex.size()));
                if (targetVertex.size() == 0) {
                    solved.set(true);
                    logger.info("solved");
                    this.printShanghaiAnswer(graph, piList, targetVertex);
                }
                updateNeighborhood(targetVertex);

                Map<PiType, List<Pi>> piMap = getRemovablePiMap(targetVertex);

                List<Pi> removedFourPies = piMap.entrySet().stream()
                        .filter(e -> e.getValue().size() == 4)
                        .flatMap(e -> e.getValue().stream())
                        .collect(Collectors.toList());
                if (removedFourPies.size() != 0) {
                    addShanghaiVertex(edgeList, graph, targetVertex, removedFourPies);
                } else {
                    List<PiPair> piPairList = new ArrayList<>();
                    for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
                        if (entry.getValue().size() == 2) {
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                        } else if (entry.getValue().size() == 3) {
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(1)));
                            piPairList.add(new PiPair(entry.getValue().get(0), entry.getValue().get(2)));
                            piPairList.add(new PiPair(entry.getValue().get(1), entry.getValue().get(2)));
                        }
                    }
                    if (piPairList.isEmpty()) {
                        // 取れるペアがなかったから詰んでる。その牌種全部の評価点をプラスする。
                        for (Map.Entry<PiType, List<Pi>> entry : piMap.entrySet()) {
                            if (entry.getValue().size() == 1) {
                                piList.stream().map(Pi::getPiType)
                                        .filter(piType -> piType == entry.getKey())
                                        .forEach(type -> {
                                            if (!pointMap.containsKey(type)) {
                                                pointMap.put(type, 0);
                                            }
                                            Integer point = pointMap.get(type);
                                            point++;
                                            pointMap.put(type, point);
                                        });
                                logger.debug("add point:" + pointMap);
                            }
                        }
                    } else {
                        piPairList.forEach(pair -> addShanghaiVertex(edgeList, graph, targetVertex, pair.toList()));
                    }
                }
            }
            floor++;
            if (floor % 1000 == 0) {
                logger.debug("floor:vertex:" + floor + ":" + graph.vertexSet().size());
            }
        }
        return solved.get();
    }

    /**
     * 探索途中の頂点の追加
     * @param edgeList 探索候補の辺リスト
     * @param graph 探索グラフ
     * @param targetVertex 辺の出発点
     * @param removalPiList 辺の到着点
     */
    private void addShanghaiVertex(List<ShanghaiEdge> edgeList, Graph<List<Pi>, ShanghaiEdge> graph, List<Pi> targetVertex, List<Pi> removalPiList) {
        List<Pi> nextVertex = new ArrayList<>(targetVertex);
        nextVertex.removeAll(removalPiList);
        graph.addVertex(nextVertex);
        ShanghaiEdge edge = new ShanghaiEdge(removalPiList);
        boolean ret = graph.addEdge(targetVertex, nextVertex, edge);
        if (ret) {
            edgeList.add(edge);
        } else {
            // todo なぜかedgeが重複するケースがあるらしい
            logger.debug("edge already added.");
        }
    }

    /**
     * 解答の表示
     * ダイクストラ法で初期状態から解答状態までの道を探索
     * @param graph 探索グラフ
     * @param startVertex 問題の初期状態
     * @param endVertex 問題が解けた状態
     */
    private void printShanghaiAnswer(Graph<List<Pi>, ShanghaiEdge> graph, List<Pi> startVertex, List<Pi> endVertex) {
        DijkstraShortestPath<List<Pi>, ShanghaiEdge> dijkstraAlg =
                new DijkstraShortestPath<>(graph);
        ShortestPathAlgorithm.SingleSourcePaths<List<Pi>, ShanghaiEdge> iPaths = dijkstraAlg.getPaths(startVertex);
        List<List<Pi>> a = iPaths.getPath(endVertex).getVertexList();
        List<Pi> preList = startVertex;
        for (List<Pi> currentList : a) {
            if (!preList.equals(currentList)) {
                List<Pi> answer = new ArrayList<>(preList);
                answer.removeAll(currentList);
                logger.info(answer.toString());
                preList = currentList;
            }
        }
    }
}
