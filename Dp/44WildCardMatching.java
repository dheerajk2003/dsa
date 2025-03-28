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