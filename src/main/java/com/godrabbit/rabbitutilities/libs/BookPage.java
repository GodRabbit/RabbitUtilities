package com.godrabbit.rabbitutilities.libs;

import java.util.ArrayList;

import com.godrabbit.rabbitutilities.gui.GuiFleshBook.MenuButton;

import net.minecraft.util.ResourceLocation;

public class BookPage { //is going to be a thing???
	
	int _id; //book page id. must be unique per book
	ResourceLocation _background; //background image for the page
	
	ArrayList<MenuButton> _buttonList; //buttons on this page
	
	BookPage _next;
	BookPage _previous;
	
	public BookPage(int ID, ResourceLocation Background, BookPage next, BookPage previous)
	{
		_id=ID;
		_background=Background;
		_buttonList=new ArrayList<MenuButton>();
		
		_next=next;
		_previous=previous;
	}
	
	public void addButton(MenuButton b)
	{
		_buttonList.add(b);
	}

	public ArrayList<MenuButton> getButtonList() {
		return _buttonList;
	}

	public void setButtonList(ArrayList<MenuButton> _buttonList) {
		this._buttonList = _buttonList;
	}

	public int getID() {
		return _id;
	}

	public ResourceLocation getBackground() {
		return _background;
	}
	
	public BookPage getNext()
	{
		return _next;
	}
	
	public BookPage getPrevious()
	{
		return _previous;
	}
	
}
