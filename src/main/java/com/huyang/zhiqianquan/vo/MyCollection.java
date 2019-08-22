package com.huyang.zhiqianquan.vo;

import java.util.List;

public class MyCollection {
    private List CWorks;
    private List CTenancys;
    private List CHouses;

    public List getCChatroom() {
        return CChatroom;
    }

    public void setCChatroom(List CChatroom) {
        this.CChatroom = CChatroom;
    }

    private List CChatroom;
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


    public MyCollection(List CWorks,List CTenancys,List CHouses){
        this.CWorks=CWorks;
        this.CTenancys=CTenancys;
        this.CHouses=CHouses;
    }
}
