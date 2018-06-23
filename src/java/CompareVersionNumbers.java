package java;

/**
 * Created by haileyyin on 5/1/18.
 */
public class CompareVersionNumbers {
    //split() 方法根据匹配给定的正则表达式来拆分字符串。
    //注意： . 、 | 和 * 等转义字符，必须得加 \\。
    //注意：多个分隔符，可以用 | 作为连字符。
    public int compareVersion(String version1, String version2) {
        if (version1.length()==0 && version2.length()==0) {
            return 0;
        } else if (version1.length()==0 && version2.length()!=0) {
            return -1;
        } else if (version1.length()==0 && version2.length()!=0) {
            return 1;
        }
        String[] arr1 = new String[version1.length()];
        String[] arr2 = new String[version2.length()];
        if (version1.length()==1) {
            arr1[0] = version1;
        } else {
            arr1 = version1.split("\\.");
        }
        if (version2.length()==1) {
            arr2[0] = version2;
        } else {
            arr2 = version2.split("\\.");
        }
        for (int i=0; i < Math.min(arr1.length, arr2.length); i++) {
            int num1 = Integer.valueOf(arr1[i]);
            int num2 = Integer.valueOf(arr2[i]);
            if (num1 > num2)
                return 1;
            else if (num1 < num2)
                return -1;
        }
        if (arr1.length > arr2.length) {
            for (int i=arr2.length; i<arr1.length; i++) {
                if (Integer.valueOf(arr1[i]) > 0)
                    return 1;
            }
        } else if (arr1.length < arr2.length) {
            for (int i=arr1.length; i<arr2.length; i++) {
                if (Integer.valueOf(arr2[i]) > 0)
                    return -1;
            }
        }
        return 0;
    }
}
