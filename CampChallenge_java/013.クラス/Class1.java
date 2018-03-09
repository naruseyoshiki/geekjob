/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.PrintWriter;

/**
 *
 * @author guest1Day
 */
public class Class1 {     //親クラス

    protected String name = "";    //フィールド
    protected int age = 0;

    protected void hito1(String n, int a) {     //メソッド(引数)

        this.name = n;        //thisで「変数＝フィールド」を指定
        this.age = a;         //(引数)から2つの変数をそれぞれフィールドに格納

    }

    protected void date(PrintWriter out) {   //メソッド(画面表示引数)
        out.print("私は"+ name + "です。<br>年齢は" + age +"歳です。");
    }
}
