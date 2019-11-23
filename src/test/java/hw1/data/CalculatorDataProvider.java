package hw1.data;


import org.testng.annotations.DataProvider;

public class CalculatorDataProvider {
    @DataProvider(name = "Sum Long Type Data")
    public Object[][] sumLongData() {
        return new Object[][]{
                {10l, 128l, 138l},
                {10l, -128l, -118l},
                {Long.MIN_VALUE, Long.MAX_VALUE, -1l},
                {0l, 0l, 0l},
                {0, -256, -256l},
                {256, 0, 256l}
        };
    }

    @DataProvider(name = "Sum Double Type Data")
    public Object[][] sumDoubleData() {
        return new Object[][]{
                {10.1, 128.9, 139.0},
                {10.1, -128.9, -118.8},
                {0f, 0f, 0.0},
                {0, -256.99, -256.99},
                {256, 0f, 256}
        };
    }

    @DataProvider(name = "Sub Long Type Data")
    public Object[][] subLongData() {
        return new Object[][]{
                {10l, 128l, -118l},
                {10l, -128l, 138l},
                {Long.MAX_VALUE, Long.MAX_VALUE, 0l},
                {0l, 0l, 0l},
                {0, -256, 256l},
                {256, 0, 256l}
        };
    }

    @DataProvider(name = "Sub Double Type Data")
    public Object[][] subDoubleData() {
        return new Object[][]{
                {10.1, 128.9, -118.8},
                {10.1, -128.9, 139},
                {0f, 0f, 0.0},
                {0, -256.99, 256.99},
                {256, 0f, 256}
        };
    }

    @DataProvider(name = "Mult Long Type Data")
    public Object[][] multLongData() {
        return new Object[][]{
                {10l, 128l, 1280l},
                {10l, -128l, -1280l},
                {0l, 0l, 0l},
                {0, -256, 0},
        };
    }

    @DataProvider(name = "Mult Double Type Data")
    public Object[][] multDoubleData() {
        return new Object[][]{
                {10.1, 128.9, 1301.89},
                {10.1, -128.9, -1301.89},
                {0f, 0f, 0.0},
                {0, -256.99, 0},
                {256, 0f, 0}
        };
    }

    @DataProvider(name = "Div Long Type Correct Data")
    public Object[][] divLongCorrectData() {
        return new Object[][]{
                {10l, 128l, 0l},
                {128l, -10l, -12l},
                {0l, 10l, 0l},
                {-10, -5, 2},
        };
    }

    @DataProvider(name = "Div Double Type Correct Data")
    public Object[][] divDoubleData() {
        return new Object[][]{
                {10.1, 128.9, 0.07835531419705197},
                {-128.9, 10.1, -12.762376237623764},
                {0f, 10f, 0.0},
                {0, -256.99, 0},
        };
    }

    @DataProvider(name = "Div Long Type Incorrect Data")
    public Object[][] divLongIncorrectData() {
        return new Object[][]{
                {10l, 0l, 0l}
        };
    }

    @DataProvider(name = "Div Double Type Incorrect Data")
    public Object[][] divDoubleIncorrectData() {
        return new Object[][]{
                {10, 0.0, 0.0}
        };
    }
}
