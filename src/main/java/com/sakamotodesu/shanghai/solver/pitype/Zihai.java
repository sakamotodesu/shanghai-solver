package com.sakamotodesu.shanghai.solver.pitype;

public enum Zihai implements PiType {
    ton, nan, sha, pe, haku, hatsu, chun, ryu;

    @Override
    public char getName() {
        return (char) (this.ordinal() + 0x31);
    }

    @Override
    public char getType() {
        return 'S';
    }

}
