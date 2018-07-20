package java;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haileyyin on 7/13/18.
 */
public class TextJustification {
    /*
    brutal force
    */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> cur = new ArrayList<>();
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            if (len + words[i].length() == maxWidth) {
                cur.add(words[i]);
                StringBuilder sb = new StringBuilder();
                for (String str:cur) {
                    sb.append(str);
                    sb.append(" ");
                }
                ans.add(sb.toString().substring(0, maxWidth));
                cur.clear();
                len = 0;
            } else if (len + words[i].length() < maxWidth) {
                cur.add(words[i]);
                len = len + words[i].length() + 1;
            } else {
                int space = maxWidth - len + cur.size();
                int slot = cur.size() - 1;
                int avrg = slot == 0? 0 : space / slot;
                int remain = slot == 0? 0 : space % slot;
                String spaceStr = "";
                while (avrg-- > 0) {
                    spaceStr += " ";
                }
                StringBuilder sb = new StringBuilder();
                for (String str:cur) {
                    sb.append(str);
                    sb.append(spaceStr);
                    if (remain-- > 0) {
                        sb.append(" ");
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString().substring(0, maxWidth));
                cur.clear();
                len = 0;
                i--;
            }
        }
        if (cur.size() > 0) {
            StringBuilder sb = new StringBuilder();
            for (String str:cur) {
                sb.append(str);
                sb.append(" ");
            }
            while (len++ < maxWidth) {
                sb.append(" ");
            }
            ans.add(sb.toString().substring(0, maxWidth));
        }
        return ans;
    }
}
