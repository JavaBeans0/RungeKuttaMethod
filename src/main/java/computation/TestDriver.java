package computation;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

public class TestDriver {
    /* Data Fields accessible by whole package */
    protected static InputStream input;
    protected static Properties prop = new Properties();
    protected static TaylorSeriesExpansion seriesExpansion;
    /* Pre-condition to Test Execution */ public static void setParameters() {
        try {
            input = new FileInputStream("/Users/naimul7/JavaProjects/RungeKuttaMethod/src/main/java/config.properties");
            prop.load(input);
            seriesExpansion = new TaylorSeriesExpansion(4, new Interval(0, 3), 0.25, new Differential(1, 1), new Condition(0, 1));
        } catch(FileNotFoundException fnfex) { fnfex.printStackTrace();
        } catch(IOException ioex) { ioex.printStackTrace(); }
    }
    public static void initiate() { System.out.println(seriesExpansion); }
    public static void closePreset() { try { input.close(); } catch(IOException ioex) { ioex.printStackTrace(); } }
    public static void printFormula() { System.out.println(seriesExpansion.printGenericF()); }
}

