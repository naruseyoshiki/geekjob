/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.Datesousa;

import java.io.IOException;
import java.io.PrintWriter;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
//@WebServlet(urlPatterns = {"/shop_.html"})
public class querystring extends HttpServlet {

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

            request.setCharacterEncoding("UTF-8");//受け取る情報の書式指定

            //各HTMLのname属性の情報を取り出し、文字列変数に代入
            String total = request.getParameter("total");

            String count = request.getParameter("count");

            String type = request.getParameter("type");

            //typeにある文字列を数値型に入れ替え、数値型変数に代入
            int typedate = Integer.parseInt(type);

            //typedateの値から各条件に沿って表示
            switch (typedate) {
                case 1: {
                    out.print("あなたが購入したのは雑貨です。<br>");
                    break;
                }
                case 2: {
                    out.print("あなたが購入したのは生鮮食品です。<br>");
                    break;
                }
                case 3: {
                    out.print("あなたが購入したのはその他です。<br>");
                    break;
                }
            }

            //各文字列を数値に入れ替え数値型変数に代入
            int totaldate = Integer.parseInt(total);
            int countdate = Integer.parseInt(count);

            //「購入総額」を「購入総量」で割り、1個当たりの金額を画面表示
            out.print("購入した商品は1個当たり"+totaldate / countdate+"円です。<br>");

            //「購入総額」が3000以下の場合ポイントは0%
            if (totaldate < 3000) {

                out.print("ポイントはありません。");
                
            //「購入総額」が3000以上かつ5000未満の場合ポイントは4%
            } else if (totaldate > 3000 && totaldate < 5000) {

                //少数点を扱うためdouble型の変数。「購入総額」の4%
                double td4 = totaldate*0.04;
                
                //数値処理のためMathクラス。floorで小数点以下を切捨て。
                out.print("ポイントは"+Math.floor(td4)+"です。");

                
            //「購入総額」が5000以上の場合ポイントは5%
            } else if (totaldate > 5000) {

                double td5 = totaldate*0.05;
                
                out.print("ポイントは"+Math.floor(td5)+"です。");

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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
