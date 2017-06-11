
package postgreConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class databaseDAO extends BaseDAO {


      public boolean doReadHome(ParametrosDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT nome FROM nomedacasa;");
            ResultSet rst = pstmt.executeQuery();
            rst.next();
            dto.setHomeName(rst.getString("nome"));
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
            return false;
        }
        return true;
    }

       public boolean doReadRooms(ParametrosDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT * FROM ambientes;");
            ResultSet rst = pstmt.executeQuery();
            //dto.clearRooms();
            while(rst.next()){
                dto.addRoom(rst.getString("serialambientes"),rst.getString("nome"));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
            return false;
        }
        return true;
    }
     public boolean doReadDevices(ParametrosDTO dto) {
        try {
            Connection con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(
               "SELECT * FROM dispositivos;");
            ResultSet rst = pstmt.executeQuery();
            while(rst.next()){
                dto.addDevice(rst.getString("serialdispositivo"),rst.getString("serialambientes"),rst.getString("nome"));
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error in doReadHome method");
            return false;
        }
        return true;
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