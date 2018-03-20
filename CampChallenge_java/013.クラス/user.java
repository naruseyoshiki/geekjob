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
public class user extends human {

    // myCardsの中身を全部合計する
    public int open() {
        int total = 0;

        for (int i = 0; i < myCards.size(); i++) {
            total = total + myCards.get(i);
        }

        return total;
    }

    // setCardメソッドは、myCardsにcardDataの中身を移す処理を実装する
    public void setCard(ArrayList<Integer> cardData) {
        for (int i = 0; i < cardData.size(); i++) {

            myCards.add(cardData.get(i));
        }
    }

//openメソッドのカードの合計値からhitするか判断する
    public boolean checkSum() {
        if (open() <= 17) {
            return true;
        } else {
            return false;
        }
    }
}
