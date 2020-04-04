package controller;

import java.util.Scanner;

import service.Iservice;
import service.service;

public class Main {
	private static Iservice ser;
	
	private Main() {
		ser = service.getInstance();
	}
	public static void main(String[] args) {
		Main con=new Main();
		con.start();
		
	}
	public void start() {
		Scanner sc = new Scanner(System.in);
		int menu=0;
		
		do {
			System.out.println("1. 입력");
			System.out.println("2. 검색");
			System.out.println("3. 전체조회");
			menu = Integer.parseInt(sc.nextLine());
			
			switch (menu) {
			case 1:
				ser.insert();
				break;

			case 2:
				ser.search();
				break;
				
			case 3:
				ser.selectALL();
				break;
				
			default:
				System.out.println("잘못입력");
				break;
			}
		}while(menu != 0);
	}
}
