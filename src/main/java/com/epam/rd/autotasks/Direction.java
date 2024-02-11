package com.epam.rd.autotasks;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        degrees = checkDegrees(degrees);

        switch (degrees){
            case 0, 360 -> {
                return N;
            }
            case 45 -> {
                return NE;
            }
            case 90 -> {
                return E;
            }
            case 135 -> {
                return SE;
            }
            case 180 -> {
                return S;
            }
            case 225 -> {
                return SW;
            }
            case 270 -> {
                return W;
            }
            case 315 -> {
                return NW;
            }
        }
        return null;
    }
    public static int checkDegrees(int degrees){
        if (degrees < 0){
            degrees = 360 - Math.abs(degrees);
        }
        while (degrees > 360){
            degrees -= 360;
        }
        return degrees;
    }
    public static Direction closestToDegrees(int degrees) {
        degrees = checkDegrees(degrees);

        if (degrees >= 0 && degrees < 30 || degrees == 360){
            return N;
        } else if (degrees >= 30 && degrees < 90) {
            return NE;
        } else if (degrees >= 90 && degrees < 135) {
            return E;
        } else if (degrees >= 135 && degrees < 180) {
            return SE;
        }else if (degrees >= 180 && degrees < 205) {
            return S;
        }else if (degrees >= 205 && degrees < 270) {
            return SW;
        }else if (degrees >= 270 && degrees < 315) {
            return W;
        }else if (degrees >= 315) {
            return NW;
        }
        return null;
    }

    public Direction opposite() {
        return switch (this) {
            case N -> S;
            case NE -> SW;
            case E -> W;
            case SE -> NW;
            case S -> N;
            case SW -> NE;
            case W -> E;
            case NW -> SE;
        };
    }

    public int differenceDegreesTo(Direction direction) {
        if (this == N && direction == NW){
            return Math.abs(360 - direction.degrees);
        }
        return Math.abs(this.degrees - direction.degrees);
    }
}
