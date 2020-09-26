package xin.qust.platform.framework;

import java.util.ArrayList;
import java.util.List;

public class WebModel {

    //pageSize
    private int ps = 10;

    //searchPage
    private int sp = 1;

    //totalPage
    private int tp = 0;

    //totalCount
    private int tc = 0;

    private List data = new ArrayList();

    public void setTotalCount(int count){

        this.tc = count;
        this.tp = count / ps;
        if(count % ps > 0){
            tp = tp + 1;
        }

    }

    public int getLimitStart(){
        return (sp - 1)*ps;
    }

    public int getLimitEnd() {
        return Math.min(sp * ps, getTc());
    }


    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getSp() {
        return sp;
    }

    public void setSp(int sp) {
        this.sp = sp;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }


}