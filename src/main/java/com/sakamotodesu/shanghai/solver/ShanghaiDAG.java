package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.FreePi;
import com.sakamotodesu.shanghai.solver.pi.Pi;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 上海専用DAG
 * 汎用的なDAGじゃないよ
 */
public class ShanghaiDAG {


    // TODO from to を指定したDAG切り出し

    // 重なり、左右は意識しないで良い構造にする

    @Getter
    private final List<Pi> vertexList = new ArrayList<>();
    @Getter
    private final List<PiPair> edgeList = new ArrayList<>();
    // 起点は特別扱い
    private Pi startVertex = FreePi.getInstance();

    /**
     * 重なりDAG作成
     *
     * @param rootPi 起点
     * @return 起点から重なり方向に生成されたDAG
     */
    public static ShanghaiDAG getOnDAG(Pi rootPi) {
        ShanghaiDAG onDag = new ShanghaiDAG();
        onDag.addVertex(rootPi);
        generateOnDAGRec(onDag, rootPi);
        return onDag;
    }

    private static void generateOnDAGRec(ShanghaiDAG onDag, Pi pi) {
        if (pi.getOnUpperLeft().isExist()) {
            onDag.addVertex(pi.getOnUpperLeft());
            onDag.addEdge(pi, pi.getOnUpperLeft());
            generateOnDAGRec(onDag, pi.getOnUpperLeft());
        }

        if (pi.getOnMiddleLeft().isExist()) {
            onDag.addVertex(pi.getOnMiddleLeft());
            onDag.addEdge(pi, pi.getOnMiddleLeft());
            generateOnDAGRec(onDag, pi.getOnMiddleLeft());
        }

        if (pi.getOnLowerLeft().isExist()) {
            onDag.addVertex(pi.getOnLowerLeft());
            onDag.addEdge(pi, pi.getOnLowerLeft());
            generateOnDAGRec(onDag, pi.getOnLowerLeft());
        }

        if (pi.getOnUpper().isExist()) {
            onDag.addVertex(pi.getOnUpper());
            onDag.addEdge(pi, pi.getOnUpper());
            generateOnDAGRec(onDag, pi.getOnUpper());
        }

        if (pi.getOnMiddle().isExist()) {
            onDag.addVertex(pi.getOnMiddle());
            onDag.addEdge(pi, pi.getOnMiddle());
            generateOnDAGRec(onDag, pi.getOnMiddle());
        }

        if (pi.getOnLower().isExist()) {
            onDag.addVertex(pi.getOnLower());
            onDag.addEdge(pi, pi.getOnLower());
            generateOnDAGRec(onDag, pi.getOnLower());
        }

        if (pi.getOnUpperRight().isExist()) {
            onDag.addVertex(pi.getOnUpperRight());
            onDag.addEdge(pi, pi.getOnUpperRight());
            generateOnDAGRec(onDag, pi.getOnUpperRight());
        }

        if (pi.getOnMiddleRight().isExist()) {
            onDag.addVertex(pi.getOnMiddleRight());
            onDag.addEdge(pi, pi.getOnMiddleRight());
            generateOnDAGRec(onDag, pi.getOnMiddleRight());
        }

        if (pi.getOnLowerRight().isExist()) {
            onDag.addVertex(pi.getOnLowerRight());
            onDag.addEdge(pi, pi.getOnLowerRight());
            generateOnDAGRec(onDag, pi.getOnLowerRight());
        }

    }


    /**
     * 頂点の追加
     * 重複登録はしない
     *
     * @param pi 頂点
     */
    public void addVertex(Pi pi) {
        if (vertexList.contains(pi)) {
            return;
        }
        if (!startVertex.isExist()) {
            startVertex = pi;
        }
        vertexList.add(pi);
    }

    /**
     * 辺の追加
     * 重複登録はしない
     *
     * @param from 辺の起点
     * @param to   辺の終点
     */
    public void addEdge(Pi from, Pi to) {
        for (PiPair edge : edgeList) {
            if (edge.eq(from, to)) {
                return;
            }
        }
        edgeList.add(new PiPair(from, to));
    }


    /**
     * DAGの中に起点と同じ牌があるか探索
     *
     * @return 起点と同じだった牌。
     */
    public List<Pi> search() {
        List<Pi> searched = vertexList.stream().filter(pi -> pi.getPiType() == startVertex.getPiType()).collect(Collectors.toList());
        searched.remove(startVertex);
        return searched;
    }

}
