package com.sakamotodesu.shanghai.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class Shanghai {


    // print stage
    public void printStage(PiType[][] layer) {

        int piWidth = 4;
        int piHalfHeight = 1;

        char[][] printLayout = new char[layer.length * piHalfHeight * 2][layer[0].length * piWidth];

        for (char[] printLayoutLine : printLayout) {
            Arrays.fill(printLayoutLine, ' ');
        }

        for (int i = 0; i < layer.length; i++) {
            PiType[] layoutLine = layer[i];
            for (int j = 0; j < layoutLine.length; j++) {
                PiType piType = layoutLine[j];
                if (piType != nashi) {
                    printLayout[i * piHalfHeight][j * piWidth] = '|';
                    printLayout[i * piHalfHeight][j * piWidth + 1] = piType.getName();
                    printLayout[i * piHalfHeight][j * piWidth + 2] = piType.getName();
                    printLayout[i * piHalfHeight][j * piWidth + 3] = '|';
                    printLayout[i * piHalfHeight + 1][j * piWidth] = '|';
                    printLayout[i * piHalfHeight + 1][j * piWidth + 1] = piType.getType();
                    printLayout[i * piHalfHeight + 1][j * piWidth + 2] = piType.getType();
                    printLayout[i * piHalfHeight + 1][j * piWidth + 3] = '|';
                }
            }
        }
        for (char[] printLayoutLine : printLayout) {
            for (char printChar : printLayoutLine) {
                System.out.print(printChar);
            }
            System.out.println();
        }
    }


    // solve stage
    // 取れる牌を全て調べる
    // 取る牌を選ぶ
    // 牌を取る
    // ゲームクリア判定 -> クリア失敗したらどう次の探索を始める？
    // 再起的に掘っていけば良さそう。取った牌によって状況変わるしね
    // 取った牌のリスト、現在のレイアウト、探索済記録？スタックとループ使えばいける？

    /**
     * 取れる牌を調べる
     *
     * @param layer 牌のレイアウト
     * @return 取れる牌のリスト。ペアではない
     */
    public List<RemovalPi> getRemovalList(PiType[][] layer) {
        List<RemovalPi> removalPiList = new ArrayList<>();
        for (int i = 0; i < layer.length; i++) {
            PiType[] layoutLine = layer[i];
            for (int j = 0; j < layoutLine.length; j++) {
                PiType piType = layoutLine[j];
                if (piType != nashi && isRemoval(layer, i, j)) {
                    removalPiList.add(new RemovalPi(piType, i, j));
                }
            }
        }
        return removalPiList;
    }

    // 自分の左右に牌があるか
    private boolean isRemoval(PiType[][] layer, int i, int j) {
        if (j == 0 || j == layer[0].length - 1) {
            return true;
        }
        // 左チェック
        if (layer[i][j - 1] != nashi) {
            return false;
        }
        if (i == 0) {
            if (layer[i + 1][j - 1] == nashi) {
                return true;
            }
        } else if (i == layer.length - 1) {
            if (layer[i - 1][j - 1] == nashi) {
                return true;
            }
        } else {
            if (layer[i + 1][j - 1] == nashi && layer[i - 1][j - 1] == nashi) {
                return true;
            }
        }

        // 右チェック
        if (layer[i][j + 1] != nashi) {
            return false;
        }
        if (i == 0) {
            return layer[i + 1][j + 1] == nashi;
        } else if (i == layer.length - 1) {
            return layer[i - 1][j + 1] == nashi;
        } else {
            return layer[i + 1][j + 1] == nashi && layer[i - 1][j + 1] == nashi;
        }
    }
}
