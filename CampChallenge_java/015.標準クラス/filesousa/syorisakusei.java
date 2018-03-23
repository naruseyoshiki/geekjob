/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.mypackage.sample.filesousa;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author guest1Day
 */
public class syorisakusei extends HttpServlet {

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
            //Mathクラスを使用

            //Fileクラスでファイルの呼び出し
            File F = new File("zikosyokai.txt");

            //Fのファイルを書き出しのため、インスタンス生成
            FileWriter fw = new FileWriter(F);

            //現在の時刻を取得、インスタンス生成
            Date D = new Date();

            //時刻の書式を指定
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");

            //fwから処理内容を書き出す
            fw.write("5を7の累乗した数と4を8の累乗した数の和について。<br>");

            //指定書式時刻
            fw.write(SDF.format(D) + "処理の開始時刻" + "<br>");

            //Mathクラスの計算のため各変数に代入
            double x = Math.pow(5, 7);
            double y = Math.pow(4, 8);

            double xy = x + y;

            //Mathクラスより計算の答え
            fw.write("答えは" + xy + "です。");

            //指定書式時刻
            fw.write("<br>" + SDF.format(D) + "処理の終了時刻");

            //ファイルをクローズ
            fw.close();

            //ファイルを読み取る
            FileReader fr = new FileReader(F);

            //フェイルの情報を読み出す
            BufferedReader br = new BufferedReader(fr);

            //ファイルの情報から1行を読み出す
            out.print(br.readLine());
            
            //最後にファイルのクローズ　
            br.close();
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
