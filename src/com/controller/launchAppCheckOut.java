import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class launchAppCheckOut extends JFrame{
    private JPanel mainPanel;
    private JButton startBtn;
    private JLabel greetingLbl;
    private JLabel detailsLbl;

    public launchAppCheckOut() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(720, 600));
        pack();
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selfCheckout sSelfCheckout = new selfCheckout();
                selfCheckout.service();
                sSelfCheckout.show();
                dispose();
            }
        });
    }
}
