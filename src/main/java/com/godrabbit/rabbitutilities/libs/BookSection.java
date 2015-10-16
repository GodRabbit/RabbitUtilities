package com.godrabbit.rabbitutilities.libs;

import java.util.ArrayList;

public class BookSection {
	ArrayList<BookPage> _pages;
	String _name;
	int _id;
	
	public BookSection(String name, int ID)
	{
		_name=name;
		_pages=new ArrayList<BookPage>();
		_id=ID;
	}
	
	public BookPage getFirst()
	{
		if(_pages.size()>=1)
			return _pages.get(0);
		return null;
	}
	
	public void addPage(BookPage p)
	{
		_pages.add(p);
	}

	public ArrayList<BookPage> getPages() {
		return _pages;
	}

	public void setPages(ArrayList<BookPage> pages) {
		this._pages = pages;
	}

	public String getName() {
		return _name;
	}

	public int getId() {
		return _id;
	}
	
	
	
}
