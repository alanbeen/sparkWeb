/**
 * This class is generated by jOOQ
 */
package com.huaxia.generated.tables;


import com.huaxia.generated.Keys;
import com.huaxia.generated.Test;
import com.huaxia.generated.tables.records.RolesRecord;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Generated;

import org.jooq.Field;
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
        "jOOQ version:3.8.0"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Roles extends TableImpl<RolesRecord> {

    private static final long serialVersionUID = 679856999;

    /**
     * The reference instance of <code>test.roles</code>
     */
    public static final Roles ROLES = new Roles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RolesRecord> getRecordType() {
        return RolesRecord.class;
    }

    /**
     * The column <code>test.roles.role_id</code>.
     */
    public final TableField<RolesRecord, Integer> ROLE_ID = createField("role_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * The column <code>test.roles.role_name</code>.
     */
    public final TableField<RolesRecord, String> ROLE_NAME = createField("role_name", org.jooq.impl.SQLDataType.VARCHAR.length(255).nullable(false), this, "");

    /**
     * Create a <code>test.roles</code> table reference
     */
    public Roles() {
        this("roles", null);
    }

    /**
     * Create an aliased <code>test.roles</code> table reference
     */
    public Roles(String alias) {
        this(alias, ROLES);
    }

    private Roles(String alias, Table<RolesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Roles(String alias, Table<RolesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Test.TEST;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<RolesRecord> getPrimaryKey() {
        return Keys.KEY_ROLES_PRIMARY;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<RolesRecord>> getKeys() {
        return Arrays.<UniqueKey<RolesRecord>>asList(Keys.KEY_ROLES_PRIMARY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Roles as(String alias) {
        return new Roles(alias, this);
    }

    /**
     * Rename this table
     */
    public Roles rename(String name) {
        return new Roles(name, null);
    }
}
