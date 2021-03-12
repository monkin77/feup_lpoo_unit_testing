package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.code.Stub;

import java.util.Arrays;
import java.util.List;

public class ListDeduplicatorTest {
    private List<Integer> list;

    @BeforeEach
    public void setupList(){
        this.list = Arrays.asList(1,2,4,2,5);
    }


    @Test
    public void deduplicate() {
        class StubSorter implements GenericListSorter{
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1, 2, 4, 5);
            }
        }
        List<Integer> expected = Arrays.asList(1,2,4,5);

        StubSorter listSorter = new StubSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(listSorter);

        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

    @Test
    public void deduplicate_bug_8726(){
        class StubSorter implements GenericListSorter{
            public List<Integer> sort(List<Integer> list){
                return Arrays.asList(1, 2, 4);
            }
        }
        List<Integer> list = Arrays.asList(1, 2, 4, 2);
        List<Integer> expected = Arrays.asList(1, 2, 4);

        StubSorter listSorter = new StubSorter();
        ListDeduplicator deduplicator = new ListDeduplicator(listSorter);

        List<Integer> distinct = deduplicator.deduplicate(list);

        Assertions.assertEquals(expected, distinct);
    }

}
