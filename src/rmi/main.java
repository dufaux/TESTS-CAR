package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class main {

	public static void main(String[] args) throws RemoteException {
		System.out.println(" ##### MAIN CLIENT ##### ");
		//LocateRegistry.createRegistry(1099);
		
		
		//ElectionParticipantSynchrone eps1 = new ParticipantSynchroneImpl(65);
		/*ElectionParticipantSynchrone eps2 = new ParticipantSynchroneImpl(66);
		ElectionParticipantSynchrone eps3 = new ParticipantSynchroneImpl(10);
		ElectionParticipantSynchrone eps4 = new ParticipantSynchroneImpl(120);*/
		
		/*Ring r = new Ring();
		r.add(eps1);
		r.init();*/
		
		try {
			String adresse = InetAddress.getByName("a11p2").toString();
			System.out.println(adresse);
			System.out.println(InetAddress.getByName("a11p2").getHostAddress());
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			/* CODE SERVER
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, eps1);*/
			
			
			//ElectionParticipantSynchrone eps = (ElectionParticipantSynchrone) Naming.lookup("TestRMI");
			ElectionParticipantSynchrone eps = (ElectionParticipantSynchrone) Naming.lookup("participant");
			System.out.println(eps.getIdentifiant());
			
			//Naming.bind("participant1",eps1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
