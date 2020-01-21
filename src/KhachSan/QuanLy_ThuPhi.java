package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QuanLy_ThuPhi {
	private static String DB_URL = "jdbc:mysql://localhost:3306/qlks-2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    
    
    public static Connection getConnection(String dbURL, String userName, String password) {
        Connection conn = null;
        try {
        	//mở kết nối Driver
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
//            System.out.println("connect successfully!");
	        
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    
    public void taoPhieuThu() {
    	System.out.println("\n------------------------**BT6_Tạo phiếu thu**---------------------\n");
		Scanner sc = new Scanner(System.in);
		hoaDon phieuthu = new hoaDon();
		System.out.println("Nhap vao ma phong can tao phieu thu:");
		int maPhong = sc.nextInt();
		phieuthu.lapHoaDon();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			int rs1 = stmt.executeUpdate("INSERT INTO `hoadon`(`MaCTDV`, `MaHDG`, `MaNV`, `Tongtien`, `Ngaylap`) "
					+ "VALUES ('" + phieuthu.getMaCTDV() + "','" + phieuthu.getMaHDG() + "','" + phieuthu.getMaNV()
					+ "','" + phieuthu.getTongTien() + "','" + phieuthu.getNgayLap() + "')");
			
			ResultSet rs = stmt.executeQuery(
					"SELECT hopdong.Nguoinhanphong,phong.tenPhongKS,chitietdichvu.Soluong,giadichvu.Gia,hopdong.Sotientratruoc,hopdong.Sotientrasau,hopdong.Ngaynhanphong,hopdong.Ngaytraphong FROM hoadon,hopdong,chitietdichvu,giadichvu,phong WHERE chitietdichvu.MaGDV = giadichvu.MaGDV AND hoadon.MaHDG = hopdong.MaHDG AND hoadon.MaCTDV = chitietdichvu.MaCTDV AND phong.MaPG = hopdong.MaPG AND hopdong.MaPG  = '"+maPhong+"'");
			System.out.println("\t\t\t\t\t\t\t===== Thông Tin Phiếu Thu =====");
			System.out.println("TEN PHONG \t\t TEN KHACH HANG \t\t NGAY NHAN PHONG \t\t NGAY TRA PHONG \t\t GIA DICH VU \t\t GIA PHONG \t\t TONG TIEN ");
			while (rs.next()) {
				int soluong = rs.getInt(3);
				int giatratruoc =rs.getInt(5);
				int giatrasau = rs.getInt(6);
				int giadichvu = rs.getInt(4);
				int tonggiadichvu = soluong*giadichvu;
				int tienphong = giatratruoc+giatrasau;
				int tongtien = tonggiadichvu+tienphong;
				System.out.println(
						rs.getString(2) + " \t\t\t " + rs.getString(1)
						+ " \t\t\t\t " + rs.getString(7) + " \t\t\t " + rs.getString(8) + " \t\t\t" +tonggiadichvu+ " \t\t\t" +tienphong+"\t\t\t" +tongtien+ "");
			}
			if (rs.equals(true)) {
				System.out.println("Lập hóa đơn thất bại,yêu cầu bạn lập lại hóa đơn mới!!!");
			} else {
				System.out.println("Lập thành công hóa đơn");
			}
			int rs2 = stmt.executeUpdate("DELETE FROM `hopdong` WHERE MaHDG = '"+phieuthu.getMaHDG()+"'");
			int rs3 = stmt.executeUpdate("UPDATE `phong` SET `MaTT`= 1 WHERE MaPG = '"+maPhong+"'");
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
    
    public void phongDangThue() {
    	System.out.println("\n--------------**BT6_ Thống kê các phòng đang cho thuê**--------------\n");
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select phong.MaPG,phong.tenPhongKS,phong.dienTich,phong.Tang,trangthai.trangThai,loaiphong.tenLoai,thietbi.Tenthietbi from phong,trangthai,loaiphong,thietbi where phong.MaTT = trangthai.MaTT AND phong.MaLP = loaiphong.MaLP AND thietbi.MaTB = phong.MaTB AND phong.MaTT = 3");
			System.out.println("\t\t\t\t\t\t\t===== Danh sách phòng đang thuê =====");
			System.out.println(
					"MA PHONG \t\t TEN PHONG \t\t DIEN TICH \t\t TANG \t\t TRANG THAI \t\t LOAI PHONG \t\t THIET BI  ");
			while (rs.next()) {

				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getString(2) + " \t\t " + rs.getFloat(3) + " \t\t"
						+ rs.getInt(4) + " \t\t " + rs.getString(5) + " \t\t " + rs.getString(6) + " \t\t "
						+ rs.getString(7) );
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}
