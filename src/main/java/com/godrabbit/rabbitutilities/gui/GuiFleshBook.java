package com.godrabbit.rabbitutilities.gui;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.godrabbit.rabbitutilities.RabbitConst;




import com.godrabbit.rabbitutilities.libs.BookPage;
import com.godrabbit.rabbitutilities.libs.BookSection;



//import net.java.games.input.Keyboard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 *  thanks to Jabelar's Tutorial on simple GUI
 * most of it copied from him (not the graphics though)
 * link: http://jabelarminecraft.blogspot.co.il/p/minecraft-modding-block-with-simple-gui.html
 *
 */
public class GuiFleshBook extends GuiScreen{
	
	private final int bookImageHeight = 192;
    private final int bookImageWidth = 256; //previously 192
    
    int PID;
    
    private static final int bookTotalPages = 10;
    private static ResourceLocation[] bookPageTextures = 
          new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    private int buttonID=0;
    int offsetFromScreenLeft = (width - bookImageWidth) / 2;
    
    private ArrayList<BookSection> sectionList=new ArrayList<BookSection>();
   /* //main sections:
    private BookSection coverSection;
    private BookSection mainMenu;
    private BookSection basicsMenu;
    private BookSection utilityMenu;
    private BookSection motionMenu;
    private BookSection worldMenu;
    private BookSection intro;
    private BookSection painMenu;
    private BookSection smokeMenu;
    private BookSection colorMenu;
    
    //basics sections:
    private BookSection fleshEaterSwordSection;
    private BookSection fleshIngotSection;
    private BookSection eyeSection;
    private BookSection muscleSection;
    private BookSection brainSection;*/
    
    private BookPage currPage = null;
    private BookSection currSection=null;
    //main menu buttons:
    private MenuButton introButton;
    private MenuButton basicsButton;
    private MenuButton worldButton;
    private MenuButton utilityButton;
    private MenuButton motionButton;
    private MenuButton painButton;
    private MenuButton smokeButton;
    private MenuButton colorButton;
    
    //"Basics" menu:
    private MenuButton fleshEaterButton;
    private MenuButton fleshIngotButton;
    private MenuButton muscleButton;
    private MenuButton eyeButton;
    private MenuButton brainButton;
    
    public GuiFleshBook()
    {
    	
    	int SID=0; //unique Book-Section ID
    	PID=0; //unique Book-Page ID
    	
    	
    	BookSection basicsMenu = new BookSection("basicsMenu", SID);
    	BookPage basics1 = new BookPage(PID, getPath("intro", 1), null, null);
    	MenuButton fleshEaterButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 28,
        		ButtonSize.subMenu, "flesh_eater_button1");
        basics1.addButton(fleshEaterButton);
        MenuButton fleshIngotButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 48,
        		ButtonSize.subMenu, "flesh_ingot_button1");
        basics1.addButton(fleshIngotButton);
        MenuButton muscleButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 68,
        		ButtonSize.subMenu, "muscle_button1");
        basics1.addButton(muscleButton);
        MenuButton eyeButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 88,
        		ButtonSize.subMenu, "eye_button1");
        basics1.addButton(eyeButton);
        MenuButton brainButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 108,
        		ButtonSize.subMenu, "brain_button1");
        basics1.addButton(brainButton);
        basicsMenu.addPage(basics1);
        PID++;
        SID++;
        sectionList.add(basicsMenu);
        
        BookSection mainMenu = new BookSection("mainMenu", SID);
    	BookPage main1=new BookPage(PID, getPath("", 0) , null, null); //get default background
    	MenuButton introButton=new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 12, 
        		"intro_button1");
    	main1.addButton(introButton);
    	MenuButton basicsButton= new MenuButton(generateBID(),PID, offsetFromScreenLeft+69, 12, 
        		"basics_button1");
    	main1.addButton(basicsButton);
    	MenuButton worldButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 43,
        		"world_button1");
    	main1.addButton(worldButton);
    	MenuButton utilityButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+69, 43,
        		"utility_button1");
    	main1.addButton(utilityButton);
    	MenuButton motionButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 74,
        		"motion_button1");
    	main1.addButton(motionButton);
    	MenuButton painButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+69, 74,
        		"pain_button1");
    	main1.addButton(painButton);
    	MenuButton smokeButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+16, 105,
        		"smoke_button1");
    	main1.addButton(smokeButton);
    	MenuButton colorButton = new MenuButton(generateBID(),PID, offsetFromScreenLeft+69, 105,
        		"color_button1");
    	main1.addButton(colorButton);
    	mainMenu.addPage(main1);
    	PID++;
    	SID++;
    	sectionList.add(mainMenu);
      
    	BookSection coverSection = new BookSection("coverSection", SID);
    	BookPage cover1 = new BookPage(PID, getPath("", -1), main1, null); //cover background id<=-1
    	coverSection.addPage(cover1);
    	PID++;
    	SID++;
    	sectionList.add(coverSection);
    	
    	//set
        currSection=coverSection;
        currPage = currSection.getFirst();
        
    	//init all textures textures
    	bookPageTextures[0] = new ResourceLocation(
                RabbitConst.MODID+":textures/gui/book_guide_cover.png");
        bookPageTextures[1] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_page.png"); //main menu 1
        bookPageTextures[2] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_intro1.png"); //introduction 1
        bookPageTextures[3] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_basics1.png"); //Basics page 1
        bookPageTextures[4] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_utility1.png"); //Utility page 1
        bookPageTextures[5] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_motion1.png"); //Motion page 1
        //flesh eater pages
        bookPageTextures[6] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_flesh_eater1.png"); //pg 1
        bookPageTextures[7] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_flesh_eater2.png"); //pg 2
          
    }
    
    public int generateBID() //generates a new unique button ID;
    {
    	int nid=buttonID;
    	buttonID++;
    	return nid;
    }
    
    public static ResourceLocation getPath(String name, int id)
    {
    	if(id>0)
    	{
    		return new ResourceLocation(RabbitConst.MODID+":textures/gui/book_guide_"+name+id+".png");
    	}
    	if(id==-1) //cover background
    		return new ResourceLocation(RabbitConst.MODID+":textures/gui/book_guide_cover.png");
    	else //default background
    	{
    		return new ResourceLocation(RabbitConst.MODID+":textures/gui/book_guide_page.png");
    	}
    }
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui()
    {
    	
    	buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        
        buttonDone = new GuiButton(generateBID(), width / 2 + 2, 4 + bookImageHeight, 
              98, 20, I18n.format("gui.done", new Object[0]));
        buttonList.add(buttonDone);
       
        buttonList.add(buttonNextPage = new NextPageButton(generateBID(), 
              offsetFromScreenLeft + 220, 156, true));
        
        buttonList.add(buttonPreviousPage = new NextPageButton(generateBID(), 
              offsetFromScreenLeft +10, 156, false));
        
        for(BookSection section : sectionList)
        {
        	for(BookPage page : section.getPages())
        	{
        		for(MenuButton b: page.getButtonList())
        		{
        			buttonList.add(b);
        		}
        	}
        }
        /*//init main menu buttons:
        //page 1:
        introButton=new MenuButton(ID, offsetFromScreenLeft+16, 12, 
        		"intro_button1");
        buttonList.add(introButton);
        ID++;
        
        basicsButton= new MenuButton(ID, offsetFromScreenLeft+69, 12, 
        		"basics_button1");
        buttonList.add(basicsButton);
        ID++;
        
        worldButton = new MenuButton(ID, offsetFromScreenLeft+16, 43,
        		"world_button1");
        buttonList.add(worldButton);
        ID++;
        
        utilityButton = new MenuButton(ID, offsetFromScreenLeft+69, 43,
        		"utility_button1");
        buttonList.add(utilityButton);
        ID++;
        
        motionButton = new MenuButton(ID, offsetFromScreenLeft+16, 74,
        		"motion_button1");
        buttonList.add(motionButton);
        ID++;
        
        painButton = new MenuButton(ID, offsetFromScreenLeft+69, 74,
        		"pain_button1");
        buttonList.add(painButton);
        ID++;
        
        smokeButton = new MenuButton(ID, offsetFromScreenLeft+16, 105,
        		"smoke_button1");
        buttonList.add(smokeButton);
        ID++;
        
        colorButton = new MenuButton(ID, offsetFromScreenLeft+69, 105,
        		"color_button1");
        buttonList.add(colorButton);
        ID++;
        
        //init "Basics" menu buttons:
        fleshEaterButton = new MenuButton(ID, offsetFromScreenLeft+16, 28,
        		ButtonSize.subMenu, "flesh_eater_button1");
        buttonList.add(fleshEaterButton);
        ID++;
        
        fleshIngotButton = new MenuButton(ID, offsetFromScreenLeft+16, 48,
        		ButtonSize.subMenu, "flesh_ingot_button1");
        buttonList.add(fleshIngotButton);
        ID++;
        
        muscleButton = new MenuButton(ID, offsetFromScreenLeft+16, 68,
        		ButtonSize.subMenu, "muscle_button1");
        buttonList.add(muscleButton);
        ID++;
        
        eyeButton = new MenuButton(ID, offsetFromScreenLeft+16, 88,
        		ButtonSize.subMenu, "eye_button1");
        buttonList.add(eyeButton);
        ID++;
        
        brainButton = new MenuButton(ID, offsetFromScreenLeft+16, 108,
        		ButtonSize.subMenu, "brain_button1");
        buttonList.add(brainButton);
        ID++;*/
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
        buttonDone.visible = true;
        buttonNextPage.visible = true;
        buttonPreviousPage.visible = true;;
        
        //show buttons on currPage; need to check for accuracy
        for(Object b : buttonList)
        {
        	if(b instanceof MenuButton)
        	{
        		//visible only if this is the curr page
        		((MenuButton) b).visible=((MenuButton) b).getPageID()==currPage.getID(); 
        	}
        }
        /*//handle main menu buttons
        introButton.visible = (currPage==1);
        basicsButton.visible = (currPage==1);
        worldButton.visible = (currPage==1);
        utilityButton.visible = (currPage==1);
        motionButton.visible = (currPage==1);
        painButton.visible = (currPage==1);
        smokeButton.visible = (currPage==1);
        colorButton.visible = (currPage==1);
        
        //handle Basics menu buttons:
        fleshEaterButton.visible = (currPage==3);
        fleshIngotButton.visible = (currPage==3);
        muscleButton.visible = (currPage==3);
        eyeButton.visible =	(currPage==3);
        brainButton.visible = (currPage==3);*/
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
    	Minecraft mc=Minecraft.getMinecraft();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        mc.getTextureManager().bindTexture(currPage.getBackground());
       /* switch(currPage)
        {
        case 0:
        	mc.getTextureManager().bindTexture(bookPageTextures[0]);
        	break;
        case 1:
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        	break;
        case 2:
        	mc.getTextureManager().bindTexture(bookPageTextures[2]);
        	break;
        case 3:
        	mc.getTextureManager().bindTexture(bookPageTextures[3]);
        	break;
        case 4:
        	mc.getTextureManager().bindTexture(bookPageTextures[6]);
        	break;
        case 5:
        	mc.getTextureManager().bindTexture(bookPageTextures[7]);
        	break;
        default:
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        	break;
        	
        }*/
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
              bookImageHeight);
        /*int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", 
              new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, 
              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
              18, 0);
        fontRendererObj.drawSplitString(stringPageText[currPage], 
              offsetFromScreenLeft + 36, 34, 116, 0);*/
        super.drawScreen(parWidth, parHeight, p_73863_3_);

    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
     if (parButton == buttonDone)
     {
         // You can send a packet to server here if you need server to do 
         // something
         mc.displayGuiScreen((GuiScreen)null);
     }
        else if (parButton == buttonNextPage)
        {
            if (currPage.getNext() != null)
            {
                currPage=currPage.getNext();
            }
        }
        else if (parButton == buttonPreviousPage)
        {
           if(currPage.getPrevious() != null)
           {
        	   currPage=currPage.getPrevious();
           }
        }
        else if(parButton==introButton)
        {
        	//currPage=2; //start intro chapter
        }
        else if(parButton==basicsButton)
        {
        	//currPage=3;
        }
        else if(parButton==fleshEaterButton)
        {
        	//currPage=4; //start flesh eatyer sword chapter
        }
   }
    
    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat 
     * events
     */
    @Override
    public void onGuiClosed() 
    {
    	
    }
   
    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return false; //so you would have something to read at night ;)
    }
    
    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, 
              boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
            this.visible=false;
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= xPosition 
                      && parY >= yPosition 
                      && parX < xPosition + width 
                      && parY < yPosition + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                ResourceLocation bTexture=new ResourceLocation( RabbitConst.MODID+":textures/gui/next_buttons.png");
                mc.getTextureManager().bindTexture(bTexture);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed)
                {
                    textureX += 23;
                }

                if (!isNextButton)
                {
                    textureY += 13;
                }

                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      23, 13);
            }
        }
    }
    
    @SideOnly(Side.CLIENT)
    public class MenuButton extends GuiButton
    {
    	/**
    	 * This class creates a button with 2 textures, one for the button is untouched and another
    	 * for when you touch the button. 
    	 */
    	ResourceLocation btexture;
    	int _page; //the page this button belongs to, important in drawScreen and updateScreen functions
    	
		public MenuButton(int buttonId,int page, int x, int y, String texture) 
		{
			//height=32; width=48
			super(buttonId, x, y, 48, 32, "");
			
			this.visible=false; //deafult
		
			btexture= new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture+".png");
			
			_page=page;
			
		}
		
		public MenuButton(int buttonId, int page, int x, int y, ButtonSize size, String texture)
		{
			super(buttonId, x, y, size._width, size._height, "");
			btexture= new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture+".png");
			
			this.visible=false; //deafult
			
			_page=page;
		}
		
		
		
		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY) {
			
			if(visible)
			{
				boolean isButtonPressed = (mouseX >= xPosition 
	                    && mouseY >= yPosition 
	                    && mouseX < xPosition + width 
	                    && mouseY < yPosition + height);
				 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F); //have no idea what this for ???

				 mc.getTextureManager().bindTexture(btexture);
				
				if(!isButtonPressed)
				{
					drawTexturedModalRect(xPosition, yPosition, 
							0, 1, 
							this.width, this.height);
				}
				else
				{
					drawTexturedModalRect(xPosition, yPosition, 
							this.width+2, 1, 
							this.width, this.height);
				}
				 
				
			}
			
		}
		
		public int getPageID()
		{
			return _page;
		}
    	
    }
    
    public enum ButtonSize
    {
    	mainMenu(48, 32),
    	subMenu(104, 20);
    	
    	int _width;
    	int _height;
    	
    	ButtonSize(int width, int height)
    	{
    		_width=width;
    		_height=height;
    	}
    }
}
