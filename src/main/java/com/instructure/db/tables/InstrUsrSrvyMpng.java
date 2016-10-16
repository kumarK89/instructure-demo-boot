/**
 * This class is generated by jOOQ
 */
package com.instructure.db.tables;


import com.instructure.db.Keys;
import com.instructure.db.Public;
import com.instructure.db.tables.records.InstrUsrSrvyMpngRecord;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Schema;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.TableImpl;


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
public class InstrUsrSrvyMpng extends TableImpl<InstrUsrSrvyMpngRecord> {

    private static final long serialVersionUID = -4260295;

    /**
     * The reference instance of <code>public.instr_usr_srvy_mpng</code>
     */
    public static final InstrUsrSrvyMpng INSTR_USR_SRVY_MPNG = new InstrUsrSrvyMpng();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<InstrUsrSrvyMpngRecord> getRecordType() {
        return InstrUsrSrvyMpngRecord.class;
    }

    /**
     * The column <code>public.instr_usr_srvy_mpng.usr_srvy_mpng_id</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, Integer> USR_SRVY_MPNG_ID = createField("usr_srvy_mpng_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.usr_id</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, Integer> USR_ID = createField("usr_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.srvy_id</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, Integer> SRVY_ID = createField("srvy_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.crtd_usr</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, String> CRTD_USR = createField("crtd_usr", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.lst_updtd_usr</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, String> LST_UPDTD_USR = createField("lst_updtd_usr", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.crtd_time</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, Date> CRTD_TIME = createField("crtd_time", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * The column <code>public.instr_usr_srvy_mpng.lst_updtd_time</code>.
     */
    public final TableField<InstrUsrSrvyMpngRecord, Date> LST_UPDTD_TIME = createField("lst_updtd_time", org.jooq.impl.SQLDataType.DATE, this, "");

    /**
     * Create a <code>public.instr_usr_srvy_mpng</code> table reference
     */
    public InstrUsrSrvyMpng() {
        this("instr_usr_srvy_mpng", null);
    }

    /**
     * Create an aliased <code>public.instr_usr_srvy_mpng</code> table reference
     */
    public InstrUsrSrvyMpng(String alias) {
        this(alias, INSTR_USR_SRVY_MPNG);
    }

    private InstrUsrSrvyMpng(String alias, Table<InstrUsrSrvyMpngRecord> aliased) {
        this(alias, aliased, null);
    }

    private InstrUsrSrvyMpng(String alias, Table<InstrUsrSrvyMpngRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<InstrUsrSrvyMpngRecord> getPrimaryKey() {
        return Keys.INSTR_USR_SRVY_MPNG_PKEY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<InstrUsrSrvyMpngRecord>> getKeys() {
        return Arrays.<UniqueKey<InstrUsrSrvyMpngRecord>>asList(Keys.INSTR_USR_SRVY_MPNG_PKEY, Keys.INSTR_USR_SRVY_MPNG_UK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<InstrUsrSrvyMpngRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<InstrUsrSrvyMpngRecord, ?>>asList(Keys.INSTR_USR_SRVY_MPNG__INSTR_USR_SRVY_MPNG_FK1, Keys.INSTR_USR_SRVY_MPNG__INSTR_USR_SRVY_MPNG_FK2);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InstrUsrSrvyMpng as(String alias) {
        return new InstrUsrSrvyMpng(alias, this);
    }

    /**
     * Rename this table
     */
    public InstrUsrSrvyMpng rename(String name) {
        return new InstrUsrSrvyMpng(name, null);
    }
}
