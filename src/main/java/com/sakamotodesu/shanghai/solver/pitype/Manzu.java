package com.sakamotodesu.shanghai.solver.pitype;

public enum Manzu implements PiType {
    eMan, ryanMan, sanWan, suWan, uWan, roWan, chiWan, perWan, quWan;

    @Override
    public char getName() {
        return (char) (this.ordinal() + 0x31);
    }

    @Override
    public char getType() {
        return 'M';
    }

}
