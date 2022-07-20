package ggutierrez;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
    @Test
    public void test0() {
        assertEquals(23, new Solution().solution(10));
    }

    @Test
    public void test1() {
        assertEquals(78, new Solution().solution(20));
    }



}