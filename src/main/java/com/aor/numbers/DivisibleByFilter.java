package com.aor.numbers;

public class DivisibleByFilter {
    private Integer divisor;
    public DivisibleByFilter(Integer number){
        this.divisor = number;
    }
    public boolean accept(Integer number){
        return (number%this.divisor) == 0;
    }
}
