class Solution {
    public String reverseWords(String s) {
        String[] list = s.trim().split("\\s+");
        List<String> words = Arrays.asList(list);
        Collections.reverse(words);
        return String.join(" ", words);
    }
}