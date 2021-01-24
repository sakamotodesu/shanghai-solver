package com.sakamotodesu.shanghai.solver.pitype;

public enum Zihai implements PiType {
    ton, nan, sha, pe, haku, hatsu, chun, ryu, season;

    @Override
    public char getName() {
        switch (this) {
            case ton:
                return 'T';
            case nan:
                return 'N';
            case sha:
                return 'S';
            case pe:
                return 'P';
            case haku:
                return 'W'; //white
            case hatsu:
                return 'H';
            case chun:
                return 'C';
            case ryu:
                return 'R';
            case season:
                return 'Z';
        }
        return ' ';
    }

    @Override
    public char getType() {
        return 'S';
    }

}
