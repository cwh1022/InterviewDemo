package com.atguigu.Interview.study.thread;

/**
 * Created on 2019/11/8
 *
 * @author connor.chen
 */
public enum CountryEnum {
    ONE(1, "齐"), TWO(2, "楚"), THREE(3, "燕")
    , FOUR(4, "赵"), FIVE(5, "魏"), SIX(6, "韩");
    private int id;
    private String code;

    CountryEnum(int id, String code) {
        this.id = id;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public int getId() {
        return id;
    }

    public static String forEachIndex(int id){
        CountryEnum[] values = CountryEnum.values();
        for (CountryEnum value : values) {
            if (id == value.getId()){
                return value.getCode();
            }
        }
        return null;
    }
}
