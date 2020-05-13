package ru.stqa.pft.sandbox;

public class MyFirstProgram {
	

	public static void main (String [] args){
    Square s = new Square();
    s.l = 5;
        System.out.println(area(s));
	}

	public static  double area(Square s){
	    return s.l +s.l;
    }

}