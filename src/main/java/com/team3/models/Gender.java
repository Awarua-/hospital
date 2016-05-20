package models;


/**
 * Created by Maxeonyx on 20/05/2016.
 */
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
}
