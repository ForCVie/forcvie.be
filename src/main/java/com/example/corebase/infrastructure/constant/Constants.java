package com.example.corebase.infrastructure.constant;

public class Constants {

    private Constants(){

    }

    public static final String ENCODING_UTF8 = "UTF-8";

    public class FileProperties {
        private FileProperties() {
        }

        public static final String PROPERTIES_APPLICATION = "application.properties";
        public static final String PROPERTIES_MESSAGE_VN = "message/message.vn.properties";
        public static final String PROPERTIES_MESSAGE_EN = "message/message.en.properties";
    }
    public static final String ROLE_ADMIN = "10210";
    public static final String ROLE_STAFF = "10220";
    public static final String ROLE_CLIENT = "10230";

    public static final String STATE_Y = "Y";
    public static final String STATE_N = "N";
    public static final String BANNER_TYPE_HOME = "BANNER_TYPE_HOME";
    public static final String Q_A_STATUS_QUESTION = "QUESTION";
    public static final String Q_A_STATUS_ANSWER = "ANSWER";
    public static final String Q_A_STATUS_REJECT = "REJECT";
    public static final String NOTICE_TOP = "10511";
    public static final String NOTICE_DOWN = "10512";
}
