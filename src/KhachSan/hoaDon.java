package KhachSan;

import java.util.Scanner;

public class hoaDon {
	private int MaCTDV;
	private int MaHDG;
	private int MaNV;
	private float tongTien;
	private String ngayLap;
	public hoaDon(int maCTDV, int maHDG, int maNV, float tongTien, String ngayLap) {
		super();
		MaCTDV = maCTDV;
		MaHDG = maHDG;
		MaNV = maNV;
		this.tongTien = tongTien;
		this.ngayLap = ngayLap;
	}
	public hoaDon() {
		this.MaCTDV = 0;
		this.MaHDG = 0;
		this.MaNV = 0;
		this.tongTien = 0;
		this.ngayLap = "";
	}
	public int getMaCTDV() {
		return MaCTDV;
	}
	public void setMaCTDV(int maCTDV) {
		MaCTDV = maCTDV;
	}
	public int getMaHDG() {
		return MaHDG;
	}
	public void setMaHDG(int maHDG) {
		MaHDG = maHDG;
	}
	public int getMaNV() {
		return MaNV;
	}
	public void setMaNV(int maNV) {
		MaNV = maNV;
	}
	public float getTongTien() {
		return tongTien;
	}
	public void setTongTien(float tongTien) {
		this.tongTien = tongTien;
	}
	public String getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(String ngayLap) {
		this.ngayLap = ngayLap;
	}
	public void lapHoaDon() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhap vao ma chi tiet dich vu:" );
		MaCTDV = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhap vao ma nha vien:" );
		MaNV = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhap vao ma hop dong:" );
		MaHDG = scanner.nextInt();
		scanner.nextLine();
		System.out.print("Nhap vao ngay lap:" );
		ngayLap = scanner.nextLine();
		
		} 
	
}
