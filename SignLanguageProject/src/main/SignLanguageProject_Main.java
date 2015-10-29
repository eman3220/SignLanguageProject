package main;

import java.awt.EventQueue;
import java.io.File;
import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import back.SG_C;
import back.SG_connectedHand;
import back.SG_connectedIndexMiddle;
import back.SG_five;
import back.SG_four;
import back.SG_nine;
import back.SG_one;
import back.SG_seven;
import back.SG_six;
import back.SG_three_v1;
import back.SG_three_v2;
import back.SG_three_v3;
import back.SG_two;
import back.SG_zero_v1;
import back.SG_zero_v2;
import back.Sign;
import back.SignGesture;
import front.GUIv2;

public class SignLanguageProject_Main {

	public static ArrayList<SignGesture> signGestures = new ArrayList<SignGesture>();

	public static SignGesture selected;

	public static void main(String[] args) {

		//LookAndFeelInfo[] plafs = UIManager.getInstalledLookAndFeels();
		try {
	        UIManager.setLookAndFeel(UIManager.getInstalledLookAndFeels()[1].getClassName());
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    } catch (InstantiationException e) {
	        e.printStackTrace();
	    } catch (IllegalAccessException e) {
	        e.printStackTrace();
	    } catch (UnsupportedLookAndFeelException e) {
	        e.printStackTrace();
	    }

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

		// SG_one
		SG_one sg_one = new SG_one();
		sg_one.setName("one");

		ArrayList<Sign> oneSigns = new ArrayList<Sign>();

		File[] onef = { new File("src/Assets/illustrations/illustration_1.png") };
		Sign one = new Sign("one", "one", "", onef);

		File[] motherf = { new File(
				"src/Assets/illustrations/illustration_mother.png") };
		Sign mother = new Sign("mother", "mother", "", motherf);

		File[] hearingf = { new File(
				"src/Assets/illustrations/illustration_hearing.png") };
		Sign hearing = new Sign("hearing", "hearing", "", hearingf);

		File[] auckf = { new File(
				"src/Assets/illustrations/illustration_auckland.png") };
		Sign auckland = new Sign("auckland", "auckland", "", auckf);

		File[] elevenf = { new File(
				"src/Assets/illustrations/illustration_11.png") };
		Sign eleven = new Sign("eleven", "eleven", "", elevenf);

		oneSigns.add(one);
		oneSigns.add(mother);
		oneSigns.add(hearing);
		oneSigns.add(auckland);
		oneSigns.add(eleven);

		sg_one.setAssociatedSigns(oneSigns);

		// SG_two
		SG_two sg_two = new SG_two();
		sg_two.setName("two");

		ArrayList<Sign> twoSigns = new ArrayList<Sign>();

		File[] twof = { new File("src/Assets/illustrations/illustration_2.png") };
		Sign two = new Sign("two", "two", "", twof);

		File[] sevenf = { new File(
				"src/Assets/illustrations/illustration_7.png") };
		Sign seven = new Sign("seven", "seven", "", sevenf);

		File[] equalf = { new File(
				"src/Assets/illustrations/illustration_equal.png") };
		Sign equal = new Sign("equal", "equal", "", equalf);

		File[] relativef = { new File(
				"src/Assets/illustrations/illustration_relative.png") };
		Sign relative = new Sign("relative", "relative", "", relativef);

		File[] twelvef = { new File(
				"src/Assets/illustrations/illustration_12.png") };
		Sign twelve = new Sign("twelve", "twelve", "", twelvef);

		twoSigns.add(two);
		twoSigns.add(seven);
		twoSigns.add(equal);
		twoSigns.add(relative);
		twoSigns.add(twelve);

		sg_two.setAssociatedSigns(twoSigns);

		// SG_three
		SG_three_v1 sg_three_v1 = new SG_three_v1();
		sg_three_v1.setName("three_v1");

		ArrayList<Sign> three_v1_Signs = new ArrayList<Sign>();

		File[] v1threef = { new File(
				"src/Assets/illustrations/illustration_3.png") };
		Sign v1three = new Sign("three", "three", "", v1threef);

		File[] v1eightf = { new File(
				"src/Assets/illustrations/illustration_8.png") };
		Sign v1eight = new Sign("eight", "eight", "", v1eightf);

		File[] v1thirteenf = { new File(
				"src/Assets/illustrations/illustration_13.png") };
		Sign v1thirteen = new Sign("thirteen", "thirteen", "", v1thirteenf);

		three_v1_Signs.add(v1three);
		three_v1_Signs.add(v1eight);
		three_v1_Signs.add(v1thirteen);

		sg_three_v1.setAssociatedSigns(three_v1_Signs);

		SG_three_v2 sg_three_v2 = new SG_three_v2();
		sg_three_v2.setName("three_v2");

		ArrayList<Sign> three_v2_Signs = new ArrayList<Sign>();

		File[] v2threef = { new File(
				"src/Assets/illustrations/illustration_3.png") };
		Sign v2three = new Sign("three", "three", "", v2threef);

		File[] v2eightf = { new File(
				"src/Assets/illustrations/illustration_8.png") };
		Sign v2eight = new Sign("eight", "eight", "", v2eightf);

		File[] v2thirteenf = { new File(
				"src/Assets/illustrations/illustration_13.png") };
		Sign v2thirteen = new Sign("thirteen", "thirteen", "", v2thirteenf);

		File[] wellingtonf = { new File(
				"src/Assets/illustrations/illustration_wellington.png") };
		Sign wellington = new Sign("wellington", "wellington", "", wellingtonf);

		File[] wanganuif = { new File(
				"src/Assets/illustrations/illustration_wanganui.png") };
		Sign wanganui = new Sign("wanganui", "wanganui", "", wanganuif);

		three_v2_Signs.add(v2three);
		three_v2_Signs.add(v2eight);
		three_v2_Signs.add(v2thirteen);
		three_v2_Signs.add(wellington);
		three_v2_Signs.add(wanganui);

		sg_three_v2.setAssociatedSigns(three_v2_Signs);

		SG_three_v3 sg_three_v3 = new SG_three_v3();
		sg_three_v3.setName("three_v3");

		ArrayList<Sign> three_v3_Signs = new ArrayList<Sign>();

		File[] threef = { new File(
				"src/Assets/illustrations/illustration_3.png") };
		Sign three = new Sign("three", "three", "", threef);

		File[] eightf = { new File(
				"src/Assets/illustrations/illustration_8.png") };
		Sign eight = new Sign("eight", "eight", "", eightf);

		File[] thirteenf = { new File(
				"src/Assets/illustrations/illustration_13.png") };
		Sign thirteen = new Sign("thirteen", "thirteen", "", thirteenf);

		three_v3_Signs.add(three);
		three_v3_Signs.add(eight);
		three_v3_Signs.add(thirteen);

		sg_three_v3.setAssociatedSigns(three_v3_Signs);

		// SG_four
		SG_four sg_four = new SG_four();
		sg_four.setName("four");

		ArrayList<Sign> fourSigns = new ArrayList<Sign>();

		File[] fourf = { new File("src/Assets/illustrations/illustration_4.png") };
		Sign four = new Sign("four", "four", "", fourf);

		File[] fourteenf = { new File(
				"src/Assets/illustrations/illustration_14.png") };
		Sign fourteen = new Sign("fourteen", "fourteen", "", fourteenf);

		File[] timetablef = { new File(
				"src/Assets/illustrations/illustration_timetable.png") };
		Sign timetable = new Sign("timetable", "timetable", "", timetablef);

		fourSigns.add(four);
		fourSigns.add(fourteen);
		fourSigns.add(timetable);

		sg_four.setAssociatedSigns(fourSigns);

		// SG_five
		SG_five sg_five = new SG_five();
		sg_five.setName("five");

		ArrayList<Sign> fiveSigns = new ArrayList<Sign>();

		File[] fivef = { new File("src/Assets/illustrations/illustration_5.png") };
		Sign five = new Sign("five", "five", "", fivef);

		File[] tenf = { new File("src/Assets/illustrations/illustration_10.png") };
		Sign ten = new Sign("ten", "ten", "", tenf);

		File[] fifteenf = { new File(
				"src/Assets/illustrations/illustration_15.png") };
		Sign fifteen = new Sign("fifteen", "fifteen", "", fifteenf);

		File[] familyf = { new File(
				"src/Assets/illustrations/illustration_family.png") };
		Sign family = new Sign("family", "family", "", familyf);

		fiveSigns.add(five);
		fiveSigns.add(ten);
		fiveSigns.add(fifteen);
		fiveSigns.add(family);

		sg_five.setAssociatedSigns(fiveSigns);

		// SG_C
		SG_C sg_c = new SG_C();
		sg_c.setName("Letter C");

		ArrayList<Sign> cSigns = new ArrayList<Sign>();

		File[] cf = { new File("src/Assets/illustrations/illustration_c.png") };
		Sign c = new Sign("c", "c", "", cf);

		File[] christchurchf = { new File(
				"src/Assets/illustrations/illustration_christchurch.png") };
		Sign christchurch = new Sign("christchurch", "christchurch", "",
				christchurchf);

		File[] classf = { new File(
				"src/Assets/illustrations/illustration_class.png") };
		Sign classclass = new Sign("class", "class", "", classf);

		cSigns.add(c);
		cSigns.add(christchurch);
		cSigns.add(classclass);

		sg_c.setAssociatedSigns(cSigns);

		// SG_connectedHand
		SG_connectedHand sg_conHand = new SG_connectedHand();
		sg_conHand.setName("Connected Hand");

		ArrayList<Sign> connectedHandSigns = new ArrayList<Sign>();

		File[] birthdayf = { new File(
				"src/Assets/illustrations/illustration_birthday.png") };
		Sign birthday = new Sign("birthday", "birthday", "", birthdayf);

		File[] understandf = { new File(
				"src/Assets/illustrations/illustration_understand.png") };
		Sign understand = new Sign("understand", "understand", "", understandf);

		connectedHandSigns.add(birthday);
		connectedHandSigns.add(understand);

		sg_conHand.setAssociatedSigns(connectedHandSigns);

		// SG_connectedIndexMiddle
		SG_connectedIndexMiddle sg_conIndMid = new SG_connectedIndexMiddle();
		sg_conIndMid.setName("Connected Ind Mid");

		ArrayList<Sign> connectedIndexMiddleSigns = new ArrayList<Sign>();

		File[] fatherf = { new File(
				"src/Assets/illustrations/illustration_father.png") };
		Sign father = new Sign("father", "father", "", fatherf);

		File[] namef = { new File(
				"src/Assets/illustrations/illustration_name.png") };
		Sign name = new Sign("name", "name", "", namef);

		File[] deaff = { new File(
				"src/Assets/illustrations/illustration_deaf.png") };
		Sign deaf = new Sign("deaf", "deaf", "", deaff);

		connectedIndexMiddleSigns.add(father);
		connectedIndexMiddleSigns.add(name);
		connectedIndexMiddleSigns.add(deaf);

		sg_conIndMid.setAssociatedSigns(connectedIndexMiddleSigns);

		SG_six sg_six = new SG_six();
		sg_six.setName("six");

		ArrayList<Sign> sixSigns = new ArrayList<Sign>();

		File[] sixf = { new File("src/Assets/illustrations/illustration_6.png") };
		Sign six = new Sign("six", "six", "", sixf);

		File[] ninef = { new File("src/Assets/illustrations/illustration_9.png") };
		Sign nine = new Sign("nine", "nine", "", ninef);

		File[] sixteenf = { new File(
				"src/Assets/illustrations/illustration_16.png") };
		Sign sixteen = new Sign("sixteen", "sixteen", "", sixteenf);

		sixSigns.add(six);
		sixSigns.add(nine);
		sixSigns.add(sixteen);

		sg_six.setAssociatedSigns(sixSigns);

		SG_seven sg_seven = new SG_seven();
		sg_seven.setName("seven");

		ArrayList<Sign> sevenSigns = new ArrayList<Sign>();

		File[] v1sevenf = { new File(
				"src/Assets/illustrations/illustration_7.png") };
		Sign v1seven = new Sign("seven", "seven", "", sevenf);

		sevenSigns.add(seven);

		sg_seven.setAssociatedSigns(sevenSigns);

		SG_nine sg_nine = new SG_nine();
		sg_nine.setName("nine");

		ArrayList<Sign> nineSigns = new ArrayList<Sign>();

		File[] v1ninef = { new File(
				"src/Assets/illustrations/illustration_9.png") };
		Sign v1nine = new Sign("nine", "nine", "", ninef);

		nineSigns.add(nine);

		sg_nine.setAssociatedSigns(nineSigns);

		SG_zero_v1 sg_zero_v1 = new SG_zero_v1();
		sg_zero_v1.setName("zero_v1");

		SG_zero_v2 sg_zero_v2 = new SG_zero_v2();
		sg_zero_v2.setName("zero_v2");

		signGestures.add(sg_zero_v1);
		signGestures.add(sg_zero_v2);
		signGestures.add(sg_one);
		signGestures.add(sg_two);
		signGestures.add(sg_three_v1);
		signGestures.add(sg_three_v2);
		signGestures.add(sg_three_v3);
		signGestures.add(sg_four);
		signGestures.add(sg_five);
		signGestures.add(sg_six);
		signGestures.add(sg_seven);
		signGestures.add(sg_nine);
		signGestures.add(sg_c);
		signGestures.add(sg_conHand);
		signGestures.add(sg_conIndMid);

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
