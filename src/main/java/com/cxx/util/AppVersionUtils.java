package com.cxx.util;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:17
 * Desc:
 */
public class AppVersionUtils {

    private static final String VERSION_SEPARATOR = "\\.";

    /**
     * 版本比较,为空表示最小版本 b>a 返回1 ; b<a 返回-1 ;b=a 返回0
     *
     * @param versionA
     * @param versionB
     * @return
     */
    public static int compareVersion(String versionA, String versionB) {
        if (versionA == null || versionA.length() == 0) return -1;
        if (versionB == null || versionB.length() == 0) return 1;
        if (versionA.equals(versionB)) return 0;
        String[] versionAArray = versionA.split(VERSION_SEPARATOR);
        String[] versionBArray = versionB.split(VERSION_SEPARATOR);

        int length = Math.min(versionAArray.length, versionBArray.length);
        if (length > 3) {
            // 只比较前三位
            length = 3;
        }
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(versionBArray[i]) > Integer.parseInt(versionAArray[i])) {
                return 1;
            } else if (Integer.parseInt(versionBArray[i]) < Integer.parseInt(versionAArray[i])) {
                return -1;
            }
        }
        return 0;
    }

    /**
     * 版本比较,在AB闭区间以内返回1，否则返回0
     *
     * @param versionA
     * @param versionB
     * @return
     */
    public static int compareVersion(String version, String versionA, String versionB) {
        if (StringUtils.isBlank(versionA) && StringUtils.isBlank(versionB)) {
            return 1;
        }
        if (version.equals(versionA) || version.equals(versionB)) {
            return 1;
        }
        if (StringUtils.isBlank(versionA) && StringUtils.isNotBlank(versionB)) {
            return compareVersion(version, versionB) >= 0 ? 1 : 0;
        }
        if (StringUtils.isNotBlank(versionA) && StringUtils.isBlank(versionB)) {
            return compareVersion(versionA, version) >= 0 ? 1 : 0;
        }
        if (StringUtils.isNotBlank(versionA) && StringUtils.isNotBlank(versionB)) {
            if (compareVersion(versionA, version) >= 0 && compareVersion(version, versionB) >= 0) {
                return 1;
            }
        }
        return 0;
    }


    public static String getBestMatchVersion(List<String> versionList, String currentVersion) {
        int index = 0, closestIndex = 0;
        String closestDiff = Integer.MAX_VALUE + "";
        for (String str : versionList) {
            if (compareVersion(str, currentVersion) == 0) {
                return currentVersion;
            }
            if (compareVersion(str, currentVersion) < 0) {
                index++;
                continue;
            }
            String diffVersion = getDiff(currentVersion, str);
            if (compareVersion(closestDiff, diffVersion) < 0) {
                closestDiff = diffVersion;
                closestIndex = index;
            }
            index++;
        }
        return versionList.get(closestIndex);
    }

    private static String getDiff(String greaterVersion, String lessVersion) {
        if (compareVersion(lessVersion, greaterVersion) <= 0) {
            String tmp = greaterVersion;
            greaterVersion = lessVersion;
            lessVersion = tmp;
        }
        String[] greaterArray = greaterVersion.split(VERSION_SEPARATOR);
        String[] lessArray = lessVersion.split(VERSION_SEPARATOR);
        int greaterArrayLength = greaterArray.length;
        int lessArrayLength = lessArray.length;

        int shorterLength = greaterArrayLength < lessArrayLength ? greaterArrayLength : lessArrayLength;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < shorterLength; i++) {
            sb.append(Integer.parseInt(greaterArray[i]) - Integer.parseInt(lessArray[i]));
            sb.append(".");
        }
        int longerLength = greaterArrayLength > lessArrayLength ? greaterArrayLength : lessArrayLength;
        String[] longerLengthArray = greaterArrayLength > lessArrayLength ? greaterArray : lessArray;
        for (int i = shorterLength; i < longerLength; i++) {
            if (greaterArrayLength < lessArrayLength) {
                sb.append("-");
            }
            sb.append(longerLengthArray[i]);
            sb.append(".");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        String m1 = "5.6.59.1";
        String m2 = "5.6.59.3";
        String m3 = "5.6.59.3";
        System.out.println(compareVersion(m1, m2, m3));
    }
}
