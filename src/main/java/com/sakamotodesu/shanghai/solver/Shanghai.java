package com.sakamotodesu.shanghai.solver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.Nashi.nashi;

public class Shanghai {


    // print stage
    public void printStage(Pi[][] layer) {

        int piWidth = 3;
        int piHalfHeight = 1;

        char[][] printLayout = new char[layer.length * piHalfHeight * 2][layer[0].length * piWidth];

        for (char[] printLayoutLine : printLayout) {
            Arrays.fill(printLayoutLine, ' ');
        }

        for (int i = 0; i < layer.length; i++) {
            Pi[] layoutLine = layer[i];
            for (int j = 0; j < layoutLine.length; j++) {
                Pi pi = layoutLine[j];
                if (pi != nashi) {
                    printLayout[i * piHalfHeight][j * piWidth] = '|';
                    printLayout[i * piHalfHeight][j * piWidth + 1] = pi.getName();
                    printLayout[i * piHalfHeight][j * piWidth + 2] = '|';
                    printLayout[i * piHalfHeight + 1][j * piWidth] = '|';
                    printLayout[i * piHalfHeight + 1][j * piWidth + 1] = pi.getType();
                    printLayout[i * piHalfHeight + 1][j * piWidth + 2] = '|';
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

    public void solve(Pi[][] layer) {
        // 取れる牌を探す
        List<RemovalPi> removalPiList = new ArrayList<>();
        for (int i = 0; i < layer.length; i++) {
            Pi[] layoutLine = layer[i];
            for (int j = 0; j < layoutLine.length; j++) {
                Pi pi = layoutLine[j];
                if (pi != nashi && isRemoval(layer, i, j)) {
                    removalPiList.add(new RemovalPi(pi, i, j));
                }
            }
        }
        System.out.println(removalPiList);

        // 取る牌を選ぶ
        // pairを探す
        // 牌を取る

    }

    // 自分の左右に牌があるか
    private boolean isRemoval(Pi[][] layer, int i, int j) {
        if (j == 0 || j == layer[0].length - 1) {
            return true;
        }
        // 左チェック
        // 左上左下だけじゃなくて左もチェック必要
        if (i == 0) {
            if (layer[i + 1][j - 1] == nashi) {
                return true;
            }
        } else if (i == layer.length) {
            if (layer[i - 1][j - 1] == nashi) {
                return true;
            }
        } else {
            if (layer[i + 1][j - 1] == nashi && layer[i - 1][j - 1] == nashi) {
                return true;
            }
        }

        // 右チェック
        if (i == 0) {
            return layer[i + 1][j + 1] == nashi;
        } else if (i == layer.length) {
            return layer[i - 1][j + 1] == nashi;
        } else {
            return layer[i + 1][j + 1] == nashi && layer[i - 1][j + 1] == nashi;
        }
    }
}
