package main;

import java.awt.EventQueue;

import back.LeapTest02;
import front.GUIv2;

public class SignLanguageProject_Main {

	public static void main(String[] args) {
		System.out.println("This is for Scotty's presentation");
		//setupBack();
		setupFront();
		
	}

	private static void setupBack() {
		System.out.println("Setting up back end...");
		
		// TODO check if leap is working
		//new LeapTest02();
		
		
		System.out.println("Back end setup complete");
	}

	private static void setupFront() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIv2 window = new GUIv2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
