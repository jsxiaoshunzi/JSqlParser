/*-
 * #%L
 * JSQLParser library
 * %%
 * Copyright (C) 2004 - 2020 JSQLParser
 * %%
 * Dual licensed under GNU LGPL 2.1 or Apache License 2.0
 * #L%
 */
package net.sf.jsqlparser.test;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import org.junit.Test;

import java.io.StringReader;

/**
 * @Author: caoguoshun@jd.com
 * @Date: 2020/10/14 11:49
 * @DESCRIPTION:
 */
public class DDLTest {


    /**
     * 只测试
     * */
    @Test
    public void indexTest() throws JSQLParserException {
        String sql="ALTER TABLE `hello`.`time_check`\n" +
                "CHANGE COLUMN `field1` `field2`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `name`,\n" +
                "ADD COLUMN `field1`  varchar(255) NULL AFTER `name`,ADD COLUMN `field11`  varchar(255) NULL AFTER `name`,\n" +
                "ADD COLUMN `firsst`  varchar(255) NULL FIRST ,\n" +
                "MODIFY COLUMN `field1`  varchar(128) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL AFTER `name`,\n" +
                "DROP PRIMARY KEY ,\n" +
                "ADD PRIMARY KEY (`id`, `firsst`),\n" +
                "DROP INDEX `unique` ,\n" +
                "ADD UNIQUE INDEX `unique` (`id`, `create_time`),\n" +
                "DROP COLUMN `field2`,\n" +
                "DROP INDEX `index_1` ,\n" +
                "ADD INDEX `index_1` (`name`(2), `field1`, `field2`) USING BTREE";
        Statement parse = CCJSqlParserUtil.parse(new StringReader(sql));
        Alter alter= (Alter) parse;

    }

    @Test
    public void truncateTest() throws JSQLParserException {
        String sql="TRUNCATE `time_check`";
        Statement parse = CCJSqlParserUtil.parse(new StringReader(sql));
        System.out.println(parse);
    }


    @Test
    public void alterTableRename() throws JSQLParserException{
        String sql="ALTER TABLE `time_check` \n" +
                "RENAME  `time_check_new` ,\n" +
                "COMMENT '我的注释'";
        Statement parse = CCJSqlParserUtil.parse(new StringReader(sql));
        System.out.println(parse);
    }

    @Test
    public void rename() throws JSQLParserException {
        String sql="RENAME TABLE s1.new_table3 to s1.new_table3_rename";
        Statement parse = CCJSqlParserUtil.parse(new StringReader(sql));
        System.out.println(parse);
    }

    @Test
    public void  createTable() throws JSQLParserException{
        String sql="CREATE TABLE `new_table` (\n" +
                "`id`  int NOT NULL ,\n" +
                "`field1`  varchar(255) NOT NULL DEFAULT 'field1' COMMENT 'comment nothing else' ,\n" +
                "`field2`  varchar(255) NULL DEFAULT NULL COMMENT 'comment nothing else2' ,\n" +
                "`index_field_1`  bigint NULL ,\n" +
                "`index_filed_2`  bigint NULL ,\n" +
                "PRIMARY KEY (`id`),\n" +
                "UNIQUE `index_1` (`index_field_1`) ,\n" +
                "UNIQUE KEY `index_1` (`index_field_1`) ,\n" +
                "UNIQUE INDEX `index_1` (`index_field_1`) ,\n" +
                "INDEX `index_2` (`index_filed_2`, `index_field_1`)\n" +
                ")\n" +
                "COMMENT='table comment'";
        Statement parse = CCJSqlParserUtil.parse(new StringReader(sql));
        System.out.println(parse);

    }

}
