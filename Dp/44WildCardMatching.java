class Solution {
    HashMap<String, Boolean> dp = new HashMap<>();

    boolean helper(String s, String p, int i, int j){
        if(i == s.length() && j == p.length())
            return true;
        if(j == p.length())
            return false;
        if(i == s.length()){
            while(j<p.length()){
                if(p.charAt(j) != '*')
                    return false;
                j++;
            }
            return true;
        }

        String k = i+"-"+j;
        boolean result;
        if(dp.containsKey(k)){
            return dp.get(k);
        }

        if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')
            result = helper(s, p, i+1, j+1);
        else if(p.charAt(j) == '*')
            result = helper(s, p, i, j+1) || helper(s, p, i+1, j);
        else
            result = false;

        dp.put(k, result);
        return result;
    }
    public boolean isMatch(String s, String p) {
        return helper(s, p, 0, 0);
    }
}



// or more optimal solution using tabulization

class Solution {
    public boolean isMatch(String s, String p) {
       int slen = s.length();
       int plen = p.length();
       if(slen == 0 && plen == 0) 
            return true;
        if(plen == 0)
            return false;
        if(slen == 0){
            for(int i=0; i<plen; i++){
                if(p.charAt(i) != '*')
                    return false;
            }
            return true;
        }
        

        boolean dp[][] = new boolean[slen+1][plen+1];
        dp[slen][plen] = true;

        // for handling * at end of p
        for (int j = plen - 1; j >= 0; j--) {
            if (p.charAt(j) == '*') {
                dp[slen][j] = dp[slen][j + 1];
            } else {
                break;
            }
        }

        for(int i=slen-1; i>=0; i--){
            for(int j=plen-1; j>=0; j--){
                if((s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') && (dp[i+1][j+1])){
                    dp[i][j] = true;
                }
                else if(p.charAt(j) == '*' && (dp[i][j+1] || dp[i+1][j])){
                    dp[i][j] = true;
                }
                else
                    dp[i][j] = false;
            }
        }

        return dp[0][0];
    }
}
