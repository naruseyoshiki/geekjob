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
public class tablekakunou extends HttpServlet {

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
//Connection、preparedStatementクラス
            Connection dbcon = null;
            PreparedStatement dbps = null;
//forNameメソッドのlibフォルダにあるmysql用のJDBCのドライバのインスタンス生成
            try {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
//getConnectionメソッドでDB接続、URL[jdbc:DB種類://データベース場所:ポート番号//DB名,ユーザー名,パス]
                dbcon = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db", "naruse", "1015");
//prepareStatementメソッドでSQL文を挿入、追加する値を[?]にする
                dbps = dbcon.prepareStatement("INSERT INTO profiles(profilesID,name,tel,age,birthday) VALUES (?,?,?,?,?)");
//prepareStatement変数に値を格納、[?番号,値]DateはvalueOfでStringに変換してから格納
                dbps.setInt(1, 6);
                dbps.setString(2, "成瀬");
                dbps.setString(3, "045-312-2231");
                dbps.setInt(4, 21);
                dbps.setDate(5, Date.valueOf("1996-10-15"));
                
                dbps.executeUpdate();
//操作が終了したら各メソッドをクローズ
                dbcon.close();
                dbps.close();
//例外が発生するかもしれない時の処理         
            } catch (SQLException sqle) {
                out.print("データに接続できません。" + sqle.toString());
//例外が発生した時の処理
            } catch (Exception e) {
                out.print("データに接続できません!" + e.toString());
//例外の有無に関わらず行う処理                
            } finally {
                //データの有無を確認
                if (dbcon != null) {
                    //必ずクローズするように記述、try実行処理
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
