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

import java.sql.*;//データベース操作のためjava.sqlパッケージのクラスをワイルドカード*でまとめてインポート

/**
 *
 * @author guest1Day
 */
public class errorhandling extends HttpServlet {

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

            //forNameメソッドでlibフォルダにあるmysql用のJDBCドライバのインスタンス生成
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                //getConnectionメソッドでDB接続、URLは[jdbc:DB種類://接続先:ポート番号/DB名,ユーザ名,パス]              
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");
//処理が終わったら閉じるclose
                dbcon.close();
//例外が発生するかもしれない処理                
            } catch (SQLException sqle) {

                out.print("接続時にエラーが発生しました。" + sqle.toString());
//例外が発生した時に行う処理
            } catch (Exception e) {

                out.print("接続時にエラーが発生しました。" + e.toString());
//例外が発生しても、しなくても行う処理            
            } finally {
//中身の有無を確認                
                if (dbcon != null) {

                    try {
//例外が発生しても必ず閉じれるようにする                        
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
