package net.ddns.noidea.Utils;

public class MathUtils {

    public static int ramdon(int min, int max){
       return (int) Math.floor(Math.random()*(max-min)+min);
    }
}
