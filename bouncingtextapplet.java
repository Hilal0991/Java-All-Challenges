import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class bouncingtextapplet extends Applet implements
Runnable {
private String message = "Hilal"; // Your name or custom text
private int x = 0; // X position of text
private int y = 100; // Y position of text
private Thread thread;
private boolean running = false;
// Initialize applet
public void init() {
setSize(400, 200);
setBackground(Color.black);
}
// Start the thread
public void start() {
if (thread == null) {
running = true;
thread = new Thread(this);
thread.start();
}
}
// Stop the thread
public void stop() {
running = false;
thread = null;
}
// The animation logic
public void run() {
while (running) {
x += 10; // Move text to the right
if (x > getWidth()) {
x = 0; // Reset when it hits right edge
}
repaint(); // Redraw screen
try {
Thread.sleep(100); // Pause for smooth animation
} catch (InterruptedException e) {
// Ignore interruption
}
}
}
// Draw the text
public void paint(Graphics g) {
g.setColor(Color.yellow);
g.drawString(message, x, y);
}
}