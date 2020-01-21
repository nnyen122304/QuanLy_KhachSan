package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	private static String DB_URL = "jdbc:mysql://localhost:3306/qlks-2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            Scanner sc = new Scanner(System.in);
            
         // Cau 1
            QuanLy_ChuKS chuKS = new QuanLy_ChuKS(); 
//           chuKS.hienThiDS_CKS();
//           chuKS.themChuKS();
//           chuKS.capnhatChuKS();
//           chuKS.xoaChuKS();
          
         //Cau2
          QuanLy_KhachSan ks = new QuanLy_KhachSan();
//          ks.layDSKhachSan();
//          ks.themKhachSan();
//          ks.capnhatKS();
//          ks.xoaKhachSan();
          
          //Cau3
          QuanLy_PhongKS phongks= new QuanLy_PhongKS();
//	  		phongks.danhSachKS();
//	  		phongks.themPhong();
//	  		phongks.xoaPhong();
//	  		phongks.suaTTPhong();
          
          //Cau4
          QuanLy_GiaThue giathue =new QuanLy_GiaThue();
//          giathue.danhSachGiaPhong();
//  		giathue.themGiaPhong();
//		    giathue.capNhatGiaPhong();
//		    giathue.xoaGiaPhong();
          
//          giathue.danhSachGiaDV();
//	  		giathue.themGiaDV();
//	  		giathue.capNhatGiaDV();
//		    giathue.xoaGiaDV();
            
          //Cau5
          QuanLy_ChoThue  choThue = new QuanLy_ChoThue();
//  		choThue.timPhongTrong();
//  		choThue.taoHopDong();
//  		choThue.thongTinHopDong();
          
          //Cau6
          QuanLy_ThuPhi  thuPhi = new QuanLy_ThuPhi();
//          thuPhi.phongDangThue();
//          thuPhi.taoPhieuThu();
//          thuPhi.thongTinPhieuThu();
          
          //login
          DangNhap dn = new DangNhap();
          dn.login();
          int choose = 0;
  		boolean exit = false;
  		dn.menuLoaiPhong();
  		while (true) {
  			choose = sc.nextInt();
  			switch (choose) {
  			case 1:
  				choThue.timPhongTrong();
  			break;
  			case 2:
  				choThue.thongTinHopDong();
  			break;
  			case 3:
  				choThue.taoHopDong();
  			break;
  			case 4:
  				thuPhi.phongDangThue();
  			break;
  			case 5:
  				thuPhi.taoPhieuThu();
  			break;
  			case 6:
  				choThue.orderPhong();
  			break;
  			case 7:
  				System.out.println("Thoát");
  				exit = true;
  				break;
  			default:
  				System.out.println("Vui lòng chọn một trong những số trong menu: ");
  				break;
  			}
  			if (exit) {
  				break;
  			}
  			dn.menuLoaiPhong();
  		}
  			
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

	}
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

}
