package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connect.JDBCConnection;

public class txt2SQL {
private String url;
private Connection con;
private Statement st;
private ResultSet rs;
private List<ServerOB> list;
private ServerOB sv;
public txt2SQL() {
	list = new ArrayList<>();
	 list.add(new ServerOB("Facebook", "192.168.1.1", "1993"));
     list.add(new ServerOB("Facebook1", "192.168.1.1", "1993"));
	
}

public void openSql() {
	try {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		url="jdbc:sqlserver://localhost:1433;databaseName=ChatApplication;encrypt=true;trustServerCertificate=true;";
		con=DriverManager.getConnection(url, "sa", "Theanh241003");
		//doi lai mk giup minh nha
		st = con.createStatement();
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public  void exit() {
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void createFIle(){
    FileOutputStream fos;
    try {
        fos = new FileOutputStream("config1.txt");
    DataOutputStream dos = new DataOutputStream(fos);
        for (int i = 0; i < list.size(); i++) {
                dos.writeUTF(list.get(i).toTxt());
        }
        dos.writeUTF("end");
    } catch (FileNotFoundException ex) {
    }catch (IOException ex) {
            }
    
}
public void txt2OB() {

	String[] hold_data = new String[3];
	try {
		FileInputStream fis = new FileInputStream("config1.txt");
		DataInputStream dis = new DataInputStream(fis);
		while(true) {			
				String data = dis.readUTF();
				if(data.equals("end")) {
					return;
				}
			hold_data=data.split(";");
			sv = new ServerOB(hold_data[0],hold_data[1],hold_data[2]);
			list.add(sv);			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public void toSql() {
	for (int i = 0; i < list.size(); i++) {
        String serverName = list.get(i).getServerName();
        String ip = list.get(i).getIp();
        String port = list.get(i).getPort();
        System.out.println(list.get(i).toString());
        try {
            st.executeUpdate("EXEC dbo.ST_SERVERNAME '" + serverName + "','" + ip + "','" + port+"'");
          
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
}


}
