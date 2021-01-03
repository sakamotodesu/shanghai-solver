package com.sakamotodesu.shanghai.solver;

public enum Manzu implements Pi {
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
