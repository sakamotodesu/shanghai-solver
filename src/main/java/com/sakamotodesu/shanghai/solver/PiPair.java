package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class PiPair {
    private Pi from;
    private Pi to;

    public boolean eq(Pi thatFrom, Pi thatTo) {
        return from.equals(thatFrom) && to.equals(thatTo);
    }
}
