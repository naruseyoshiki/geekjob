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
public class Class1 {

    protected String name = "";
    protected int age = 0;

    protected void hito1(String n, int a) {

        this.name = n;
        this.age = a;

    }

    protected void date(PrintWriter out) {
        out.print("私は"+ name + "です。<br>年齢は" + age +"歳です。");
    }
}
