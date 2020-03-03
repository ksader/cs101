package org.saderfamily;

import java.util.HashMap;
import java.util.Map;

public class CountUniques {
    public static void main(String args[]) {
        String str = "BanaNab";
        Map<Character, Integer> characterCounts = new HashMap<>(str.length());
        for (Character c: str.toCharArray() ) {
            final char lowerChar = Character.toLowerCase(c);
            if(characterCounts.get(lowerChar) == null) {
                characterCounts.put(lowerChar, 1);
            } else {
                Integer count = characterCounts.get(lowerChar);
                characterCounts.put(lowerChar, ++count);
            }
        }

        for (Map.Entry<Character, Integer> ent : characterCounts.entrySet()) {
            if(ent.getValue() == 1) {
                System.out.println("Unique character " + ent.getKey());
            }
        }
    }
}
