package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class QuanLy_ChoThue {
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
	public void timPhongTrong() {
		System.out.println("\n------------------------**BT5_Tìm kiếm các phòng rãnh**---------------------\n");
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select phong.MaPG,phong.tenPhongKS,phong.dienTich,phong.Tang,trangthai.trangThai,loaiphong.tenLoai,thietbi.Tenthietbi from phong,trangthai,loaiphong,thietbi where phong.MaTT = trangthai.MaTT AND phong.MaLP = loaiphong.MaLP AND thietbi.MaTB = phong.MaTB AND phong.MaTT = 1");
			System.out.println("\t\t\t\t\t\t\t===== Danh sách phòng trống =====");
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

	

	public void taoHopDong() {
		System.out.println("\n------------------------**BT5_Tạo hợp đồng**---------------------\n");
		Scanner sc = new Scanner(System.in);
		hopDong hd = new hopDong();
		hd.lapHopDong();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stm = conn.createStatement();
		
			int rs1 = stm.executeUpdate(
					"INSERT INTO `hopdong`(`MaPG`, `MaNV`, `Tenhopdong`, `Ngaylap`, `Sotientratruoc`, `Sotientrasau`, `Nguoidangki`, `Nguoinhanphong`, `Ngaynhanphong`, `Ngaytraphong`) "
							+ "VALUES ('" + hd.getMaPG() + "','" + hd.getMaNV() + "','" + hd.getTenHopDong() + "','"
							+ hd.getNgaylap() + "','" + hd.getSotientratruoc() + "','" + hd.getSotientrasau() + "','"
							+ hd.getNguoidangky() + "','" + hd.getNguoinhanphong() + "','" + hd.getNgaynhanphong()
							+ "','" + hd.getNgaytraphong() + "')");
			if (rs1 == 1) {
				System.out.println("Thêm thành công hợp đồng");
			} else {
				System.out.println("Thêm hợp đồng thất bại,yêu cầu bạn lập lại hợp đồng mới!!!");
			}
			/* Cập nhật thông tin phòng */
			int res = stm.executeUpdate(
					"UPDATE `phong` SET `MaTT`= 3 WHERE MaPG = "+hd.getMaPG()+"");
			ResultSet rs = stm.executeQuery(
					"select phong.tenPhongKS,nhanvien.Hoten,hopdong.Tenhopdong,hopdong.Ngaylap,hopdong.Sotientratruoc,hopdong.Sotientrasau,hopdong.Nguoidangki,hopdong.Nguoinhanphong,hopdong.Ngaynhanphong,hopdong.Ngaytraphong from phong,hopdong,nhanvien WHERE hopdong.MaPG = phong.MaPG AND hopdong.MaNV = nhanvien.MaNV AND phong.MaPG = "+hd.getMaPG()+"");
			System.out.println("\t\t\t\t\t\t\t===== Thông tin hợp đồng  =====");
			System.out.println(
					"TEN PHONG \t\t TEN NHAN VIEN \t\t TEN HOP DONG \t\t NGAY LAP \t\t SO TIEN TRA TRUOC \t\t SO TIEN TRA SAU \t\t NGUOI DANG KI \t\t NGUOI NHAN PHONG \t\t NGAY NHAN PHONG \t\t NGAY TRA PHONG  ");
			while (rs.next()) {

				System.out.println(rs.getString(1) + " \t\t " + rs.getString(2) + " \t\t " + rs.getString(3) + " \t\t"
						+ rs.getString(4) + " \t\t " + rs.getString(5) + " \t\t\t " + rs.getString(6) + " \t\t\t"
						+ rs.getString(7) + " \t\t\t\t" + rs.getString(8) + " \t\t\t " + rs.getString(9) + " \t\t\t "
						+ rs.getString(10) );
			}
			
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	public void orderPhong() {
		Scanner sc = new Scanner(System.in);
		datPhong dp = new datPhong();
		dp.datphong();
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			Statement stm = conn.createStatement();
			int rs = stmt.executeUpdate("INSERT INTO `datphong`(`Ngaydat`, `Ngaynhan`, `Tiencoc`, `MaPG`, `Hoten`, `Sodienthoai`)"
					+ "VALUES ('" + dp.getNgaydat() + "','" + dp.getNgaynhan() + "','" + dp.getTiencoc()
					+ "','" + dp.getMaPG() + "','" + dp.getHoten() + "','"+dp.getSodienthoai()+"')");
			if (rs == 1) {
				System.out.println("Đặt phòng thành công");
			} else {
				System.out.println("Đặt phòng thất bại,yêu cầu bạn đặt phòng lại!!!");
			}
			/* Cập nhật thông tin phòng */
			int res = stm.executeUpdate(
					"UPDATE `phong` SET `MaTT`= 2 WHERE MaPG = "+dp.getMaPG()+"");
			ResultSet result = stmt.executeQuery(
					"select phong.MaPG,phong.tenPhongKS,datphong.Hoten,datphong.Sodienthoai,trangthai.trangThai,loaiphong.tenLoai,datphong.ngaydat,datphong.ngaynhan from datphong,phong,trangthai,loaiphong where phong.MaPG = datphong.MaPG AND phong.MaTT = trangthai.MaTT AND phong.MaLP = loaiphong.MaLP AND phong.MaTT = 2");
			System.out.println("\t\t\t\t\t\t\t===== Danh sách phòng đã đặt cộc =====");
			System.out.println(
					"MA PHONG \t\t TEN PHONG \t\t TEN NGUOI DAT \t\t SDT \t\t TRANG THAI \t\t LOAI PHONG \t\t NGAY DAT \t\t NGAY NHAN  ");
			while (result.next()) {

				System.out.println(result.getInt(1) + " \t\t\t " + result.getString(2) + " \t\t " + result.getString(3) + " \t\t"
						+ result.getString(4) + " \t " + result.getString(5) + " \t " + result.getString(6) + "\t "
						+ result.getString(7) + " \t\t " + result.getString(8) + " \t\t ");
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
	
	
	public void thongTinHopDong() {
		try {
			Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(
					"select phong.tenPhongKS,nhanvien.Hoten,hopdong.Tenhopdong,hopdong.Ngaylap,hopdong.Sotientratruoc,hopdong.Sotientrasau,hopdong.Nguoidangki,hopdong.Nguoinhanphong,hopdong.Ngaynhanphong,hopdong.Ngaytraphong from phong,hopdong,nhanvien WHERE hopdong.MaPG = phong.MaPG AND hopdong.MaNV = nhanvien.MaNV");
			System.out.println("\t\t\t\t\t\t\t===== Thông tin hợp đồng  =====");
			System.out.println(
					"TEN PHONG \t TEN NHAN VIEN \t\t TEN HOP DONG \t\t NGAY LAP \t\t SO TIEN TRA TRUOC \t\t SO TIEN TRA SAU \t\t NGUOI DANG KI \t\t NGUOI NHAN PHONG \t\t NGAY NHAN PHONG \t\t NGAY TRA PHONG  ");
			while (rs.next()) {

				System.out.println(rs.getString(1) + " \t\t " + rs.getString(2) + " \t\t " + rs.getString(3) + " \t\t"
						+ rs.getString(4) + " \t\t " + rs.getString(5) + " \t\t\t " + rs.getString(6) + " \t\t\t"
						+ rs.getString(7) + " \t\t\t\t" + rs.getString(8) + " \t\t\t " + rs.getString(9) + " \t\t\t "
						+ rs.getString(10) );
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	

}