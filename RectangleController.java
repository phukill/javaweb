/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Rectangle;

/**
 *
 * @author Phu Cong
 */
@WebServlet(name = "RectangleController", urlPatterns = {"/RectangleController"})
public class RectangleController extends HttpServlet {

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
        int num = Integer.parseInt(request.getParameter("num"));
        ArrayList<Rectangle> rec = new ArrayList<>();
        Random ran = new Random();
        for(int i = 0; i < num; i++){
            Rectangle r = new Rectangle();           
            r.setX(ran.nextInt(500));
            r.setY(ran.nextInt(500));
            r.setW(ran.nextInt(500 - r.getX()));
            r.setH(ran.nextInt(500 - r.getY()));
            r.setX1(r.getX());
            r.setX2(r.getX()+r.getW());
            r.setX3(r.getH()+r.getY());
            r.setX4(r.getY());
            r.setY1(r.getY());
            r.setY2(r.getY() + r.getH());
            r.setY3(r.getW()+r.getX());
            r.setY4(r.getX());
            
            r.setRed(ran.nextInt(256));
            r.setGreen(ran.nextInt(256));
            r.setBlue(ran.nextInt(256));
            
            rec.add(r);
        }
        request.setAttribute("rec", rec);
        request.getRequestDispatcher("rectangle.jsp").forward(request, response);
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
