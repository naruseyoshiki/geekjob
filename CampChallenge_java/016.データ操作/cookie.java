/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.Datesousa;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.Cookie;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class cookie extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            //Dateクラスで現在の時刻を取得
            Date date = new Date();

            //書式を指定
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");

            //文字列変数に書式を指定した現在の時刻
            String D = SDF.format(date);

            //書式指定済みの現在の時刻を表示
            out.print("現在の時刻は" + D + "です。");

            //
            //Cookie C = new Cookie("date",D);
            //文字列変数に現在の時刻と書式を通信に適した形へ変換して代入
            String encode = URLEncoder.encode(D, "UTF-8");

            //クッキーへ変換済みの時刻を代入
            Cookie C = new Cookie("date", encode);

            //cookieに反映、次のアクセスから反映した値が使用できる
            response.addCookie(C);

            //配列でcookieを取得
            Cookie[] CS = request.getCookies();

            //値が入っているかnullで確認
            if (CS != null) {

                //配列を回して値を確認していく
                for (int i = 0; i < CS.length; i++) {

                    //配列のName属性を取り出し、dateと比較する
                    if (CS[i].getName().equals("date")) {

                        //文字列変数に配列から取り出した値を代入
                        String Cdate = CS[i].getValue();

                        //文字列変数に配列を元の文字列に戻す
                        String dcode = URLDecoder.decode(Cdate, "UTF-8");

                        //元に戻した文字列を表示
                        out.print(dcode);
                        break;
                    }
                }
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
