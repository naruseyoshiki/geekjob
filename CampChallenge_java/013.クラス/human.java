/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public abstract class human {

    protected ArrayList<Integer> myCards = new ArrayList<Integer>();

    public abstract int open();

    public abstract void setCard(ArrayList<Integer> cardData);

    public abstract boolean checkSum();

    
    }
