package com.huyang.zhiqianquan.vo;

import java.util.List;

public class MyCollection {
    private List CWorks;

    public List getCWorks() {
        return CWorks;
    }

    public void setCWorks(List CWorks) {
        this.CWorks = CWorks;
    }

    public List getCTenancys() {
        return CTenancys;
    }

    public void setCTenancys(List CTenancys) {
        this.CTenancys = CTenancys;
    }

    public List getCHouses() {
        return CHouses;
    }

    public void setCHouses(List CHouses) {
        this.CHouses = CHouses;
    }

    private List CTenancys;
    private List CHouses;
    public MyCollection(List CWorks,List CTenancys,List CHouses){
        this.CWorks=CWorks;
        this.CTenancys=CTenancys;
        this.CHouses=CHouses;
    }
}
