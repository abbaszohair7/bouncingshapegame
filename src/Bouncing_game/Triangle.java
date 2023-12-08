package Bouncing_game;

import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Triangle extends JPanel {
	private int triangleX = 50; // Initial x-coordinate of the triangle
    private int triangleY = 50; // Initial y-coordinate of the triangle
    private int triangleSize = 50; // Size of the triangle
    private int triangleVelocityX; // Horizontal velocity of the triangle
    private int triangleVelocityY; // Vertical velocity of the triangle
    Color triangleColor = Color.black;
    public Triangle() {
        setForeground(Color.LIGHT_GRAY);
        setBackground(Color.LIGHT_GRAY);
        
        
        // Generate random initial velocities
        Random rand = new Random();
        triangleVelocityX = rand.nextInt(4) + 1; // Random value between 1 and 4
        triangleVelocityY = rand.nextInt() + 1; // Random value between 1 and 4
        

        Timer timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update the triangle's position
                triangleX += triangleVelocityX;
                triangleY += triangleVelocityY;

                // Check if the triangle hits the window boundaries
                if (triangleX <= 0 || triangleX + triangleSize >= getWidth()) {
                    triangleVelocityX = -triangleVelocityX; // Reverse horizontal velocity
                }
                if (triangleY <= 0 || triangleY + triangleSize >= getHeight()) {
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

        // Draw a triangle
        int[] xPoints = {triangleX, triangleX + triangleSize, triangleX + triangleSize / 2};
        int[] yPoints = {triangleY + triangleSize, triangleY + triangleSize, triangleY};
        int nPoints = 3;

        g.setColor(triangleColor);
        g.fillPolygon(xPoints, yPoints, nPoints);
        
    }

	public void resetState() {
		// TODO Auto-generated method stub
		
	}
}
 