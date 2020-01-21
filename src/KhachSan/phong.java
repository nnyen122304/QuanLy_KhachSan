package KhachSan;

public class phong {
	private int MaPG;
	private int MaTT;
	private int MaLP;
	private int MaTB;
	private String tenPhongKS;
	private float dienTich;
	private int   Tang;
	public phong(int maPG, int maTT, int maLP, int maTB, String tenPhongKS, float dienTich, int tang) {
		super();
		MaPG = maPG;
		MaTT = maTT;
		MaLP = maLP;
		MaTB = maTB;
		this.tenPhongKS = tenPhongKS;
		this.dienTich = dienTich;
		Tang = tang;
	}
	public phong(){
		this.MaTT = 0;
		this.MaLP = 0;
		this.MaTB = 0;
		this.tenPhongKS = "";
		this.dienTich = 0;
		this.Tang=0;
	}
	public int getMaPG() {
		return MaPG;
	}
	public void setMaPG(int maPG) {
		MaPG = maPG;
	}
	public int getMaTT() {
		return MaTT;
	}
	public void setMaTT(int maTT) {
		MaTT = maTT;
	}
	public int getMaLP() {
		return MaLP;
	}
	public void setMaLP(int maLP) {
		MaLP = maLP;
	}
	public int getMaTB() {
		return MaTB;
	}
	public void setMaTB(int maTB) {
		MaTB = maTB;
	}
	public String getTenPhongKS() {
		return tenPhongKS;
	}
	public void setTenPhongKS(String tenPhongKS) {
		this.tenPhongKS = tenPhongKS;
	}
	public float getDienTich() {
		return dienTich;
	}
	public void setDienTich(float dienTich) {
		this.dienTich = dienTich;
	}
	public int getTang() {
		return Tang;
	}
	public void setTang(int tang) {
		Tang = tang;
	}
	
}

