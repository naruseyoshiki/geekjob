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
public class zenjyohohyouzi extends HttpServlet {

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
                //forNameメソッドでlibフォルダのmysql用のJDBCのドライバを読み込み
                Class.forName("com.mysql.jdbc.Driver");

                //getConnectionメソッドでDB接続、
                //URL[[jdbc:DB種類:DB場所:ポート番号/DB名],ユーザー名,パスワード]
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //SQL文(表示)を変数に格納
                String mozi = "select * from profiles";

                //PreparedStatement変数に「格納したSQL文」と「DB接続」を格納
                PreparedStatement dbps = dbcon.prepareStatement(mozi);
                //ResultSet変数に前に格納した情報を格納し、SQL文の実行
                ResultSet dbrs = dbps.executeQuery();

                //nextメソッドで格納情報の有無を確認、while文で有るだけ処理実行
                //各カラムの情報を表示
                while (dbrs.next()) {
                    out.print("profilesID:" + dbrs.getInt("profilesID")
                            + "<br>name:" + dbrs.getString("name")
                            + "<br>tel:" + dbrs.getString("tel")
                            + "<br>age" + dbrs.getInt("age")
                            + "<br>birthday:" + dbrs.getDate("birthday") + "<br>");
                }

                //操作終了したので各メソッドをクローズする
                dbcon.close();
                dbrs.close();
                dbps.close();

                //例外のあるかもしれない場合の処理
            } catch (SQLException sqle) {
                out.print("エラーがあります。" + sqle.toString());
                //例外のある場合の処理
            } catch (Exception e) {

                out.print("エラーがあります。" + e.toString());
                //例外の有無に関わらず実行する処理
            } finally {
                if (dbcon != null) {
                    try {
                        dbcon.close();

                    } catch (Exception ex) {
                        out.print(ex.getMessage());
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
