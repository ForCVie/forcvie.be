package com.example.corebase.infrastructure.constant;

public enum SequencesConstant {

    CODE_MNG("CODE_MNG", "CODE"),
    FILE_MNG("FILE_MNG", "FILE"),
    CPS_MENU_MNG("MENU", "CMM"),
    SYS_ROLE_MNG("sys_role", "RL"),
    MENU_ROLE("menu_role", "MR"),
    BANNER("banner", "BAN"),
    BANNER_TEE("banner_tee", "BAN"),
    POPUP_NOTICE("popup_notice", "BAN"),
    NOTICE("notice", "NO"),
    STAFF_MNG("staff_mng", "ST"),
    USER_MNG("user_mng", "CL"),
    OWNER_MNG("owner_mng", "ON"),
    USER_ADDRESS_MNG("user_address", "UA"),
    FOOD_STORE("food_store", "FS"),
    TABLE_THREE("TBL_THREE", "T3");

    private final String tableName;
    private final String prefix;

    SequencesConstant(String tableName, String prefix) {
        this.tableName = tableName;
        this.prefix = prefix;
    }

    public String getTableName() {
        return tableName;
    }

    public String getPrefix() {
        return prefix;
    }
}
