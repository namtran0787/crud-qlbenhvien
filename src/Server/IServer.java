package Server;
import java.rmi.*;

import BacSy.BacSy;
import BenhNhan.BenhNhan;


public interface IServer extends Remote{
/*
 * Benh Nhan
 */
	public String insert(BenhNhan benhnhan) throws RemoteException;
	
	public String update(BenhNhan benhnhan) throws RemoteException;
	
	public String delete(BenhNhan benhnhan) throws RemoteException;
	
	
/*
 * Bac sy
 */
	public String insert(BacSy bacsy) throws RemoteException;
	
	public String update(BacSy bacsy) throws RemoteException;
	
	public String delete(BacSy bacsy) throws RemoteException;



}
