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
public class sinahyouzi extends HttpServlet {

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

            //送信した値を各型に変換して格納
            String product = request.getParameter("product");
            int price = Integer.parseInt(request.getParameter("price"));
            Date duedate = Date.valueOf(request.getParameter("duedate"));

            //DB接続のためのクラス宣言DB接続,SQL文取得,SQL文実行
            Connection dbcon = null;
            PreparedStatement dbps = null;
            ResultSet dbrs = null;

            try {
                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //DB接続
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //追加用SQL文
                String mozi = "INSERT INTO sinakanri (product, price, duedate) VALUES (?, ?, ?)";

                //SQL文取得
                dbps = dbcon.prepareStatement(mozi);

                //?に各送信内容を格納
                dbps.setString(1, product);
                dbps.setInt(2, price);
                dbps.setDate(3, duedate);

                //追加SQL文で更新
                dbps.executeUpdate();

                //検索用SQL文、商品一覧機能
                String mozi1 = "SELECT * FROM sinakanri";

                //SQL文実行
                dbrs = dbps.executeQuery(mozi1);

                
                //値の有無、登録商品の表示
                while (dbrs.next()) {
                    out.print("<br>【商品名】：" + dbrs.getString("product")
                            + "<br>価格：" + dbrs.getString("price")
                            + "<br>期限：" + dbrs.getString("duedate"));

                }if(false) {
                    out.print("x");//登録商品が無い場合
                }
                
        //各接続クラスを閉じる
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
