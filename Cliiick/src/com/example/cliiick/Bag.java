package com.example.cliiick;

public class Bag {
    private int[] bag = new int[6];
	int Size;
	int Last;
	
	public Bag(int size){
		Size = size;
		Last = 0;
	}
	public void Insert(int id){
		if(Last!=Size){
			bag[Last++]=id;
		}
	}
	
	public int getLast(){
		return Last;
	}
	
	public int getNext(){
		if(Last!=0){
			return bag[--Last];
		}else{
			return -1;
		}
	}
}
