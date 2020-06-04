package hotel;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class serv {

	public static void main(String[] args) throws Exception, IOException {
		
/*
 * checked out cust
 * flush single rooms
 * flush dob
 * flush prm
 * flush sut
 * del cust
 * 
 * */
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Map<String, Custo> c = null;
		Map<String, Custo> sin = null;
		Map<String, Custo> dobl = null;
		Map<String, Custo> pre = null;
		Map<String, Custo> sut = null;
		List<Custo> cust = null;
		
		int flag = 0;
		
		do {
			int ch = 0;
			System.out.println("<<<<<<<< Welcome in Hotel xyz mangement >>>>>>>>");
			System.out.println("1. List Checked-out Customers");
			System.out.println("2. Delete Customers");
			System.out.println("3. Delete Customers from Single Room ");
			System.out.println("4. Delete Customers from Double Room ");
			System.out.println("5. Delete Customers from Premium Room ");
			System.out.println("6. Delete Customers from Suite ");
			System.out.println("Please Enter the serial no of your choice.....");
			int choice = Integer.parseInt(br.readLine());
			
			switch (choice) {
			case 1:
				try(FileInputStream fiis = new FileInputStream("test\\out.dat")) {
					try(ObjectInputStream obc = new ObjectInputStream(fiis)){
						cust = (List<Custo>)obc.readObject();
						System.out.println(cust);
						
					}
				}
				catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				break;
			
			case 2:
				try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
					try(ObjectInputStream ob = new ObjectInputStream(fis)){
						c = (Map<String, Custo>)ob.readObject();
						
						do {
							if(c.size() > 1) {
								System.out.println(c);
								System.out.println("\n" + "Enter the mobile no. of Customer to Delete :");
								String mob = br.readLine();
								if(c.containsKey(mob)) {
									
							//Single rom del		
									try(FileInputStream ss = new FileInputStream("test\\single.dat")) {
										try(ObjectInputStream sss = new ObjectInputStream(ss)){
											sin = (Map<String, Custo>)sss.readObject();
											
											if(sin.containsKey(c.get(mob).getRoom_name())) {
												if(sin.size() > 1) {
													sin.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\single.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(sin);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
												else {
													LocalDate in = LocalDate.parse("01/01/2020", f);
													LocalDate out = LocalDate.parse("02/01/2020", f);
													Custo ca = new Custo("12345", "default", "sameer123", in, out, 1, "test");
													sin.put(ca.getRoom_name(), ca);
													sin.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\single.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(sin);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
											}
										}
									}
								
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									//double room del
									try(FileInputStream ss = new FileInputStream("test\\double.dat")) {
										try(ObjectInputStream sss = new ObjectInputStream(ss)){
											dobl = (Map<String, Custo>)sss.readObject();
											
											if(dobl.containsKey(c.get(mob).getRoom_name())) {
												if(dobl.size() > 1) {
													dobl.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\double.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(dobl);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
												else {
													LocalDate in = LocalDate.parse("01/01/2020", f);
													LocalDate out = LocalDate.parse("02/01/2020", f);
													Custo ca = new Custo("12345", "default", "sameer123", in, out, 1, "test");
													dobl.put(ca.getRoom_name(), ca);
													dobl.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\double.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(dobl);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
											}
										}
									}
								
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									
									//Premium room del
									try(FileInputStream ss = new FileInputStream("test\\premium.dat")) {
										try(ObjectInputStream sss = new ObjectInputStream(ss)){
											pre = (Map<String, Custo>)sss.readObject();
											
											if(pre.containsKey(c.get(mob).getRoom_name())) {
												if(pre.size() > 1) {
													pre.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\premium.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(pre);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
												else {
													LocalDate in = LocalDate.parse("01/01/2020", f);
													LocalDate out = LocalDate.parse("02/01/2020", f);
													Custo ca = new Custo("12345", "default", "sameer123", in, out, 1, "test");
													pre.put(ca.getRoom_name(), ca);
													pre.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\premium.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(pre);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
											}
										}
									}
								
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									//Suite room del
									try(FileInputStream ss = new FileInputStream("test\\suite.dat")) {
										try(ObjectInputStream sss = new ObjectInputStream(ss)){
											sut = (Map<String, Custo>)sss.readObject();
											
											if(sut.containsKey(c.get(mob).getRoom_name())) {
												if(sut.size() > 1) {
													sut.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\suite.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(sut);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
												else {
													LocalDate in = LocalDate.parse("01/01/2020", f);
													LocalDate out = LocalDate.parse("02/01/2020", f);
													Custo ca = new Custo("12345", "default", "sameer123", in, out, 1, "test");
													sut.put(ca.getRoom_name(), ca);
													sut.remove(c.get(mob).getRoom_name());
													try(FileOutputStream fos = new FileOutputStream("test\\suite.dat")) {
														try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
															
																obj.writeObject(sut);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
												}
											}
										}
									}
								
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									c.remove(mob);
			
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println("/n"+"Customer Details removed Successfully ...");
									System.out.println("press 0 to continue and 1 to exit deleting function..");
									ch = Integer.parseInt(br.readLine());
							}
							
								else {System.out.println("NO such Customer with Mobile no. : " + mob);}
							}
							else {
								System.out.println("No values to delete except default values");
								break;
							}

						}while(ch != 1);


						}
						
					}
				
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				try(FileInputStream ss = new FileInputStream("test\\single.dat")) {
					try(ObjectInputStream sss = new ObjectInputStream(ss)){
						sin = (Map<String, Custo>)sss.readObject();
						
						do {
							if(sin.size() > 1) {
								System.out.println(sin);
								System.out.println("\n" + "Enter the Room no. of Customer to Delete :");
								String room = br.readLine();
								if(sin.containsKey(room)) {
									
									try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
										try(ObjectInputStream ob = new ObjectInputStream(fis)){
											c = (Map<String, Custo>)ob.readObject();
											c.remove(sin.get(room).getCust_mob());
											}
										}
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									sin.remove(room);
			
									try(FileOutputStream fos = new FileOutputStream("test\\single.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(sin);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println("\n"+"Customer Details removed Successfully ...");
									System.out.println("press 0 to continue and 1 to exit deleting function..");
									ch = Integer.parseInt(br.readLine());
							}	
						
						
							else {System.out.println("NO such Customer with Room no. : " );}
							}
							else {
								System.out.println("No Customers except default values");
								break;
							}
						}while(ch != 1);
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
	
				break;	
				
			case 4:
				try(FileInputStream ss1 = new FileInputStream("test\\double.dat")) {
					try(ObjectInputStream ss2 = new ObjectInputStream(ss1)){
						dobl = (Map<String, Custo>)ss2.readObject();
						
						do {
							if(dobl.size() > 1) {
								System.out.println(dobl);
								System.out.println("\n" + "Enter the Room no. of Customer to Delete :");
								String room = br.readLine();
								if(dobl.containsKey(room)) {
									
									try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
										try(ObjectInputStream ob = new ObjectInputStream(fis)){
											c = (Map<String, Custo>)ob.readObject();
											c.remove(dobl.get(room).getCust_mob());
											}
										}
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									dobl.remove(room);
			
									try(FileOutputStream fos = new FileOutputStream("test\\double.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(dobl);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println("\n"+"Customer Details removed Successfully ...");
									System.out.println("press 0 to continue and 1 to exit deleting function..");
									ch = Integer.parseInt(br.readLine());
							}	
						
						
							else {System.out.println("NO such Customer with Room no. : " );}
							}
							else {
								System.out.println("No Customers except default values");
								break;
							}
						}while(ch != 1);
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
	
				break;
				
			case 5:
				try(FileInputStream ss1 = new FileInputStream("test\\premium.dat")) {
					try(ObjectInputStream ss2 = new ObjectInputStream(ss1)){
						pre = (Map<String, Custo>)ss2.readObject();
						
						do {
							if(pre.size() > 1) {
								System.out.println(pre);
								System.out.println("\n" + "Enter the Room no. of Customer to Delete :");
								String room = br.readLine();
								if(pre.containsKey(room)) {
									
									try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
										try(ObjectInputStream ob = new ObjectInputStream(fis)){
											c = (Map<String, Custo>)ob.readObject();
											c.remove(pre.get(room).getCust_mob());
											}
										}
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									pre.remove(room);
			
									try(FileOutputStream fos = new FileOutputStream("test\\premium.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(pre);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println("\n"+"Customer Details removed Successfully ...");
									System.out.println("press 0 to continue and 1 to exit deleting function..");
									ch = Integer.parseInt(br.readLine());
							}	
						
						
							else {System.out.println("NO such Customer with Room no. : " );}
							}
							else {
								System.out.println("No Customers except default values");
								break;
							}
						}while(ch != 1);
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
	
				break;
				
			case 6:
				try(FileInputStream ss1 = new FileInputStream("test\\suite.dat")) {
					try(ObjectInputStream ss2 = new ObjectInputStream(ss1)){
						sut = (Map<String, Custo>)ss2.readObject();
						
						do {
							if(sut.size() > 1) {
								System.out.println(sut);
								System.out.println("\n" + "Enter the Room no. of Customer to Delete :");
								String room = br.readLine();
								if(sut.containsKey(room)) {
									
									try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
										try(ObjectInputStream ob = new ObjectInputStream(fis)){
											c = (Map<String, Custo>)ob.readObject();
											c.remove(sut.get(room).getCust_mob());
											}
										}
									catch (ClassNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									
									sut.remove(room);
			
									try(FileOutputStream fos = new FileOutputStream("test\\suite.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(sut);
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println("\n"+"Customer Details removed Successfully ...");
									System.out.println("press 0 to continue and 1 to exit deleting function..");
									ch = Integer.parseInt(br.readLine());
							}	
						
						
							else {System.out.println("NO such Customer with Room no. : " );}
							}
							else {
								System.out.println("No Customers except default values");
								break;
							}
						}while(ch != 1);
					}
				}
				catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
	
	
				break;

			default:
				System.out.println("Please enter Proper option");
				break;
			}
			
			System.out.println("Press 0 to continue || Press 1 to exit");
			flag = Integer.parseInt(br.readLine());
		}while(flag != 1);
		
	}

}
