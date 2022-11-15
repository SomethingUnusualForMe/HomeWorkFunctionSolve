package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    Calc underTest;
    @BeforeEach
    protected void setUP(){
        underTest = new Calc(-0.5,2);
        double[][] arr = underTest.calculateArray();
    }

    @Test
    public void testCalcSteps() {
        int expected = 750;
        int result = underTest.calcSteps();
        assertEquals(expected,result,"Must be 750");
    }

    @Test
    void testGetIdxOfHighestY(){
        int expected = 174;
        int result = underTest.getIdxOfHighestY();
        assertEquals(expected,result,"Must be 174");
    }
    @Test
    void testGetIdxOfLowestY(){
        int expected = 362;
        int result = underTest.getIdxOfLowestY();
        assertEquals(expected,result,"Must be 362");
    }

    @Test
    void testCalculateArray() {
        double[][] arr = underTest.calculateArray();
        boolean result = arr.length > 0;
        assertTrue(result,"Array is empty!");
    }
    @Test
    void testCalculateArrayNotNull() {
        double[][] arr = underTest.calculateArray();
        boolean result = Arrays.stream(arr).allMatch(Objects::nonNull);
        assertTrue(result,"Array values is null!");
    }

    @Test
    void testGetInfoOf () {
        String  expected = "Idx not found!";
        String result = underTest.getInfoOf(800);
        assertEquals(expected,result,"Must be same!");
    }

}