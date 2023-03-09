package BacSy;

import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import BenhNhan.BenhNhan;
import ConnJDBC.JDBCData;
import Server.IServer;

public class BacSyData extends JDBCData{
	/*
	 * FIND ALL BacSy
	 */
			public static List<BacSy> findAllBacSy() {
				List<BacSy> bacSyList = new ArrayList<>();
				String query = "select * from BacSy";
				try {
					Connection conn = getConnection(); // getConnection open on first source code 
					Statement stm = conn.createStatement();
					ResultSet rs = stm.executeQuery(query);
					while (rs.next()) {
						BacSy bs = new BacSy(rs.getString("IDBS"), 
												   rs.getString("TenBacSy"), 
												   rs.getInt("NamSinh"), 
												   rs.getString("ChuyenMon"), 
												   rs.getString("KinhNghiem"), 											    
												   rs.getString("Khoa"), 								   
												   rs.getString("TrinhDo"))	   
								;
						
						bacSyList.add(bs);
					}
				} catch ( Exception ex) {
					ex.printStackTrace();
				}
				return bacSyList;
			}
	/*
	 * end.
	 *
	 *-------------------------------------------------
	 *
	 * insert data into sql
	 */			 
					public static void insert(BacSy bs) {
						
						try {
							String query = "INSERT INTO BacSy  	  (IDBS,"       // 1
																+ "TenBacSy,"		// 2
																+ "NamSinh,"	// 3	int	
																+ "ChuyenMon,"	// 4
																+ "KinhNghiem,"	// 5
																+ "Khoa, "		// 6 													
																+ "TrinhDo) "	// 7
																
																
										 + "values (?,?,?,?,?,?,?)";
					        
							Connection conn = getConnection();
							PreparedStatement pstmt = conn.prepareStatement(query);
							
							pstmt.setString(1, bs.getIDBS());
							pstmt.setString(2, bs.getTenBacSy());
							pstmt.setInt(3, bs.getNamSinh());
							pstmt.setString(4, bs.getChuyenMon());
							pstmt.setString(5, bs.getKinhNghiem());
							pstmt.setString(6, bs.getKhoa());
							pstmt.setString(7, bs.getTrinhDo());
							
							try {
								IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
							}
							// UPDATE
							pstmt.executeUpdate();
						} catch ( Exception e) {
						}
					}
	/*
	 * end.
	 *
	 *-------------------------------------------------
	*
 * delete some data in sql 
 */
		public static void delete(BacSy bs) {
			String query = "DELETE FROM BacSy WHERE BacSy.IDBS='"+bs.getIDBS()+"'"
							+ "or BacSy.TenBacSy='" + bs.getTenBacSy() +"'";
			
			try {
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				try {
					IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
				}
				pstmt.executeUpdate();

				pstmt.setString(1, bs.getIDBS());
				pstmt.setString(2, bs.getTenBacSy());
			} catch ( Exception e) {

			}
		}
/*
 * end.
 *
 *-------------------------------------------------
 *
 * update some data in sql 
 */
		public static void update(BacSy bs) {
			String query = "UPDATE BacSy set IDBS=?,"
											+ "TenBacSy=?,"
											+ "NamSinh=?,"
											+ "ChuyenMon=?,"
											+ "KinhNghiem=?,"
											+ "Khoa=?, "
											+ "TrinhDo=? "										
							
											+ "where IDBS = '" + bs.getIDBS() +"'";
		
			
			try {
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, bs.getIDBS());
				pstmt.setString(2, bs.getTenBacSy());
				pstmt.setInt(3, bs.getNamSinh());
				pstmt.setString(4, bs.getChuyenMon());
				pstmt.setString(5, bs.getKinhNghiem());
				pstmt.setString(6, bs.getKhoa());
				pstmt.setString(7, bs.getTrinhDo());
				
				try {
					IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
				}
				// UPDATE
				pstmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Cập nhật bác sỹ thành công!","Message",JOptionPane.INFORMATION_MESSAGE);
					
						
				} catch ( Exception e) {
				System.out.println(e);
			}
		}
/*
 * end.
 *
 *-------------------------------------------------
 *
 * tìm theo tên và id
 */	
		public static List<BacSy> findNameBacSy(BacSy bs) {
			List<BacSy> bacSyList = new ArrayList<>();
			String query = "Select * from BacSy where BacSy.IDBS like N'" +bs.getIDBS() 
							+"'"+ "or BacSy.TenBacSy like N'" + bs.getTenBacSy() + "'";
			try {
				Connection conn = getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				
				while (rs.next()) {
					BacSy bss = new BacSy(rs.getString("IDBS"), 
							   rs.getString("TenBacSy"), 
							   rs.getInt("NamSinh"), 
							   rs.getString("ChuyenMon"), 
							   rs.getString("KinhNghiem"), 											    
							   rs.getString("Khoa"), 								   
							   rs.getString("TrinhDo"))
							   
			;

					bacSyList.add(bss);				
				}
			} catch (Exception e) {
				
			}
			
			
			return bacSyList;
		}	
}
