package _03_IntroToStacks;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

public class _03_TestMatchingBrackets {

    @Test
    public void testMatchingBrackets() {
        assertTrue(doBracketsMatch("{}"));
        assertTrue(doBracketsMatch("{{}}"));
        assertTrue(doBracketsMatch("{}{}{{}}"));
        assertFalse(doBracketsMatch("{{}"));
        assertFalse(doBracketsMatch("}{"));
    }

    // USE A STACK TO COMPLETE THE METHOD
    // FOR CHECKING IF EVERY OPENING BRACKET HAS A MATCHING CLOSING BRACKET
    private boolean doBracketsMatch(String b) {
        Stack<Character> allChar = new Stack<>();

        for (int i = 0; i < b.length(); i++) {
            allChar.push(b.charAt(i));
        }

        int allBrackets = 0;
        while (!allChar.isEmpty()) {
            Character aChar = allChar.pop();
            if (aChar == '{')
                allBrackets++;
            else if (aChar == '}') {
                allBrackets--;
            }
            if (allBrackets > 0)
                return false;

        }

        return allBrackets == 0;

    }

}