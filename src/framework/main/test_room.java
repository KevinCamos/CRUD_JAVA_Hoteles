//package framework.main;
//
//import javax.swing.JOptionPane;
//
//import framework.rooms.classes.room;
//import framework.rooms.classes.suite;

//public class test_room {
//	public static void main(String[] args)
//			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
//////		room suite1 = new suite("hola", "1", "1", "1", "1", "1", 1, 1, 1, true, true, true, true, "1");
//////		suite1 = (room) framework.utils.reflection.createObject(suite1);
////
//////		room suite1 = new suite("hola", "1", "1", "1", "1", "1", 1, 1, 1, true, true, true, true, "1");
//////		
//////		suite1 = (room) framework.utils.reflection.getAtributteObject(suite1);
//////		suite1.setInt
//////		System.out.println(suite1.toString());
////
////		room suite1 = new suite("hola", "1", "1", "1", "1", "1", 1, 1, 1, true, true, true, true, "1");
//////		ArrayList<String> totalAttributs = reflection.extraerListaAtributos(suite1);
//////		System.out.println(totalAttributs);
////		Field[] list = suite1.getClass().getSuperclass().getDeclaredFields();
//////		Field[] list2 = suite1.getClass().getSuperclass();
////		for (int i = 0; i < list.length; i++) {
////			JOptionPane.showMessageDialog(null, list[i].toString());
//////			System.out.println(list.toString());
////
////			String[] SplitDateMatrix = list[i].toString().split("[ ]", 0);
////			String[] SplitDateMatrix2 = SplitDateMatrix[2].toString().split("[.]", 0);
////
////			System.out.println(SplitDateMatrix2[4].toString());
////
////		}
////		String conjuntoDeCaracteres = JOptionPane.showInputDialog("Escriu un atribut");
////		Field line = suite1.getClass().getSuperclass().getDeclaredField(conjuntoDeCaracteres);
////		line.setAccessible(true); // puc canviar els datos de dins sense que salte el control de seguretat
////		//
////		System.out.println(line.getClass().getSimpleName());
////		line.set(line, 0);
////		System.out.println(line.get(suite1));
////
////	}
////}
/////*
//// * public ProjectDate(String dateEntered) { // Constructor, li afegeixes la data
//// * i t'ho divideix en dies. String[] SplitDateMatrix = null;
//// * 
//// * SplitDateMatrix = dateEntered.split("/"); this.day =
//// * Integer.parseInt(SplitDateMatrix[0]); this.month =
//// * Integer.parseInt(SplitDateMatrix[1]); this.year =
//// * Integer.parseInt(SplitDateMatrix[2]);
//// * 
//// * this.dateEntered = dateEntered; }
//// */