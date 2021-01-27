package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
import com.sakamotodesu.shanghai.solver.pi.PlacedPi;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.sakamotodesu.shanghai.solver.pitype.Manzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Pinzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Souzu.*;
import static com.sakamotodesu.shanghai.solver.pitype.Zihai.*;

public class StageData {

    @Getter
    public static List<Pi> dendo = new ArrayList<>(Arrays.asList(new PlacedPi(nan, 0, 8, 0),
            new PlacedPi(suPin, 0, 10, 0),
            new PlacedPi(chiSou, 0, 12, 0),

            new PlacedPi(roPin, 2, 5, 0),
            new PlacedPi(haku, 2, 7, 0),
            new PlacedPi(sha, 2, 9, 0),
            new PlacedPi(ryu, 2, 11, 0),
            new PlacedPi(suWan, 2, 13, 0),
            new PlacedPi(sha, 2, 15, 0),

            new PlacedPi(nan, 4, 4, 0),
            new PlacedPi(season, 4, 6, 0),
            new PlacedPi(quPin, 4, 8, 0),
            new PlacedPi(chun, 4, 10, 0),
            new PlacedPi(pe, 4, 12, 0),
            new PlacedPi(chiSou, 4, 14, 0),
            new PlacedPi(pe, 4, 16, 0),

            new PlacedPi(eSou, 6, 2, 0),
            new PlacedPi(suWan, 6, 4, 0),
            new PlacedPi(ryanMan, 6, 6, 0),
            new PlacedPi(ryanMan, 6, 8, 0),
            new PlacedPi(hatsu, 6, 10, 0),
            new PlacedPi(ryanPin, 6, 12, 0),
            new PlacedPi(hatsu, 6, 14, 0),
            new PlacedPi(roWan, 6, 16, 0),
            new PlacedPi(quPin, 6, 18, 0),

            new PlacedPi(pe, 7, 0, 0),
            new PlacedPi(season, 7, 20, 0),

            new PlacedPi(ton, 8, 2, 0),
            new PlacedPi(ePin, 8, 4, 0),
            new PlacedPi(chun, 8, 6, 0),
            new PlacedPi(uSou, 8, 8, 0),
            new PlacedPi(ton, 8, 10, 0),
            new PlacedPi(chun, 8, 12, 0),
            new PlacedPi(uSou, 8, 14, 0),
            new PlacedPi(ton, 8, 16, 0),
            new PlacedPi(eMan, 8, 18, 0),

            new PlacedPi(sanWan, 9, 0, 0),
            new PlacedPi(sanPin, 9, 20, 0),

            new PlacedPi(pe, 10, 2, 0),
            new PlacedPi(suWan, 10, 6, 0),
            new PlacedPi(eMan, 10, 14, 0),
            new PlacedPi(suPin, 10, 18, 0),

            new PlacedPi(chun, 11, 4, 0),
            new PlacedPi(quPin, 11, 8, 0),
            new PlacedPi(ryanMan, 11, 10, 0),
            new PlacedPi(suPin, 11, 12, 0),
            new PlacedPi(eMan, 11, 16, 0),

            new PlacedPi(sanWan, 1, 10, 1),

            new PlacedPi(nan, 2, 7, 1),
            new PlacedPi(roPin, 2, 13, 1),

            new PlacedPi(sanWan, 3, 5, 1),
            new PlacedPi(ton, 3, 9, 1),
            new PlacedPi(uWan, 3, 11, 1),
            new PlacedPi(chiSou, 3, 15, 1),

            new PlacedPi(roWan, 6, 2, 1),
            new PlacedPi(eMan, 6, 4, 1),
            new PlacedPi(haku, 6, 6, 1),
            new PlacedPi(eSou, 6, 8, 1),
            new PlacedPi(season, 6, 10, 1),
            new PlacedPi(ryu, 6, 12, 1),
            new PlacedPi(ryanPin, 6, 14, 1),
            new PlacedPi(haku, 6, 16, 1),
            new PlacedPi(eSou, 6, 18, 1),

            new PlacedPi(chiSou, 7, 0, 1),
            new PlacedPi(quSou, 7, 20, 1),

            new PlacedPi(uPin, 8, 2, 1),
            new PlacedPi(ryu, 8, 4, 1),
            new PlacedPi(ePin, 8, 6, 1),
            new PlacedPi(sanWan, 8, 8, 1),
            new PlacedPi(ryanPin, 8, 10, 1),
            new PlacedPi(quPin, 8, 12, 1),
            new PlacedPi(hatsu, 8, 14, 1),
            new PlacedPi(ePin, 8, 16, 1),
            new PlacedPi(uPin, 8, 18, 1),

            new PlacedPi(suSou, 9, 0, 1),
            new PlacedPi(nan, 9, 20, 1),

            new PlacedPi(uPin, 10, 2, 1),
            new PlacedPi(suPin, 10, 6, 1),
            new PlacedPi(uSou, 10, 14, 1),
            new PlacedPi(ryu, 10, 18, 1),

            new PlacedPi(hatsu, 11, 4, 1),
            new PlacedPi(haku, 11, 8, 1),
            new PlacedPi(season, 11, 10, 1),
            new PlacedPi(roWan, 11, 12, 1),
            new PlacedPi(ePin, 11, 16, 1),

            new PlacedPi(roPin, 6, 4, 2),
            new PlacedPi(sha, 6, 16, 2),

            new PlacedPi(sanPin, 7, 2, 2),
            new PlacedPi(sha, 7, 6, 2),
            new PlacedPi(ryanPin, 7, 10, 2),
            new PlacedPi(uSou, 7, 14, 2),
            new PlacedPi(quSou, 7, 18, 2),

            new PlacedPi(uPin, 8, 4, 2),
            new PlacedPi(uWan, 8, 8, 2),
            new PlacedPi(ryanMan, 8, 12, 2),
            new PlacedPi(uWan, 8, 16, 2),

            new PlacedPi(sanPin, 9, 2, 2),
            new PlacedPi(uWan, 9, 6, 2),
            new PlacedPi(suWan, 9, 14, 2),
            new PlacedPi(sanPin, 9, 18, 2),

            new PlacedPi(roPin, 11, 9, 2),
            new PlacedPi(eSou, 11, 11, 2),

            new PlacedPi(quSou, 7, 4, 3),
            new PlacedPi(quSou, 7, 16, 3),

            new PlacedPi(suSou, 8, 2, 3),
            new PlacedPi(suSou, 8, 6, 3),
            new PlacedPi(roWan, 8, 14, 3),
            new PlacedPi(suSou, 8, 18, 3)));
}
