package com.jdjr.dbsync.common.gtid;

import com.jdjr.cds.binlog.parser.alter.*;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.alter.AlterExpression;
import net.sf.jsqlparser.statement.create.table.Index;
import org.junit.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
}
