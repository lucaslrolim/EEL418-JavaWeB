
package postgreConnection;

import Models.Device;
import Models.Room;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ParametrosDTO implements Serializable{
    private String serialroom;
    private String homeName;
    private String genericName;
    private List<Room> rooms = new ArrayList<Room>();
    private List<Device> devices = new ArrayList<Device>();
    private List<Device> roomDevices = new ArrayList<Device>();
    public String getGenericName() {
        return genericName;
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
}
