package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class QuanLy_PhongKS {
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
	
	public void danhSachKS() {
		System.out.println("\n------------------------**in danh sách phòng**---------------------\n");
    	try {
           
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            // get data from table 'student'
           ResultSet rs1 = stmt.executeQuery("select * from phong");
           System.out.println("MA PHONG \t MA TRANG THAI \t MA LOAI PHONG \t\t TEN PHONG \t\t DIEN TICH \t\t TANG \t\t MA TB ");
	            	while (rs1.next()) {
	            		
	            		//System.out.println("có mã1");
	            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getInt(3)+ "\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getFloat(5)+ "\t\t\t" +rs1.getInt(6)+ "\t\t"+rs1.getInt(7) );
	            }
	         
	          //}
            
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public void themPhong() {
		  try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Thêm Phòng**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao so phong can them: ");
		      int number = sc.nextInt();
		      
		      for (int i = 0; i < number; i++) {
		    	  PhongKS ks = new PhongKS();
			      	ks.nhapPhongKS();
						
					String sql = "INSERT INTO phong (`MaTT`, `MaLP`, `tenPhongKS`, `dienTich`, `Tang`, `MaTB`) VALUES ('"+ks.getMaTT()+"', '"+ks.getMaLP()+"','"+ks.getTenPhongKS()+"','"+ks.getDienTich()+"','"+ks.getTang()+"','"+ks.getTang()+"') ";
					int rs= stmt.executeUpdate(sql);
					System.out.println("Them thanh cong !!");
		      }
		      
		       ResultSet rs1 = stmt.executeQuery("select * from phong");
	           System.out.println("MA PHONG \t MA TRANG THAI \t MA LOAI PHONG \t\t TEN PHONG \t\t DIEN TICH \t\t TANG \t\t MA TB ");
            	while (rs1.next()) {
            		
            		//System.out.println("có mã1");
            		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getInt(3)+ "\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getFloat(5)+ "\t\t\t" +rs1.getInt(6)+ "\t\t"+rs1.getInt(7) );
	            }

			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
	      

	}
	
	public void xoaPhong() {
		try{
			  Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	          Statement stmt = conn.createStatement();
	    	  System.out.println("\n------------------------**Xóa Phòng**---------------------\n");
		      Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap ma phong can xoa: ");
		       int maPG = sc.nextInt();
						
		      String sql1 = "DELETE FROM phong WHERE MaPG='"+maPG+"' ";
		      int rs1= stmt.executeUpdate(sql1);
		      System.out.println("\nxoa thanh cong !!\n");
		      
		      ResultSet rs = stmt.executeQuery("select * from phong");
		        System.out.println("MA PHONG \t MA TRANG THAI \t MA LOAI PHONG \t\t TEN PHONG \t\t DIEN TICH \t\t TANG \t\t MA TB ");
		     	while (rs.next()) {
		     		
		     		//System.out.println("có mã1");
		     		System.out.println(rs.getInt(1)+ "\t\t\t" +rs.getInt(2)+ "\t\t" +rs.getInt(3)+ "\t\t" +rs.getString(4)+ "\t\t\t" +rs.getFloat(5)+ "\t\t\t" +rs.getInt(6)+ "\t\t"+rs.getInt(7) );
		         }
		  
			   conn.close();
	     }catch (Exception e) { 
	          System.out.println(e);
	      }
		
	      
	}
	
	public void suaTTPhong() {
		try {
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement stmt = conn.createStatement();
            System.out.println("\n------------------------**Sửa thông tin Phòng**---------------------\n");
            Scanner sc = new Scanner(System.in);
		      System.out.print("\nNhap vao ma phong can sua thong tin: ");
		      int maPhongSua = sc.nextInt();
		      PhongKS ks = new PhongKS();
		      ks.nhapPhongKS();
          int rs = stmt.executeUpdate("UPDATE phong SET MaTT='"+ks.MaTT+"',MaLP='"+ks.MaLP+"',tenPhongKS='"+ks.tenPhongKS+"',dienTich='"+ks.dienTich+"',Tang='"+ks.Tang+"',MaTB='"+ks.MaTB+"' WHERE MaPG='"+maPhongSua+"'");
         
          if (rs==1) {
        	  System.out.println("\nthanh cong\n");
          } else {
        	  System.out.println("khong thanh cong");
          }
          
          ResultSet rs1 = stmt.executeQuery("select * from phong");
          System.out.println("MA PHONG \t MA TRANG THAI \t MA LOAI PHONG \t\t TEN PHONG \t\t DIEN TICH \t\t TANG \t\t MA TB ");
          while (rs1.next()) {
       		
       		//System.out.println("có mã1");
       		System.out.println(rs1.getInt(1)+ "\t\t\t" +rs1.getInt(2)+ "\t\t" +rs1.getInt(3)+ "\t\t" +rs1.getString(4)+ "\t\t\t" +rs1.getFloat(5)+ "\t\t\t" +rs1.getInt(6)+ "\t\t"+rs1.getInt(7) );
           }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	

}
