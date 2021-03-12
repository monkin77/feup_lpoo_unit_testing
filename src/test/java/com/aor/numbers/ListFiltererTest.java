package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ListFiltererTest {

    @Test
    void filter() {
        GenericListFilter filter = Mockito.mock(GenericListFilter.class);
        Mockito.when(filter.accept(0)).thenReturn(true);
        Mockito.when(filter.accept(1)).thenReturn(true);
        Mockito.when(filter.accept(-1)).thenReturn(false);
        Mockito.when(filter.accept(-5)).thenReturn(false);

        List<Integer> expected = Arrays.asList(0, 1);
        List<Integer> numbersToTest = Arrays.asList(0, 1, -1, -5);

        ListFilterer listFilter = new ListFilterer(filter);
        List<Integer> result = listFilter.filter(numbersToTest);

        Assertions.assertEquals(expected, result);
    }
}