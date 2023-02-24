package TestSuite;

import computation.TestDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class TestCases {
    @BeforeTest public static void testPreset() { TestDriver.setParameters(); }
    @Test public static void testObject() { TestDriver.initiate(); }
    @Test public static void testFormula() { TestDriver.printFormula(); }
    @AfterTest public static void testClosePreset() { TestDriver.closePreset(); }
}
