/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author lucas
 */
public class Device {
    private String name;
    private String id;
    private String rId;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    public String getrId(){
        return rId;
    }
    public void setrId(String rId){
        this.rId = rId;
    }
}
