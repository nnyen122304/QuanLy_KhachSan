package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import KhachSan.GiaThue;
public class QuanLy_GiaThue {
	private static String DB_URL = "jdbc:mysql://localhost:3306/qlks-2";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    
    public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    public void danhSachGiaPhong() {
		System.out.println("\n------------------------**in danh sách giá phòng**---------------------\n");
    	try {
           
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            // get data from table 'student'
           ResultSet rs1 = stmt.executeQuery("select * from giaphong");
           System.out.println("MA GIA PHONG \t MA PHONG \t\t GIA PHONG \t\t NGAY BAT DAU \t\t NGAY KET THUC");
	            	while (rs1.next()) {
	            		
	            		//System.out.println("có mã1");
	            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
	            }
	         
	          //}
            
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
    
    public void danhSachGiaDV() {
		System.out.println("\n------------------------**in danh sách giá dịch vụ**---------------------\n");
    	try {
           
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            // get data from table 'student'
           ResultSet rs1 = stmt.executeQuery("select * from giadichvu");
           System.out.println("MA GIA DV \t MA DICH VU \t\t GIA DICH VU \t\t\t NGAY BAT DAU \t\t\t NGAY KET THUC");
	            	while (rs1.next()) {
	            		
	            		//System.out.println("có mã1");
	            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
	            }
	         
	          //}
            
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public void themGiaPhong() {
		try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Thêm Giá Phòng**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao so phong can them gia: ");
		      int number = sc.nextInt();
		      
		      for (int i = 0; i < number; i++) {
		    	  GiaThue giaphong = new GiaThue();
			      	giaphong.nhapGiaPhong();
						
					String sql = "INSERT INTO giaphong (`MaPG`, `Gia`, `Ngay_Tu`, `Ngay_Den`) VALUES ('"+giaphong.getMaPG()+"', '"+giaphong.getGia()+"','"+giaphong.getNgay_Tu()+"','"+giaphong.getNgay_Den()+"') ";
					int rs= stmt.executeUpdate(sql);
					System.out.println("\nThem thanh cong !!\n");
		      }
		      
		      ResultSet rs1 = stmt.executeQuery("select * from giaphong");
	           System.out.println("MA GIA PHONG \t MA PHONG \t\t GIA PHONG \t\t NGAY BAT DAU \t\t NGAY KET THUC");
            	while (rs1.next()) {
            		
            		//System.out.println("có mã1");
            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
	            }

			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
	      
	}
	
	
	
	public void themGiaDV() {
		try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Thêm Giá dịch vụ**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao so dich vu can them gia: ");
		      int number = sc.nextInt();
		      
		      for (int i = 0; i < number; i++) {
		    	  GiaThue giadv = new GiaThue();
			      	giadv.nhapDV();
						
					String sql = "INSERT INTO giadichvu (`MaDV`, `Gia`, `Ngay_Tu`, `Ngay_Den`) VALUES ('"+giadv.getMaDV()+"', '"+giadv.getGiaDV()+"','"+giadv.getTu_ngay()+"','"+giadv.getDen_Ngay()+"') ";
					int rs= stmt.executeUpdate(sql);
					System.out.println("\nThem thanh cong !!\n");
		      }
		      	
		      ResultSet rs1 = stmt.executeQuery("select * from giadichvu");
		      System.out.println("MA GIA DV \t MA DICH VU \t\t GIA DICH VU \t\t\t NGAY BAT DAU \t\t\t NGAY KET THUC");
            	while (rs1.next()) {
            		
            		//System.out.println("có mã1");
            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
	            }

			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
	      
	}
	
	public void  xoaGiaPhong() {
		try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Xóa Giá Phòng**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap ma gia phong can xoa: ");
		       int maGP = sc.nextInt();
						
		      String sql1 = "DELETE FROM giaphong WHERE MaGP='"+maGP+"' ";
		      int rs1= stmt.executeUpdate(sql1);
		      System.out.println("\nxoa thanh cong !!\n");
		      
		      ResultSet rs = stmt.executeQuery("select * from giaphong");
	           System.out.println("MA GIA PHONG \t MA PHONG \t\t GIA PHONG \t\t NGAY BAT DAU \t\t NGAY KET THUC");
            	while (rs.next()) {
            		
            		//System.out.println("có mã1");
            		System.out.println(rs.getInt(1)+ "\t\t\t" +rs.getInt(2)+ "\t\t" +rs.getFloat(3)+ "\t\t\t" +rs.getString(4)+ "\t\t\t" +rs.getString(5));
	            }
		  
			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
	}
	public void  xoaGiaDV() {
		try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Xóa gia dich vu can xoa**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap ma gia dich vu can xoa: ");
		       int maDV = sc.nextInt();
						
		      String sql1 = "DELETE FROM giadichvu WHERE MaGDV='"+maDV+"' ";
		      int rs1= stmt.executeUpdate(sql1);
		      System.out.println("\nxoa thanh cong !!\n");
		      
		      ResultSet rs = stmt.executeQuery("select * from giadichvu");
		      System.out.println("MA GIA DV \t MA DICH VU \t\t GIA DICH VU \t\t\t NGAY BAT DAU \t\t\t NGAY KET THUC");
           		while (rs.next()) {
           		
           		//System.out.println("có mã1");
           		System.out.println(rs.getInt(1)+ "\t\t\t" +rs.getInt(2)+ "\t\t" +rs.getFloat(3)+ "\t\t\t" +rs.getString(4)+ "\t\t\t" +rs.getString(5));
	            }
		  
			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
	}
	
	
	public void  capNhatGiaPhong() {
		try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("\n------------------------**cập nhật giá thuê Phòng**---------------------\n");
            Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao ma gia phong can cap nhat: ");
		      int maGPCN = sc.nextInt();
//		      GiaThue CNGiaPhong = new GiaThue();
//		      CNGiaPhong.nhapGiaPhong();
		  	Scanner scanner = new Scanner(System.in);
		      System.out.println("Nhap gia phong: ");
		        float Gia = scanner.nextFloat();
		        scanner.nextLine();
				
				System.out.println("Nhap ngay bat dau: ");
				String Ngay_Tu = scanner.nextLine();
				
				System.out.println("Nhap ngay ket thuc: ");
				String Ngay_Den=scanner.nextLine();
		      
          int rs = stmt.executeUpdate("UPDATE giaphong SET Gia='"+Gia+"',Ngay_Tu='"+Ngay_Tu+"',Ngay_Den='"+Ngay_Den+"' WHERE MaGP='"+maGPCN+"'");
         
          if (rs==1) {
        	  System.out.println("\nthanh cong\n");
          } else {
        	  System.out.println("khong thanh cong");
          }
          
          ResultSet rs1 = stmt.executeQuery("select * from giaphong");
          System.out.println("MA GIA PHONG \t MA PHONG \t\t GIA PHONG \t\t NGAY BAT DAU \t\t NGAY KET THUC");
       		while (rs1.next()) {
       		
       		//System.out.println("có mã1");
       		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
           }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	public void  capNhatGiaDV() {
		try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("\n------------------------**cập nhật giá thuê dịch vụ**---------------------\n");
            Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao ma gia dich vu can cap nhat: ");
		      int maGDVCN = sc.nextInt();
//		      GiaThue CNGiaPhong = new GiaThue();
//		      CNGiaPhong.nhapGiaPhong();
		  	Scanner scanner = new Scanner(System.in);
		      System.out.println("Nhap gia dich vu: ");
		       float GiaDV = scanner.nextFloat();
		        scanner.nextLine();
				
				System.out.println("Nhap ngay bat dau dich vu: ");
				String Ngay_Tu = scanner.nextLine();
				
				System.out.println("Nhap ngay ket thuc dich vu: ");
				String Ngay_Den=scanner.nextLine();
		      
          int rs = stmt.executeUpdate("UPDATE giadichvu SET Gia='"+GiaDV+"',Ngay_Tu='"+Ngay_Tu+"',Ngay_Den='"+Ngay_Den+"' WHERE MaGDV='"+maGDVCN+"'");
         
          if (rs==1) {
        	  System.out.println("\nthanh cong\n");
          } else {
        	  System.out.println("khong thanh cong");
          }
          
          ResultSet rs1 = stmt.executeQuery("select * from giadichvu");
          System.out.println("MA GIA DV \t MA DICH VU \t\t GIA DICH VU \t\t\t NGAY BAT DAU \t\t\t NGAY KET THUC");
      		while (rs1.next()) {
      		
      		//System.out.println("có mã1");
      		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getFloat(3)+ "\t\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getString(5));
           }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
}
	
