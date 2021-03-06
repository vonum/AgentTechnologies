package interfaces;

import java.util.Map;

import javax.ejb.Remote;

import model.AgentCenter;

@Remote
public interface NodeRemote {

	public Object registerAgentCenter(AgentCenter center);
	
	public String unregisterAgentCenter(String alias);
	
	public String hiMaster();
	
	public String byeMaster();
	
	public AgentCenter getMaster();
	
	public AgentCenter getCurNode();
	
	public Map<String, AgentCenter> getCenters();
	
	public String isRegistered();
	
	public AgentCenter isMaster();
	
	public void callNigga();
	
	public String hearthBear();

}
