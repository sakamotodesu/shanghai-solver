package com.sakamotodesu.shanghai.solver.pitype;

public enum Souzu implements PiType {
    eSou, ryanSou, sanSou, suSou, uSou, roSou, chiSou, perSou, quSou;

    @Override
    public char getName() {
        return (char) (this.ordinal() + 0x31);
    }

    @Override
    public char getType() {
        return 'S';
    }

}
