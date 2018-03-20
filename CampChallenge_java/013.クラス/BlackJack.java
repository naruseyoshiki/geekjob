/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author guest1Day
 */
public class BlackJack extends HttpServlet {

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
            user U = new user();             //各インスタンス化
            Dealer D = new Dealer();

            ArrayList<Integer> dcard = D.deal();  //Dealer側
            out.print("カードを配ります。<br>");
            D.setCard(dcard);
            D.open();
            while (D.checkSum()) {
                ArrayList<Integer> dhcard = D.hit();
                D.setCard(dhcard);
                D.open();
            }

            ArrayList<Integer> ucard = D.deal();  //User側
            U.setCard(ucard);
            U.open();
            U.checkSum();
            while (U.checkSum()) {
                out.print("Hit。<br>");
                ArrayList<Integer> uhcard = D.hit();
                U.setCard(uhcard);
                U.open();

            }

            int dc = D.open();
            int uc = U.open();
            out.print("オープン。<br>");
            out.print("Dealer　" + dc + "<br>" + "User　" + uc);//結果表示

            if (uc <= 21 && dc < uc || dc > 21 && uc <= 21) { //勝敗
                out.print("<br>Userの勝ちです。");
            } else if (dc <= 21 && dc > uc || uc > 21 && dc <= 21) {
                out.print("<br>Userの負けです。");
            } else if (dc == uc || uc > 21 && dc > 21) {
                out.print("<br>引き分けです。");
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
