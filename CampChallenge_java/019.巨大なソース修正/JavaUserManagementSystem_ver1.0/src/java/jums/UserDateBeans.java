/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author guest1Day フォームから受け取ったデータ自体を格納できるJavaBeans(UserDataBeans.java)
 * これを利用して表示や分岐などをさせる
 */
public class UserDateBeans implements Serializable {

    //各フォームの値を各変数に格納
    private String name;
    private Date birthday;
    private Date year;
    private Date month;
    private Date day;
    private Integer type;
    private String tell;
    private String comment;

    //メソッド名
    public UserDateBeans() {
    }

    //各エラー値、フォームが未入力
    public Integer errorI = null;
    public String errorS = null;
    public Date errorD = null;

    //フォームの値が全て入っているかの有無判断、
    //1つでも無ければfalse
    public boolean cheak = true;

    //以下各フォーム値の取得と送信
    public String getname() {
        if (name.equals("")) {
            cheak = false;
            return errorS;
        } else {
            return name;
        }
    }

    public void setname(String name) {
        this.name = name;
    }

    public Date getbirthday() {
        if (birthday.equals("----年--月--日")) {
            cheak = false;
            return errorD;
        } else {
            return birthday;
        }
    }

    public void setbirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getyear() {
        if (year.equals("----")) {
            cheak = false;
            return errorD;
        } else {
            return year;
        }
    }

    public void setyear(Date year) {
        this.year = year;
    }

    public Date getmonth() {
        if (month.equals("--")) {
            cheak = false;
            return errorD;
        } else {
            return month;
        }
    }

    public void setmonth(Date month) {
        this.month = month;
    }

    public Date getday() {
        if (day.equals("--")) {
            cheak = false;
            return errorD;
        } else {
            return day;
        }
    }

    public void setday(Date day) {
        this.day = day;
    }

    public Integer gettype() {
        if (type.equals("")) {
            cheak = false;
            return errorI;
        } else {
            return type;
        }
    }

    public void settype(Integer type) {
        this.type = type;
    }

    public String gettell() {
        if (tell.equals("")) {
            cheak = false;
            return errorS;
        } else {
            return tell;
        }
    }

    public void settell(String tell) {
        this.tell = tell;
    }

    public String getcomment() {
        if (comment.equals("")) {
            cheak = false;
            return errorS;
        } else {
            return comment;
        }
    }

    public void setcomment(String comment) {
        this.comment = comment;
    }

    //ここで全ての値が入力済か確認
    public boolean getcheak() {
        return cheak;
    }

    //各フォームの未入力があった場合セッションのクリア
    //getメソッドがerrorにあたる場合に適用
    public String Sclear(String clear) {
        if (clear == null) {
            clear = "";
            return clear;
        } else {
            return clear;
        }
    }

    //confirm.jspへアクセス済か確認
    public String Accessed(String access, String no) {
        if (access.equals("yes")) {
            return access;
        }
        return no;
        
    }

}
