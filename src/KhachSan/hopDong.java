package KhachSan;

import java.util.Scanner;

public class hopDong {
	private int MaPG;
	private int MaNV;
	private String tenHopDong ;
	private String Ngaylap;
	private String Sotientratruoc ;
	private String Sotientrasau;
	private String Nguoidangky;
	private String Nguoinhanphong;
	private String Ngaynhanphong;
	private String Ngaytraphong;
	public hopDong(int maPG, int maNV, String tenHopDong, String ngaylap, String sotientratruoc, String sotientrasau,
			String nguoidangky, String nguoinhanphong, String ngaynhanphong, String ngaytraphong) {
		super();
		MaPG = maPG;
		MaNV = maNV;
		this.tenHopDong = tenHopDong;
		Ngaylap = ngaylap;
		Sotientratruoc = sotientratruoc;
		Sotientrasau = sotientrasau;
		Nguoidangky = nguoidangky;
		Nguoinhanphong = nguoinhanphong;
		Ngaynhanphong = ngaynhanphong;
		Ngaytraphong = ngaytraphong;
	}
	public hopDong() {
		this.MaPG = 0;
		this.MaNV = 0;
		this.tenHopDong = "";
		this.Ngaylap = "";
		this.Sotientratruoc = "";
		this.Sotientrasau = "";
		this.Nguoidangky = "";
		this.Nguoinhanphong = "";
		this.Ngaynhanphong = "";
		this.Ngaytraphong = "";
	}
	public int getMaPG() {
		return MaPG;
	}
	public void setMaPG(int maPG) {
		MaPG = maPG;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public String getTenHopDong() {
		return tenHopDong;
	}
	public void setTenHopDong(String tenHopDong) {
		this.tenHopDong = tenHopDong;
	}
	public String getNgaylap() {
		return Ngaylap;
	}
	public void setNgaylap(String ngaylap) {
		Ngaylap = ngaylap;
	}
	public String getSotientratruoc() {
		return Sotientratruoc;
	}
	public void setSotientratruoc(String sotientratruoc) {
		Sotientratruoc = sotientratruoc;
	}
	public String getSotientrasau() {
		return Sotientrasau;
	}
	public void setSotientrasau(String sotientrasau) {
		Sotientrasau = sotientrasau;
	}
	public String getNguoidangky() {
		return Nguoidangky;
	}
	public void setNguoidangky(String nguoidangky) {
		Nguoidangky = nguoidangky;
	}
	public String getNguoinhanphong() {
		return Nguoinhanphong;
	}
	public void setNguoinhanphong(String nguoinhanphong) {
		Nguoinhanphong = nguoinhanphong;
	}
	public String getNgaynhanphong() {
		return Ngaynhanphong;
	}
	public void setNgaynhanphong(String ngaynhanphong) {
		Ngaynhanphong = ngaynhanphong;
	}
	public String getNgaytraphong() {
		return Ngaytraphong;
	}
	public void setNgaytraphong(String ngaytraphong) {
		Ngaytraphong = ngaytraphong;
	}
	public void lapHopDong() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao ma phong:" );
		MaPG = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhap vao ma nhan vien:" );
		MaNV = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhap vao ten hop dong:" );
		tenHopDong = scanner.nextLine();
		System.out.print("Nhap vao ngay lap:" );
		Ngaylap = scanner.nextLine();
		System.out.print("Nhap vao so tien tra truoc:" );
		Sotientratruoc = scanner.nextLine();
		System.out.print("Nhap vao so tien tra sau:" );
		Sotientrasau = scanner.nextLine();
		System.out.print("Nhap vao ten nguoi dang ky:" );
		Nguoidangky = scanner.nextLine();
		System.out.print("Nhap vao ten nguoi nhan phong:" );
		Nguoinhanphong = scanner.nextLine();
		System.out.print("Nhap vao ngay nhan phong:" );
		Ngaynhanphong = scanner.nextLine();
		System.out.print("Nhap vao ngay tra phong:" );
		Ngaytraphong = scanner.nextLine();
		} 
}