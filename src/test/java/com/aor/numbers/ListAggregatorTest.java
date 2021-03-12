package com.aor.numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.jvm.hotspot.code.Stub;

import java.util.Arrays;
import java.util.List;

public class ListAggregatorTest {
    private List<Integer> list;

    @BeforeEach
    public void setupArray(){
        this.list = Arrays.asList(1,2,4,2,5);
    }

    @Test
    public void sum() {
        ListAggregator aggregator = new ListAggregator();
        int sum = aggregator.sum(list);

        Assertions.assertEquals(14, sum);
    }

    @Test
    public void max() {
        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(5, max);
    }

    @Test
    public void min() {
        ListAggregator aggregator = new ListAggregator();
        int min = aggregator.min(list);

        Assertions.assertEquals(1, min);
    }

    @Test
    public void distinct() {
        class StubDeduplicator implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list){
                return Arrays.asList(1,2,4,5);
            }
        }

        ListAggregator aggregator = new ListAggregator();
        StubDeduplicator deduplicator = new StubDeduplicator();

        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(4, distinct);
    }

    @Test
    public void max_bug_7263(){
        List<Integer> list = Arrays.asList(-1, -4, -5);

        ListAggregator aggregator = new ListAggregator();
        int max = aggregator.max(list);

        Assertions.assertEquals(-1, max);
    }

    @Test
    public void distinct_bug_8726(){
        class StubDeduplicator implements GenericListDeduplicator{
            public List<Integer> deduplicate(List<Integer> list){
                return Arrays.asList(1,2,4);
            }
        }

        List<Integer> list = Arrays.asList(1, 2, 4, 2);

        ListAggregator aggregator = new ListAggregator();
        StubDeduplicator deduplicator = new StubDeduplicator();

        int distinct = aggregator.distinct(list, deduplicator);

        Assertions.assertEquals(3, distinct);
    }
}
