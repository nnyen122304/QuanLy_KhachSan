package KhachSan;

import java.util.Scanner;

public class KhachSan {
	private int MaCKS;
	private String Tenkhachsan;
	private String Diachi;
	private int Sotang;
	
	public KhachSan(int MaCKS, String Tenkhachsan, String Diachi, int Sotang) {
		super();
		MaCKS = MaCKS;
		Tenkhachsan = Tenkhachsan;
		Diachi = Diachi;
		Sotang = Sotang;
	}
	public KhachSan() {
		this.MaCKS = 0;
		this.Tenkhachsan = "";
		this.Diachi = "";
		this.Sotang = 0;
	}

	public int getMaCKS() {
		return MaCKS;
	}
	public void setMaCKS(int maCKS) {
		MaCKS = maCKS;
	}
	public String getTenkhachsan() {
		return Tenkhachsan;
	}
	public void setTenkhachsan(String tenkhachsan) {
		Tenkhachsan = tenkhachsan;
	}
	public String getDiachi() {
		return Diachi;
	}
	public void setDiachi(String diachi) {
		Diachi = diachi;
	}
	public int getSotang() {
		return Sotang;
	}
	public void setSotang(int sotang) {
		Sotang = sotang;
	}
	
	public void nhapKhachSan() {
		Scanner scanner = new Scanner(System.in);
	    
        System.out.println("Nhap MaCKS: ");
        MaCKS = scanner.nextInt();
        scanner.nextLine();

		System.out.println("Nhap Ten khach san: ");
		Tenkhachsan=scanner.nextLine();
		
		System.out.println("Nhap Dia chi: ");
		Diachi=scanner.nextLine();
		
		System.out.println("Nhap So tang: ");
		Sotang = scanner.nextInt();
	}
}