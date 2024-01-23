package vn.oceantech.l3pre.constants;

public class Constant {
    public static final String REGEX_PHONE_NUMBER = "^\\d{10,11}$";
    public static final String REGEX_IDENTIFICATION_NUMBER = "^\\d{9}|\\d{12}$";
    public static final String REGEX_EMAIL = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final int AGE_18 = 18;
    public static final int AGE_60 = 60;
    public static final int EXIST_LEADER = 1;
    public static final int EXIST_EMPLOYEE = 1;
    public static final int EXIST_ENDED_INFORMATION = 1;
    public static final int EXIST_FAMILY_RELATIONSHIP = 1;
    public static final int EXIST_RECORD_ENDED_PROFILE = 1;
    public static final int EXIST_CERTIFICATE = 1;
    public static final int MIN_ID_VALUE = 1;
    public static final int MIN_NUMBER_OF_TIMES_VALUE = 1;
    public static final int SALARY_RANK_MIN_VALUE = 0;
    public static final int SALARY_MIN_VALUE = 1000000;
    public static final int SALARY_MAX_VALUE = 1000000000;
}
