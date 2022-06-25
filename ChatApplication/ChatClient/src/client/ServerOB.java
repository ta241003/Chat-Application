package client;

public class ServerOB {
private String serverName;
private String ip;
private String port;
public ServerOB(String serverName, String ip, String port) {
	super();
	this.serverName = serverName;
	this.ip = ip;
	this.port = port;
}
public ServerOB() {
	super();
}
public String getServerName() {
	return serverName;
}
public void setServerName(String serverName) {
	this.serverName = serverName;
}
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getPort() {
	return port;
}
public void setPort(String port) {
	this.port = port;
}
@Override
public String toString() {
	return "ServerOB [serverName=" + serverName + ", ip=" + ip + ", port=" + port + "]";
}
public String toTxt(){
    return getServerName()+";"+getIp()+";"+getPort()+"\n";
}

}
