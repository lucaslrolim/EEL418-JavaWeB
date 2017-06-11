
package Handlers;


import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import postgreConnection.BaseDAO;
import postgreConnection.ParametrosDTO;
import postgreConnection.databaseDAO;

public class IniciadorDeSessao implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent se) {
        ParametrosDTO dto = new ParametrosDTO();
        boolean b;
        b = (new databaseDAO()).doReadHome(dto);
        if(b){
             se.getSession().setAttribute("homeName",dto.getHomeName());
             System.out.println("Iniciador de Sessão OK");
        }
        else{
            se.getSession().setAttribute("homeName","Nome não encontrado");
        }
        boolean r;
        r = (new databaseDAO()).doReadRooms(dto);
        if(r){
            se.getSession().setAttribute("roomsList",dto.getRooms());
        }
        else{
            se.getSession().setAttribute("roomsList","Rooms não encontrado");
        }
        boolean d;
        d = (new databaseDAO()).doReadDevices(dto);
        if(d){
         se.getSession().setAttribute("devicesList",dto.getDevices());
         se.getSession().setAttribute("roomDevices",dto.getDevices());
        }
        else{
            se.getSession().setAttribute("devicesList","Devices não encontrado");
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}