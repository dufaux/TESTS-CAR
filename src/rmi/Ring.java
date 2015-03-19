package rmi;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class Ring {
	
	private ArrayList<ElectionParticipantSynchrone> liste;

	public Ring(){
		liste = new ArrayList<ElectionParticipantSynchrone>();
	}
	
	public Ring(ArrayList<ElectionParticipantSynchrone> lst) throws RemoteException{
		this.liste = lst;
		this.init();
	}
	
	public void add(ElectionParticipantSynchrone participant){
		this.liste.add(participant);
	}
	
	public void init() throws RemoteException{
		liste.get(0).setGauche(liste.get(liste.size()-1));
		liste.get(0).setDroite(liste.get(1));
		for(int i=1; i<liste.size()-1;i++){
			liste.get(i).setGauche(liste.get(i-1));
			liste.get(i).setDroite(liste.get(i+1));
		}
		liste.get(liste.size()-1).setGauche(liste.get(liste.size()-2));
		liste.get(liste.size()-1).setDroite(liste.get(0));
	}
	
	public void display() throws RemoteException{
		for(int i=0; i<liste.size();i++){
			System.out.println("id = "+liste.get(i).getIdentifiant()+" et id gauche = "+liste.get(i).getVoisinGauche().getIdentifiant()+" et id droite ="+liste.get(i).getVoisinDroite().getIdentifiant());
		}
	}
}
