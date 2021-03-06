package com.sakamotodesu.shanghai.solver;

import com.sakamotodesu.shanghai.solver.pi.Pi;
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
    public static final List<Pi> normal = new ArrayList<>(Arrays.asList(new Pi(chiSou, 0, 4, 0),
            new Pi(eSou, 0, 6, 0),
            new Pi(chiSou, 0, 12, 0),
            new Pi(ePin, 0, 14, 0),

            new Pi(season, 2, 2, 0),
            new Pi(chiSou, 2, 4, 0),
            new Pi(ryanPin, 2, 6, 0),
            new Pi(ePin, 2, 8, 0),
            new Pi(suWan, 2, 10, 0),
            new Pi(suWan, 2, 12, 0),
            new Pi(ryanPin, 2, 14, 0),
            new Pi(sha, 2, 16, 0),

            new Pi(ryanPin, 4, 4, 0),
            new Pi(ePin, 4, 6, 0),
            new Pi(suWan, 4, 8, 0),
            new Pi(suWan, 4, 10, 0),
            new Pi(ePin, 4, 12, 0),
            new Pi(eSou, 4, 14, 0),

            new Pi(season, 6, 6, 0),
            new Pi(eSou, 6, 8, 0),
            new Pi(ryanPin, 6, 10, 0),
            new Pi(ton, 6, 12, 0),
            new Pi(ton, 6, 17, 0),

            new Pi(roSou, 7, 15, 0),
            new Pi(ryu, 7, 19, 0),

            new Pi(uWan, 8, 8, 0),
            new Pi(ryu, 8, 10, 0),
            new Pi(sanSou, 8, 17, 0),

            new Pi(chiSou, 10, 9, 0),

            new Pi(sha, 11, 2, 0),

            new Pi(season, 12, 0, 0),
            new Pi(sanSou, 12, 4, 0),

            new Pi(sanSou, 13, 2, 0),

            new Pi(ton, 1, 5, 1),
            new Pi(uWan, 1, 13, 1),

            new Pi(roSou, 2, 3, 1),
            new Pi(season, 2, 15, 1),

            new Pi(uWan, 3, 5, 1),
            new Pi(ton, 3, 7, 1),
            new Pi(eSou, 3, 9, 1),
            new Pi(sha, 3, 11, 1),
            new Pi(sanSou, 3, 13, 1),

            new Pi(ryu, 5, 7, 1),
            new Pi(sha, 5, 9, 1),
            new Pi(ryu, 5, 11, 1),

            new Pi(roSou, 7, 9, 1),
            new Pi(uWan, 7, 17, 1),

            new Pi(roSou, 12, 2, 1)

    ));


    @Getter
    public static List<Pi> dendo = new ArrayList<>(Arrays.asList(new Pi(nan, 0, 8, 0),
            new Pi(suPin, 0, 10, 0),
            new Pi(chiSou, 0, 12, 0),

            new Pi(roPin, 2, 5, 0),
            new Pi(haku, 2, 7, 0),
            new Pi(sha, 2, 9, 0),
            new Pi(ryu, 2, 11, 0),
            new Pi(suWan, 2, 13, 0),
            new Pi(sha, 2, 15, 0),

            new Pi(nan, 4, 4, 0),
            new Pi(season, 4, 6, 0),
            new Pi(quPin, 4, 8, 0),
            new Pi(chun, 4, 10, 0),
            new Pi(pe, 4, 12, 0),
            new Pi(chiSou, 4, 14, 0),
            new Pi(pe, 4, 16, 0),

            new Pi(eSou, 6, 2, 0),
            new Pi(suWan, 6, 4, 0),
            new Pi(ryanMan, 6, 6, 0),
            new Pi(ryanMan, 6, 8, 0),
            new Pi(hatsu, 6, 10, 0),
            new Pi(ryanPin, 6, 12, 0),
            new Pi(hatsu, 6, 14, 0),
            new Pi(roWan, 6, 16, 0),
            new Pi(quPin, 6, 18, 0),

            new Pi(pe, 7, 0, 0),
            new Pi(season, 7, 20, 0),

            new Pi(ton, 8, 2, 0),
            new Pi(ePin, 8, 4, 0),
            new Pi(chun, 8, 6, 0),
            new Pi(uSou, 8, 8, 0),
            new Pi(ton, 8, 10, 0),
            new Pi(chun, 8, 12, 0),
            new Pi(uSou, 8, 14, 0),
            new Pi(ton, 8, 16, 0),
            new Pi(eMan, 8, 18, 0),

            new Pi(sanWan, 9, 0, 0),
            new Pi(sanPin, 9, 20, 0),

            new Pi(pe, 10, 2, 0),
            new Pi(suWan, 10, 6, 0),
            new Pi(eMan, 10, 14, 0),
            new Pi(suPin, 10, 18, 0),

            new Pi(chun, 11, 4, 0),
            new Pi(quPin, 11, 8, 0),
            new Pi(ryanMan, 11, 10, 0),
            new Pi(suPin, 11, 12, 0),
            new Pi(eMan, 11, 16, 0),

            new Pi(sanWan, 1, 10, 1),

            new Pi(nan, 2, 7, 1),
            new Pi(roPin, 2, 13, 1),

            new Pi(sanWan, 3, 5, 1),
            new Pi(ton, 3, 9, 1),
            new Pi(uWan, 3, 11, 1),
            new Pi(chiSou, 3, 15, 1),

            new Pi(roWan, 6, 2, 1),
            new Pi(eMan, 6, 4, 1),
            new Pi(haku, 6, 6, 1),
            new Pi(eSou, 6, 8, 1),
            new Pi(season, 6, 10, 1),
            new Pi(ryu, 6, 12, 1),
            new Pi(ryanPin, 6, 14, 1),
            new Pi(haku, 6, 16, 1),
            new Pi(eSou, 6, 18, 1),

            new Pi(chiSou, 7, 0, 1),
            new Pi(quSou, 7, 20, 1),

            new Pi(uPin, 8, 2, 1),
            new Pi(ryu, 8, 4, 1),
            new Pi(ePin, 8, 6, 1),
            new Pi(sanWan, 8, 8, 1),
            new Pi(ryanPin, 8, 10, 1),
            new Pi(quPin, 8, 12, 1),
            new Pi(hatsu, 8, 14, 1),
            new Pi(ePin, 8, 16, 1),
            new Pi(uPin, 8, 18, 1),

            new Pi(suSou, 9, 0, 1),
            new Pi(nan, 9, 20, 1),

            new Pi(uPin, 10, 2, 1),
            new Pi(suPin, 10, 6, 1),
            new Pi(uSou, 10, 14, 1),
            new Pi(ryu, 10, 18, 1),

            new Pi(hatsu, 11, 4, 1),
            new Pi(haku, 11, 8, 1),
            new Pi(season, 11, 10, 1),
            new Pi(roWan, 11, 12, 1),
            new Pi(ePin, 11, 16, 1),

            new Pi(roPin, 6, 4, 2),
            new Pi(sha, 6, 16, 2),

            new Pi(sanPin, 7, 2, 2),
            new Pi(sha, 7, 6, 2),
            new Pi(ryanPin, 7, 10, 2),
            new Pi(uSou, 7, 14, 2),
            new Pi(quSou, 7, 18, 2),

            new Pi(uPin, 8, 4, 2),
            new Pi(uWan, 8, 8, 2),
            new Pi(ryanMan, 8, 12, 2),
            new Pi(uWan, 8, 16, 2),

            new Pi(sanPin, 9, 2, 2),
            new Pi(uWan, 9, 6, 2),
            new Pi(suWan, 9, 14, 2),
            new Pi(sanPin, 9, 18, 2),

            new Pi(roPin, 11, 9, 2),
            new Pi(eSou, 11, 11, 2),

            new Pi(quSou, 7, 4, 3),
            new Pi(quSou, 7, 16, 3),

            new Pi(suSou, 8, 2, 3),
            new Pi(suSou, 8, 6, 3),
            new Pi(roWan, 8, 14, 3),
            new Pi(suSou, 8, 18, 3)));

    @Getter
    public static List<Pi> dendo_ryota = new ArrayList<>(Arrays.asList(new Pi(roSou, 0, 10, 0),

            new Pi(suPin, 1, 6, 0),
            new Pi(roSou, 1, 8, 0),
            new Pi(suSou, 1, 12, 0),
            new Pi(roWan, 1, 14, 0),

            new Pi(suPin, 2, 4, 0),
            new Pi(sanSou, 2, 10, 0),
            new Pi(perPin, 2, 16, 0),

            new Pi(ryanPin, 3, 2, 0),
            new Pi(uSou, 3, 6, 0),
            new Pi(uWan, 3, 8, 0),
            new Pi(uWan, 3, 12, 0),
            new Pi(roWan, 3, 14, 0),
            new Pi(ryanPin, 3, 18, 0),

            new Pi(hatsu, 4, 4, 0),
            new Pi(sanSou, 4, 10, 0),
            new Pi(uSou, 4, 16, 0),

            new Pi(suPin, 5, 2, 0),
            new Pi(chun, 5, 6, 0),
            new Pi(chun, 5, 8, 0),
            new Pi(hatsu, 5, 12, 0),
            new Pi(ryanPin, 5, 14, 0),
            new Pi(ryanSou, 5, 18, 0),

            new Pi(hatsu, 6, 4, 0),
            new Pi(chiWan, 6, 10, 0),
            new Pi(ryanSou, 6, 16, 0),

            new Pi(hatsu, 7, 2, 0),
            new Pi(uSou, 7, 6, 0),
            new Pi(suSou, 7, 8, 0),
            new Pi(season, 7, 12, 0),
            new Pi(chun, 7, 14, 0),
            new Pi(ryu, 7, 18, 0),

            new Pi(roSou, 8, 0, 0),
            new Pi(chiSou, 8, 10, 0),
            new Pi(sanWan, 8, 20, 0),

            new Pi(ryu, 10, 10, 0),

            new Pi(suWan, 11, 8, 0),
            new Pi(nan, 11, 12, 0),

            new Pi(sha, 12, 4, 0),
            new Pi(suPin, 12, 6, 0),
            new Pi(roPin, 12, 10, 0),
            new Pi(quSou, 12, 14, 0),
            new Pi(ryanPin, 12, 16, 0),

            new Pi(chun, 0, 10, 1),

            new Pi(sanSou, 1, 6, 1),
            new Pi(roWan, 1, 8, 1),
            new Pi(chiWan, 1, 12, 1),
            new Pi(uWan, 1, 14, 1),

            new Pi(suSou, 2, 4, 1),
            new Pi(suWan, 2, 10, 1),
            new Pi(perSou, 2, 16, 1),

            new Pi(sanWan, 3, 2, 1),
            new Pi(roSou, 3, 6, 1),
            new Pi(suWan, 3, 8, 1),
            new Pi(sanWan, 3, 12, 1),
            new Pi(sha, 3, 14, 1),
            new Pi(sha, 3, 18, 1),

            new Pi(nan, 4, 4, 1),
            new Pi(sanSou, 4, 10, 1),
            new Pi(chiWan, 4, 16, 1),

            new Pi(roPin, 5, 2, 1),
            new Pi(perSou, 5, 6, 1),
            new Pi(roPin, 5, 8, 1),
            new Pi(suSou, 5, 12, 1),
            new Pi(suWan, 5, 14, 1),
            new Pi(season, 5, 18, 1),

            new Pi(ryanSou, 6, 4, 1),
            new Pi(season, 6, 10, 1),
            new Pi(perSou, 6, 16, 1),

            new Pi(chiWan, 7, 2, 1),
            new Pi(chiSou, 7, 6, 1),
            new Pi(perPin, 7, 8, 1),
            new Pi(roWan, 7, 12, 1),
            new Pi(sanWan, 7, 14, 1),
            new Pi(pe, 7, 18, 1),

            new Pi(haku, 8, 0, 1),
            new Pi(ryu, 8, 10, 1),
            new Pi(uPin, 8, 20, 1),

            new Pi(uSou, 10, 10, 1),

            new Pi(roPin, 11, 8, 1),
            new Pi(uWan, 11, 12, 1),

            new Pi(quSou, 12, 4, 1),
            new Pi(perPin, 12, 6, 1),
            new Pi(chiSou, 12, 10, 1),
            new Pi(ton, 12, 14, 1),
            new Pi(sha, 12, 16, 1),

            new Pi(ton, 1, 6, 2),
            new Pi(ton, 1, 8, 2),
            new Pi(quSou, 1, 10, 2),
            new Pi(quSou, 1, 12, 2),
            new Pi(perSou, 1, 14, 2),

            new Pi(nan, 2, 4, 2),
            new Pi(perPin, 2, 16, 2),

            new Pi(haku, 3, 2, 2),
            new Pi(ryanSou, 3, 7, 2),
            new Pi(pe, 3, 13, 2),
            new Pi(uPin, 3, 18, 2),

            new Pi(uPin, 5, 2, 2),
            new Pi(chiSou, 5, 7, 2),
            new Pi(haku, 5, 13, 2),
            new Pi(ton, 5, 18, 2),

            new Pi(pe, 6, 4, 2),
            new Pi(season, 6, 16, 2),

            new Pi(nan, 7, 6, 2),
            new Pi(haku, 7, 8, 2),
            new Pi(ryu, 7, 12, 2),
            new Pi(pe, 7, 14, 2),

            new Pi(uPin, 8, 10, 2)));
}
