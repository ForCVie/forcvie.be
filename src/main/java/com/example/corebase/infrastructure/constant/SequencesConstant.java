package com.example.corebase.infrastructure.constant;

public enum SequencesConstant {

    CODE_MNG("CODE_MNG", "CODE"),
    FILE_MNG("FILE_MNG", "FILE"),
    CPS_MENU_MNG("MENU", "CMM"),
    SYS_ROLE_MNG("sys_role", "RL"),
    MENU_ROLE("menu_role", "MR"),
    CPS_MODULE_MNG("CPS_MODULE_MNG", "CMD"),
    CPS_PERMISSION("CPS_PERMISSION", "CPM"),
    CPS_API_MENU_PERMISSION("CPS_API_MENU_PERMISSION", "CAMP"),
    BANNER("banner", "BAN"),
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
