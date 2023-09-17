package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactTest {
    @Test
    public void whenException() {
        Fact fact = new Fact();
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> fact.calc(-1));
        assertThat(exception.getMessage()).isEqualTo("N could not be less than 0");
    }

    @Test
    public void whenInput2() {
        Fact fact = new Fact();
        int n = 5;
        int expected = 120;
        int result = fact.calc(n);
        assertThat(result).isEqualTo(expected);
    }
}