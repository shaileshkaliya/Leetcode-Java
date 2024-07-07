class Solution {
    public List<String> validStrings(int n) {
        List<String> result = new ArrayList<>();
        helper(n, "", result);
        return result;

    }
    private void helper(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }

        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
            helper(n, current + "0", result);
        }
        
        helper(n, current + "1", result);
    }

}