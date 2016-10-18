package com.instructure.bridge.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;

public final class ModelMapperUtil {

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration().addValueReader(new RecordValueReader());
        MODEL_MAPPER.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
    }

    private ModelMapperUtil() {

    }
}
