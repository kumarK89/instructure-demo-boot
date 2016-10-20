package com.instructure.bridge.common;

public interface Converter {

    <T1, T2> T2 convert(T1 t1);
}
