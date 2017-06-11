/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;

import Handlers.Handler;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.Room;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import postgreConnection.BaseDAO;
/**
 *
 * @author lucas
 */
public class Controller extends HttpServlet {
    
    
    List<Room> roomList = new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF8");
        response.setCharacterEncoding("UTF8");
        Handler handler;
        try {
            System.out.println("Handler OK");
            String handlerName = request.getParameter("handlerName");
            handler = (Handler) Class.forName(handlerName).newInstance();
            String responsePage = handler.process(request, response);
            request.getRequestDispatcher(responsePage).forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("EXCESSAO_CONTROLLER", e.toString());
            request.getRequestDispatcher("/erro.jsp").forward(request, response);
        }

    }
    
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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


