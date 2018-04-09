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

/**
 *
 * @author guest1Day
 */
public class NABandor extends HttpServlet {

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
//名前・年齢・誕生日情報を送信するフォーム
//複合検索処理を記述します。AND検索か，OR検索とするかは，自由

            //フォーム内容の書式設定
            request.setCharacterEncoding("UTF-8");

            //送信内容を各変数に代入
            String NA = request.getParameter("N");
            int AG = Integer.parseInt(request.getParameter("A"));
            Date BA = Date.valueOf(request.getParameter("B"));

            //DB接続のクラス
            Connection dbcon = null;
            PreparedStatement dbps = null;
            ResultSet dbrs = null;

            try {
                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //URLを指定してDB接続
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //2項目を満たす条件の検索用SQL文
                String mozi = "select * from profiles where name =? and age =? and birthday =?";
                
                //SQL文の取得
                dbps = dbcon.prepareStatement(mozi);
                
                //SQL文の各?に送信内容をそれぞれ格納
                dbps.setString(1,NA);
                dbps.setInt(2, AG);
                dbps.setDate(3, BA);
                
                //SQL文の実行
                dbrs = dbps.executeQuery();
                
                while(dbrs.next()){
                    out.print("<br>名前："+dbrs.getString("name")
                    +"<br>年齢："+dbrs.getString("age")
                    +"<br>誕生日："+dbrs.getString("birthday"));
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
