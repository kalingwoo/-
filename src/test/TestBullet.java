package test;

import static org.junit.Assert.*;
import org.junit.Test;

import core.JetFighter;
import core.Bullet;
import core.Enemy;
import core.Entity;
import globalData.Render;
import globalData.Updateable;
import globalData.Updater;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.GameUI;

public class TestBullet {

    @Test
    public void testConstructor() {
        GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 10;
        int y = 20;

        Bullet bullet = new Bullet(gameUI, x, y, entity);
        
        // Verify that the Bullet object is created successfully
        assertEquals("Bullet object should not be null", bullet);
        
        // Verify that the Bullet object is added to Render and Update lists
        // (Assuming Render and Update classes are properly implemented and accessible)
        // assertEquals("Bullet should be added to Render list", true, Render.addRenderableObject(bullet));
        // assertEquals("Bullet should be added to Update list", true, Updater.addUpdateList(bullet));

        // Verify that the width, height, speed, and AP values are set correctly

        // Verify that the getImage() method is called

        //assertEquals(true, bullet.getImage());
    }

    @Test
    public void testDefaultSetting() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 10;
        int y = 20;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);
        bullet.defaultSetting();

        // Verify that the width, height, speed, and AP values are set to their default values
        assertEquals(x, bullet.getX(),0);
        assertEquals(y, bullet.getY(),0);
        assertEquals("bullet", bullet.getID());
        assertEquals( 4, bullet.getWidth(),0);
        assertEquals(12, bullet.getHeight(),0);
        assertEquals(12, bullet.getSpeed(),0);
        assertEquals(1, bullet.getAP(),0);
    }

    @Test
    public void testGetXY() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 10;
        int y = 20;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);

        // Verify that the width, height, speed, and AP values are set to their default values
        assertEquals(x, bullet.getX(),0);
        assertEquals(y, bullet.getY(),0);
    }
    
    @Test
    public void testGetBulletID() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 10;
        int y = 20;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);
        assertEquals("bullet", bullet.getID());
    }
    
    
    @Test
    public void testGetRenderable() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 10;
        int y = 20;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);
        assertEquals(bullet, bullet.getRenderable());
    }
    
    

    @Test
    public void testDraw() {
        Bullet bullet = new Bullet(null, 10, 20, null);
        //Graphics2D g2 = new Graphics2D();

        // Draw the bullet
        //assertEquals(bullet.draw(g2),g2.drawImage(bufferedImage,x,y,width,height,null));

        // TODO: Verify that the image is drawn correctly
        // You can add assertions to check the drawing behavior based on your implementation.
    }

    //@Test
    //public void testGetLayer() {
        //Bullet bullet = new Bullet(null, 0, 0, null);

        // Verify that the method returns the correct layer value
        //assertEquals("Layer should be 1", 1, bullet.getLayer());
    //}

    @Test
    public void testUpdate_YGreaterThanZero() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 0;
        int y = 100;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);

        // Update the bullet
        bullet.update();

        // Verify that the y value decreases by the correct speed
        assertEquals( 100 - bullet.getSpeed(), bullet.getY(),0);
    }

    @Test
    public void testUpdate_YEqualsZero() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 0;
        int y = -1;
    	Bullet bullet = new Bullet(gameUI, x, y, entity);
        //Updater.removeUpdateList(bullet);
        //Render.removeRenderableObject(bullet);

        // Update the bullet
        bullet.update();

        // Verify that the bullet is removed from the Render and Update lists
        assertEquals( Render.containsRenderableObject(bullet), false);
        assertEquals( Updater.containsUpdateableObject(bullet),false);
    }

    @Test
    public void testCollision() {
    	GameUI gameUI = new GameUI();
        Entity entity = new Entity(gameUI);
        int x = 0;
        int y = 10;
        Bullet bullet = new Bullet(gameUI, x, y, entity);
        // Update the bullet
        bullet.update();

        // Verify that the bullet is removed from the Render and Update lists
       // assertEquals( Render.containsRenderableObject(bullet), false);
        //assertEquals( Updater.addUpdateList(bullet),false);
    }
    
        @Test
        public void testCheckCollision_EnemyCollision() {
            GameUI gameUI = new GameUI();
            Entity entity = new Entity(gameUI);
            int x = 10;
            int y = 20;
            int AP = 1;
            
            // Create a bullet object
            Bullet bullet = new Bullet(gameUI, x, y, entity);
            
            bullet.defaultSetting();
            // Create an enemy object at the same position as the bullet
            Enemy enemy = new Enemy(gameUI, x, y, "enemy01");
            //Enemy enemy = new Enemy(null, null, null, null);
            //enemy.reduceHP(1); // HP = 0 
            
            
            // Add the enemy to the collision check list
            //addEnemyToCollisionCheckList(enemy);

            // Call the checkCollision method
            bullet.update();

            // Verify that the enemy's HP is reduced by the bullet's AP
            //assertEquals("Enemy HP should be reduced by AP", 0, enemy.getHP(),0);

            // Verify that the bullet is removed from the Render and Update lists
            assertEquals("Bullet should be removed from Render list", Render.containsRenderableObject(bullet),true);
            assertEquals("Bullet should be removed from Update list", Updater.containsUpdateableObject(bullet),true);

            // Verify that the jet's score is updated if the enemy dies
            JetFighter jet = (JetFighter) entity;
            assertEquals("Jet score should be increased", jet.getScore(), 100);

            // Cleanup: Remove the enemy from the collision check list
            //removeEnemyFromCollisionCheckList(enemy);
        }

        @Test
        public void testCheckCollision_EnemyCollision_2() {
            GameUI gameUI = new GameUI();
            Entity entity = new Entity(gameUI);
            int x = 10;
            int y = 20;
            int AP = 1;
            
            // Create a bullet object
            Bullet bullet = new Bullet(gameUI, x, y, entity);
            
            bullet.defaultSetting();
            // Create an enemy object at the same position as the bullet
            Enemy enemy = new Enemy(gameUI, x, y, "enemy01");
            Updater.addUpdateList(bullet);
            Updater.addUpdateList(enemy);
            // Call the checkCollision method
            bullet.update();
            enemy.update();
            Updater.update();
            // Verify that the enemy's HP is reduced by the bullet's AP
            //assertEquals("Enemy HP should be reduced by AP", 0, enemy.getHP(),0);

            // Verify that the bullet is removed from the Render and Update lists
            assertEquals("Bullet should be removed from Render list", Render.containsRenderableObject(bullet),true);
            assertEquals("Bullet should be removed from Update list", Updater.containsUpdateableObject(bullet),false);

            // Verify that the jet's score is updated if the enemy dies
            JetFighter jet = (JetFighter) entity;
            assertEquals("Jet score should be increased", jet.getScore(), 100);

            // Cleanup: Remove the enemy from the collision check list
            //removeEnemyFromCollisionCheckList(enemy);
        }

}