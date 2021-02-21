package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 幅優先探索でdiet処理を軽くするためのクラス
 * そのうちお払い箱になりそう
 */

@AllArgsConstructor
public class CandidateAnswer {
    @Getter
    private List<Pi> candidateAnswerList;
    @Getter
    private List<Pi> analysysPiList;

    public CandidateAnswer(CandidateAnswer that) {
        this.candidateAnswerList = new ArrayList<>(that.getCandidateAnswerList());
        this.analysysPiList = new ArrayList<>(that.getAnalysysPiList());
    }

    public void addAll(List<Pi> piList) {
        candidateAnswerList.addAll(piList);
        analysysPiList.removeAll(piList);
    }
}
