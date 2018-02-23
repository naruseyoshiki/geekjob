/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.camp.servlet;

import java.io.Serializable;
import java.util.Date;

public class ResultData implements Serializable{
    
private Date a;
private String b;

public ResultData(){}

public Date getA(){
    return a;
}

public void setA(Date a){
    this.a = a;
}

public String getB(){
    return b;
}

public void setB(String b){
    this.b =b;
}

}

