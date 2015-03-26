package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class mainserver {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws UnknownHostException 
	 */
	public static void main(String[] args) throws RemoteException, UnknownHostException {
		System.out.println(" ##### MAIN SERVER ##### ");
		System.setProperty("java.rmi.server.hostname","localhost");
		int port = 1100;
		System.out.println(" Serveur RMI sur port "+port);
		LocateRegistry.createRegistry(port);
		
		ElectionParticipantSynchrone eps1;
		eps1 = new ParticipantSynchroneImpl(port);
		
		try {
//			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() +":"+ port +"/participant1";
			//Naming.bind("participant",eps1);
			Naming.bind("participant2",eps1);
			//Naming.bind("participant1",eps1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
