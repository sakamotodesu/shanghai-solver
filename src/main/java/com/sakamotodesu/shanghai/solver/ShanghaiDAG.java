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
    public static ShanghaiDAG getFloorDAG(Pi rootPi) {
        ShanghaiDAG floorDag = new ShanghaiDAG();
        floorDag.addVertex(rootPi);
        generateFloorDAGRec(floorDag, rootPi);
        return floorDag;
    }

    private static void generateFloorDAGRec(ShanghaiDAG floorDag, Pi pi) {
        if (pi.getOnUpperLeft().isExist()) {
            floorDag.addVertex(pi.getOnUpperLeft());
            floorDag.addEdge(pi, pi.getOnUpperLeft());
            generateFloorDAGRec(floorDag, pi.getOnUpperLeft());
        }

        if (pi.getOnMiddleLeft().isExist()) {
            floorDag.addVertex(pi.getOnMiddleLeft());
            floorDag.addEdge(pi, pi.getOnMiddleLeft());
            generateFloorDAGRec(floorDag, pi.getOnMiddleLeft());
        }

        if (pi.getOnLowerLeft().isExist()) {
            floorDag.addVertex(pi.getOnLowerLeft());
            floorDag.addEdge(pi, pi.getOnLowerLeft());
            generateFloorDAGRec(floorDag, pi.getOnLowerLeft());
        }

        if (pi.getOnUpper().isExist()) {
            floorDag.addVertex(pi.getOnUpper());
            floorDag.addEdge(pi, pi.getOnUpper());
            generateFloorDAGRec(floorDag, pi.getOnUpper());
        }

        if (pi.getOnMiddle().isExist()) {
            floorDag.addVertex(pi.getOnMiddle());
            floorDag.addEdge(pi, pi.getOnMiddle());
            generateFloorDAGRec(floorDag, pi.getOnMiddle());
        }

        if (pi.getOnLower().isExist()) {
            floorDag.addVertex(pi.getOnLower());
            floorDag.addEdge(pi, pi.getOnLower());
            generateFloorDAGRec(floorDag, pi.getOnLower());
        }

        if (pi.getOnUpperRight().isExist()) {
            floorDag.addVertex(pi.getOnUpperRight());
            floorDag.addEdge(pi, pi.getOnUpperRight());
            generateFloorDAGRec(floorDag, pi.getOnUpperRight());
        }

        if (pi.getOnMiddleRight().isExist()) {
            floorDag.addVertex(pi.getOnMiddleRight());
            floorDag.addEdge(pi, pi.getOnMiddleRight());
            generateFloorDAGRec(floorDag, pi.getOnMiddleRight());
        }

        if (pi.getOnLowerRight().isExist()) {
            floorDag.addVertex(pi.getOnLowerRight());
            floorDag.addEdge(pi, pi.getOnLowerRight());
            generateFloorDAGRec(floorDag, pi.getOnLowerRight());
        }

    }

    /**
     * 重なりDAG作成
     *
     * @param rootPi 起点
     * @return 起点から重なり方向に生成されたDAG
     */
    public static ShanghaiDAG getRightSideDAG(Pi rootPi) {
        ShanghaiDAG rightSideDag = new ShanghaiDAG();
        rightSideDag.addVertex(rootPi);
        generateRightSideDAGRec(rightSideDag, rootPi);
        return rightSideDag;
    }

    private static void generateRightSideDAGRec(ShanghaiDAG rightSideDag, Pi pi) {
        if (pi.getUpperRight().isExist()) {
            rightSideDag.addVertex(pi.getUpperRight());
            rightSideDag.addEdge(pi, pi.getUpperRight());
            generateRightSideDAGRec(rightSideDag, pi.getUpperRight());
        }

        if (pi.getMiddleRight().isExist()) {
            rightSideDag.addVertex(pi.getMiddleRight());
            rightSideDag.addEdge(pi, pi.getMiddleRight());
            generateRightSideDAGRec(rightSideDag, pi.getMiddleRight());
        }

        if (pi.getLowerRight().isExist()) {
            rightSideDag.addVertex(pi.getLowerRight());
            rightSideDag.addEdge(pi, pi.getLowerRight());
            generateRightSideDAGRec(rightSideDag, pi.getLowerRight());
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
