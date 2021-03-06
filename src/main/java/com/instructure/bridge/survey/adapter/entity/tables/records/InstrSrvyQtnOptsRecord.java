/**
 * This class is generated by jOOQ
 */
package com.instructure.bridge.survey.adapter.entity.tables.records;


import java.sql.Date;

import javax.annotation.Generated;

import com.instructure.bridge.survey.adapter.entity.tables.InstrSrvyQtnOpts;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record7;
import org.jooq.Row7;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.8.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class InstrSrvyQtnOptsRecord extends UpdatableRecordImpl<InstrSrvyQtnOptsRecord> implements Record7<Integer, Integer, String, String, String, Date, Date> {

    private static final long serialVersionUID = -754318703;

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.srvy_qtn_opt_id</code>.
     */
    public void setSrvyQtnOptId(Integer value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.srvy_qtn_opt_id</code>.
     */
    public Integer getSrvyQtnOptId() {
        return (Integer) get(0);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.srvy_qtn_id</code>.
     */
    public void setSrvyQtnId(Integer value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.srvy_qtn_id</code>.
     */
    public Integer getSrvyQtnId() {
        return (Integer) get(1);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.opt_text</code>.
     */
    public void setOptText(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.opt_text</code>.
     */
    public String getOptText() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.crtd_usr</code>.
     */
    public void setCrtdUsr(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.crtd_usr</code>.
     */
    public String getCrtdUsr() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.lst_updtd_usr</code>.
     */
    public void setLstUpdtdUsr(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.lst_updtd_usr</code>.
     */
    public String getLstUpdtdUsr() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.crtd_time</code>.
     */
    public void setCrtdTime(Date value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.crtd_time</code>.
     */
    public Date getCrtdTime() {
        return (Date) get(5);
    }

    /**
     * Setter for <code>public.instr_srvy_qtn_opts.lst_updtd_time</code>.
     */
    public void setLstUpdtdTime(Date value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.instr_srvy_qtn_opts.lst_updtd_time</code>.
     */
    public Date getLstUpdtdTime() {
        return (Date) get(6);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Record1<Integer> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record7 type implementation
    // -------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, Date, Date> fieldsRow() {
        return (Row7) super.fieldsRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Row7<Integer, Integer, String, String, String, Date, Date> valuesRow() {
        return (Row7) super.valuesRow();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field1() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.SRVY_QTN_OPT_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Integer> field2() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.SRVY_QTN_ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field3() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.OPT_TEXT;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field4() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.CRTD_USR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<String> field5() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.LST_UPDTD_USR;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field6() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.CRTD_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Field<Date> field7() {
        return InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS.LST_UPDTD_TIME;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value1() {
        return getSrvyQtnOptId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer value2() {
        return getSrvyQtnId();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value3() {
        return getOptText();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value4() {
        return getCrtdUsr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String value5() {
        return getLstUpdtdUsr();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value6() {
        return getCrtdTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Date value7() {
        return getLstUpdtdTime();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value1(Integer value) {
        setSrvyQtnOptId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value2(Integer value) {
        setSrvyQtnId(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value3(String value) {
        setOptText(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value4(String value) {
        setCrtdUsr(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value5(String value) {
        setLstUpdtdUsr(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value6(Date value) {
        setCrtdTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord value7(Date value) {
        setLstUpdtdTime(value);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrSrvyQtnOptsRecord values(Integer value1, Integer value2, String value3, String value4, String value5, Date value6, Date value7) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached InstrSrvyQtnOptsRecord
     */
    public InstrSrvyQtnOptsRecord() {
        super(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS);
    }

    /**
     * Create a detached, initialised InstrSrvyQtnOptsRecord
     */
    public InstrSrvyQtnOptsRecord(Integer srvyQtnOptId, Integer srvyQtnId, String optText, String crtdUsr, String lstUpdtdUsr, Date crtdTime, Date lstUpdtdTime) {
        super(InstrSrvyQtnOpts.INSTR_SRVY_QTN_OPTS);

        set(0, srvyQtnOptId);
        set(1, srvyQtnId);
        set(2, optText);
        set(3, crtdUsr);
        set(4, lstUpdtdUsr);
        set(5, crtdTime);
        set(6, lstUpdtdTime);
    }
}
