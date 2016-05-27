package agents;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import interfaces.Agent;
import interfaces.PingRemote;
import model.ACLMessage;
import model.AgentType;
import model.SirAgent;
/**
 * 
 * Klasa koja bi se bavila rukovanjem postojecih agentima, nalazi ih kao beanove i startuje/stopuje
 * AgentManager znaci upravlja sa agentima i pruza rest interfejs ovo ih nalazi i poziva/stopira
 *
 */
public class AgentLoader 
{

	 //ArrayList<SirAgent> runningAgents;
	
	public AgentLoader()
	{
		//this.runningAgents = runningAgents;
	}

	
	public Agent startAgent(AgentType type, String name)
	{
		try {

			Hashtable<String, Object> jndiProps = new Hashtable<>();
			jndiProps.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			jndiProps.put("jboss.naming.client.ejb.context", true);
			InitialContext ctx = new InitialContext(jndiProps);
			
			String agentClass = Agent.class.getName();
				
			String pingClass = type.getName();

			String lookupString = "ejb:AgentSystemEAR/AgentSystemEJB//" + pingClass + "!" + agentClass + "?stateful";
			
			System.out.println(lookupString);
			Object o = ctx.lookup(lookupString);
			
			Agent a = (Agent)o;
			
			System.out.println(a.hashCode());
			
//			PingRemote p = (PingRemote) o;
//			
//			if(p != null) 
//			{
//				System.out.println("Ping nije nula");
//			}

			return (Agent)o;
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return null;
	}
}
