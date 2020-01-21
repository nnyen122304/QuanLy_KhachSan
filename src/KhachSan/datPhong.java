package KhachSan;

import java.util.Scanner;

public class datPhong {
		private String Ngaynhan;
		private String Ngaydat;
		private float Tiencoc;
		private int MaPG;
		private String Hoten;
		private String Sodienthoai;
		
		public datPhong(String ngaynhan, String ngaydat, float tiencoc, int maPG, String hoten, String sodienthoai) {
			super();
			Ngaynhan = ngaynhan;
			Ngaydat = ngaydat;
			Tiencoc = tiencoc;
			MaPG = maPG;
			Hoten = hoten;
			Sodienthoai = sodienthoai;
		}

		public datPhong() {
			this.Ngaynhan = "";
			this.Ngaydat = "";
			this.Tiencoc = 0;
			this.MaPG = 0;
			this.Hoten = "";
			this.Sodienthoai ="";
		}
		
		public String getNgaynhan() {
			return Ngaynhan;
		}

		public void setNgaynhan(String ngaynhan) {
			Ngaynhan = ngaynhan;
		}

		public String getNgaydat() {
			return Ngaydat;
		}

		public void setNgaydat(String ngaydat) {
			Ngaydat = ngaydat;
		}

		public float getTiencoc() {
			return Tiencoc;
		}

		public void setTiencoc(float tiencoc) {
			Tiencoc = tiencoc;
		}

		public int getMaPG() {
			return MaPG;
		}

		public void setMaPG(int maPG) {
			MaPG = maPG;
		}

		public String getHoten() {
			return Hoten;
		}

		public void setHoten(String hoten) {
			Hoten = hoten;
		}

		public String getSodienthoai() {
			return Sodienthoai;
		}

		public void setSodienthoai(String sodienthoai) {
			Sodienthoai = sodienthoai;
		}

		public void datphong() {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Nhap vao ho ten nguoi dat:" );
			Hoten = scanner.nextLine();
			System.out.print("Nhap vao so dien thoai:" );
			Sodienthoai = scanner.nextLine();
			System.out.print("Nhap vao ngay dat:" );
			Ngaydat = scanner.nextLine();
			System.out.print("Nhap vao ngay nhan phong:" );
			Ngaynhan = scanner.nextLine();
			System.out.print("Nhap vao tien dat coc:" );
			Tiencoc = scanner.nextFloat();
			scanner.nextLine();
			System.out.print("Nhap vao ma phong:" );
			MaPG = scanner.nextInt();
			
			}
	}