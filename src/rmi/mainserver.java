package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class mainserver {

	/**
	 * @param args
	 * @throws RemoteException 
	 */
	public static void main(String[] args) throws RemoteException {
		System.out.println(" ##### MAIN SERVER ##### ");
		LocateRegistry.createRegistry(1099);
		
		ElectionParticipantSynchrone eps1;
		eps1 = new ParticipantSynchroneImpl(65);
		
		/*ElectionParticipantSynchrone eps2 = new ParticipantSynchroneImpl(66);
		ElectionParticipantSynchrone eps3 = new ParticipantSynchroneImpl(10);
		ElectionParticipantSynchrone eps4 = new ParticipantSynchroneImpl(120);*/
		
		/*Ring r = new Ring();
		r.add(eps1);
		r.init();*/
		try {
			//String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
			//System.out.println("Enregistrement de l'objet avec l'url : " + url);
			//Naming.rebind(url, eps1);
			Naming.bind("participant",eps1);
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
