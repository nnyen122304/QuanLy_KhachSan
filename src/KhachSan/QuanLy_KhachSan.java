package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QuanLy_KhachSan {
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
	
	public void layDSKhachSan() {
    	System.out.println("\n------------------------**BT2_Lấy danh sách khach san**---------------------\n");
    	try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
  	        ResultSet rs = stmt.executeQuery("select * from khachsan");

//  	        ResultSet rs = stmt.executeQuery("select khachsan.MaKS, chukhachsan.MaCKS, khachsan.Tenkhachsan, khachsan.Diachi, khachsan.Sotang from chukhachsan, khachsan where chukhachsan.MaCKS = khachsan.MaCKS	");
  	        System.out.println("MA KS \t\t\t MA CKS \t\t\t TEN KHACH SAN \t\t DIA CHI \t\t\t SOTANG ");
  	        while(rs.next()) {
  				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getInt(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
  						+ rs.getString(4) + " \t\t\t " + rs.getInt(5)  + " \t\t\t ");
  			}

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
	
	public void themKhachSan() { 
      try(
            Connection conn = QuanLy_ChuKS.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement st = conn.createStatement();
	        ){ 
    	  System.out.println("\n------------------------**BT2_Thêm  khách sạn**---------------------\n");
	      Scanner sc = new Scanner(System.in);
	      System.out.print("\nNhap vao so  khach san can them: ");
	      int number = sc.nextInt();
	      
	      for (int i = 0; i < number; i++) {
	    	  KhachSan kSan = new KhachSan();
	    	  kSan.nhapKhachSan();
					
				String sql = "INSERT INTO khachsan ( `MaCKS`, `Tenkhachsan`, `Diachi`, `Sotang`) VALUES ( '"+kSan.getMaCKS()+"','"+kSan.getTenkhachsan()+"','"+kSan.getDiachi()+"','"+kSan.getSotang()+"') ";
				int rs= st.executeUpdate(sql);
				
	      }
	      System.out.println("Them thanh cong !!\n");
	      
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery("select khachsan.MaKS, chukhachsan.MaCKS, khachsan.Tenkhachsan, khachsan.Diachi, khachsan.Sotang from chukhachsan, khachsan where chukhachsan.MaCKS = khachsan.MaCKS	");
	      System.out.println("MA KS \t\t\t MA CKS \t\t\t TEN KHACH SAN \t\t DIA CHI \t\t\t SOTANG ");
	      while(rs.next()) {
				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getInt(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
						+ rs.getString(4) + " \t\t\t " + rs.getInt(5)  + " \t\t\t ");
			}

		   conn.close();
     }catch (Exception e) { 
          System.out.println(e);
      }

    }
	
	public void capnhatKS() {
    	System.out.println("\n-----------**BT1_Cập thật thông tin khách sạn**-----------\n");
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nNhap vao so luong khach san can cap nhat: ");
        int slKhachSan = sc.nextInt();
        sc.nextLine();
        
	    if(slKhachSan != 0) {
	    	try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            Statement stmt = conn.createStatement();

	            for(int i=0; i<slKhachSan; i++) {
	            	KhachSan ks = new KhachSan();
	            	
	            	System.out.println("\nNhap vao ma khach san can cap nhat: ");
	 				int maKS = sc.nextInt();
	 				
	 				ks.nhapKhachSan();
	            	int rs = stmt.executeUpdate("UPDATE khachsan SET `MaCKS`= '"+ks.getMaCKS()+"', `Tenkhachsan`= '"+ks.getTenkhachsan()+"', `Diachi`= '"+ks.getDiachi()+"', `Sotang`= '"+ks.getSotang()+"' WHERE `MaKS`='"+maKS+"' ");

		            if(rs == 1) {
		            	System.out.print("\nCap nhat thanh cong\n");
		            }else {
		            	System.out.print("Cap nhat that bai");
		            }
	            }
	            
	            ResultSet rs = stmt.executeQuery("select khachsan.MaKS, chukhachsan.MaCKS, khachsan.Tenkhachsan, khachsan.Diachi, khachsan.Sotang from chukhachsan, khachsan where khachsan.MaCKS = chukhachsan.MaCKS");
		  	    System.out.println("MA KS \t\t\t MA CKS \t\t\t TEN KHACH SAN \t\t DIA CHI \t\t\t SOTANG ");
		  	    while(rs.next()) {
		  				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getInt(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
		  						+ rs.getString(4) + " \t\t\t " + rs.getInt(5)  + " \t\t\t ");
	  			}
	            
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	   
	    }
	    else {
	    	System.out.println("Khong tim thay ma chu khach san can tim!!");
	    }
	}
	
	public void xoaKhachSan() {
    	System.out.println("\n-----------**BT1_Xóa khách sạn**-----------\n");
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nNhap vao so luong khach san can xoa: ");
        int slKS_Xoa = sc.nextInt();
        sc.nextLine();
        
	    if(slKS_Xoa != 0) {
	    	try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            Statement stmt = conn.createStatement();

	            for(int i=0; i<slKS_Xoa; i++) {
	            	KhachSan chuks = new KhachSan();
	            	
	            	System.out.println("\nNhap vao ma khach san can xoa: ");
	 				int maKS = sc.nextInt();
	 				
	            	int rs = stmt.executeUpdate("DELETE FROM khachsan WHERE MaKS='"+maKS+"' ");
	            	 
		            if(rs == 1) {
		            	System.out.print("\nCap nhat thanh cong\n");
		            }else {
		            	System.out.print("\nCap nhat that bai\n");
		            }
	            }
	            
	            ResultSet rs = stmt.executeQuery("select khachsan.MaKS, chukhachsan.MaCKS, khachsan.Tenkhachsan, khachsan.Diachi, khachsan.Sotang from chukhachsan, khachsan where chukhachsan.MaCKS = khachsan.MaCKS	");
	  	        System.out.println("MA KS \t\t\t MA CKS \t\t\t TEN KHACH SAN \t\t DIA CHI \t\t\t SOTANG ");
	  	        while(rs.next()) {
	  				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getInt(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
	  						+ rs.getString(4) + " \t\t\t " + rs.getInt(5)  + " \t\t\t ");
	  			}
	            
	            conn.close();
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	   
	    }
	    else {
	    	System.out.println("Khong tim thay ma chu khach san can tim!!");
	    }
	}
    

}
