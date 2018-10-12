/*
 * [288] Unique Word Abbreviation
 *
 * https://leetcode.com/problems/unique-word-abbreviation/description/
 *
 * algorithms
 * Medium (18.83%)
 * Total Accepted:    36.4K
 * Total Submissions: 193.5K
 * Testcase Example:  '["ValidWordAbbr","isUnique","isUnique","isUnique","isUnique"]\n[[["deer","door","cake","card"]],["dear"],["cart"],["cane"],["make"]]'
 *
 * An abbreviation of a word follows the form <first letter><number><last
 * letter>. Below are some examples of word abbreviations:
 * 
 * 
 * a) it                      --> it    (no abbreviation)
 * 
 * ⁠    1
 * ⁠    ↓
 * b) d|o|g                   --> d1g
 * 
 * ⁠             1    1  1
 * ⁠    1---5----0----5--8
 * ⁠    ↓   ↓    ↓    ↓  ↓    
 * c) i|nternationalizatio|n  --> i18n
 * 
 * ⁠             1
 * ⁠    1---5----0
 * ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * 
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation
 * is unique in the dictionary. A word's abbreviation is unique if no other
 * word from the dictionary has the same abbreviation.
 * 
 * Example:
 * 
 * 
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 * 
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 * 
 * 
 */
class ValidWordAbbr {

    Map<String, String> map;

    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for (String s : dictionary) {
            String abbr = abbreviate(s);
            if (!map.containsKey(abbr)) {
                map.put(abbr, s);
            } else if (!s.equals(abbr)) {
                map.put(abbr, "");
            }
        }
    }

    public boolean isUnique(String word) {
        String abbr = abbreviate(word);
        if (map.containsKey(abbr)) {
            return word.equals(map.get(abbr));
        }
        // map.put(abbr, word);
        return true;
    }

    public String abbreviate(String s) {
        if (s.length() <= 2) {
            return s;
        } else {
            return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
        }
    }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary); boolean param_1 =
 * obj.isUnique(word);
 */
