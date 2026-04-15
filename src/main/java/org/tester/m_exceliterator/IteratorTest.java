package org.tester.m_exceliterator;

import java.util.List;

/**
 * @created : 01/04/2026,00:56,mer.
 **/
public class IteratorTest extends ReadMultiple{
    public static void main(String[] args) {
        String f="TestDataFolders/log.xlsx";
        List<String> p=getProductInfo(f,"product3","qoy",0);
        System.out.println(p);
    }
}
