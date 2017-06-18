
package postgreConnection;

import Models.Device;
import Models.Room;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonValue;

public class ParametrosDTO implements Serializable{
    private String serialroom;
    private String homeName;
    private int typeOfRequest;
    private String genericName;
    private List<Room> rooms = new ArrayList<Room>();
    private List<Device> devices = new ArrayList<Device>();
    private List<Device> roomDevices = new ArrayList<Device>();
    public String getGenericName() {
        return genericName;
    }
    public void setTypeoOfRequest(int typeoOfRequest) {
        this.typeOfRequest = typeoOfRequest;
    }
    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }
    
     public String getHomeName() {
        return homeName;
    }
    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }
//
    public List getRooms(){
        return rooms;
    }
    public void addMultipleRooms(List rooms){;
        this.rooms = rooms;
    }
   public void addMultipleDevices(List devices){;
        this.devices = devices;
    }  
    public void addRoom(String roomId,String roomName){
        Room r = new Room();
        r.setId(roomId);
        r.setName(roomName);
        this.rooms.add(r);
    }
    public void clearRooms(){
        this.rooms.clear();
    }
//
    public List getDevices(){
        return devices;
    }
    public List getRoomDevices(String rId){
        this.roomDevices.clear();
        for(int i = 0; i < this.devices.size();i++){
            if(this.devices.get(i).getrId().equals(rId)){
                this.roomDevices.add(this.devices.get(i));
            }
        }
        System.out.println("getRoomDevices OK");
        return roomDevices;
    }
    public String getRoomById(String id){
        String name;
        for(int i = 0; i < this.rooms.size();i++){
            if(this.rooms.get(i).getId().equals(id)){
                this.genericName = this.rooms.get(i).getName();
            }
        }
        System.out.println(genericName);
        return genericName;
    }
    public void addDevice(String deviceId,String rId,String deviceName){
        Device d = new Device();
        d.setId(deviceId);
        d.setName(deviceName);
        d.setrId(rId);
        this.devices.add(d);
    }
    
     JsonObject objetoJSON;
     public JsonObject toJSON(){ 
         JsonObjectBuilder returnJson = Json.createObjectBuilder();
         if(typeOfRequest == 1){
        // Adding rooms to JSON
            JsonArrayBuilder roomsArray = Json.createArrayBuilder();
            for (int i=0; i < rooms.size(); i++) {
                JsonObjectBuilder jo = Json.createObjectBuilder();
                jo.add("id",rooms.get(i).getId());
                jo.add("name",rooms.get(i).getName());
                roomsArray.add(jo);
            }
            returnJson.add("rooms",roomsArray);
         }
        if(typeOfRequest == 1){
            // Adding home name to 
            returnJson.add("homeName",homeName);
        }
        if(typeOfRequest == 3){
            // Adding devices to JSON
            JsonArrayBuilder devicesArray = Json.createArrayBuilder();
            for (int i=0; i<devices.size(); i++) {
                JsonObjectBuilder jo = Json.createObjectBuilder();
                jo.add("id",devices.get(i).getId());
                jo.add("name",devices.get(i).getName());
                jo.add("associateRoom",devices.get(i).getrId());
                jo.add("FileName",devices.get(i).getFileName());
                devicesArray.add(jo);
            }
            returnJson.add("devices",devicesArray);
        }
        if(typeOfRequest == 2){
           JsonArrayBuilder devicesArray = Json.createArrayBuilder();
            for (int i=0; i< roomDevices.size(); i++) {
                JsonObjectBuilder jo = Json.createObjectBuilder();
                jo.add("id",roomDevices.get(i).getId());
                jo.add("name",roomDevices.get(i).getName());
                jo.add("FileName",devices.get(i).getFileName());
                devicesArray.add(jo);
            }
            returnJson.add("devices",devicesArray);           
        }
        
//        System.out.println(returnJson.build());
        return returnJson.build();
    }

    @Override
    public String toString(){
        return toJSON().toString();
    }
}
