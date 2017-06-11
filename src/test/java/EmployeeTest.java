import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class EmployeeTest {

    private ByteArrayOutputStream out = new ByteArrayOutputStream();
    private Employee employeeFirst = new Employee("Ramon", "Empl1");
    private Employee employeeSecond = new Employee("Michael", "Empl2");
    private Employee manager = new Employee("Alisa", "Manager");
    private Employee ceo = new Employee("John", "Boss");

    @Before
    public void initialize() {
        System.setOut(new PrintStream(out));
        List<Employee> managerSubordinates = Arrays.asList(employeeFirst, employeeSecond);
        List<Employee> ceoSubordinates = Arrays.asList(manager);
        manager.setSubordinates(managerSubordinates);
        ceo.setSubordinates(ceoSubordinates);
    }

    @Test
    public void printCEONameForEmployeeTest(){
        employeeFirst.printCEOName();
        String actual = out.toString();
        String expected = "John Boss";
        assertEquals(actual, expected);
    }

    @Test
    public void printCEONameForManagerTest(){
        manager.printCEOName();
        String actual = out.toString();
        String expected = "John Boss";
        assertEquals(actual, expected);
    }

    @Test
    public void printCEONameForCEOTest(){
        ceo.printCEOName();
        String actual = out.toString();
        String expected = "John Boss";
        assertEquals(actual, expected);
    }

    @Test
    public void printAllSubordinatesForEmployeeTest(){
        employeeFirst.printAllsubordinates();
        String actual = out.toString();
        String expected = "";
        assertEquals(actual, expected);
    }

    @Test
    public void printAllSubordinatesForManagerTest(){
        manager.printAllsubordinates();
        String actual = out.toString();
        String expected = "Ramon Empl1\r\nMichael Empl2\r\n";
        assertEquals(actual, expected);
    }

    @Test
    public void printAllEmployeeFromEmployeeTest(){
        employeeFirst.printAllEmployee();
        String actual = out.toString();
        String expected = "John Boss\r\nRamon Empl1\r\nMichael Empl2\r\nAlisa Manager\r\n";
        assertEquals(actual, expected);
    }

    @Test
    public void printAllEmployeeFromManagerTest(){
        manager.printAllEmployee();
        String actual = out.toString();
        String expected = "John Boss\r\nRamon Empl1\r\nMichael Empl2\r\nAlisa Manager\r\n";
        assertEquals(actual, expected);
    }

    @Test
    public void printAllEmployeeFromCEOTest(){
        System.err.print(System.getProperty("line.separator"));
        ceo.printAllEmployee();
        String actual = out.toString();
        String expected = "John Boss\r\nRamon Empl1\r\nMichael Empl2\r\nAlisa Manager\r\n";
        assertEquals(actual, expected);
    }


    @After
    public void cleanData() {
        System.setOut(null);
        employeeFirst = null;
        employeeSecond = null;
        manager = null;
        ceo = null;
    }
}
