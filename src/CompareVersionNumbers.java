class Solution {
    public int compareVersion(String version1, String version2) {
        int temp1, temp2;
        int i=0, j=0;
        while(i < version1.length() || j < version2.length()) {
        	temp1 = 0;
        	temp2 = 0;
        	while (i < version1.length() && '.' != version1.charAt(i)) {
        		temp1 = 10 * temp1 + (version1.charAt(i) - '0');
        		i++;
        	}
        	i++;
        	while (j < version2.length() && '.' != version2.charAt(j)) {
        		temp2 = 10 * temp2 + (version2.charAt(j) - '0');
        		j++;
        	}
        	j++;
        	if (temp1 > temp2) {
        		return 1;
        	}
        	if (temp1 < temp2) {
        		return -1;
        	}
        }
        return 0;
    }
}