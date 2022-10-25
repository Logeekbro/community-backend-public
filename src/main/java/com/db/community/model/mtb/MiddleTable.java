package com.db.community.model.mtb;


import com.db.community.model.enums.Visible;

import static com.db.community.common.GlobalVars.*;

/**
 * 中间表抽象类
 */
public abstract class MiddleTable {

    private Visible visible = Visible.VISIBLE;

    public MiddleTable() {
    }

    public MiddleTable(Visible visible){
        this.visible = visible;
    }

    abstract String tableName();

    abstract String firstFiledName();

    abstract String secondFiledName();

    public String createTime() {
        return "create_time";
    }

    public String visible(){
        switch (this.visible){
            case VISIBLE:
                return "AND " + VISIBLE_FILED_NAME + "=" + VISIBLE_VALUE;
            case UN_VISIBLE:
                return "AND " + VISIBLE_FILED_NAME + "=" + UN_VISIBLE_VALUE;
            case ALL:
                return "";
        }
        return "AND " + VISIBLE_FILED_NAME + "=" + VISIBLE_VALUE;
    }

}
