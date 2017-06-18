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
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.sql.Connection;
import java.util.List;
import java.util.ArrayList;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.servlet.RequestDispatcher;
import jdk.nashorn.internal.parser.JSONParser;
import junit.framework.Test;
import org.json.simple.JSONObject;
import postgreConnection.BaseDAO;
import postgreConnection.ParametrosDTO;
import postgreConnection.databaseDAO;
/**
 *
 * @author lucas
 */
public class Controller extends HttpServlet {
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Não é um conjunto de pares nome-valor,
        // então tem que ler como se fosse um upload de arquivo...
        BufferedReader br = new BufferedReader(
                                  new  InputStreamReader(
                                           request.getInputStream(),"UTF8"));
        String textoDoJson = br.readLine();
        
        JsonObject jsonObjectDeJava = null;
        // Ler e fazer o parsing do String para o "objeto json" java
        try (   //Converte o string em "objeto json" java
                // Criar um JsonReader.
                JsonReader readerDoTextoDoJson = 
                        Json.createReader(new StringReader(textoDoJson))) {
                // Ler e fazer o parsing do String para o "objeto json" java
                jsonObjectDeJava = readerDoTextoDoJson.readObject();
                // Acabou, então fechar o reader.
        }catch(Exception e){
            e.printStackTrace();
        }
     ParametrosDTO dto = new ParametrosDTO();
     int typeOfRequest = Integer.parseInt(jsonObjectDeJava.getString("typeOfRequest"));
     
     if(typeOfRequest == 1){
        // Home Name
        dto.setTypeoOfRequest(typeOfRequest);
        String homeName = new databaseDAO().doReadHome();
        dto.setHomeName(homeName);
        // Rooms Names
        List rooms = new databaseDAO().doReadRooms();
        dto.addMultipleRooms(rooms);
        // Devices Names
        List devices = new databaseDAO().doReadDevices();
        dto.addMultipleDevices(devices);
        System.out.println("Preencheu campos iniciais");
     }
     
     if(typeOfRequest == 2){
        dto.setTypeoOfRequest(typeOfRequest);
        String roomId = jsonObjectDeJava.getString("roomId");
        // Devices Names
        List devices = new databaseDAO().doReadDevices();
        dto.addMultipleDevices(devices);
        dto.getRoomDevices(roomId);
        System.out.println("Preencheu devices");
     }
     if(typeOfRequest == 3){
        String newHomeName = jsonObjectDeJava.getString("homeName");
        boolean e;
        e = (new databaseDAO()).doUpdateHome(newHomeName);
        if(e){
            System.out.println("Success on edition");
        }
        else{
            System.out.println("Fail on edition");
        }
     }
     if(typeOfRequest == 4){
       String newStatus = jsonObjectDeJava.getString("status");
       ObjectMapper mapper = new ObjectMapper();
       JSONObject root = mapper.readValue(new File("/home/lucas/repositoriosGit/EEL418-JavaWeB/EEL418-CAD/src/main/lampada.json"), JSONObject.class);
       root.put("name","Lucas");
       try (FileWriter file = new FileWriter("/home/lucas/repositoriosGit/EEL418-JavaWeB/EEL418-CAD/src/main/lampada.json")) {
        file.write(root.toString());
        System.out.println("Successfully updated json object to file...!!");
        }
     }

     response.setContentType("application/json;charset=UTF-8");
     PrintWriter out = response.getWriter();
     out.print(dto.toString());
     out.flush();
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


