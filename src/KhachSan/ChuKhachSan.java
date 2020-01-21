package KhachSan;

import java.util.Scanner;

public class ChuKhachSan {
	private String Hoten;
	private String Diachi;
	private String Sodienthoai;
	private String Email;
	
	public ChuKhachSan( String Hoten, String Diachi, String Sodienthoai, String Email) {
		this.Hoten = Hoten;
		this.Diachi = Diachi;
		this.Sodienthoai = Sodienthoai;
		this.Email = Email;
	}
	
	public ChuKhachSan() {
		this.Hoten = "";
		this.Diachi = "";
		this.Sodienthoai = "";
		this.Email = "";
	}



	public String getHoten() {
		return Hoten;
	}

	public void setHoten(String hoten) {
		Hoten = hoten;
	}

	public String getDiachi() {
		return Diachi;
	}

	public void setDiachi(String diachi) {
		Diachi = diachi;
	}

	public String getSodienthoai() {
		return Sodienthoai;
	}

	public void setSodienthoai(String sodienthoai) {
		Sodienthoai = sodienthoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}
	
	public void nhapChuKhachSan() {
		Scanner scanner = new Scanner(System.in);
    
        System.out.println("Nhap Ho ten: ");
        Hoten = scanner.nextLine();

		System.out.println("Nhap Diachi: ");
		Diachi=scanner.nextLine();
		
		System.out.println("Nhap So dien thoai: ");
		Sodienthoai=scanner.nextLine();
		
		System.out.println("Nhap Email: ");
		Email = scanner.nextLine();

      
	}

}


