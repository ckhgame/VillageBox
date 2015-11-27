package com.ckhgame.villagebento.book;

import java.util.HashMap;

public class VBBooks {
	
	private static HashMap<String, VBBook> books = new HashMap<String, VBBook>();
	
	public static void init(){
		//book list
		
		VBBook book;
		
		//CookingBookI
		book = new VBBook("CookingBookI");
		book.addPage("title1", "testtestetasdasda asdasdas dasda das", "CookingBookI_p0");
		book.addPage("title2", " page 2 page 2 page 2 page 2 page 2 page 2 page 2", "CookingBookI_p1");
		book.addPage("title3", "333333333 3333 3333 3 3 3 3333 3 33 page 3", "CookingBookI_p2");	
		addBook(book);
		
	}
	
	public static void addBook(VBBook book){
		books.put(book.getName(), book);
	}
	
	public static VBBook getBook(String name){
		if(books.containsKey(name)){
			return books.get(name); 
		}
		else{
			return null;
			
		}
	}
}
