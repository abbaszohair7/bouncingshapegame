package Bouncing_game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class Circle extends JPanel {
	private int triangleX = 50; // Initial x-coordinate of the circle
    private int triangleY = 50; // Initial y-coordinate of the circle
    private int triangleArea = 50; // Diameter of the circle
    private int triangleVelocityX; // Horizontal velocity of the circle
    private int triangleVelocityY; // Vertical velocity of the circle
    Color triangleColor = Color.black;
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public Circle() {
		setForeground(Color.LIGHT_GRAY);
    	setBackground(UIManager.getColor("InternalFrame.activeTitleGradient"));
        // Generate random initial velocities
        Random rand = new Random();
        triangleVelocityX = rand.nextInt(4) + 1; // Random value between 1 and 4
        triangleVelocityY = rand.nextInt(4) + 1; // Random value between 1 and 4

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the circle's position
            	triangleX += triangleVelocityX;
            	triangleY += triangleVelocityY;

                // Check if the circle hits the window boundaries
                if (triangleX <= 0 || triangleX + triangleArea >= getWidth()) {
                	triangleVelocityX = -triangleVelocityX; // Reverse horizontal velocity
                }
                if (triangleY <= 0 || triangleY + triangleArea >= getHeight()) {
                	triangleVelocityY = -triangleVelocityY; // Reverse vertical velocity
                }

                repaint();
            }
        });
        timer.start();
    }
	 public void setVelocity(int velocityX, int velocityY) {
	        this.triangleVelocityX = velocityX;
	        this.triangleVelocityY = velocityY;
	    }
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(triangleColor);
        g.fillOval(triangleX, triangleY, triangleArea, triangleArea);
        
    }
	public void resetState() {
		// TODO Auto-generated method stub
		
	}
	}


