package com.dt.vm.common;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
public class KeyValueRs implements Comparable<KeyValueRs> {

    private String key;

    private String value;


    public static class OrderByValue implements Comparator<KeyValueRs> {

        @Override
        public int compare(KeyValueRs o1, KeyValueRs o2) {
            return o1.value.compareTo(o2.value);
        }
    }

    @Override
    public int compareTo(KeyValueRs obj) {

        String compareValue = obj.getValue();
        return this.value.compareTo(compareValue);
    }
}
