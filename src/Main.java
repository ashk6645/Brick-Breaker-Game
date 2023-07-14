import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener {

    private Timer timer;
    private boolean gameRunning;
    private int ballX, ballY, ballXDirection, ballYDirection;
    private int paddleX, paddleY, paddleWidth, paddleHeight;
    private int brickWidth, brickHeight;
    private int[][] bricks;

    public Main() {
        setTitle("Brick Breaker");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        ballX = 400; // initial ball position
        ballY = 500;
        ballXDirection = -1; // initial ball direction
        ballYDirection = -2;

        paddleX = 350; // initial paddle position
        paddleY = 550;
        paddleWidth = 100;
        paddleHeight = 10;

        brickWidth = 80;
        brickHeight = 20;

        bricks = new int[5][10];
        for (int i = 0; i < 5; i++) { // initialize bricks
            for (int j = 0; j < 10; j++) {
                bricks[i][j] = 1; // 1 indicates brick exists
            }
        }

        gameRunning = true;
        timer = new Timer(5, this); // fires actionPerformed every 5 milliseconds
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT) { // move paddle left
                    if (paddleX > 0) {
                        paddleX -= 20;
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // move paddle right
                    if (paddleX < getWidth() - paddleWidth) {
                        paddleX += 20;
                    }
                }
            }
        });

        setFocusable(true);
        setVisible(true);
    }

    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.BLACK);
        g.fillOval(ballX, ballY, 20, 20); // draw ball

        g.setColor(Color.BLUE);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight); // draw paddle

        for (int i = 0; i < 5; i++) { // draw bricks
            for (int j = 0; j < 10; j++) {
                if (bricks[i][j] == 1) {
                    g.setColor(Color.RED);
                    g.fillRect(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                }
            }
        }

        if (!gameRunning) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 300, 300);
        }
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();

        ballX += ballXDirection;
        ballY += ballYDirection;

        if (ballX < 0 || ballX > getWidth() - 20) { // ball hits left or right wall
            ballXDirection = -ballXDirection;
        }
        if (ballY < 0) { // ball hits top wall
            ballYDirection = -ballYDirection;
        }
        if (ballY > getHeight() - 20) { // ball hits bottom wall
            gameRunning = false;
        }

        if (new Rectangle(ballX, ballY, 20, 20).intersects(new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight))) {
            ballYDirection = -ballYDirection; // ball hits paddle
        }

        for (int i = 0; i < 5; i++) { // ball hits brick
            for (int j = 0; j < 10; j++) {
                if (bricks[i][j] == 1) {
                    Rectangle brickRect = new Rectangle(j * brickWidth + 80, i * brickHeight + 50, brickWidth, brickHeight);
                    Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
                    if (ballRect.intersects(brickRect)) {
                        bricks[i][j] = 0;
                        ballYDirection = -ballYDirection;
                    }
                }
            }
        }

        repaint();
    }

    public static void main(String[] args) {
        new Main();
    }
}
