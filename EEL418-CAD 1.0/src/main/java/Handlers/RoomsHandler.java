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


public class RoomsHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        String jspURL = "/rooms.jsp";
        String roomName = request.getParameter("room_Name");
        String action = request.getParameter("action");
        ParametrosDTO dto_g = new ParametrosDTO();
        dto_g.setGenericName(roomName);
        if(action.equals("register")){
            boolean b;
            b = (new databaseDAO()).doCreateRoom(dto_g);
            if(b){
                System.out.println("Successful insertions");
            }
            else{
                System.out.println("Fail on insertion");
            }
        }
        else if (action.equals("reload")){
            boolean r;
            r = (new databaseDAO()).doReadRooms(dto_g);
            if(r){
                request.getSession().setAttribute("roomsList",dto_g.getRooms());
            }
            else{
                request.getSession().setAttribute("roomsList","Erro");
            }
        }
        else if (action.equals("edit")){
            String newName = request.getParameter("newName");
            String idToChange = request.getParameter("idToChange");
            boolean e;
            e = (new databaseDAO()).doUpdateRoom(idToChange,newName);
            if(e){
                 System.out.println("Success on edition");
            }
            else{
                System.out.println("Fail on edition");
            }
        }   
        else{
            boolean d;
            d = (new databaseDAO()).doDeleteRoom(action);
            if(d){
                System.out.println("Deleted with successful");
            }
            else{
                System.out.println("Fail deleting data");
            }
        }

        return jspURL;
    }
    }


