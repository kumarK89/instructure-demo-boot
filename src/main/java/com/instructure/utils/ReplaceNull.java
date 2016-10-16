package com.instructure.utils;

import java.util.Collections;
import java.util.List;

public class ReplaceNull {

    private ReplaceNull() {
        super();
    }

    public static <T> List<T> withEmptyList(List<T> input) {
        Collections.emptyList();
        if (input == null) {
            return Collections.emptyList();
        }
        return input;
    }

}
