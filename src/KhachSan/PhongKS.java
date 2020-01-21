package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class PhongKS {
	int MaPG;
	int MaTT;
	int MaLP;
	String tenPhongKS;
	float dienTich;
	int Tang;
	int MaTB;

	public PhongKS(int MaPG, int MaTT, int MaLP, String tenPhongKS, float dienTich, int Tang, int MaTB) {
		super();
		this.MaPG = MaPG;
		this.MaTT = MaTT;
		this.MaLP = MaLP;
		this.tenPhongKS = tenPhongKS;
		this.dienTich = dienTich;
		this.Tang = Tang;
		this.MaTB= MaTB;
	}

	public PhongKS() {
		this.MaTT = 0;
		this.MaLP = 0;
		this.tenPhongKS = "";
		this.dienTich =  0;
		this.Tang = 0;
		this.MaTB=0;
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

	public int getMaTB() {
		return MaTB;
	}

	public void setMaTB(int maTB) {
		MaTB = maTB;
	}

	
	
	public void nhapPhongKS() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Nhap Ma trang thai: ");
        MaTT  = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nhap Ma loai phong: ");
        MaLP = scanner.nextInt();
        scanner.nextLine();
		
		System.out.println("Nhap ten phong: ");
		tenPhongKS = scanner.nextLine();
		
		System.out.println("Nhap dien tich: ");
		dienTich=scanner.nextFloat();
		scanner.nextLine();
		
		System.out.println("Nhap tang: ");
        Tang = scanner.nextInt();
        scanner.nextLine();
        
        System.out.println("Nhap ma thiet bi: ");
        MaTB = scanner.nextInt();
        scanner.nextLine();
        
//		try {
//	    	System.out.println("Nhap trang thai:true/false");
//	    	trangThai= scanner.nextBoolean();
//	    } catch (Exception e) {
//	        scanner.nextLine(); 
//	    }  
//		
	}
	
	
	    

	
	
}
