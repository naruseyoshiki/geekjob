/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.Datesousa;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class querystring2 extends HttpServlet {

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
//例１「 84 = 2 * 2 * 3 * 7 」 
//例２「396 = 2 * 2 * 3 * 3 あまり 11 」 
//例３「997 = あまり 997 」 

//・例１にあるように，原則，すべての素数を列挙し，元の値とともに画面表示してください。 
//・例２にあるように，求める素因数は，１桁のもののみとします。
//このとき，分解しきれなかった数については，「あまり○」の要領で表示させてください。 
//・例３にあるように，対象とする数が素数の場合に，「この数は素数です」といった表示
            request.setCharacterEncoding("UTF-8");//受け取る情報の書式設定

            //文字列変数にname属性の情報(入力数値)を代入
            String suuti = request.getParameter("suuti");

            //文字列(入力数値)を数値型に入れ替え、数値型変数に代入
            int y = Integer.parseInt(suuti);

            //入力数値を表示
            out.print(y + "=");

            if (y == 0 || y == 1) {
                out.print("error");
            }

            //1桁素数で「入力数値」を分解する
            while (y % 2 == 0 && y > 0) {
                out.print(2);
                y /= 2;

                if (y >= 2) {
                    out.print("*");
                }
            }
            while (y % 3 == 0 && y > 0) {
                out.print(3);
                y /= 3;

                if (y >= 3) {
                    out.print("*");
                }
            }
            while (y % 5 == 0 && y > 0) {
                out.print(5);
                y /= 5;

                if (y >= 5) {
                    out.print("*");
                }
            }
            while (y % 7 == 0 && y > 0) {
                out.print(7);
                y /= 7;

                if (y >= 7) {
                    out.print("*");
                }
            }
            //1桁素数で分解しきれない数を表示
            if (y != 1) {
                out.print("あまり" + y);
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
