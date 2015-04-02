package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main2 {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws AlreadyBoundException 
	 * @throws MalformedURLException 
	 * @throws NotBoundException 
	 */
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException, NotBoundException {
		
		//System.setProperty("java.rmi.server.hostname","127.0.0.1");
		//Registry reglocal = LocateRegistry.createRegistry(1099);
		
		ElectionParticipantSynchrone eps2;
		eps2 = new ParticipantSynchroneImpl(785);
		
		Registry regp7 = LocateRegistry.getRegistry("a11p7");
		Registry reglocal = LocateRegistry.getRegistry("localhost");
		
		reglocal.bind("participant2", eps2);
		ElectionParticipantSynchrone epslocal = (ElectionParticipantSynchrone) reglocal.lookup("participant2");
		System.out.println("identifiant du participant local est : "+epslocal.getIdentifiant());
		
		ElectionParticipantSynchrone epsToBind = (ElectionParticipantSynchrone)regp7.lookup("participant1");
		System.out.println("identifiant du participant 1 chez allan : "+epsToBind.getIdentifiant());
		
		Naming.bind("participant1",epsToBind);
		ElectionParticipantSynchrone epsremote = (ElectionParticipantSynchrone) Naming.lookup("participant1");
		epsremote.setIdentifiant(214);
		System.out.println("identifiant du participant 1 chez allan : "+epsremote.getIdentifiant());
		
		System.out.println("blajljl");
	}

}
