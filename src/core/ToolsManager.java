package core;

import com.google.gson.Gson;

import java.util.concurrent.ThreadLocalRandom;

public class ToolsManager {

    public static int randomInt(int maxIncluded){
        return  ThreadLocalRandom.current().nextInt(0, maxIncluded + 1);
    }
    public static int randomInt(int minIncluded, int maxIncluded){
        return  ThreadLocalRandom.current().nextInt(minIncluded, maxIncluded + 1);
    }

    public static boolean isWorked(double percent){
        double result = Math.random();
        if(percent>result) return true;
        else return false;
    }


}
