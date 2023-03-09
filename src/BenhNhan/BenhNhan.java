package BenhNhan;

public class BenhNhan {
	private String IDBN;             
	private String Name;
	private int GioiTinh;
	private String NoiSinh;
	private int NamSinh;
	private String SDT;
	private String NhomMau;
	private String ChieuCao;
	private String CanNang;
	//Benh an
	private String BenhLayNhiem;
	private String BenhVeDa;
	private String BenhHoHap;
	private String BenhVeThan;
	private String BenhVeTimMach;
	private String BenhTieuHoa;
	private String ChanDoan;
	private String GhiChu;
	
	// Constructor
	
	
	public BenhNhan() {
		
	}
	public BenhNhan(String iDBN, String name, int gioiTinh, String noiSinh, int namSinh, String sDT, String nhomMau,
			String chieuCao, String canNang, String benhLayNhiem, String benhVeDa, String benhHoHap, String benhVeThan,
			String benhVeTimMach, String benhTieuHoa, String chanDoan, String ghiChu) {
		super();
		IDBN = iDBN;
		Name = name;
		GioiTinh = gioiTinh;
		NoiSinh = noiSinh;
		NamSinh = namSinh;
		SDT = sDT;
		NhomMau = nhomMau;
		ChieuCao = chieuCao;
		CanNang = canNang;
		BenhLayNhiem = benhLayNhiem;
		BenhVeDa = benhVeDa;
		BenhHoHap = benhHoHap;
		BenhVeThan = benhVeThan;
		BenhVeTimMach = benhVeTimMach;
		BenhTieuHoa = benhTieuHoa;
		ChanDoan = chanDoan;
		GhiChu = ghiChu;

	}
	// GT AND ST
	public String getIDBN() {
		return IDBN;
	}
	public void setIDBN(String iDBN) {
		IDBN = iDBN;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public String getNoiSinh() {
		return NoiSinh;
	}
	public void setNoiSinh(String noiSinh) {
		NoiSinh = noiSinh;
	}
	public int getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(int namSinh) {
		NamSinh = namSinh;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getNhomMau() {
		return NhomMau;
	}
	public void setNhomMau(String nhomMau) {
		NhomMau = nhomMau;
	}
	public String getChieuCao() {
		return ChieuCao;
	}
	public void setChieuCao(String chieuCao) {
		ChieuCao = chieuCao;
	}
	public String getCanNang() {
		return CanNang;
	}
	public void setCanNang(String canNang) {
		CanNang = canNang;
	}
	public String getBenhLayNhiem() {
		return BenhLayNhiem;
	}
	public void setBenhLayNhiem(String benhLayNhiem) {
		BenhLayNhiem = benhLayNhiem;
	}
	public String getBenhVeDa() {
		return BenhVeDa;
	}
	public void setBenhVeDa(String benhVeDa) {
		BenhVeDa = benhVeDa;
	}
	public String getBenhHoHap() {
		return BenhHoHap;
	}
	public void setBenhHoHap(String benhHoHap) {
		BenhHoHap = benhHoHap;
	}
	public String getBenhVeThan() {
		return BenhVeThan;
	}
	public void setBenhVeThan(String benhVeThan) {
		BenhVeThan = benhVeThan;
	}
	public String getBenhVeTimMach() {
		return BenhVeTimMach;
	}
	public void setBenhVeTimMach(String benhVeTimMach) {
		BenhVeTimMach = benhVeTimMach;
	}
	public String getBenhTieuHoa() {
		return BenhTieuHoa;
	}
	public void setBenhTieuHoa(String benhTieuHoa) {
		BenhTieuHoa = benhTieuHoa;
	}
	public String getChanDoan() {
		return ChanDoan;
	}
	public void setChanDoan(String chanDoan) {
		ChanDoan = chanDoan;
	}
	public String getGhiChu() {
		return GhiChu;
	}
	public void setGhiChu(String ghiChu) {
		GhiChu = ghiChu;
	}
	
}
