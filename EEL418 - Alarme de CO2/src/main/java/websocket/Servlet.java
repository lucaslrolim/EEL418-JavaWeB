package websocket;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/input")
public class Servlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        
        System.out.println("alarme="+request.getParameter("alarme"));
        
        websocket.Servlet.session.getBasicRemote().sendText(
                                   "{\"alarme\":\""+request.getParameter("alarme")+"\"}");
        
        try (PrintWriter out = response.getWriter()) {
            out.print("");
        }
    }
    
    //==== TEM QUE SER STATIC PARA DURAR POR VÁRIOS PEDIDOS! ====
    public static Session session;
        
    @OnOpen
    public void onOpen(Session session) {
        try {
            Servlet.session = session;
            Servlet.session.getBasicRemote().sendText("{\"alarme\":\"false\"}");
            System.out.println("--- OnOpen: Conectou.");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @OnMessage
    public void receber(String arg){

    }

    @OnError
    public void onError(Session session,java.lang.Throwable throwable) {
        System.out.println("--- OnError: "+throwable);
    }

    @OnClose
    public void onClose(Session session,CloseReason reason) {
        System.out.println("--- OnClose: "+reason);
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
