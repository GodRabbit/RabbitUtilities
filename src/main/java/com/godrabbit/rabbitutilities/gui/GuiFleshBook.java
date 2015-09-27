package com.godrabbit.rabbitutilities.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.godrabbit.rabbitutilities.RabbitConst;




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
    private int currPage = 0;
    private static final int bookTotalPages = 6;
    private static ResourceLocation[] bookPageTextures = 
          new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
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
    
    public GuiFleshBook()
    {
    	//init all textures textures
    	bookPageTextures[0] = new ResourceLocation(
                RabbitConst.MODID+":textures/gui/book_guide_cover.png");
        bookPageTextures[1] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_page.png"); //main menu
        bookPageTextures[2] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_intro1.png"); //introduction1
        bookPageTextures[3] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_basics1.png"); //Basics page
        bookPageTextures[4] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_utility1.png"); //Utility page
        bookPageTextures[5] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_motion1.png"); //Motion page
          
         //handle text:
        stringPageText[0] = "";
        stringPageText[1] = "";
        stringPageText[2]="";
        stringPageText[3]="";
    }
    
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui()
    {
    	
    	buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight, 
              98, 20, I18n.format("gui.done", new Object[0]));
   
        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, 
              offsetFromScreenLeft + 220, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, 
              offsetFromScreenLeft +10, 156, false));
        
        //init main menu buttons:
        //page 1:
        introButton=new MenuButton(3, offsetFromScreenLeft+16, 12, 
        		"intro_button1");
        buttonList.add(introButton);
        
        basicsButton= new MenuButton(4, offsetFromScreenLeft+69, 12, 
        		"basics_button1");
        buttonList.add(basicsButton);
        
        worldButton = new MenuButton(5, offsetFromScreenLeft+16, 43,
        		"world_button1");
        buttonList.add(worldButton);
        
        utilityButton = new MenuButton(6, offsetFromScreenLeft+69, 43,
        		"utility_button1");
        buttonList.add(utilityButton);
        
        motionButton = new MenuButton(7, offsetFromScreenLeft+16, 74,
        		"motion_button1");
        buttonList.add(motionButton);
        
        painButton = new MenuButton(8, offsetFromScreenLeft+69, 74,
        		"pain_button1");
        buttonList.add(painButton);
        
        smokeButton = new MenuButton(9, offsetFromScreenLeft+16, 105,
        		"smoke_button1");
        buttonList.add(smokeButton);
        
        colorButton = new MenuButton(10, offsetFromScreenLeft+69, 105,
        		"color_button1");
        buttonList.add(colorButton);
        
        //init "Basics" menu buttons:
        fleshEaterButton = new MenuButton(11, offsetFromScreenLeft+16, 28,
        		ButtonSize.subMenu, "flesh_eater_button1");
        buttonList.add(fleshEaterButton);
        
        fleshIngotButton = new MenuButton(12, offsetFromScreenLeft+16, 48,
        		ButtonSize.subMenu, "flesh_ingot_button1");
        buttonList.add(fleshIngotButton);
        
        muscleButton = new MenuButton(13, offsetFromScreenLeft+16, 68,
        		ButtonSize.subMenu, "muscle_button1");
        buttonList.add(muscleButton);
        
        eyeButton = new MenuButton(14, offsetFromScreenLeft+16, 88,
        		ButtonSize.subMenu, "eye_button1");
        buttonList.add(eyeButton);
    }
    
    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
        buttonDone.visible = true;
        buttonNextPage.visible = (currPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currPage > 0;
        
        //handle main menu buttons
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
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        switch(currPage)
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
        default:
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        	break;
        	
        }
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
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
            if (currPage > 0)
            {
                --currPage;
            }
        }
        else if(parButton==introButton)
        {
        	currPage=2; //start intro chapter
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
    	
    	
		public MenuButton(int buttonId, int x, int y, String texture) 
		{
			//height=32; width=48
			super(buttonId, x, y, 48, 32, "");
			
			this.visible=false; //deafult
		
			btexture= new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture+".png");
			
		}
		
		public MenuButton(int buttonId, int x, int y, ButtonSize size, String texture)
		{
			super(buttonId, x, y, size._width, size._height, "");
			btexture= new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture+".png");
			
			this.visible=false; //deafult
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
