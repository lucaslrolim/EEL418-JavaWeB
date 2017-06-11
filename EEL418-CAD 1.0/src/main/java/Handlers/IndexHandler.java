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


public class IndexHandler implements Handler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response){
        String newName = request.getParameter("newName");
        boolean e;
        e = (new databaseDAO()).doUpdateHome(newName);
        if(e){
            System.out.println("Success on edition");
        }
        else{
            System.out.println("Fail on edition");
        }
        boolean r;
        ParametrosDTO dto_i = new ParametrosDTO();
        dto_i.setHomeName(newName);
        r = (new databaseDAO()).doReadHome(dto_i);
        if(r){
            request.getSession().setAttribute("homeName",newName);
         }
        else{
            request.getSession().setAttribute("homeName","Erro");
        }
        return "/index.jsp";
    }
 }


