package domain;

public enum MainFunction {
    REGISTER_ORDER("1", "주문등록"),
    PAY_ORDER("2", "결제하기"),
    QUIT("3", "프로그램 종료");

    private final String key;
    private final String value;
    private static final String MainFunctionErrorMsg = "[ERROR] 실행할 수 없는 기능 입니다." ;

    MainFunction(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public static String print() {
        String print = "## 메인화면" + System.lineSeparator();
        for (MainFunction mainFunction : MainFunction.values()) {
            print += mainFunction.key + " - " + mainFunction.value + System.lineSeparator();
        }
        return print;
    }

    public static MainFunction validate(String userInput) {
        for (MainFunction mainFunction : MainFunction.values()) {
            if(mainFunction.key.equals(userInput)) return mainFunction;
        }
        throw new IllegalArgumentException(MainFunctionErrorMsg);
    }

}
