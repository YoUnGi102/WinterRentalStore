package dk.via.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.ExportException;

public class ServerDriver {

    public static void main(String[] args){
        System.setProperty("java.rmi.server.hostname","127.0.0.1");
        int port = 1039;

        try{
            RemoteModel server = new Server();
            Registry registry = LocateRegistry.createRegistry(port);
            registry.bind("RMIServer", server);
        }catch (ExportException e){
            System.out.println("Server Already Running");
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

        System.out.println("Server running on port " + port);
    }

}
