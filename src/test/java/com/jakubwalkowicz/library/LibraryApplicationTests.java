package com.jakubwalkowicz.library;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LibraryApplicationTests {

    Calculator underTest = new Calculator();
    @Test
    void itShouldAddTwoNumbers() {
        // given
        int numberOne = 20;
        int numberTwo = 30;

        // when
        int result = underTest.add(numberOne, numberTwo);

        // then
        int expected = 50;
        assertThat(result).isEqualTo(expected);
    }

    static class Calculator {
        int add(int x, int y) {
            return x + y;
        }
    }
}
