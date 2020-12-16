import java.util.*;

public class Main {
	
	Scanner scan = new Scanner(System.in);
	
	void clear() {
		for (int i = 0 ; i < 30; i++) {
			System.out.println();
		}
	}
	
	double sksFinder(double thisSks) {
		if (thisSks < 50) return 0;
		else if (thisSks >= 50 && thisSks < 65) return 1;
		else if (thisSks >= 65 && thisSks < 70) return 2;
		else if (thisSks >= 70 && thisSks < 75) return 2.5;
		else if (thisSks >= 75 && thisSks < 80) return 3;
		else if (thisSks >= 80 && thisSks < 85) return 3.33;
		else if (thisSks >= 85 && thisSks < 90) return 3.67;
		else return 4;
	}
	
	void ips() {
		clear();
		double totalSks = -1;
		int totalSubject = -1;
		double totalScore = 0;
		do {
			System.out.print("Input total number of subjects : ");
			try {
				totalSubject = scan.nextInt();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scan.nextLine();
		} while (totalSubject < 1);
		do {
			System.out.print("Input total number of SKS : ");
			try {
				totalSks = scan.nextDouble();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		} while (totalSks < 1);
		for (int i = 1; i <= totalSubject; i++){
			double thisScore = -1, thisSks = -1;
			do {
				System.out.print("Input subject " + i + " score : ");
				try {
					thisScore = scan.nextDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				scan.nextLine();
			} while (thisScore < 0);
			do {
				System.out.print("Input the subject " + i + " SKS : ");
				try {
					thisSks = scan.nextDouble();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				scan.nextLine();
			} while (thisSks < 1);
			totalScore += ((sksFinder(thisScore)) * thisSks);
			System.out.println("This score is " + (sksFinder(thisScore)));
		}
		System.out.println();
		totalScore /= totalSks;
		System.out.println("Your total score is " + totalScore);
		System.out.println();
		System.out.println("Press enter to continue...");
		scan.nextLine();
		mainMenu();
	}
	
	void ipk() {
		clear();
		int semester = -1;
		double totalScore = 0;
		int sksKumulatif = 0;
		do {
			System.out.print("Input the number of semester you have passed : ");
			try {
				semester = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}while (semester < 1);
		
		for (int i = 1; i <= semester; i++) {
			double thisSemester = -1;
			do {
				System.out.print("Input semester " + i + " IPS : ");
				try {
					thisSemester = scan.nextDouble();
				} catch (Exception e) {
					// TODO: handle exception
				}
				scan.nextLine();
			}while (thisSemester < 0);
			int semesterSKS = -1;
			do {
				System.out.print("Input semester " + i + " SKS : ");
				try {
					semesterSKS = scan.nextInt();
				} catch (Exception e) {
					// TODO: handle exception
				}
				scan.nextLine();
			}while (semesterSKS < 1);
			totalScore = ((totalScore * sksKumulatif) + (thisSemester * semesterSKS)) / (sksKumulatif + semesterSKS);
			sksKumulatif += semesterSKS;
		}
		System.out.println();
		System.out.printf("Your total IPK is : %.2f\n", totalScore);
		System.out.println();
		System.out.println("Press enter to continue...");
		scan.nextLine();
		mainMenu();
	}
	
	void mainMenu() {
		int choose = -1;
		do {
			clear();
			System.out.println("Welcome to IPK Calculator");
			System.out.println("=========================");
			System.out.println("1. Calculate IPS");
			System.out.println("2. Calculate IPK");
			System.out.println("3. Exit");
			System.out.print(">> ");
			try {
				choose = scan.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}while (choose < 1 || choose > 3);
		switch (choose) {
		case 1:
			ips();
			break;
		case 2:
			ipk();
			break;
		case 3:
			System.exit(0);
			break;
		}
	}
	
	public Main() {
		mainMenu();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}
}

