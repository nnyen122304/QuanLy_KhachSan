package KhachSan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class QuanLy_ChuKS {
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
    
    public void hienThiDS_CKS() {
    	System.out.println("\n------------------------**BT1_Lấy danh sách Chu khach san**---------------------\n");
    	try {
            // connnect to database 'testdb'
            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
            // crate statement
            Statement stmt = conn.createStatement();
            // get data from table 'student'
           ResultSet rs1 = stmt.executeQuery("select * from chukhachsan");
   			System.out.println("MA CKS \t\t HO TEN \t\t DIA CHI \t\t\t SO DIEN THOAI \t\t\t\t EMAIL ");

            	while (rs1.next()) {
            		System.out.println(rs1.getInt(1)+ "\t\t" +rs1.getString(2)+ "\t\t\t" +rs1.getString(3)+ "\t\t\t\t" +rs1.getString(4)+ "\t\t\t\t" +rs1.getString(5) );
	            }

            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
    
    public void themChuKS() { 
      try(
            Connection conn = QuanLy_ChuKS.getConnection(DB_URL, USER_NAME, PASSWORD);
            Statement st = conn.createStatement();
	        ){ 
    	  System.out.println("\n------------------------**BT1_Thêm chủ khách sạn**---------------------\n");
	      Scanner sc = new Scanner(System.in);
	      System.out.print("\nNhap vao so chu khach san can them: ");
	      int number = sc.nextInt();
	      for (int i = 0; i < number; i++) {
	    	  ChuKhachSan chuks = new ChuKhachSan();
	    	  chuks.nhapChuKhachSan();
					
				String sql = "INSERT INTO chukhachsan ( `Hoten`, `Diachi`, `Sodienthoai`, `Email`) VALUES ( '"+chuks.getHoten()+"','"+chuks.getDiachi()+"','"+chuks.getSodienthoai()+"','"+chuks.getEmail()+"') ";
				int rs= st.executeUpdate(sql);
				
	      }
	      System.out.println("\nThem thanh cong !!");
	      
	      Statement stmt = conn.createStatement();
	      ResultSet rs = stmt.executeQuery("select * from chukhachsan");
	      System.out.println("MA CKS \t\t\t HO TEN \t\t\t DIA CHI \t\t SO DIEN THOAI \t\t\t EMAIL ");
	      while(rs.next()) {
				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getString(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
						+ rs.getString(4) + " \t\t\t " + rs.getString(5)  + " \t\t\t ");
			}
		   conn.close();
     }catch (Exception e) { 
          System.out.println(e);
      }

    }
    
    public void capnhatChuKS() {
    	System.out.println("\n-----------**BT1_Cập thật thông tin chủ khách sạn**-----------\n");
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nNhap vao so luong chu khach san can cap nhat: ");
        int slChu = sc.nextInt();
        sc.nextLine();
        
	    if(slChu != 0) {
	    	try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            Statement stmt = conn.createStatement();

	            for(int i=0; i<slChu; i++) {
	            	ChuKhachSan chuks = new ChuKhachSan();
	            	
	            	System.out.println("\nNhap vao ma chu khach san can cap nhat: ");
	 				int maChuKS = sc.nextInt();
	 				
		            chuks.nhapChuKhachSan();
	            	int rs = stmt.executeUpdate("UPDATE chukhachsan SET `Hoten`= '"+chuks.getHoten()+"', `Diachi`= '"+chuks.getDiachi()+"', `Sodienthoai`= '"+chuks.getSodienthoai()+"', `Email`= '"+chuks.getEmail()+"' WHERE `MaCKS`='"+maChuKS+"' ");

		            if(rs == 1) {
		            	System.out.print("\nCap nhat thanh cong\n");
		            }else {
		            	System.out.print("Cap nhat that bai");
		            }
	            }
	            
	  	      	ResultSet rs = stmt.executeQuery("select * from chukhachsan");
	            System.out.println("MA CKS \t\t\t HO TEN \t\t\t DIA CHI \t\t SO DIEN THOAI \t\t\t EMAIL ");
	  	      	while(rs.next()) {
	  				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getString(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
	  						+ rs.getString(4) + " \t\t\t " + rs.getString(5)  + " \t\t\t ");
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
    
    public void xoaChuKS() {
    	System.out.println("\n-----------**BT1_Xóa chủ khách sạn**-----------\n");
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.println("\nNhap vao so luong chu khach san can xoa: ");
        int slChuXoa = sc.nextInt();
        sc.nextLine();
        
	    if(slChuXoa != 0) {
	    	try {
	            Connection conn = getConnection(DB_URL, USER_NAME, PASSWORD);
	            Statement stmt = conn.createStatement();

	            for(int i=0; i<slChuXoa; i++) {
	            	ChuKhachSan chuks = new ChuKhachSan();
	            	
	            	System.out.println("\nNhap vao ma chu khach san can xoa: ");
	 				int maChuKS = sc.nextInt();
	 				
	            	int rs = stmt.executeUpdate("DELETE FROM chukhachsan WHERE MaCKS='"+maChuKS+"' ");
	            	 
		            if(rs == 1) {
		            	System.out.print("\nCap nhat thanh cong");
		            }else {
		            	System.out.print("Cap nhat that bai");
		            }
	            }
	            
	            ResultSet rs = stmt.executeQuery("select * from chukhachsan");
	            System.out.println("MA CKS \t\t\t HO TEN \t\t\t DIA CHI \t\t SO DIEN THOAI \t\t\t EMAIL ");
	  	      	while(rs.next()) {
	  				System.out.println(rs.getInt(1) + " \t\t\t " + rs.getString(2) + " \t\t\t\t " + rs.getString(3) + " \t\t\t"
	  						+ rs.getString(4) + " \t\t\t " + rs.getString(5)  + " \t\t\t ");
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
