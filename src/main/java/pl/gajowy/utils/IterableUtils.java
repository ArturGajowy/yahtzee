package pl.gajowy.utils;

import java.util.List;

public class IterableUtils {
    public static <T> T head(List<T> list) {
        return list.get(0);
    }

    public static <T> List<T> tail(List<T> list) {
        if (list.isEmpty()) {
            return list;
        } else {
            return list.subList(1, list.size());
        }
    }

    public static Integer sum(Iterable<Integer> iterable) {
        Integer result = 0;
        for (Integer value : iterable) {
            result += value;
        }
        return result;
    }
}
