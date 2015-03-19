package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class main {

	public static void main(String[] args) throws RemoteException {
		ElectionParticipantSynchrone eps1 = new ParticipantSynchroneImpl(65);
		/*ElectionParticipantSynchrone eps2 = new ParticipantSynchroneImpl(66);
		ElectionParticipantSynchrone eps3 = new ParticipantSynchroneImpl(10);
		ElectionParticipantSynchrone eps4 = new ParticipantSynchroneImpl(120);*/
		
		/*Ring r = new Ring();
		r.add(eps1);
		r.init();*/
		
		try {
			Naming.bind("participant1",eps1);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (AlreadyBoundException e) {
			e.printStackTrace();
		} 
	}

}
