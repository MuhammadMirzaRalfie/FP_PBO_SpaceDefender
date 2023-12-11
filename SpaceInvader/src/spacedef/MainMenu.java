package spacedef;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        initUI();
       
    }

    private void initUI() {
        setTitle("Space Defender");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 0, 10)); // GridLayout dengan 3 baris dan jarak 10 piksel
        setBackground(Color.blue);
        
        JLabel titleLabel = new JLabel("Space Defender", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        JButton startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 dispose(); // Tutup jendela main menu

                 // Membuat jendela permainan baru dengan kelas Board
                 JFrame gameFrame = new JFrame("Space Defender");
                 gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 gameFrame.setSize(Commons.BOARD_WIDTH, Commons.BOARD_HEIGHT);
                 gameFrame.setResizable(false);

                 Board board = new Board();
                 gameFrame.add(board);
                 gameFrame.setVisible(true);
             }
         });
            

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Keluar dari aplikasi saat tombol Exit ditekan
            }
        });

        panel.add(titleLabel);
        panel.add(startButton);
        panel.add(exitButton);

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainMenu();
            }
        });
    }
}
