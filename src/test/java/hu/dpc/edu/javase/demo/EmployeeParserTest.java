/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.dpc.edu.javase.demo;

import java.io.Reader;
import java.io.StringReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author IQJB
 */
public class EmployeeParserTest {

    public EmployeeParserTest() {
    }

    public ReadableSource createTestData(final String testData) {
        return new ReadableSource() {

            @Override
            public Reader getReader() {
                return new StringReader(testData);
            }
        };
    }

    @Test
    public void testReadEmployees() {
        //given
        ReadableSource source = createTestData("123,Secretary,Belane,20000\n"
                + "121,Manager,Bela,10000,HR\n"
                + "123,Employee,Feri,30000");
        EmployeeParser parser = new EmployeeParser(source);
        
        //when
        EmployeeIterator it = parser.readEmployees();
        //then
        it.next();
       
        
        
    }

}
