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
public class recorddelete extends HttpServlet {

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

            Connection dbcon = null;

            try {

                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //DB接続、DBURL、ユーザーを指定
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //SQL文削除用を格納
                String mozi = "delete from profiles where profilesID = ?";

                //削除用SQL文を取得
                PreparedStatement dbps = dbcon.prepareStatement(mozi);

                //削除用SQL文の?に値を入力
                dbps.setInt(1, 6);

                //DBを更新
                dbps.executeUpdate();

                //検索用SQL文を格納
                String mozi2 = "select * from profiles";

                //削除用SQL文、検索用SQL文を格納し、実行
                ResultSet dbrs = dbps.executeQuery(mozi2);

                while (dbrs.next()) {
                    out.print("<br>profilesID:" + dbrs.getInt("profilesID")
                            + "<br>name:" + dbrs.getString("name")
                            + "<br>tel:" + dbrs.getString("tel")
                            + "<br>age:" + dbrs.getInt("age")
                            + "<br>birthday:" + dbrs.getDate("birthday"));
                }
                dbcon.close();
                dbps.close();
                dbrs.close();

            } catch (SQLException sqle) {
                out.print("エラーが発生しました。" + sqle.toString());
            } catch (Exception ex) {
                out.print("エラーが発生しました！" + ex.toString());
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
