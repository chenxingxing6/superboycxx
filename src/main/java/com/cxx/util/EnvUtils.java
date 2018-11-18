package com.cxx.util;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:16
 * Desc: 运行环境工具类
 */
public class EnvUtils {
    public static final String DEV = "dev";
    public static final String PRE = "pre";
    public static final String PUBLIC = "prod";
    public static final String DAILY = "daily";
    public static String ENV = null;
    public static final String ENV_HOSTNAME = "HOSTNAME";

    static {
        String env = System.getenv(ENV_HOSTNAME);
        if (env == null || env.equals("")){
            ENV = DAILY;
        }else {
            String[] ss = env.split("\\.");
            if (ss.length <2){
                ENV = DAILY;
            }else {
                ENV = ss[1];
            }
        }
    }

   public static boolean isPublic(){ return ENV.equalsIgnoreCase(PUBLIC);}

   public static boolean isPre(){ return ENV.equalsIgnoreCase(PRE);}

   public static boolean isDaily(){ return ENV.equalsIgnoreCase(DAILY);}

   public static boolean isDev(){ return ENV.equalsIgnoreCase(DEV);}

   public static boolean isOnLine() {return isPublic() || isPre();}

   public static boolean isOffLine() {return !isOnLine();}

    public static void main(String[] args) {
        System.out.println(isOffLine());
    }


}
