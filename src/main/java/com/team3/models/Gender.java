package com.team3.models;

public enum Gender {
    Male, Female, Other;

    public static Gender fromInt(int gender) {
        switch (gender) {
            case 0:
                return Male;
            case 1:
                return Female;
            default:
            case 2:
                return Other;
        }
    }

    public static Gender fromString(String gender) {
        return fromInt(Integer.parseInt(gender));
    }
}

