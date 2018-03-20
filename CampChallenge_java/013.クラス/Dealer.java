/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author guest1Day
 */
public class Dealer extends human {

//    protected int mark = 4;  
//    protected int kazu = 13;

    public int open() {   //myCardsの合計値
        int total = 0;

        for (int i = 0; i < myCards.size(); i++) {
            total = total + myCards.get(i);
        }
        return total;
    }

    // setCardメソッドは、myCardsにcardDataの中身を移す処理を実装する
    public void setCard(ArrayList<Integer> cardData) {
        int total = 0;

        for (int i = 0; i < cardData.size(); i++) {
            total = cardData.get(i);
            myCards.add(total);
            //myCards.add(cardData.get(i));
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
    protected ArrayList<Integer> cards = new ArrayList<Integer>();

//同じ処理を4回行う　cards(山札)にセットする
    public Dealer() {

        for (int m = 0; m < 4; m++) {

            for (int i = 1; i <= 13; i++) {

                if (i >= 11) {
                    cards.add(10);

                } else {
                    cards.add(i);
                }
            }

        }
    }

    public ArrayList<Integer> deal() {  //山札から2枚配る
        ArrayList<Integer> D = new ArrayList<Integer>();
        Random dealcard = new Random();
        //Collections.shuffle(cards);
        for (int i = 0; i < 2; i++) {
        int index = dealcard.nextInt(cards.size());

        //for (int i = 0; i < 2; i++) {
            D.add(cards.get(index));
            cards.remove(index);
        }
        return D;
    }

    public ArrayList<Integer> hit() {  //山札から1枚配る
        ArrayList<Integer> H = new ArrayList<Integer>();
        Random hitcard = new Random();
        Collections.shuffle(cards);
        int index = hitcard.nextInt(cards.size());

        H.add(cards.get(index));
        cards.remove(index);

        return H;
    }
}
