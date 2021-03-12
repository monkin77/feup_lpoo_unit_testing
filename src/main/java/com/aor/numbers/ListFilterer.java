package com.aor.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListFilterer {
    public GenericListFilter filter;
    public ListFilterer(GenericListFilter filter){
        this.filter = filter;
    }

    public List<Integer> filter(List<Integer> list){
        List<Integer> passed = new ArrayList<Integer>();
        for(Integer num : list){
            if(this.filter.accept(num))
                passed.add(num);
        }
        return passed;
    }
}
