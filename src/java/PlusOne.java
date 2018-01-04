package java;

/**
 * Created by haileyyin on 11/16/17.
 */
public class PlusOne {
    /*
   create a int variable to record how much the previous bit overflow
   iterate the array from the last element, move forward
   stop until no overflow
   */
    public int[] plusOne(int[] digits) {
        if(digits.length==0)
            return new int[]{1};
        int sign = 1;
        int overflow = 0;
        digits[digits.length-1] += 1;
        overflow = digits[digits.length-1]/10;
        digits[digits.length-1] %= 10;
        for(int i=digits.length-2; i>=0&&overflow>0; i--){
            digits[i] += overflow;
            overflow = digits[i]/10;
            digits[i] %= 10;
        }
        if(overflow>0){
            int[] newDigits = new int[digits.length+1];
            newDigits[0] = overflow;
            for(int i=0; i<digits.length; i++){
                newDigits[i+1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}
