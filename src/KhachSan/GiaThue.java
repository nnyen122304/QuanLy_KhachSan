package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;
import KhachSan.PhongKS;
public class GiaThue {  
    int MaGP;
	int MaPG;
	float Gia;
	String Ngay_Tu;
	String Ngay_Den;
	
	int MaGDV;
	int MaDV;
	float GiaDV;
	public String Tu_ngay;
	String Den_Ngay;
	
	public GiaThue(int MaGP, int MaPG, float Gia, String Ngay_Tu, String Ngay_Den, int MaGDV, int MaDV, float GiaDV, String Tu_Ngay, String Den_Ngay) {
		super();
		this.MaGP = MaGP;
		this.MaPG = MaPG;
		this.Gia = Gia;
		this.Ngay_Tu = Ngay_Tu;
		this.Ngay_Den = Ngay_Den;
		this.MaGDV = MaGDV;
		this.MaDV = MaDV;
		this.GiaDV = GiaDV;
		this.Tu_ngay = Tu_Ngay;
		this.Den_Ngay = Den_Ngay;
	}

	public GiaThue() {
		this.MaGP = 0;
		this.MaPG = 0;
		this.Gia = 0;
		this.Ngay_Tu = "";
		this.Ngay_Den = "";
		this.MaGDV = 0;
		this.MaDV = 0;
		this.GiaDV = 0;
		this.Tu_ngay = "";
		this.Den_Ngay = "";
	}
	
	public int getMaGP() {
		return MaGP;
	}

	public void setMaGP(int maGP) {
		MaGP = maGP;
	}

	public int getMaPG() {
		return MaPG;
	}

	public void setMaPG(int maPG) {
		MaPG = maPG;
	}

	public float getGia() {
		return Gia;
	}

	public void setGia(float gia) {
		Gia = gia;
	}

	public String getNgay_Tu() {
		return Ngay_Tu;
	}

	public void setNgay_Tu(String ngay_Tu) {
		Ngay_Tu = ngay_Tu;
	}

	public String getNgay_Den() {
		return Ngay_Den;
	}

	public void setNgay_Den(String ngay_Den) {
		Ngay_Den = ngay_Den;
	}
	
	
	public int getMaGDV() {
		return MaGDV;
	}

	public void setMaGDV(int maGDV) {
		MaGDV = maGDV;
	}

	public int getMaDV() {
		return MaDV;
	}

	public void setMaDV(int maDV) {
		MaDV = maDV;
	}

	public float getGiaDV() {
		return GiaDV;
	}

	public void setGiaDV(float giaDV) {
		GiaDV = giaDV;
	}

	public String getTu_ngay() {
		return Tu_ngay;
	}

	public void setTu_ngay(String tu_ngay) {
		Tu_ngay = tu_ngay;
	}

	public String getDen_Ngay() {
		return Den_Ngay;
	}

	public void setDen_Ngay(String den_Ngay) {
		Den_Ngay = den_Ngay;
	}

	public void nhapGiaPhong() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap Ma phong: ");
        MaPG  = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nhap gia phong: ");
        Gia = scanner.nextFloat();
        scanner.nextLine();
		
		System.out.println("Nhap ngay bat dau: ");
		Ngay_Tu = scanner.nextLine();
		
		System.out.println("Nhap ngay ket thuc: ");
		Ngay_Den=scanner.nextLine();
		
	}
	
	public void nhapDV() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap Ma dich vu: ");
        MaDV  = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nhap gia dich vu: ");
        GiaDV = scanner.nextFloat();
        scanner.nextLine();
		
		System.out.println("Nhap ngay bat dau dich vu: ");
		Tu_ngay = scanner.nextLine();
		
		System.out.println("Nhap ngay ket thuc dich vu: ");
		Den_Ngay=scanner.nextLine();
		
	}
	
	
}

