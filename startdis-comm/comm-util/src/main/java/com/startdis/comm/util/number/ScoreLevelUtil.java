package com.startdis.comm.util.number;

import java.math.BigDecimal;

public class ScoreLevelUtil {

    public static String getScoreLevel(BigDecimal score){
        String level = "一般";
        if (score.compareTo(new BigDecimal(100)) >= 0){
            level = "好";
        }
        if (isBetween(score,new BigDecimal(90),new BigDecimal(100))){
            level = "较好";
        }
        if (isBetween(score,new BigDecimal(80),new BigDecimal(90))){
            level = "一般";
        }
        if (isBetween(score,new BigDecimal(70),new BigDecimal(80))){
            level = "较差";
        }
        if (score.compareTo(new BigDecimal(70)) < 0){
            level = "差";
        }
        return level;
    }

    public static boolean isBetween(BigDecimal score, BigDecimal start, BigDecimal end){
        return score.compareTo(start) >= 0 && score.compareTo(end) < 0;
    }
}
