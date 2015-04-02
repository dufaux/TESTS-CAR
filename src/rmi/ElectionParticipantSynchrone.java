package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ElectionParticipantSynchrone extends Remote{

	public ElectionParticipantSynchrone election(ElectionParticipantSynchrone initiateur, int idMax, ElectionParticipantSynchrone candidat) throws RemoteException;

	public void setGauche(ElectionParticipantSynchrone participant) throws RemoteException;
	
	public void setDroite(ElectionParticipantSynchrone participant) throws RemoteException;
	
	public ElectionParticipantSynchrone getVoisinGauche() throws RemoteException;
	
	public ElectionParticipantSynchrone getVoisinDroite() throws RemoteException;
	
	public int getIdentifiant() throws RemoteException;

	public void setIdentifiant(int id) throws RemoteException;
	
}

