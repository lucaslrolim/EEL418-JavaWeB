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


public class DevicesHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        String jspURL = "/devices.jsp";
        String deviceName = request.getParameter("device_name");
        String deviceRoomId = request.getParameter("device_roomId");
        String action = request.getParameter("action");
        ParametrosDTO dto_g = new ParametrosDTO();
        dto_g.setGenericName(deviceName);
        if(action.equals("register")){
            boolean b;
            b = (new databaseDAO()).doCreateDevice(dto_g,deviceRoomId);
            if(b){
                System.out.println("Successful insertions");
            }
            else {
                System.out.println("Fail on insertion");
            }
        }
        else if (action.equals("reload")){
            boolean r;
            r = (new databaseDAO()).doReadDevices(dto_g);
            if(r){
                request.getSession().setAttribute("devicesList",dto_g.getDevices());
            }
            else{
                request.getSession().setAttribute("devicesList","Erro");
            }
        }
        else if (action.equals("edit")){
            String newName = request.getParameter("newName");
            String idToChange = request.getParameter("idToChange");
            boolean e;
            e = (new databaseDAO()).doUpdateDevice(idToChange,newName);
            if(e){
                 System.out.println("Success on edition");
            }
            else{
                System.out.println("Fail on edition");
            }
        }
        else{
            boolean d;
            d = (new databaseDAO()).doDeleteDevice(action);
            System.out.println("Device ID: " + action );
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


