/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2019 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.statement.rename;

import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.StatementVisitor;


public class Rename implements Statement {

    private String type;
    private Table oldTable;
    private Table newTable;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Table getOldTable() {
        return oldTable;
    }

    public void setOldTable(Table oldTable) {
        this.oldTable = oldTable;
    }

    public Table getNewTable() {
        return newTable;
    }

    public void setNewTable(Table newTable) {
        this.newTable = newTable;
    }

    @Override
    public void accept(StatementVisitor statementVisitor) {
        statementVisitor.visit(this);
    }
}
