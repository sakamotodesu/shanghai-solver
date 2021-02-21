package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 幅優先探索でdiet処理を軽くするためのクラス
 * そのうちお払い箱になりそう
 */

@AllArgsConstructor
public class CandidateAnswer {
    @Getter
    private List<Pi> candidateAnswerList;
    @Getter
    private Set<Pi> candidateAnswerSet;

    public void addAll(List<Pi> piList) {
        candidateAnswerList.addAll(piList);
        candidateAnswerSet.addAll(piList);
    }
}
