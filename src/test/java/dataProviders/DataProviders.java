package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
        @DataProvider(name = "sampleDp")
        public static Object[][] sampleDp() {
            return new Object[][]{{}};
        }
}
