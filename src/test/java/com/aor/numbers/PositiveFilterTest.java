package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositiveFilterTest {
    private PositiveFilter posFilter;

    @BeforeEach
    void setupFilter(){
        this.posFilter = new PositiveFilter();
    }

    @Test
    void acceptPositives() {
        List<Integer> list = Arrays.asList(1, 2);

        for(Integer number : list){
            boolean accepts = this.posFilter.accept(number);
            Assertions.assertEquals(true, accepts);
        }
    }

    @Test
    void rejectNegatives(){
        List<Integer> list = Arrays.asList(0, -1, -7);

        for(Integer number : list){
            boolean accepts = this.posFilter.accept(number);
            Assertions.assertEquals(false, accepts);
        }
    }
}