class Solution {
    public String reformat(String s) {
        // v1: brute force, speed 95.76 %
        int cntLtr = 0;
        int cntDgt = 0;
        for(char c : s.toCharArray()) {
            if(Character.isLetter(c)) cntLtr ++;
            else cntDgt ++;
        }
        
        if(Math.abs(cntLtr - cntDgt) > 1) return "";
        
        char[] rst = new char[s.length()];
        if(cntLtr > cntDgt) {
            int idxL = 0;
            int idxD = 1;
            for(int i = 0; i < rst.length; i++) {
                if(Character.isLetter(s.charAt(i))) {
                    rst[idxL] = s.charAt(i);
                    idxL += 2;
                }
                else {
                    rst[idxD] = s.charAt(i);
                    idxD += 2;
                }
            }
        }
        else {
            int idxL = 1;
            int idxD = 0;
            for(int i = 0; i < rst.length; i++) {
                if(Character.isLetter(s.charAt(i))) {
                    rst[idxL] = s.charAt(i);
                    idxL += 2;
                }
                else {
                    rst[idxD] = s.charAt(i);
                    idxD += 2;
                }
            }
        }
        
        return new String(rst);
    }
}