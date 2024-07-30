package dataProviders;

import org.testng.annotations.DataProvider;

public class DataProviders {
        @DataProvider(name = "sampleDp")
        public static Object[][] sampleDp() {
            return new Object[][]{{}};
        }

    @DataProvider(name = "loginCredentials")
    public static Object[][] loginCredentials() {
        return new Object[][]
                {
                        {"invalidUserName","invalidUserName","admin123"},
                {"invalidPassword","Admin","admin132"},
//                {"emptyInputs","",""},
                {"validCredentials","Admin","admin123"}};
    }
}
