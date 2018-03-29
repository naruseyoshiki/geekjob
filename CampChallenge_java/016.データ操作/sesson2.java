/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.Datesousa;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;

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
public class sesson2 extends HttpServlet {

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
//「入力フォームを表示する」「フォームから受け取った値をセッション領域に格納する」
//「セッション領域に値が格納されていればフォームの初期値として表示させる」
//・名前，性別，趣味の情報をフォームによって送信できる。 
//・フォームによって値を送信すると，次回アクセス時に，その値がフォームの初期値となる（セッションかクッキーを利用する）。

            request.setCharacterEncoding("UTF-8");//受け取る情報の書式設定
    
            //各入力フォームを表示
            out.print("名前は"+request.getParameter("name")+"<br>");
            out.print("性別は"+request.getParameter("sei")+"<br>");
            out.print("趣味は"+request.getParameter("syumi")+"<br><br>");
            
            //セッションを取得
            HttpSession hs = request.getSession();
            
            //初期に入力した値を読み込み、表示(初期値)
            out.print("名前初期は"+hs.getAttribute("na")+"<br>");
            out.print("性別初期は"+hs.getAttribute("se")+"<br>");
            out.print("趣味初期は"+hs.getAttribute("sy")+"<br>");
            
            //各入力フォームの値を読み込み、その値を含む各文字列をセッションに書き込む(格納)
            hs.setAttribute("na",request.getParameter("name"));
            hs.setAttribute("se",request.getParameter("sei"));
            hs.setAttribute("sy",request.getParameter("syumi"));
            
            
            //リクエストパラメータの表示
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>フォーム送信結果</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p></p>");
            out.println("</body>");
            out.println("</html>");
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
