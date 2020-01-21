package KhachSan;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;
public class DangNhap {
	public void login() {
		Scanner sc = new Scanner(System.in);

		try {
			while (true){
				System.out.println("Nhap tai khoan: ");
				String us = sc.nextLine();
				System.out.println("Nhap mat khau: ");
				String pw = sc.nextLine();
				if (us.equals("") || pw.equals("")){
					System.out.println("Vui long nhap du thong tin !");
				}
				else {
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/qlks-2", "root", "");
					String sql = "SELECT * FROM user WHERE taikhoan=? AND matkhau=?";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, us);
					stmt.setString(2, pw);
					ResultSet re = stmt.executeQuery();
					if (re.next()){
						System.out.println("Dang nhap thanh cong");
						break;
					}
					else {
						System.out.println("Dang nhap that bai ");
					}
				}
			}
		}
		catch (Exception e){
			System.out.println("Ket noi that  bai");
		}
	}

	public static void menuLoaiPhong() {
		System.out.println("=======QUẢN LÝ KHÁCH SẠN=======");
		System.out.println("1. Tìm phòng");
		System.out.println("2. Thông tin hợp đồng");
		System.out.println("3. Tạo hợp đồng");
		System.out.println("4. Danh sách phòng đang thuê");
		System.out.println("5. Tạo phiếu thu");
		System.out.println("6. Thông tin phiếu thu");
		System.out.println("7. Đặt Phòng");
		System.out.println("---------------------------");
		System.out.print("Vui lòng chọn: ");	
	}
}

