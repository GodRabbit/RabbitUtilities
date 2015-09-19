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
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 4;
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
    
    public GuiFleshBook()
    {
    	//handle textures
    	bookPageTextures[0] = new ResourceLocation(
                RabbitConst.MODID+":textures/gui/book_guide_cover.png");
        bookPageTextures[1] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_page.png"); //main menu
        bookPageTextures[2] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_page.png");
        bookPageTextures[3] = new ResourceLocation(
        		RabbitConst.MODID+":textures/gui/book_guide_page.png");
          
         //handle text:
        stringPageText[0] = "";
        stringPageText[1] = "";
        stringPageText[2]="So you handed him your cow, and grabbed the Magic Beans.\n\nPleased with "
        		+ "yourself, you hurried away, looking for tilled dirt in which to plant the Magic"
        		+ " Beans.\n\nYou couldn't wait to see how proud your mother would be for";
        stringPageText[3]="being so shrewd!  Untold wealth in return for an old, milkless cow;"
        		+ " what a good deal you made!\n\nSo off you went, looking for a place to plant"
        		+ " the Magic Beans with room to grow...";
    }
    
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui()
    {
    	// DEBUG
    	System.out.println("GuiFleshBook initGUI()");
    	buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight, 
              98, 20, I18n.format("gui.done", new Object[0]));
   
        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, 
              offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, 
              offsetFromScreenLeft + 38, 156, false));
        
        //register menu buttons:
        introButton=new MenuButton(3, offsetFromScreenLeft+32, 32, 
        		"intro_button1", "intro_button1");
        buttonList.add(introButton);
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
        //handle menu buttons
        introButton.visible = (currPage==1);
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (currPage == 0)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[0]);
        }
        else
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
              bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", 
              new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, 
              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
              18, 0);
        fontRendererObj.drawSplitString(stringPageText[currPage], 
              offsetFromScreenLeft + 36, 34, 116, 0);
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
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
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
    	ResourceLocation[] btexture = new ResourceLocation[2];
    	
		public MenuButton(int buttonId, int x, int y, String texture1, String texture2) 
		{
			//height=32; width=48
			super(buttonId, x, y, 48, 32, "");
			
			//button unpressed
			btexture[0]= new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture1+".png");
			//button pressed
			//btexture[1] = new ResourceLocation(RabbitConst.MODID+":textures/gui/"+texture2+".png");
			
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

				 mc.getTextureManager().bindTexture(btexture[0]);
				
				
				drawTexturedModalRect(xPosition, yPosition, 
	                      0, 1, 
	                      this.width, this.height);
				 
				
			}
			
		}
    	
    }
}
