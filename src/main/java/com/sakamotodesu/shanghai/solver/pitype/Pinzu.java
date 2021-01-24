package com.sakamotodesu.shanghai.solver.pitype;

public enum Pinzu implements PiType {
    ePin, ryanPin, sanPin, suPin, uPin, roPin, chiPin, perPin, quPin;

    @Override
    public char getName() {
        return (char) (this.ordinal() + 0x31);
    }

    @Override
    public char getType() {
        return 'P';
    }

}
