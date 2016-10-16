package com.instructure.utils;

import java.util.Collections;
import java.util.List;

public class ReplaceNull {

    private ReplaceNull() {
        super();
    }

    public static <T> List<T> withEmptyList(List<T> input) {
        if (input == null) {
            input = Collections.emptyList();
        }
        return input;
    }

}
