package com.instructure.utils;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.NameTokenizers;
import org.modelmapper.jooq.RecordValueReader;

/**
 * Created by kumark on 15-10-2016.
 */
public final class ModelMapperUtil {

    public static final ModelMapper MODEL_MAPPER = new ModelMapper();

    static {
        MODEL_MAPPER.getConfiguration().addValueReader(new RecordValueReader());
        MODEL_MAPPER.getConfiguration().setSourceNameTokenizer(NameTokenizers.UNDERSCORE);
    }
}
