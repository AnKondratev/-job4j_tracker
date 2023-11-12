package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] split1 = o1.split("/");
        String[] split2 = o2.split("/");
        int res = -split1[0].compareTo(split2[0]);
        if (res == 0) {
            for (int i = 1; i < Math.min(split1.length, split2.length); i++) {
                res = split1[i].compareTo(split2[i]);
                if (res != 0) {
                    break;
                }
            }
            if (res == 0) {
                res = Integer.compare(split1.length, split2.length);
            }
        }
        return res;
    }
}