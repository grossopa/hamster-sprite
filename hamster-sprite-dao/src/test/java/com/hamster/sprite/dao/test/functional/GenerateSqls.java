/**
 * 
 */
package com.hamster.sprite.dao.test.functional;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.hamster.core.api.util.excel2sql.Excel2SQLGenerator;

/**
 * @author <a href="mailto:grossopaforever@gmail.com">Jack Yin</a>
 * @version 1.0
 */
public class GenerateSqls {

    private static final Excel2SQLGenerator generator = new Excel2SQLGenerator();

    public static final void main(String[] args) throws IllegalAccessException, InstantiationException, IOException, InvalidFormatException {
        File excelFile = new File("src/test/resources/sql/test-data.xlsx");
        File output = new File("src/main/resources/sqls/test");

        generator.generate(excelFile, output);
    }
}
