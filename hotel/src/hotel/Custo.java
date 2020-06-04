package hotel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class Custo implements Serializable{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 6827736597435861626L;
	private String cust_mob;//
	private String cust_name;//
	private String password;//
	private String room_name;//
	private int choice;//
	private float bill;
	private float other_bill;
	private float food_bill;
	private float room_bill;//
	private float ext_room_bill;
	private int room_pr;//
	private long stay;//
	private long ext_stay;//
	private float discount;
	private float gst;
	private int status;//
	private LocalDate entry_dt;//
	private LocalDate exit_dt;//
	private LocalDate extend;//
	private int flag;
	Map<Integer, Integer> Room_price = new HashMap<Integer, Integer>();//
	
	
	Custo(String mob, String name, String pass, LocalDate ent, LocalDate ex, int ch, String r_name){
		this.cust_mob = mob;
		this.cust_name = name;
		this.password = pass;
		this.choice = ch;
		this.entry_dt = ent;
		this.exit_dt = ex;
		this.choice = ch;
		this.Room_price.put(1, 5000);
		this.Room_price.put(2, 9000);
		this.Room_price.put(3, 15000);
		this.Room_price.put(4, 22000);
		this.room_pr = this.Room_price.get(this.choice);
		long day = ChronoUnit.DAYS.between(this.entry_dt, this.exit_dt);
		if(day == 0) {this.stay = 1;}
		else if(day > 0) {this.stay = day;}
		else {System.out.println("Please enter proper dates");}
		this.room_bill = this.stay * this.room_pr;
		this.room_name = r_name;
		
		this.status = 1;		
		
	}


	public String getCust_mob() {
		return cust_mob;
	}


	public void setCust_mob(String cust_mob) {
		this.cust_mob = cust_mob;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}
	
	public float gst(float bill) {
		return (bill * 18) / 100;
	}
	
	
	public float discount(float bill, float dis) {
		return (bill * dis) / 100;
	}
	
	public float bill() throws IOException {
		float bil;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Food Bill :");
		String s = br.readLine();
		this.food_bill = this.food_bill + Float.parseFloat(s);
		System.out.println("Other Bill(If any) :");
		String b = br.readLine();
		this.other_bill = this.other_bill + Float.parseFloat(b);
		bil = this.room_bill + this.food_bill + this.other_bill;
		System.out.println("Discount %(if any) : ");
		String d = br.readLine();
		this.discount = Float.parseFloat(d);
		float dp = discount(bil, this.discount);
		bil = bil - dp;
		this.gst = gst(bil);
		bil = bil + gst;
		this.bill = bil;
		this.status = 0;		
		return this.bill;
	}
	
	public void extend(LocalDate ext) {
		this.extend = ext;
		this.ext_stay = ChronoUnit.DAYS.between(this.exit_dt, this.extend);
		this.stay = this.stay + this.ext_stay;
		this.ext_room_bill = this.ext_stay * this.room_pr;
		this.exit_dt = this.extend;
		this.room_bill = this.stay * this.room_pr;
		this.flag = this.flag + 1;
		this.status = 1;
	}


	public long getStay() {
		return stay;
	}


	public LocalDate getExit_dt() {
		return exit_dt;
	}


	public String getRoom_name() {
		return room_name;
	}


	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}


	@Override
	public String toString() {
		return "\n" + "Customer Mobile No. : " + cust_mob + "\n" + "Customer Name  " + cust_name +"\n"+ "Room : " + room_name + "\n"+ "Check In : "
				+ entry_dt + "\n"+ "Check Out : " + exit_dt + "\n"+ "Stay Days : " + stay + "\n"+"Room Bill : " + room_bill+  "\n"+ "Food Bill : " + food_bill + "\n" + "Other Bill=" + other_bill +  
				 "\n"+ "Discount : " + discount + "\n"+ "Gst : " + gst + "\n"+ "Total Bill : "+ bill + "\n" +"Status(1 means active & 0 means checked out) : " + status + "\n" + "******************************************************"  ;
	}


	

}
