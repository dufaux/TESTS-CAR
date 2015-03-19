package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class main {

	public static void main(String[] args) throws RemoteException {
		LocateRegistry.createRegistry(1099);
		
		
		ElectionParticipantSynchrone eps1 = new ParticipantSynchroneImpl(65);
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
			String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
			System.out.println("Enregistrement de l'objet avec l'url : " + url);
			Naming.rebind(url, eps1);
			//Naming.bind("participant1",eps1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
