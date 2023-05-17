package First_Pakage;
import java.util.*;
class Bus_Booking{
	Scanner scanner=new Scanner(System.in);
	String name;
	int age;
	double adharcard;
	String gender;
	int option;
	Bus_Booking(){
		System.out.print("Enter Your Name: ");
		name=scanner.nextLine();
		System.out.print("Enter your age: ");
		age=scanner.nextInt();
		System.out.print("Enter your adhar number: ");
		adharcard=scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter your Gender: ");
		gender=scanner.nextLine();
		System.out.print("Enter bus number 1/2/3: ");
		option=scanner.nextInt();
	} 
	public boolean books(ArrayList<Bus_Info> bi,ArrayList<Bus_Booking> bb) {
		int cap=0;
		int book=0;
		for(Bus_Info b:bi) {
			if(b.getinfo()==option) {
				cap=b.getcapacity();
			}
		}
		for(Bus_Booking b:bb) {
			if(b.option==option) {
				book++;
			}
		}
		if(cap>book) {
			return true;
		}
		else {
			return false;
		}
	}
	public void showdetails() {
		System.out.println("Name: "+name);
		System.out.println("Age: "+age);
		System.out.println("Adhar Number : "+adharcard);
		System.out.println("Gender: "+gender);
		System.out.println("Bus No: "+option);
	}
}
class Bus_Info{
	private int bus_no;
	private String cool;
	private int capacity;
	Bus_Info(int a,String b,int c){
		bus_no=a;
		cool=b;
		capacity=c;
	}
	void printinfo() {
		System.out.println("The Bus No:"+bus_no+" / This Bus contain "+cool+" / Capacity of the bus is "+capacity);
	}
	public int getinfo() {
		return bus_no;
	}
	public int getcapacity() {
		return capacity;
	}
}
public class BusProject{
	public static void main(String args[]) {
		Scanner scanner=new Scanner(System.in);
		ArrayList<Bus_Booking> booking=new ArrayList<Bus_Booking>();
		ArrayList<Bus_Info> bus =new ArrayList<Bus_Info>();
		bus.add(new Bus_Info(1,"AC",2));
		bus.add(new Bus_Info(2,"Non-AC",25));
		bus.add(new Bus_Info(3,"AC",15));
		System.out.println("Thank you for Chosing our travels for booking tickets");
		System.out.println();
		for(Bus_Info b:bus) {
			b.printinfo();
		}
		System.out.println();
		int want=1;
		while(want==1) {
			System.out.println("For booking press 1 and for cancel press 2");
			want=scanner.nextInt();
			if(want==1) {
				System.out.println("Booking.....");
				Bus_Booking b=new Bus_Booking();
				if(b.books(bus,booking)) {
					booking.add(b);
					System.out.println();
					System.out.println("Booking Confirmed");
					}
				else {
					System.out.println("Bus is Full !");
				}
			}
			else {
				System.out.println("----------->Find the Booked details below<-------------");
				for(Bus_Booking y:booking) {
					y.showdetails();
					System.out.println();
				}
				System.out.println("Thank you");
				want=0;
			}	
		}
		}
}

