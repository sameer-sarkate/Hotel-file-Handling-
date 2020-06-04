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
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class app {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/yyyy");



		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		
		int flag = 0;
		
		do {
			int single, dob, premium, suite;
			
			Map<String, Custo> c = new HashMap<String, Custo>();
			Map<String, Custo> sin = new HashMap<String, Custo>();
			Map<String, Custo> dobl = new HashMap<String, Custo>();
			Map<String, Custo> pre = new HashMap<String, Custo>();
			Map<String, Custo> sut = new HashMap<String, Custo>();
			List<Custo> cust = new LinkedList<Custo>();
			
			
			System.out.println("<<<<<<<<<<<<<<<<<Welcome to hotel xyz>>>>>>>>>>>>>>");
			System.out.println("Please Enter Mobile no.");
			String c_mob = br.readLine();
			
			try(FileInputStream fis = new FileInputStream("test\\custo.dat")) {
				try(ObjectInputStream ob = new ObjectInputStream(fis)){
					
					c = (Map<String, Custo>)ob.readObject();
					boolean key = c.containsKey(c_mob);
					if(key == true) {
						System.out.println("Enter Password :");
						String pass = br.readLine();
						if(c.get(c_mob).getPassword().equals(pass)) {
							
							System.out.println("Press the serial no. of your choice :");
							System.out.println("1. Checkout");
							System.out.println("2. Extend Stay");
							
							int ch = Integer.parseInt(br.readLine());
							
							if(ch == 1) {
								c.get(c_mob).bill();
								System.out.println(c.get(c_mob));
								
								try(FileInputStream fiis = new FileInputStream("test\\out.dat")) {
									try(ObjectInputStream obc = new ObjectInputStream(fiis)){
										cust = (List<Custo>)obc.readObject();
										
									}
								}
								catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								catch (IOException e) {
									e.printStackTrace();
								}
								
								cust.add(c.get(c_mob));
								
								try(FileOutputStream foos = new FileOutputStream("test\\out.dat")) {
									try(ObjectOutputStream objj = new ObjectOutputStream(foos)){
										
											objj.writeObject(cust);
														
									}
								}
								catch (FileNotFoundException e) {
									e.printStackTrace();
								}
								catch (IOException e) {
									e.printStackTrace();
								}
								
								
								//Single rom del		
								try(FileInputStream ss = new FileInputStream("test\\single.dat")) {
									try(ObjectInputStream sss = new ObjectInputStream(ss)){
										sin = (Map<String, Custo>)sss.readObject();
										
										if(sin.containsKey(c.get(c_mob).getRoom_name())) {
											if(sin.size() > 1) {
												sin.remove(c.get(c_mob).getRoom_name());
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
												sin.remove(c.get(c_mob).getRoom_name());
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
										
										if(dobl.containsKey(c.get(c_mob).getRoom_name())) {
											if(dobl.size() > 1) {
												dobl.remove(c.get(c_mob).getRoom_name());
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
												dobl.remove(c.get(c_mob).getRoom_name());
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
										
										if(pre.containsKey(c.get(c_mob).getRoom_name())) {
											if(pre.size() > 1) {
												pre.remove(c.get(c_mob).getRoom_name());
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
												pre.remove(c.get(c_mob).getRoom_name());
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
										
										if(sut.containsKey(c.get(c_mob).getRoom_name())) {
											if(sut.size() > 1) {
												sut.remove(c.get(c_mob).getRoom_name());
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
												sut.remove(c.get(c_mob).getRoom_name());
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
								
								
								c.remove(c_mob);
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
							}
							else if(ch == 2) {
								System.out.println("Enter extended checkout date (strictly in dd/mm/yyy format) :");
								String dt = br.readLine();
								LocalDate date = LocalDate.parse(dt, f);
								long days = ChronoUnit.DAYS.between(c.get(c_mob).getExit_dt(), date);
								
								if(days>0) {
									c.get(c_mob).extend(date);
									c.get(c_mob).bill();
									try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
										try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
											
												obj.writeObject(c);
												System.out.println("Extended succsessfully...");
															
										}
									}
									catch (FileNotFoundException e) {
										e.printStackTrace();
									}
									catch (IOException e) {
										e.printStackTrace();
									}
									System.out.println(c.get(c_mob));
								}
								else {
									System.out.println("Extend Date must be after previous checkout date...");
								}

							}
							else {
								System.out.println("enter proper choice");
							}
							
						}
						else {
							System.out.println("Incorrect password");
						}
					}
					else {


						
						try(FileInputStream dss = new FileInputStream("test\\double.dat")) {
							try(ObjectInputStream sds = new ObjectInputStream(dss)){
								dobl = (Map<String, Custo>)sds.readObject();
							}
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						
						try(FileInputStream pss = new FileInputStream("test\\premium.dat")) {
							try(ObjectInputStream sps = new ObjectInputStream(pss)){
								pre = (Map<String, Custo>)sps.readObject();
							}
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						
						try(FileInputStream sus = new FileInputStream("test\\suite.dat")) {
							try(ObjectInputStream sts = new ObjectInputStream(sus)){
								sut = (Map<String, Custo>)sts.readObject();
							}
						}
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						
						single = 15 - sin.size();
						dob = 9 - dobl.size();
						premium = 6 - pre.size();
						suite = 4 - sut.size();
						
						System.out.println("Rooms that we offer");
						System.out.println("1. Single Room - Rs.5000/-");
						System.out.println("2. Double Room - Rs.9000/-");
						System.out.println("3. Premium - Rs.15000/-");
						System.out.println("4. Suite - Rs.22000/-");
						System.out.println("Enter serial no of choice of your room : ");
						int choice = Integer.parseInt(br.readLine());
						System.out.println("Enter name");
						String name = br.readLine();
						System.out.println("Enter checkin date (strictly in dd/mm/yyy format) :");
						String entry = br.readLine();
						LocalDate in = LocalDate.parse(entry, f);
						System.out.println("Enter checkout date (strictly in dd/mm/yyy format) :");
						String exit = br.readLine();
						LocalDate out = LocalDate.parse(exit, f);
						long day = ChronoUnit.DAYS.between(in, out);
						
						if(day >= 0) {

							
							if(choice > 0 && choice < 5) {
								System.out.println("Set Password : ");
								String password = br.readLine();
								
								if(choice == 1) {
									
									if(single > 0) {
										String r_name = "S"+single;
										Custo n = new Custo(c_mob, name, password, in, out, choice, r_name);
										c.put(c_mob, n);
										try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
											try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
												
													obj.writeObject(c);
													sin.put(c.get(c_mob).getRoom_name(), c.get(c_mob));
													try(FileOutputStream ss = new FileOutputStream("test\\single.dat")) {
														try(ObjectOutputStream sins = new ObjectOutputStream(ss)){
															
																sins.writeObject(sin);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
													System.out.println("Booking Done Succsessfully in Room : " + r_name);
												
											}
										}
										catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										catch (IOException e) {
											e.printStackTrace();
										}
									}
									else {System.out.println("Sorry, Single room not available at the moment...");}
									
									
								}
								if(choice == 2) {
									
									if(dob > 0) {
										String r_name1 = "D"+dob;
										Custo n = new Custo(c_mob, name, password, in, out, choice, r_name1);
										c.put(c_mob, n);
										try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
											try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
												
													obj.writeObject(c);
													dobl.put(c.get(c_mob).getRoom_name(), c.get(c_mob));
													try(FileOutputStream ds = new FileOutputStream("test\\double.dat")) {
														try(ObjectOutputStream dss = new ObjectOutputStream(ds)){
															
																dss.writeObject(dobl);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
													System.out.println("Booking Done Succsessfully in Room : " + r_name1);
												
											}
										}
										catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										catch (IOException e) {
											e.printStackTrace();
										}
									}
									else {System.out.println("Sorry, Single room not available at the moment...");}
									

								}
								if(choice == 3) {
									
									if(premium > 0) {
										String r_name2 = "P"+premium;
										Custo n = new Custo(c_mob, name, password, in, out, choice, r_name2);
										c.put(c_mob, n);
										try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
											try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
												
													obj.writeObject(c);
													pre.put(c.get(c_mob).getRoom_name(), c.get(c_mob));
													try(FileOutputStream ps = new FileOutputStream("test\\premium.dat")) {
														try(ObjectOutputStream prs = new ObjectOutputStream(ps)){
															
																prs.writeObject(pre);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
													System.out.println("Booking Done Succsessfully in Room : " + r_name2);
												
											}
										}
										catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										catch (IOException e) {
											e.printStackTrace();
										}
									}
									else {System.out.println("Sorry, Single room not available at the moment...");}
									

								}
								if(choice == 4) {
									
									if(suite > 0) {
										String r_name3 = "ST"+suite;
										Custo n = new Custo(c_mob, name, password, in, out, choice, r_name3);
										c.put(c_mob, n);
										try(FileOutputStream fos = new FileOutputStream("test\\custo.dat")) {
											try(ObjectOutputStream obj = new ObjectOutputStream(fos)){
												
													obj.writeObject(c);
													sut.put(c.get(c_mob).getRoom_name(), c.get(c_mob));
													try(FileOutputStream sus = new FileOutputStream("test\\suite.dat")) {
														try(ObjectOutputStream sts = new ObjectOutputStream(sus)){
															
																sts.writeObject(sut);
																			
														}
													}
													catch (FileNotFoundException e) {
														e.printStackTrace();
													}
													catch (IOException e) {
														e.printStackTrace();
													}
													System.out.println("Booking Done Succsessfully in Room : " + r_name3);
												
											}
										}
										catch (FileNotFoundException e) {
											e.printStackTrace();
										}
										catch (IOException e) {
											e.printStackTrace();
										}
									}
									else {System.out.println("Sorry, Single room not available at the moment...");}
									
									
								}


							}
							else {
								System.out.println("You have entered wrong room type....please enter a valid choice");
							}
						}
						else {
							System.out.println("Check-in date must be Prior to check-out dates....");
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
			
			System.out.println("...............Press 1 to exit || Press 0 to continue...........");
			flag = Integer.parseInt(br.readLine());
			
		}while(flag != 1);
		
		br.close();
		
		

		
		
		
	}

}
