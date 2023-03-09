package BenhNhan;

import java.rmi.Naming;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import ConnJDBC.JDBCData;
import Server.IServer;

public class BenhNhanData extends JDBCData{
	
 /*
 * FIND ALL PATIENTS
 */
		public static List<BenhNhan> findAllPatient() {
			List<BenhNhan> benhNhanList = new ArrayList<>();
			String query = "select * from BenhNhan";
			try {
				Connection conn = getConnection(); // getConnection open on first source code 
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				while (rs.next()) {
					BenhNhan bn = new BenhNhan(rs.getString("IDBN"), 
											   rs.getString("NAME"), 
											   rs.getInt("GIOITINH"), 
											   rs.getString("NOISINH"), 
											   rs.getInt("NAMSINH"), 											    
											   rs.getString("SDT"), 								   
											   rs.getString("NHOMMAU"), 
											   rs.getString("CHIEUCAO"), 
											   rs.getString("CANNANG"),
											   rs.getString("BenhLayNhiem"),
											   rs.getString("BenhVeDa"),
											   rs.getString("BenhHoHap"),
											   rs.getString("BenhVeThan"),
											   rs.getString("BenhVeTimMach"),
											   rs.getString("BenhTieuHoa"),
											   rs.getString("ChanDoan"),
											   rs.getString("GhiChu"));
							;
				
					benhNhanList.add(bn);
				}
			} catch ( Exception ex) {
				ex.printStackTrace();
			}
			return benhNhanList;
		}
/*
 * end.
 *
 *-------------------------------------------------
 *
 * insert data into sql
 */
		public static void insert(BenhNhan bn) {
			
			try {
				String query = "INSERT into BenhNhan (IDBN,"       // 1
													+ "NAME,"		// 2
													+ "GIOITINH,"	// 3	int	
													+ "NOISINH,"	// 4
													+ "NAMSINH,"	// 5
													+ "SDT, "		// 6 													
													+ "NHOMMAU, "	// 7
													+ "CHIEUCAO, "	// 8
													+ "CANNANG, "	// 9
													+ "BenhLayNhiem,"// 10
													+ "BenhVeDa,"	// 11
													+ "BenhHoHap,"	// 12
													+ "BenhVeThan,"	// 13
													+ "BenhVeTimMach,"	// 14
													+ "BenhTieuHoa,"// 15
													+ "ChanDoan,"// 16
													+ "GhiChu)" // 17
												    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		        
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, bn.getIDBN());
				pstmt.setString(2, bn.getName());
				pstmt.setInt(3, bn.getGioiTinh());
				pstmt.setString(4, bn.getNoiSinh());
				pstmt.setInt(5, bn.getNamSinh());
				pstmt.setString(6, bn.getSDT());
				pstmt.setString(7, bn.getNhomMau());
				pstmt.setString(8, bn.getChieuCao());
				pstmt.setString(9, bn.getCanNang());
				pstmt.setString(10, bn.getBenhLayNhiem());
				pstmt.setString(11, bn.getBenhVeDa());
				pstmt.setString(12, bn.getBenhHoHap());
				pstmt.setString(13, bn.getBenhVeThan());
				pstmt.setString(14, bn.getBenhVeTimMach());
				pstmt.setString(15, bn.getBenhTieuHoa());
				pstmt.setString(16, bn.getChanDoan());
				pstmt.setString(17, bn.getGhiChu());

				try {
					IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
				}
				// UPDATE
				if (pstmt.executeUpdate() == 1 ) {
					JOptionPane.showMessageDialog(null, "Thêm bệnh nhân thành công!","Message",JOptionPane.INFORMATION_MESSAGE);				
				}
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
		public static void delete(BenhNhan bn) {
			String query = "DELETE FROM BenhNhan WHERE BenhNhan.IDBN='"+bn.getIDBN()+"'"
					       + "or BenhNhan.NAME='" + bn.getName() +"'";
			
			try {
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				try {
					IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
				}
				pstmt.executeUpdate();
				
				pstmt.setString(1, bn.getIDBN());
				pstmt.setString(2, bn.getName());
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
		public static void update(BenhNhan bn) {
			String query = "UPDATE BenhNhan set IDBN=?,"
											+ "NAME=?,"
											+ "GIOITINH=?,"
											+ "NOISINH=?,"
											+ "NAMSINH=?,"
											+ "SDT=?, "										
											+ "NHOMMAU=?, "
											+ "CHIEUCAO=?, "
											+ "CANNANG=?, "
											+ "BenhLayNhiem=?, "// 10
											+ "BenhVeDa=?, "	// 11
											+ "BenhHoHap=?, " 	// 12
											+ "BenhVeThan=?, "	// 13
											+ "BenhVeTimMach=?,"	// 14
											+ "BenhTieuHoa=?, "// 15
											+ "ChanDoan=?, "// 16
											+ "GhiChu=? "// 16

											+ "where IDBN = '" + bn.getIDBN() +"'";
		
			
			try {
				Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, bn.getIDBN());
				pstmt.setString(2, bn.getName());
				pstmt.setInt(3, bn.getGioiTinh());
				pstmt.setString(4, bn.getNoiSinh());
				pstmt.setInt(5, bn.getNamSinh());
				pstmt.setString(6, bn.getSDT());
				pstmt.setString(7, bn.getNhomMau());
				pstmt.setString(8, bn.getChieuCao());
				pstmt.setString(9, bn.getCanNang());	
				pstmt.setString(10, bn.getBenhLayNhiem());
				pstmt.setString(11, bn.getBenhVeDa());
				pstmt.setString(12, bn.getBenhHoHap());
				pstmt.setString(13, bn.getBenhVeThan());
				pstmt.setString(14, bn.getBenhVeTimMach());
				pstmt.setString(15, bn.getBenhTieuHoa());
				pstmt.setString(16, bn.getChanDoan());
				pstmt.setString(17, bn.getGhiChu());

				try {
					IServer iserver = (IServer) Naming.lookup("rmi://localhost:1099/db");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Vui lòng kết nối với server!","Message",JOptionPane.WARNING_MESSAGE);
				}
				// UPDATE
				pstmt.executeUpdate();
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
/*
 * end.
 *
 *-------------------------------------------------
 *
 * tìm theo tên và id
 */	
		public static List<BenhNhan> findNameBenhNhan(BenhNhan bn) {
			List<BenhNhan> benhNhanList = new ArrayList<>();
			String query = "Select * from BenhNhan where BenhNhan.IDBN like N'" +bn.getIDBN() 
							+"'"+ "or BenhNhan.NAME like N'" + bn.getName() + "'";
			try {
				Connection conn = getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(query);
				
				while (rs.next()) {
					BenhNhan bnn = new BenhNhan(rs.getString("IDBN"), 
											   rs.getString("NAME"), 
											   rs.getInt("GIOITINH"), 
											   rs.getString("NOISINH"), 
											   rs.getInt("NAMSINH"), 
											   rs.getString("SDT"),
											   rs.getString("NHOMMAU"), 
											   rs.getString("CHIEUCAO"), 
											   rs.getString("CANNANG"),
											   rs.getString("BenhLayNhiem"),
											   rs.getString("BenhVeDa"),
											   rs.getString("BenhHoHap"),
											   rs.getString("BenhVeThan"),
											   rs.getString("BenhVeTimMach"),
											   rs.getString("BenhTieuHoa"),
											   rs.getString("ChanDoan"),
											   rs.getString("GhiChu"));
										
							;	

						benhNhanList.add(bnn);				
				}
			} catch (Exception e) {
				
			}
			
			
			return benhNhanList;
		}
}
