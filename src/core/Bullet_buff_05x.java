package core;

import main.GameUI;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Bullet_buff_05x extends Bullet{
		
	public Bullet_buff_05x(GameUI gameUI,int x, int y, Entity obj) {
		super(gameUI,x,y,obj);
		defaultSetting();
		getImage();
	}
	
	public void defaultSetting() {
		this.width= 4;
		this.height = 12;
		this.speed = 8;
		this.AP = 0.5;
	}

	public void getImage() {
		try {
			bufferedImage = ImageIO.read(getClass().getResourceAsStream("/bullet/bullet01.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}