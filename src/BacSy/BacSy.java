package BacSy;

public class BacSy {
	private String IDBS;
	private String TenBacSy;
	private int NamSinh;
	private String ChuyenMon;
	private String KinhNghiem;
	private String Khoa;
	private String TrinhDo;
	
	
	public BacSy(String iDBS, String tenBacSy, int namSinh, String chuyenMon, String kinhNghiem, String khoa,
			String trinhDo) {

		IDBS = iDBS;
		TenBacSy = tenBacSy;
		NamSinh = namSinh;
		ChuyenMon = chuyenMon;
		KinhNghiem = kinhNghiem;
		Khoa = khoa;
		TrinhDo = trinhDo;
	}
	public BacSy() {

	}
	public String getIDBS() {
		return IDBS;
	}
	public void setIDBS(String iDBS) {
		IDBS = iDBS;
	}
	public String getTenBacSy() {
		return TenBacSy;
	}
	public void setTenBacSy(String tenBacSy) {
		TenBacSy = tenBacSy;
	}
	public int getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(int namSinh) {
		NamSinh = namSinh;
	}
	public String getChuyenMon() {
		return ChuyenMon;
	}
	public void setChuyenMon(String chuyenMon) {
		ChuyenMon = chuyenMon;
	}
	public String getKinhNghiem() {
		return KinhNghiem;
	}
	public void setKinhNghiem(String kinhNghiem) {
		KinhNghiem = kinhNghiem;
	}
	public String getTrinhDo() {
		return TrinhDo;
	}
	public void setTrinhDo(String trinhDo) {
		TrinhDo = trinhDo;
	}
	public String getKhoa() {
		return Khoa;
	}
	public void setKhoa(String khoa) {
		Khoa = khoa;
	}
	
	
}
