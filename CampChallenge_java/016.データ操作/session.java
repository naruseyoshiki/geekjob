/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.Datesousa;

import java.util.Date;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpSession;
import java.net.URLDecoder;
import java.net.URLEncoder;

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
public class session extends HttpServlet {

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

            //書式指定済みの現在の時刻を表示
            out.print("現在の時刻は" + SDF.format(date) + "です。<br>");
       
            //セッションを取得
            HttpSession S = request.getSession();
                        
            //セッションに時刻を取得し、その値が入っているかnullで確認
            if(S.getAttribute("date") != null){
                
                //改めて時刻を取得及び表示する
                out.print("前回のログイン時刻は"+S.getAttribute("date"));
            }
            //書式取得済みの時刻をセッションに書き込み(今回の表示時刻を残す)
            S.setAttribute("date",SDF.format(date));

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
