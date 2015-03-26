package rmi;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class main {

	public static void main(String[] args) throws RemoteException,
			MalformedURLException, NotBoundException, UnknownHostException {
		try {
			String symbolicLink = args[0];
			System.out.println(" ##### MAIN CLIENT ##### ");
			String serverAddress = InetAddress.getByName(symbolicLink)
					.getHostAddress();
			ElectionParticipantSynchrone eps = (ElectionParticipantSynchrone) Naming
					.lookup("rmi://" + serverAddress + ":1099/participant");
			System.out.println("Mon identifiant est :" + eps.getIdentifiant());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" ##### MAIN CLIENT ##### ");
			ElectionParticipantSynchrone eps  = (ElectionParticipantSynchrone) Naming
					.lookup("rmi://localhost/participant2");
			System.out.println("Mon identifiant est :" + eps.getIdentifiant());
		}

	}

	public static void printUsage() {
		System.out.println("main serverSymbolicAdress");
		System.out
				.println("\t serverSymbolicAddress : the symbolic address where the rmi server is launched");
	}

}
