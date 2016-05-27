package agents;

import javax.ejb.Remote;
import javax.ejb.Stateful;

import interfaces.Agent;
import interfaces.PingRemote;
import model.ACLMessage;
import model.AIDS;
import model.Performative;
import model.SirAgent;

@Stateful
@Remote(Agent.class)
public class PingAgent extends SirAgent
{

	public void init(AIDS aids)
	{
		
	}
	
	public void stop()
	{
		
	}
	
	public void hi()
	{
		System.out.println("Ping says hi");
	}
	
	@Override
	public void handleMessage(ACLMessage msg)
	{
		System.out.println("Ping got hit son!");
//		System.out.println(msg.getConversationId());
//		System.out.println("WUT");
//		
//		System.out.println(msg.getPerformative());
//		
//		switch(msg.getPerformative())
//		{
//			case REQUEST:
//			{
//				System.out.println("REQUEST");
//			}
//			break;
//			
//			case INFORM:
//			{
//				System.out.println("INFORM");
//			}
//			break;
//			
//			default : 
//			{
//				System.out.println("UNSUPPORTED PERFORMATIVE");
//			}
//		}
//		
	}
	
}
