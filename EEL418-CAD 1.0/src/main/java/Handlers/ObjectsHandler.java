package Handlers;

import Handlers.Handler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import postgreConnection.ParametrosDTO;
import postgreConnection.databaseDAO;

public class ObjectsHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        String jspURL = "/objectControl.jsp";
        String roomName = request.getParameter("roomName");
        String deviceName = request.getParameter("deviceName");
        request.getSession().setAttribute("roomName", roomName);
        request.getSession().setAttribute("deviceName", deviceName);
        return jspURL;
    }
    }


