import javafx.scene.layout.Background;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by HUYNHDUC on 6/5/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image backgroud;
    Plane player1;
    Plane player2;
    Plane player3;

    BufferedImage bufferedImage;
    ArrayList<PlaneEnemy> enemies = new ArrayList<>();

    ArrayList<Plane> h;


    public ArrayList<PlaneEnemy> getEnemies() {
        return enemies;
    }


    public GameWindow() {
        this.setSize(480, 600);
        this.setTitle("1945");
        this.setVisible(true);


        player1 = PlaneFighter.getInstance();
        player3 = PlaneFighter.getInstance();

        // cach goi ham shot trong ifighter
        // ((PlaneFighter)player1).shot();

        //c2
//        Ifighter a = (Ifighter)player1;
//                         a.shot();

        player2 = new PlaneSupporter(200, 300, "Resources/PLANE3.png");


        enemies.add(new PlaneEnemy(150, 250, "Resources/PLANE1.png"));
        enemies.add(new PlaneEnemy(100, 200, "Resources/PLANE1.png"));
        enemies.add(new PlaneEnemy(200, 350, "Resources/PLANE1.png"));
        enemies.add(new PlaneEnemy(250, 450, "Resources/PLANE1.png"));
        enemies.add(new PlaneEnemy(300, 200, "Resources/PLANE1.png"));
        enemies.add(new PlaneEnemy(350, 250, "Resources/PLANE1.png"));

        Iterator inrEnemies = enemies.iterator();

        for (IRocketlistener iRocketlistener : enemies) {

            ((Subject) player1).addRocketListener(iRocketlistener);
        }

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                player2.move(e.getX(), e.getY());
            }
        });


        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    System.out.println("clich chuot phai");
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    ((Subject) player1).FireRocket();
                    while (inrEnemies.hasNext()) {
                        PlaneEnemy pe = (PlaneEnemy) inrEnemies.next();
                        if (pe.planeFireRocket() == 1) inrEnemies.remove();
                    }
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // vưa an phim

            }

            @Override
            public void keyPressed(KeyEvent e) {
                // giu phim
                switch (e.getKeyCode()) {

                    case KeyEvent.VK_W:

                        player3.speedY = -3;
                        break;
                    case KeyEvent.VK_S:
                        player3.speedY = 3;
                        break;
                    case KeyEvent.VK_A:
                        player3.speedX = -3;
                        break;
                    case KeyEvent.VK_D:
                        player3.speedX = 3;
                        break;
                    case KeyEvent.VK_SPACE: {
                        ((Ifighter) player1).shot();
                        break;

                    }


                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                //tha phim
                player3.speedX = 0;
                player3.speedY = 0;


            }

        });


        try {
            backgroud = ImageIO.read(new File("Resources/Background.png"));
            //         player2.image = ImageIO.read(new File("Resources/PLANE2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


        //      repaint(); //goi update

    }

    // ham tinh khoang cach
    private double kc(int x1, int y1, int x2, int y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    long count = 0;

    public void gameUpdate() {
        count++;
        player1.update();
        player2.update();

        for (PlaneEnemy p : enemies) {
            p.update();
        }

        if (count == 600) {
            count = 0;
            if (player2 instanceof ISupport) {
                if (kc(player1.positionX, player1.positionY, player2.positionX, player2.positionY) <= 100.0f) {
                    ((ISupport) player2).bonusHP(player1);
                }
            }
            if (player1 instanceof ISupport) {
                if (kc(player1.positionX, player1.positionY, player2.positionX, player2.positionY) <= 100.0f) {
                    ((ISupport) player1).bonusHP(player2);
                }
            }

        }

    }

    @Override
    public void update(Graphics g) {
        //   System.out.println("update");
        if (bufferedImage == null) {
            bufferedImage = new BufferedImage(480, 600, 1);
        }
        Graphics bufferGraphics = bufferedImage.getGraphics();

        bufferGraphics.drawImage(backgroud, 0, 0, null);

        for (PlaneEnemy p : enemies) {
            p.draw(bufferGraphics);
        }
        player1.draw(bufferGraphics);
        player2.draw(bufferGraphics);


        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {

            try {

                Thread.sleep(17);
                gameUpdate();
                // doan code nay chay 60 lan 1s
                repaint(); //goi update
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
