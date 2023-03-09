package Server;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import BacSy.BacSy;
import BacSy.BacSyData;
import BenhNhan.BenhNhan;
import BenhNhan.BenhNhanData;


public class ServerIMP extends UnicastRemoteObject implements IServer {

	private BenhNhanData benhnhandata;
	private BacSyData bacsydata;

	public ServerIMP() throws RemoteException {
		super();
		this.benhnhandata = new BenhNhanData();
		this.bacsydata = new BacSyData();
	}

	private static final long serialVersionUID = 1L;


	@Override
	public String insert(BenhNhan benhnhan) throws RemoteException {
		return null;
	}

	@Override
	public String update(BenhNhan benhnhan) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(BenhNhan benhnhan) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String insert(BacSy bacsy) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(BacSy bacsy) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(BacSy bacsy) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
