package de.buddelbubi.api;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class NukkitConnection {

 //Code from ServerConnector 

    String address;
    Integer port;
  
    public NukkitConnection() {
      
    }
  
    public NukkitConnection(String address, Integer port) {
      
        this.address = address;
        this.port = port;
      
    }
  
    public void setAddress(String address) {
      
        this.address = address;
      
    }
  
    public void setPort(Integer port) {
      
        this.port =  port;
      
    }
public int getOnlinePlayers() {
      
        net.minidev.json.JSONObject data;
        try {
            data = getDataPack();
            if(data.containsKey("OnlinePlayers")) {
                return Integer.parseInt(data.get("OnlinePlayers").toString());
            } else return -1;
        } catch (DOMException | ParserConfigurationException | ParseException | SAXException | IOException e) {
          
            e.printStackTrace();
            return -1;
        }
      
      
    }
public int getMaxPlayers() {
      
        net.minidev.json.JSONObject data;
        try {
            data = getDataPack();
            if(data.containsKey("MaxPlayers")) {
                return Integer.parseInt(data.get("MaxPlayers").toString());
            } else return -1;
        } catch (DOMException | ParserConfigurationException | ParseException | SAXException | IOException e) {
          
            e.printStackTrace();
            return -1;
        }
      
      
    }
public String getMotd() {
  
    net.minidev.json.JSONObject data;
    try {
        data = getDataPack();
        if(data.containsKey("Motd")) {
            return data.get("Motd").toString();
        } else return "-1";
    } catch (DOMException | ParserConfigurationException | ParseException | SAXException | IOException e) {
      
        e.printStackTrace();
        return "-1";
    }
  
  
}
  
  
    public JSONObject getDataPack() throws ParserConfigurationException, DOMException, ParseException, MalformedURLException, SAXException, IOException {
        String url = "http://" + this.address + ":" + this.port;
        JSONObject data = new JSONObject();
      
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new URL(url).openStream());
            data = (JSONObject) new JSONParser().parse(doc.getDocumentElement().getTextContent());
      
        return data;
      
    }
    public boolean canConnect(){
        	
    	try {
			
		
            URL url = new URL("http://" + this.address + ":" + this.port);
            url.openStream();
			return true;
    	} catch (Exception e) {
    		return false;
		}
		
           
        
      
    }
}