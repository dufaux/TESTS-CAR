package rmi;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Test;

public class testElection {

	@Test
	public void test() throws RemoteException {
		ElectionParticipantSynchrone eps1 = new ParticipantSynchroneImpl(65);
		ElectionParticipantSynchrone eps2 = new ParticipantSynchroneImpl(66);
		ElectionParticipantSynchrone eps3 = new ParticipantSynchroneImpl(10);
		ElectionParticipantSynchrone eps4 = new ParticipantSynchroneImpl(120);
		
		Ring r = new Ring();
		r.add(eps1);
		r.add(eps2);
		r.add(eps3);
		r.add(eps4);
		r.init();

		assertEquals(eps4,eps3.election(eps3, 10, eps3));
	}

}
