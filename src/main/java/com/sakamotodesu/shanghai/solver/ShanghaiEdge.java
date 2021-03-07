package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pitype.PiType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.jgrapht.graph.DefaultEdge;

import java.util.List;
import java.util.Map;


@AllArgsConstructor
public class ShanghaiEdge extends DefaultEdge {

    @Getter
    private final List<Pi> removalPiList;

    public int getPoint(Map<PiType, Integer> pointMap) {

        return removalPiList.stream()
                .filter(pi -> pointMap.containsKey(pi.getPiType()))
                .mapToInt(pi -> pointMap.get(pi.getPiType()))
                .sum();
    }


}
