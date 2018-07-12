package java;

/**
 * Created by haileyyin on 7/6/18.
 */
public class ValidWordAbbreviation {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {

            if (Character.isDigit(abbr.charAt(j))) {
                if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                    return false;
                }
                int k = j + 1;
                while ( k < abbr.length() && Character.isDigit(abbr.charAt(k))) {
                    k++;
                }
                int value = Integer.parseInt(abbr.substring(j,k));
                i += value;
                j = k;
            } else {
                if (word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        return i==word.length()&&j==abbr.length();
    }
}
