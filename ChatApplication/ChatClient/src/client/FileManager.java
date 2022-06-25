package client;

import java.io.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 //
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
////
public class FileManager {
//
	private static String url;
	private static Connection con;
	private static Statement st;
	private static ResultSet rs;
	//
	public final static String SERVER_FILE = "config.txt";

	public static boolean exist(String fileName) {
		return (new File(fileName)).isFile();
	}
// no la doc file txt dung ko dung bac oi
	// the bo lop nay di ko can lop nay nua  ma hinh nhu cai nay no ghi xuong txt ay  them xoa sua la ghi vo day 
	// ko can dau dung loptxt2sql cung dc em tao them cho oke bac thu comment lai roi tao nhung ma cai project nay no chay bat dau tu dau bac de minh cho coi cai demo
	public static List<ServerData> getServerList() {

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(new File(SERVER_FILE)));
		} catch (FileNotFoundException e) {
			System.out.println("File " + SERVER_FILE + " does not exist");
			return null;
		}

		List<ServerData> serverList = new ArrayList<ServerData>();
		try {
			String line = reader.readLine();
			try {

				while (line != null && !line.isEmpty()) {
					String[] serverData = line.split(",");
					serverList.add(new ServerData(serverData[0], serverData[1], Integer.parseInt(serverData[2])));
					line = reader.readLine();
				}
			} catch (Exception num) {
				System.out.println("File's format is incorrect");
				reader.close();
				return null;
			}
			reader.close();
		} catch (IOException io) {
			System.out.println("Read error");
		}
		return serverList;
	}

	public static void setServerList(List<ServerData> serverList) {

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(new File(SERVER_FILE)));

			for (ServerData serverData : serverList)
				writer.write(serverData.nickName + "," + serverData.ip + "," + serverData.port + "\n");

			writer.close();
		} catch (IOException io) {
			System.out.println("Write error");
		}
	}

	public static Object[][] getServerObjectMatrix(List<ServerData> serverList) {
		if (serverList == null)
			return new Object[][] {};
		Object[][] serverObjMatrix = new Object[serverList.size()][6];
		for (int i = 0; i < serverList.size(); i++) {
			serverObjMatrix[i][0] = serverList.get(i).nickName;
			serverObjMatrix[i][1] = serverList.get(i).realName;
			serverObjMatrix[i][2] = serverList.get(i).ip;
			serverObjMatrix[i][3] = serverList.get(i).port;
			serverObjMatrix[i][4] = serverList.get(i).isOpen ? "Hoạt động" : "Không hoạt động";
			serverObjMatrix[i][5] = serverList.get(i).connectAccountCount;
		}
		return serverObjMatrix;
	}
	
	
	///////////////////
/// Open sql hàm này để mở kết nối đến sql
public static void openSql() {
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


// hàm đóng kết nối
	public static void exit() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	///hàm đổ dât từ LIst lên sql trước đó tận dùng hàm getServerList() nó đọc file txt giúp mình lưu data từ txt sang list mình láy data từ list lên sql
	public static void toSql(List<ServerData> serverList) {
		openSql();
		 try {
	            st.executeUpdate("delete serverName");
       
     } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
     }
		for (int i = 0; i < serverList.size(); i++) {
	        String serverName = serverList.get(i).nickName;
	        String ip = serverList.get(i).ip;
	        String port = String.valueOf(serverList.get(i).port);
	        System.out.println(serverList.get(i).toS());
	        try {
		            st.executeUpdate("EXEC dbo.ST_SERVERNAME '" + serverName + "','" + ip + "','" + port+"'");
	          
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	       
	    }
		exit();
}
	
	
}
