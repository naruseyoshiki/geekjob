/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author guest1Day
 */
public class im2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    String[] modoriti(String p){
        String[] prof ={"1", "1996-01-01", "tokyo"};
        String[] prof1={"2", "1996-01-03", null};
        String[] prof2={"3", "1996-01-02", "kanagawa"};
       if(p.equals(prof[0])){  //呼び出し側と「特定の情報」の場所を比較
           return prof;
       }else if(p.equals(prof1[0])){
           return prof1;
       }else if(p.equals(prof2[0])){
           return prof2;
       }else
           return prof2;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
                   
        for(int i=0 ; i<=2 ; i++){    //「全体(prof-prof2)」の繰り返し
          String[] p =modoriti(String.valueOf(i+1));//メソッド呼び出し＝先に数値から文字列変換
            for(int j=0 ; j<=2 ; j++){  //「全体」の「特定の情報」の中を繰り返し
           /* if(j==2){
                continue;
            }    */
           if(p[j]==null){   //nullを何番目でも指定できる
               continue;
           }
          out.print(p[j]+"<br>");  //「特定の情報」から指定
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
