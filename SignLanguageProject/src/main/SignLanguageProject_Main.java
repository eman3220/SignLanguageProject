package main;

import java.awt.EventQueue;

import back.LeapTest02;
import front.GUIv2;

public class SignLanguageProject_Main {

	public static void main(String[] args) {
		System.out.println("This is for Scotty's presentation");
		setupBack();
		setupFront();
		
	}

	private static void setupBack() {
		System.out.println("Setting up the back end...");
		
		// not doing much at the moment...
		setupSigns();
		
		System.out.println("Back end setup complete");
	}

	private static void setupSigns() {
		// create a signGesture
		
		// create signs related to signGesture
		
		
	}

	private static void setupFront() {
		System.out.println("Setting up the front end...");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIv2 window = new GUIv2();
					window.frame.setVisible(true);
					System.out.println("Front end setup complete");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
