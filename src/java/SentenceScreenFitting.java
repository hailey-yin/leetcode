package java;

/**
 * Created by haileyyin on 2/5/18.
 */
public class SentenceScreenFitting {
    /*
    brutal force: time limit exceed
    便利句子，每个单词分别处理，但是这种做法很不高效，因为有可能屏幕的宽度特别大，而单词可能就一两个，那么我们这样遍历的话就太浪费时间了
    */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0;
        int curIdx = 0;
        int curRow = 0;
        int curCol = 0;
        while (curRow < rows) {
            while (curCol < cols) {
                if (curCol + sentence[curIdx].length() - 1 < cols) {
                    curCol += sentence[curIdx].length() + 1;
                    if (curIdx == sentence.length - 1) {
                        count++;
                        curIdx = 0;
                    } else {
                        curIdx++;
                    }

                } else {
                    curCol++;
                }
            }
            curRow++;
            curCol = 0;
        }
        return count;
    }

    /*
    reformatted sentence: ["ab", "cde", "f"] --> "ab cde f"
    rows 5
    cols 4

    ab cde f ab cde f ab cde f ab cde f ...
    xxx
       xxxx
           xxxxx
                xxxx              stop until we finish the last row, and count how many
                    xxxxx            character in the reformatted sentence we put into the screen

    answer: (3+4+5+4+5)/9=2
     */
    public int wordsTyping2(String[] sentence, int rows, int cols) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<sentence.length; i++){
            sb.append(sentence[i]);
            sb.append(" ");

        }
        String reformat = sb.toString();
        int length = reformat.length();
        int count = 0;
        while(rows>0){
            count += cols;
            if(reformat.charAt(count%length)==' '){
                count++;
            } else {
                while(count>0&&reformat.charAt((count-1)%length)!=' '){
                    count--;
                }
            }
            rows--;
        }
        return count/length;
    }
}
