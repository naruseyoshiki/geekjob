/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author guest1Day
 */
public class sinanilogin extends HttpServlet {

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

            request.setCharacterEncoding("UTF-8");

            String NA = request.getParameter("N");
            int PA = Integer.parseInt(request.getParameter("P"));

            Connection dbcon = null;
            PreparedStatement dbps = null;
            ResultSet dbrs = null;

            try {
                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //URLを指定してDB接続
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //検索用SQL文、ユーザー情報の正否確認
                String mozi = "select * from userkanri where name =? and pass =?";

                //SQL文を取得
                dbps = dbcon.prepareStatement(mozi);

                //?にユーザー名、パスワードを格納
                dbps.setString(1, NA);
                dbps.setInt(2, PA);

                //SQL文を実行
                dbrs = dbps.executeQuery();

                //値の有無確認
                if (dbrs.next()) {

                //指定ファイルに受けた各値を送信するRequestDispatcer   
                RequestDispatcher rd = request.getRequestDispatcher("sinaform.jsp");
                rd.forward(request, response);
                
                    
                } else {

                    out.print("ログインできません。");//送信情報に誤り、DBに無い場合
                }

                //DBを閉じる
                dbcon.close();
                dbps.close();
                dbrs.close();
                
            //エラーハンドリング    
            } catch (SQLException sqle) {
                out.print("エラーが発生しました。" + sqle.toString());
            } catch (Exception ex) {
                out.print("エラーが発生しました!" + ex.toString());
            } finally {
                if (dbcon != null) {
                    try {
                        dbcon.close();

                    } catch (Exception e) {
                        out.print(e.getMessage());
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
