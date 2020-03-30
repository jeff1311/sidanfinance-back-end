package com.ljf.sidanfinance.dao.model;

import javax.persistence.*;

@Table(name = "calendar")
public class Calen {
    @Id
    private String dt;

    private String dt2;

    private String yr;

    private String mm;

    private String dd;

    @Column(name = "day_of_week")
    private String dayOfWeek;

    @Column(name = "week_num")
    private String weekNum;

    private String qr;

    @Column(name = "bourse_week")
    private String bourseWeek;

    private String yrmm;

    @Column(name = "week_begin")
    private String weekBegin;

    @Column(name = "week_end")
    private String weekEnd;

    public Calen(String dt, String dt2, String yr, String mm, String dd, String dayOfWeek, String weekNum, String qr, String bourseWeek, String yrmm, String weekBegin, String weekEnd) {
        this.dt = dt;
        this.dt2 = dt2;
        this.yr = yr;
        this.mm = mm;
        this.dd = dd;
        this.dayOfWeek = dayOfWeek;
        this.weekNum = weekNum;
        this.qr = qr;
        this.bourseWeek = bourseWeek;
        this.yrmm = yrmm;
        this.weekBegin = weekBegin;
        this.weekEnd = weekEnd;
    }

    public Calen() {
        super();
    }

    /**
     * @return dt
     */
    public String getDt() {
        return dt;
    }

    /**
     * @param dt
     */
    public void setDt(String dt) {
        this.dt = dt == null ? null : dt.trim();
    }

    /**
     * @return dt2
     */
    public String getDt2() {
        return dt2;
    }

    /**
     * @param dt2
     */
    public void setDt2(String dt2) {
        this.dt2 = dt2 == null ? null : dt2.trim();
    }

    /**
     * @return yr
     */
    public String getYr() {
        return yr;
    }

    /**
     * @param yr
     */
    public void setYr(String yr) {
        this.yr = yr == null ? null : yr.trim();
    }

    /**
     * @return mm
     */
    public String getMm() {
        return mm;
    }

    /**
     * @param mm
     */
    public void setMm(String mm) {
        this.mm = mm == null ? null : mm.trim();
    }

    /**
     * @return dd
     */
    public String getDd() {
        return dd;
    }

    /**
     * @param dd
     */
    public void setDd(String dd) {
        this.dd = dd == null ? null : dd.trim();
    }

    /**
     * @return day_of_week
     */
    public String getDayOfWeek() {
        return dayOfWeek;
    }

    /**
     * @param dayOfWeek
     */
    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek == null ? null : dayOfWeek.trim();
    }

    /**
     * @return week_num
     */
    public String getWeekNum() {
        return weekNum;
    }

    /**
     * @param weekNum
     */
    public void setWeekNum(String weekNum) {
        this.weekNum = weekNum == null ? null : weekNum.trim();
    }

    /**
     * @return qr
     */
    public String getQr() {
        return qr;
    }

    /**
     * @param qr
     */
    public void setQr(String qr) {
        this.qr = qr == null ? null : qr.trim();
    }

    /**
     * @return bourse_week
     */
    public String getBourseWeek() {
        return bourseWeek;
    }

    /**
     * @param bourseWeek
     */
    public void setBourseWeek(String bourseWeek) {
        this.bourseWeek = bourseWeek == null ? null : bourseWeek.trim();
    }

    /**
     * @return yrmm
     */
    public String getYrmm() {
        return yrmm;
    }

    /**
     * @param yrmm
     */
    public void setYrmm(String yrmm) {
        this.yrmm = yrmm == null ? null : yrmm.trim();
    }

    /**
     * @return week_begin
     */
    public String getWeekBegin() {
        return weekBegin;
    }

    /**
     * @param weekBegin
     */
    public void setWeekBegin(String weekBegin) {
        this.weekBegin = weekBegin == null ? null : weekBegin.trim();
    }

    /**
     * @return week_end
     */
    public String getWeekEnd() {
        return weekEnd;
    }

    /**
     * @param weekEnd
     */
    public void setWeekEnd(String weekEnd) {
        this.weekEnd = weekEnd == null ? null : weekEnd.trim();
    }
}