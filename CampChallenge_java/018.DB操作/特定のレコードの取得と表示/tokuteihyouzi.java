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
public class tokuteihyouzi extends HttpServlet {

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

            //Connectionクラス
            Connection dbcon = null;

            try {
                //forNameメソッドでlidフォルダのmysql用のJDBCのドライバを読み込み
                Class.forName("com.mysql.jdbc.Driver");

                //DB接続、URL[[jdbc:DB種類://DB場所:ポート番号/DB名],ユーザー名,パスワード]
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

                //SQL文を文字列変数に格納
                String mozi = "select * from profiles where profilesID = ?";

                //DB情報とSQL文を格納した変数を格納及び取得
                PreparedStatement dbps = dbcon.prepareStatement(mozi);

                //SQL文の?に値を指定
                dbps.setInt(1, 1);
                
                //SQL文の実行
                ResultSet dbrs = dbps.executeQuery();
//情報の有無の確認、情報の画面表示
                while (dbrs.next()) {

                    out.print("profilesID:" + dbrs.getString("profilesID")
                            + "<br>name:" + dbrs.getString("name")
                            + "<br>tel:" + dbrs.getString("tel")
                            + "<br>age:" + dbrs.getInt("age")
                            + "<br>birthday:" + dbrs.getString("birthday")
                    );

                }
//各メソッドを閉じる
                dbcon.close();
                dbps.close();
                dbrs.close();
//エラーハンドリングtry-catch-finally
            } catch (SQLException sqle) {
                out.print("エラーがあります。" + sqle.toString());
            } catch (Exception ex) {
                out.print("エラーがあります!" + ex.toString());
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
