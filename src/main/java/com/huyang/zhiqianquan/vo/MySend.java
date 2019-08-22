package com.huyang.zhiqianquan.vo;

import java.util.List;

public class MySend {
    private List SChartroom;

    public MySend(List SChartroom, List STenancy, List SWork, List SHouse) {
        this.SChartroom = SChartroom;
        this.STenancy = STenancy;
        this.SWork = SWork;
        this.SHouse = SHouse;
    }

    public List getSChartroom() {
        return SChartroom;
    }

    public void setSChartroom(List SChartroom) {
        this.SChartroom = SChartroom;
    }

    public List getSTenancy() {
        return STenancy;
    }

    public void setSTenancy(List STenancy) {
        this.STenancy = STenancy;
    }

    public List getSWork() {
        return SWork;
    }

    public void setSWork(List SWork) {
        this.SWork = SWork;
    }

    public List getSHouse() {
        return SHouse;
    }

    public void setSHouse(List SHouse) {
        this.SHouse = SHouse;
    }

    private List STenancy;
    private List SWork;
    private List SHouse;
}
