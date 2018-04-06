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
public class recordupdate extends HttpServlet {

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
//profileID カラムでレコードを指定し，profileID 以外のカラムの値を更新してください。
//更新後の値は自由。その後，全件検索を行い，全レコードの全カラムを画面表示
            Connection dbcon = null;

            try {
                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //DB接続
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //更新用SQL文、profilesIDカラムを指定してnameを更新
                String mozi = "update profiles set name =? where profilesID = 1";

                //SQL文取得
                PreparedStatement dbps = dbcon.prepareStatement(mozi);

                //取得したSQL文の?に値を入力
                dbps.setString(1, "成瀬 良輝");

                //DBを更新
                dbps.executeUpdate();

                //検索用SQL文
                String mozi1 = "select * from profiles";

                //更新、検索用SQL文を実行
                ResultSet dbrs = dbps.executeQuery(mozi1);

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
