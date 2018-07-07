package com.example.aspect.aspectjtest001;

public class TimeUtils {

    /**
     * @param mss 要转换的毫秒数
     * @return 该毫秒数转换为 * days * hours * minutes * seconds 后的格式
     */
    public static String formatDuring(long mss) {
        long days = mss / (1000 * 60 * 60 * 24);
        long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);
        long seconds = (mss % (1000 * 60)) / 1000;
        return days + " days " + hours + " hours " + minutes + " minutes "
                + seconds + " seconds ";
    }
}
