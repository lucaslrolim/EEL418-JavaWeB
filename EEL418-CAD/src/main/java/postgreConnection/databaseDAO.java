
package postgreConnection;

import Models.Device;
import Models.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class databaseDAO extends BaseDAO {


      public String doReadHome() {
        String homeName;
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT nome FROM nomedacasa;");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            homeName = rst.getString("nome");
          //  dto.setHomeName(rst.getString("nome"));
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
            return "error";
        };
        return homeName;
    }

       public List doReadRooms() {
        List<Room> rooms = new ArrayList<Room>();
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT * FROM ambientes;");
            ResultSet rst = pstmt.executeQuery();
            //dto.clearRooms();
            while(rst.next()){
                Room r = new Room();
                r.setId(rst.getString("serialambientes"));
                r.setName(rst.getString("nome"));
                rooms.add(r);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
        }
        return rooms;
    }
     public List doReadDevices() {
        List<Device> devices = new ArrayList<Device>();
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT * FROM dispositivos;");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                Device d = new Device();
                d.setId(rst.getString("serialdispositivo"));
                d.setrId(rst.getString("serialambientes"));
                d.setName(rst.getString("nome"));
                devices.add(d);
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
        }
        return devices;
    }
public boolean doCreateRoom(ParametrosDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "INSERT INTO \"ambientes\" (\"nome\") VALUES(?);");
            pstmt.setString(1, dto.getGenericName());
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
public boolean doCreateDevice(ParametrosDTO dto,String serialRoom) {
        try {
            System.out.println(dto.getGenericName());
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "INSERT INTO \"dispositivos\" (\"nome\",\"serialambientes\") VALUES(?,?);");
            pstmt.setString(1, dto.getGenericName());
            pstmt.setInt(2, Integer.parseInt(serialRoom));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean doDeleteDevice(String deviceId){
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "DELETE FROM dispositivos WHERE serialdispositivo=?;");
            pstmt.setInt(1, Integer.parseInt(deviceId));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean doDeleteRoom(String roomId){
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "DELETE FROM ambientes WHERE serialambientes=?;");
            pstmt.setInt(1, Integer.parseInt(roomId));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean doUpdateRoom(String id,String newName) {
        try {
            Connection con = getConnection();
            System.out.println(newName);
            PreparedStatement pstmt = con.prepareStatement(
               "UPDATE ambientes SET nome=? WHERE serialambientes=?;");
            pstmt.setString(1, newName);
            pstmt.setInt(2, Integer.parseInt(id));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
        public boolean doUpdateDevice(String id,String newName) {
        try {
            Connection con = getConnection();
            System.out.println(newName);
            PreparedStatement pstmt = con.prepareStatement(
               "UPDATE dispositivos SET nome=? WHERE serialdispositivo=?;");
            pstmt.setString(1, newName);
            pstmt.setInt(2, Integer.parseInt(id));
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean doUpdateHome(String newName) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "UPDATE nomedacasa SET nome=?;");
            pstmt.setString(1, newName);
            pstmt.execute();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}