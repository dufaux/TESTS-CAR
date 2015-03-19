package rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ParticipantSynchroneImpl extends UnicastRemoteObject implements ElectionParticipantSynchrone{
	
	private ElectionParticipantSynchrone voisinGauche;
	private ElectionParticipantSynchrone voisinDroite;
	private int id;
	
	public ParticipantSynchroneImpl(int identifiant) throws RemoteException {
		super();
		this.id = identifiant;
	}
	
	public void setGauche(ElectionParticipantSynchrone participant){
		this.voisinGauche = participant;
	}
	
	public void setDroite(ElectionParticipantSynchrone participant){
		this.voisinDroite = participant;
	}
	
	public ElectionParticipantSynchrone getVoisinGauche(){
		return this.voisinGauche;
	}
	
	public ElectionParticipantSynchrone getVoisinDroite(){
		return this.voisinDroite;
	}
	
	public int getIdentifiant(){
		System.out.println("quelqu'un affiche l'identifiant");
		return this.id;
	}
	
	public ElectionParticipantSynchrone election(ElectionParticipantSynchrone initiateur, int idMax, ElectionParticipantSynchrone candidat) throws RemoteException{
		
		System.out.println("comparaison election idMax = "+idMax+" et this.id="+this.id);
		if(this.voisinGauche.equals(initiateur)){
			if(this.id > idMax){
				return this;
			}
			return candidat;
		}
		if(this.id > idMax){
			return voisinGauche.election(initiateur, this.id, this);
		}
		return voisinGauche.election(initiateur, idMax, candidat);
	}

}
