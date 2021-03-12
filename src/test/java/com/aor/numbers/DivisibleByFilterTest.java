package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleByFilterTest {
    @Test
    void acceptDivisibles() {
        DivisibleByFilter filter = new DivisibleByFilter(7);
        List<Integer> list = Arrays.asList(0, 7, 21, 49);

        for(Integer number : list){
            boolean accepts = filter.accept(number);
            Assertions.assertEquals(true, accepts);
        }
    }

    @Test
    void rejectDivisibles(){
        DivisibleByFilter filter = new DivisibleByFilter(5);
        List<Integer> list = Arrays.asList(1, 8, 32, 71);

        for(Integer number : list){
            boolean accepts = filter.accept(number);
            Assertions.assertEquals(false, accepts);
        }
    }
}