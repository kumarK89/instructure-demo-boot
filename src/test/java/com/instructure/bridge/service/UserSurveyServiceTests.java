package com.instructure.bridge.service;

import com.instructure.bridge.dao.UserSurveyDao;
import com.instructure.bridge.service.dto.SurveyDto;
import com.instructure.bridge.service.dto.SurveyQuestionOptionsDto;
import com.instructure.bridge.service.dto.SurveyQuestionsDto;
import com.instructure.bridge.service.dto.UserDto;

import org.jooq.Configuration;
import org.jooq.Converter;
import org.jooq.Field;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record10;
import org.jooq.Record11;
import org.jooq.Record12;
import org.jooq.Record13;
import org.jooq.Record14;
import org.jooq.Record15;
import org.jooq.Record16;
import org.jooq.Record17;
import org.jooq.Record18;
import org.jooq.Record19;
import org.jooq.Record2;
import org.jooq.Record20;
import org.jooq.Record21;
import org.jooq.Record22;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Record6;
import org.jooq.Record7;
import org.jooq.Record8;
import org.jooq.Record9;
import org.jooq.RecordMapper;
import org.jooq.Row5;
import org.jooq.Row6;
import org.jooq.Table;
import org.jooq.exception.DataTypeException;
import org.jooq.exception.MappingException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jooq.codgen.tables.records.InstrUsrSrvyMpngRecord;
import jooq.codgen.tables.records.InstrUsrSrvyQtnOptRecord;

import static org.mockito.Matchers.anyInt;

@RunWith(MockitoJUnitRunner.class)
public class UserSurveyServiceTests {

    @Mock
    UserSurveyDao userSurveyDao;

    @Before
    public void intializeMocks() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Test the Get Surveys which are available for the particular User.
     */
    @Test
    public void testGetUserSurveyDetails() {
        Mockito.stub(userSurveyDao.getAssignedSurveysForUser(anyInt()))
                .toReturn(createRecord6values());
        //.toReturn(Collections.emptyList());

        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        userSurveyService.getUserSurveyDetails(anyInt());
        Mockito.verify(userSurveyDao).getAssignedSurveysForUser(anyInt());
    }

    /**
     * Test the Get Surveys which are available for the particular User.
     */
    @Test
    public void testGetUserSurveyDetailsForNull() {
        Mockito.stub(userSurveyDao.getAssignedSurveysForUser(anyInt()))
                    .toReturn(Collections.emptyList());

        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        userSurveyService.getUserSurveyDetails(anyInt());
        Mockito.verify(userSurveyDao).getAssignedSurveysForUser(anyInt());
    }

    private List<Record6<Integer, String, Integer,
            String, Date, Date>> createRecord6values() {
        List<Record6<Integer, String, Integer,
                String, Date, Date>> result = new ArrayList<>();
        Record6<Integer, String, Integer,
                String, Date, Date> record6 = new Record6<Integer, String, Integer, String, Date, Date>() {
            @Override
            public Row6<Integer, String, Integer, String, Date, Date> fieldsRow() {
                return null;
            }

            @Override
            public Row6<Integer, String, Integer, String, Date, Date> valuesRow() {
                return null;
            }

            @Override
            public Field<Integer> field1() {
                return null;
            }

            @Override
            public Field<String> field2() {
                return null;
            }

            @Override
            public Field<Integer> field3() {
                return null;
            }

            @Override
            public Field<String> field4() {
                return null;
            }

            @Override
            public Field<Date> field5() {
                return null;
            }

            @Override
            public Field<Date> field6() {
                return null;
            }

            @Override
            public Integer value1() {
                return null;
            }

            @Override
            public String value2() {
                return null;
            }

            @Override
            public Integer value3() {
                return null;
            }

            @Override
            public String value4() {
                return null;
            }

            @Override
            public Date value5() {
                return null;
            }

            @Override
            public Date value6() {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value1(Integer value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value2(String value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value3(Integer value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value4(String value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value5(Date value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> value6(Date value) {
                return null;
            }

            @Override
            public Record6<Integer, String, Integer, String, Date, Date> values(Integer integer, String s, Integer integer2, String s2, Date date, Date date2) {
                return null;
            }

            @Override
            public <T> Field<T> field(Field<T> field) {
                return null;
            }

            @Override
            public Field<?> field(String name) {
                return null;
            }

            @Override
            public Field<?> field(Name name) {
                return null;
            }

            @Override
            public Field<?> field(int index) {
                return null;
            }

            @Override
            public Field<?>[] fields() {
                return new Field<?>[0];
            }

            @Override
            public Field<?>[] fields(Field<?>... fields) {
                return new Field<?>[0];
            }

            @Override
            public Field<?>[] fields(String... fieldNames) {
                return new Field<?>[0];
            }

            @Override
            public Field<?>[] fields(Name... fieldNames) {
                return new Field<?>[0];
            }

            @Override
            public Field<?>[] fields(int... fieldIndexes) {
                return new Field<?>[0];
            }

            @Override
            public <T> T get(Field<T> field) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T get(Field<?> field, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T, U> U get(Field<T> field, Converter<? super T, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object get(String fieldName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T get(String fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U get(String fieldName, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object get(Name fieldName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T get(Name fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U get(Name fieldName, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object get(int index) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T get(int index, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U get(int index, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T> void set(Field<T> field, T value) {

            }

            @Override
            public <T, U> void set(Field<T> field, U value, Converter<? extends T, ? super U> converter) {

            }

            @Override
            public int size() {
                return 0;
            }

            @Override
            public Record original() {
                return null;
            }

            @Override
            public <T> T original(Field<T> field) {
                return null;
            }

            @Override
            public Object original(int fieldIndex) {
                return null;
            }

            @Override
            public Object original(String fieldName) {
                return null;
            }

            @Override
            public Object original(Name fieldName) {
                return null;
            }

            @Override
            public boolean changed() {
                return false;
            }

            @Override
            public boolean changed(Field<?> field) {
                return false;
            }

            @Override
            public boolean changed(int fieldIndex) {
                return false;
            }

            @Override
            public boolean changed(String fieldName) {
                return false;
            }

            @Override
            public boolean changed(Name fieldName) {
                return false;
            }

            @Override
            public void changed(boolean changed) {

            }

            @Override
            public void changed(Field<?> field, boolean changed) {

            }

            @Override
            public void changed(int fieldIndex, boolean changed) {

            }

            @Override
            public void changed(String fieldName, boolean changed) {

            }

            @Override
            public void changed(Name fieldName, boolean changed) {

            }

            @Override
            public void reset() {

            }

            @Override
            public void reset(Field<?> field) {

            }

            @Override
            public void reset(int fieldIndex) {

            }

            @Override
            public void reset(String fieldName) {

            }

            @Override
            public void reset(Name fieldName) {

            }

            @Override
            public Object[] intoArray() {
                return new Object[0];
            }

            @Override
            public List<Object> intoList() {
                return null;
            }

            @Override
            public Map<String, Object> intoMap() {
                return null;
            }

            @Override
            public Record into(Field<?>... fields) {
                return null;
            }

            @Override
            public <T1> Record1<T1> into(Field<T1> field1) {
                return null;
            }

            @Override
            public <T1, T2> Record2<T1, T2> into(Field<T1> field1, Field<T2> field2) {
                return null;
            }

            @Override
            public <T1, T2, T3> Record3<T1, T2, T3> into(Field<T1> field1, Field<T2> field2, Field<T3> field3) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4> Record4<T1, T2, T3, T4> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5> Record5<T1, T2, T3, T4, T5> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6> Record6<T1, T2, T3, T4, T5, T6> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7> Record7<T1, T2, T3, T4, T5, T6, T7> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8> Record8<T1, T2, T3, T4, T5, T6, T7, T8> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20, Field<T21> field21) {
                return null;
            }

            @Override
            public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20, Field<T21> field21, Field<T22> field22) {
                return null;
            }

            @Override
            public <E> E into(Class<? extends E> type) throws MappingException {
                return null;
            }

            @Override
            public <E> E into(E object) throws MappingException {
                return null;
            }

            @Override
            public <R extends Record> R into(Table<R> table) {
                return null;
            }

            @Override
            public ResultSet intoResultSet() {
                return null;
            }

            @Override
            public <E> E map(RecordMapper<Record, E> mapper) {
                return null;
            }

            @Override
            public void from(Object source) throws MappingException {

            }

            @Override
            public void from(Object source, Field<?>... fields) throws MappingException {

            }

            @Override
            public void from(Object source, String... fieldNames) throws MappingException {

            }

            @Override
            public void from(Object source, Name... fieldNames) throws MappingException {

            }

            @Override
            public void from(Object source, int... fieldIndexes) throws MappingException {

            }

            @Override
            public void fromMap(Map<String, ?> map) {

            }

            @Override
            public void fromMap(Map<String, ?> map, Field<?>... fields) {

            }

            @Override
            public void fromMap(Map<String, ?> map, String... fieldNames) {

            }

            @Override
            public void fromMap(Map<String, ?> map, Name... fieldNames) {

            }

            @Override
            public void fromMap(Map<String, ?> map, int... fieldIndexes) {

            }

            @Override
            public void fromArray(Object... array) {

            }

            @Override
            public void fromArray(Object[] array, Field<?>... fields) {

            }

            @Override
            public void fromArray(Object[] array, String... fieldNames) {

            }

            @Override
            public void fromArray(Object[] array, Name... fieldNames) {

            }

            @Override
            public void fromArray(Object[] array, int... fieldIndexes) {

            }

            @Override
            public int compareTo(Record record) {
                return 0;
            }

            @Override
            public <T> T getValue(Field<T> field) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T getValue(Field<T> field, T defaultValue) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T getValue(Field<?> field, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T> T getValue(Field<?> field, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object getValue(String fieldName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Object getValue(String fieldName, Object defaultValue) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T getValue(String fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T> T getValue(String fieldName, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U getValue(String fieldName, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U getValue(String fieldName, Converter<?, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object getValue(Name fieldName) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T getValue(Name fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U getValue(Name fieldName, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public Object getValue(int index) throws IllegalArgumentException {
                return null;
            }

            @Override
            public Object getValue(int index, Object defaultValue) throws IllegalArgumentException {
                return null;
            }

            @Override
            public <T> T getValue(int index, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T> T getValue(int index, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U getValue(int index, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <U> U getValue(int index, Converter<?, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                return null;
            }

            @Override
            public <T> void setValue(Field<T> field, T value) {

            }

            @Override
            public <T, U> void setValue(Field<T> field, U value, Converter<T, ? super U> converter) {

            }

            @Override
            public void attach(Configuration configuration) {

            }

            @Override
            public void detach() {

            }
        };
        result.add(record6);
        return result;
    }

    /**
     * Test whether the answer submitted are properly going to DAO layer to submit.
     */
    @Test
    public void testSubmitSurvey() {

        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        List<SurveyQuestionsDto> surveyQuestionsDtos = new ArrayList<>();
        List<SurveyQuestionOptionsDto> surveyQuestionOptionsDtos = new ArrayList<>();
        SurveyQuestionOptionsDto surveyQuestionOptionsDto = new SurveyQuestionOptionsDto();
        surveyQuestionOptionsDto.setOptionSelected(true);
        surveyQuestionOptionsDto.setOptText("Test");
        surveyQuestionOptionsDto.setSrvyQtnOptId(1);
        surveyQuestionOptionsDtos.add(surveyQuestionOptionsDto);
        SurveyQuestionsDto surveyQuestionsDto = new SurveyQuestionsDto();
        surveyQuestionsDto.setQtnTxt("Test");
        surveyQuestionsDto.setSrvyQtnId(1);
        surveyQuestionsDto.setSurveyQuestionOptionsDtos(surveyQuestionOptionsDtos);
        surveyQuestionsDtos.add(surveyQuestionsDto);
        Mockito.when(userSurveyDao.getUserSrvyMpngRcrd(anyInt(), anyInt()))
                .thenReturn(createInstrUsrSrvyMpngRecord());
        Mockito.doNothing().when(userSurveyDao).submitSurvey
                (Mockito.anyListOf(InstrUsrSrvyQtnOptRecord.class));
        userSurveyService.submitSurvey(anyInt(), anyInt(), surveyQuestionsDtos);
        Mockito.verify(userSurveyDao).getUserSrvyMpngRcrd(anyInt(), anyInt());
        Mockito.verify(userSurveyDao).submitSurvey
                (Mockito.anyListOf(InstrUsrSrvyQtnOptRecord.class));

    }

    private InstrUsrSrvyMpngRecord createInstrUsrSrvyMpngRecord() {
        InstrUsrSrvyMpngRecord instrUsrSrvyMpngRecord = new InstrUsrSrvyMpngRecord();
        instrUsrSrvyMpngRecord.setUsrSrvyMpngId(1);
        instrUsrSrvyMpngRecord.setSrvyId(1);
        instrUsrSrvyMpngRecord.setUsrId(1);
        return instrUsrSrvyMpngRecord;
    }

    /**
     * Test whether the GetUserSurveyQustions method is returning the
     * surveyQuestionsDtos list or not.
     */
    @Test
    public void testGetUserSurveyQustions() {
        SurveyDto surveyDto = createSurveyDtoMock();
        UserDto userDto = createUserDtoMock();
        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        Mockito.stub(userSurveyDao.getUserSurveyQustions(anyInt(), anyInt()))
                .toReturn(createRecord5values(surveyDto.getSrvyId()));
        //  .toReturn(Collections.EMPTY_LIST);
        userSurveyService.getUserSurveyQustions(userDto.getUserId(), surveyDto.getSrvyId());
        Mockito.verify(userSurveyDao).getUserSurveyQustions(anyInt(), anyInt());
    }

    private SurveyDto createSurveyDtoMock() {
        SurveyDto surveyDto = new SurveyDto();
        surveyDto.setSrvyId(1);
        surveyDto.setSrvyName("Test");
        surveyDto.setSrvyEndDt(new Date(new java.util.Date().getTime()));
        surveyDto.setSrvyStrtDt(new Date(new java.util.Date().getTime()));

        return surveyDto;
    }

    private UserDto createUserDtoMock() {
        UserDto userDto = new UserDto();
        userDto.setUserName("Test");
        userDto.setUserId(1);
        return userDto;
    }


    /**
     * Test whether the GetUserSurveyQustions method is returning the
     * surveyQuestionsDtos list or not.
     */
    @Test
    public void testGetUserSurveyQustionsForMultipleValues() {
        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        Mockito.stub(userSurveyDao.getUserSurveyQustions(anyInt(), anyInt()))
                .toReturn(createRecord5values(3));
        //  .toReturn(Collections.EMPTY_LIST);
        userSurveyService.getUserSurveyQustions(anyInt(), anyInt());
        Mockito.verify(userSurveyDao).getUserSurveyQustions(anyInt(), anyInt());
    }

    /**
     * Test whether the GetUserSurveyQustions method is returning the
     * surveyQuestionsDtos list or not.
     */
    @Test
    public void testGetUserSurveyQustionsForNull() {
        UserSurveyService userSurveyService = new UserSurveyServiceImpl(userSurveyDao);
        Mockito.stub(userSurveyDao.getUserSurveyQustions(anyInt(), anyInt()))
          .toReturn(Collections.EMPTY_LIST);
        userSurveyService.getUserSurveyQustions(anyInt(), anyInt());
        Mockito.verify(userSurveyDao).getUserSurveyQustions(anyInt(), anyInt());
    }

    private List<Record5<String, Integer, Integer, String, Boolean>>
    createRecord5values(int value) {
        List<Record5<String, Integer, Integer, String, Boolean>> result = new ArrayList<>();
        for (int i = 0; i < value; i++) {
            Record5<String, Integer, Integer, String, Boolean> record5 =
                    new Record5<String, Integer, Integer, String, Boolean>() {
                        @Override
                        public Row5<String, Integer, Integer, String, Boolean> fieldsRow() {
                            return null;
                        }

                        @Override
                        public Row5<String, Integer, Integer, String, Boolean> valuesRow() {
                            return null;
                        }

                        @Override
                        public Field<String> field1() {
                            return null;
                        }

                        @Override
                        public Field<Integer> field2() {
                            return null;
                        }

                        @Override
                        public Field<Integer> field3() {
                            return null;
                        }

                        @Override
                        public Field<String> field4() {
                            return null;
                        }

                        @Override
                        public Field<Boolean> field5() {
                            return null;
                        }

                        @Override
                        public String value1() {
                            return null;
                        }

                        @Override
                        public Integer value2() {
                            return 1;
                        }

                        @Override
                        public Integer value3() {
                            return 1;
                        }

                        @Override
                        public String value4() {
                            return "Test";
                        }

                        @Override
                        public Boolean value5() {
                            return true;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> value1(String value) {
                            return null;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> value2(Integer value) {
                            return null;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> value3(Integer value) {
                            return null;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> value4(String value) {
                            return null;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> value5(Boolean value) {
                            return null;
                        }

                        @Override
                        public Record5<String, Integer, Integer, String, Boolean> values(String s, Integer integer, Integer integer2, String s2, Boolean aBoolean) {
                            return null;
                        }

                        @Override
                        public <T> Field<T> field(Field<T> field) {
                            return null;
                        }

                        @Override
                        public Field<?> field(String name) {
                            return null;
                        }

                        @Override
                        public Field<?> field(Name name) {
                            return null;
                        }

                        @Override
                        public Field<?> field(int index) {
                            return null;
                        }

                        @Override
                        public Field<?>[] fields() {
                            return new Field<?>[0];
                        }

                        @Override
                        public Field<?>[] fields(Field<?>... fields) {
                            return new Field<?>[0];
                        }

                        @Override
                        public Field<?>[] fields(String... fieldNames) {
                            return new Field<?>[0];
                        }

                        @Override
                        public Field<?>[] fields(Name... fieldNames) {
                            return new Field<?>[0];
                        }

                        @Override
                        public Field<?>[] fields(int... fieldIndexes) {
                            return new Field<?>[0];
                        }

                        @Override
                        public <T> T get(Field<T> field) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T get(Field<?> field, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T, U> U get(Field<T> field, Converter<? super T, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object get(String fieldName) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T get(String fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U get(String fieldName, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object get(Name fieldName) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T get(Name fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U get(Name fieldName, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object get(int index) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T get(int index, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U get(int index, Converter<?, ? extends U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T> void set(Field<T> field, T value) {

                        }

                        @Override
                        public <T, U> void set(Field<T> field, U value, Converter<? extends T, ? super U> converter) {

                        }

                        @Override
                        public int size() {
                            return 0;
                        }

                        @Override
                        public Record original() {
                            return null;
                        }

                        @Override
                        public <T> T original(Field<T> field) {
                            return null;
                        }

                        @Override
                        public Object original(int fieldIndex) {
                            return null;
                        }

                        @Override
                        public Object original(String fieldName) {
                            return null;
                        }

                        @Override
                        public Object original(Name fieldName) {
                            return null;
                        }

                        @Override
                        public boolean changed() {
                            return false;
                        }

                        @Override
                        public boolean changed(Field<?> field) {
                            return false;
                        }

                        @Override
                        public boolean changed(int fieldIndex) {
                            return false;
                        }

                        @Override
                        public boolean changed(String fieldName) {
                            return false;
                        }

                        @Override
                        public boolean changed(Name fieldName) {
                            return false;
                        }

                        @Override
                        public void changed(boolean changed) {

                        }

                        @Override
                        public void changed(Field<?> field, boolean changed) {

                        }

                        @Override
                        public void changed(int fieldIndex, boolean changed) {

                        }

                        @Override
                        public void changed(String fieldName, boolean changed) {

                        }

                        @Override
                        public void changed(Name fieldName, boolean changed) {

                        }

                        @Override
                        public void reset() {

                        }

                        @Override
                        public void reset(Field<?> field) {

                        }

                        @Override
                        public void reset(int fieldIndex) {

                        }

                        @Override
                        public void reset(String fieldName) {

                        }

                        @Override
                        public void reset(Name fieldName) {

                        }

                        @Override
                        public Object[] intoArray() {
                            return new Object[0];
                        }

                        @Override
                        public List<Object> intoList() {
                            return null;
                        }

                        @Override
                        public Map<String, Object> intoMap() {
                            return null;
                        }

                        @Override
                        public Record into(Field<?>... fields) {
                            return null;
                        }

                        @Override
                        public <T1> Record1<T1> into(Field<T1> field1) {
                            return null;
                        }

                        @Override
                        public <T1, T2> Record2<T1, T2> into(Field<T1> field1, Field<T2> field2) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3> Record3<T1, T2, T3> into(Field<T1> field1, Field<T2> field2, Field<T3> field3) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4> Record4<T1, T2, T3, T4> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5> Record5<T1, T2, T3, T4, T5> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6> Record6<T1, T2, T3, T4, T5, T6> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7> Record7<T1, T2, T3, T4, T5, T6, T7> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8> Record8<T1, T2, T3, T4, T5, T6, T7, T8> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9> Record9<T1, T2, T3, T4, T5, T6, T7, T8, T9> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> Record10<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> Record11<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> Record12<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> Record13<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> Record14<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> Record15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> Record16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> Record17<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> Record18<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> Record19<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> Record20<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> Record21<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20, Field<T21> field21) {
                            return null;
                        }

                        @Override
                        public <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> Record22<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22> into(Field<T1> field1, Field<T2> field2, Field<T3> field3, Field<T4> field4, Field<T5> field5, Field<T6> field6, Field<T7> field7, Field<T8> field8, Field<T9> field9, Field<T10> field10, Field<T11> field11, Field<T12> field12, Field<T13> field13, Field<T14> field14, Field<T15> field15, Field<T16> field16, Field<T17> field17, Field<T18> field18, Field<T19> field19, Field<T20> field20, Field<T21> field21, Field<T22> field22) {
                            return null;
                        }

                        @Override
                        public <E> E into(Class<? extends E> type) throws MappingException {
                            return null;
                        }

                        @Override
                        public <E> E into(E object) throws MappingException {
                            return null;
                        }

                        @Override
                        public <R extends Record> R into(Table<R> table) {
                            return null;
                        }

                        @Override
                        public ResultSet intoResultSet() {
                            return null;
                        }

                        @Override
                        public <E> E map(RecordMapper<Record, E> mapper) {
                            return null;
                        }

                        @Override
                        public void from(Object source) throws MappingException {

                        }

                        @Override
                        public void from(Object source, Field<?>... fields) throws MappingException {

                        }

                        @Override
                        public void from(Object source, String... fieldNames) throws MappingException {

                        }

                        @Override
                        public void from(Object source, Name... fieldNames) throws MappingException {

                        }

                        @Override
                        public void from(Object source, int... fieldIndexes) throws MappingException {

                        }

                        @Override
                        public void fromMap(Map<String, ?> map) {

                        }

                        @Override
                        public void fromMap(Map<String, ?> map, Field<?>... fields) {

                        }

                        @Override
                        public void fromMap(Map<String, ?> map, String... fieldNames) {

                        }

                        @Override
                        public void fromMap(Map<String, ?> map, Name... fieldNames) {

                        }

                        @Override
                        public void fromMap(Map<String, ?> map, int... fieldIndexes) {

                        }

                        @Override
                        public void fromArray(Object... array) {

                        }

                        @Override
                        public void fromArray(Object[] array, Field<?>... fields) {

                        }

                        @Override
                        public void fromArray(Object[] array, String... fieldNames) {

                        }

                        @Override
                        public void fromArray(Object[] array, Name... fieldNames) {

                        }

                        @Override
                        public void fromArray(Object[] array, int... fieldIndexes) {

                        }

                        @Override
                        public int compareTo(Record record) {
                            return 0;
                        }

                        @Override
                        public <T> T getValue(Field<T> field) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(Field<T> field, T defaultValue) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(Field<?> field, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(Field<?> field, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T, U> U getValue(Field<T> field, Converter<? super T, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object getValue(String fieldName) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public Object getValue(String fieldName, Object defaultValue) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(String fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(String fieldName, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U getValue(String fieldName, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U getValue(String fieldName, Converter<?, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object getValue(Name fieldName) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(Name fieldName, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U getValue(Name fieldName, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public Object getValue(int index) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public Object getValue(int index, Object defaultValue) throws IllegalArgumentException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(int index, Class<? extends T> type) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T> T getValue(int index, Class<? extends T> type, T defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U getValue(int index, Converter<?, U> converter) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <U> U getValue(int index, Converter<?, U> converter, U defaultValue) throws IllegalArgumentException, DataTypeException {
                            return null;
                        }

                        @Override
                        public <T> void setValue(Field<T> field, T value) {

                        }

                        @Override
                        public <T, U> void setValue(Field<T> field, U value, Converter<T, ? super U> converter) {

                        }

                        @Override
                        public void attach(Configuration configuration) {

                        }

                        @Override
                        public void detach() {

                        }
                    };
            result.add(record5);
        }
        return result;
    }
}