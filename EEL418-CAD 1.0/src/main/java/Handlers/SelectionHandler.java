/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Handlers;
import Handlers.Handler;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import postgreConnection.ParametrosDTO;
import postgreConnection.databaseDAO;

/**
 *
 * @author lucas
 */
public class SelectionHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) {
     String jspURL = "/index.jsp";
     String roomName = request.getParameter("roomName");
     String selectedRoom = request.getParameter("selectRoom");
     System.out.println("Selected Room = " + selectedRoom);
     ParametrosDTO dto_o = new ParametrosDTO();
        boolean r;
        r = (new databaseDAO()).doReadDevices(dto_o);
        if(r){
            request.getSession().setAttribute("roomDevices",dto_o.getRoomDevices(selectedRoom));
            System.out.println("Handler Selection OK");
        }
        else{
            request.getSession().setAttribute("roomsDevices","Erro");
        }
     request.getSession().setAttribute("selectedRoom", selectedRoom);
     ParametrosDTO dto_rl = new ParametrosDTO();
        boolean rl;
        rl = (new databaseDAO()).doReadRooms(dto_rl);
        if(rl){
            request.getSession().setAttribute("roomName",dto_rl.getRoomById(selectedRoom));
            System.out.println("Handler Selection OK");
        }
        else{
            request.getSession().setAttribute("roomName","Erro");
        }
    
     return jspURL;
    }
    
}
