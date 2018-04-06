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
import java.time.LocalDate;

/**
 *
 * @author guest1Day
 */
public class zenupdate extends HttpServlet {

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

            //送信情報の書式設定
            request.setCharacterEncoding("UTF-8");

            //各送信情報を文字列変数に格納
            String ID1 = request.getParameter("id1");
            String ID = request.getParameter("id");
            String Na = request.getParameter("N");
            String Te = request.getParameter("T");
            String Ag = request.getParameter("A");
            String Bi = request.getParameter("B");

            //DB操作のためのクラス
            Connection dbcon = null;
            PreparedStatement dbps = null;
            ResultSet dbrs = null;

            try {
                //ドライバ接続
                Class.forName("com.mysql.jdbc.Driver");

                //DB接続
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");

            //更新SQL文を取得
            dbps = dbcon.prepareStatement("update profiles set profilesID = ? where profilesID = ?");
            
            //SQL文の各?に値、現在のIDを格納、DB情報を更新
            dbps.setString(1, ID);
            dbps.setString(2, ID1);
            int z = dbps.executeUpdate();
            
            dbps = dbcon.prepareStatement("update profiles set name = ? where profilesID = ?");
            
            dbps.setString(1, Na);
            dbps.setString(2, ID1);
            int a = dbps.executeUpdate();
            
            dbps = dbcon.prepareStatement("update profiles set tel = ? where profilesID = ?");
            
            dbps.setString(1, Te);
            dbps.setString(2, ID1);
            int b = dbps.executeUpdate();
            
            dbps = dbcon.prepareStatement("update profiles set age = ? where profilesID = ?");
            
            dbps.setString(1, Ag);
            dbps.setString(2, ID1);
            int c = dbps.executeUpdate();
            
            dbps = dbcon.prepareStatement("update profiles set birthday = ? where profilesID = ?");
            
            dbps.setDate(1,Date.valueOf(Bi));
            dbps.setString(2, ID1);
            int d = dbps.executeUpdate();
                 
                //検索SQL文
                String mozi1 = "select * from profiles";

                //各SQL文を格納して実行
                dbrs = dbps.executeQuery(mozi1);

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
