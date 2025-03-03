import javax.swing.*;

public class kontoDialog {
    private JPanel dialogPanel;
    private JButton button1;
    private JButton button2;
    private JLabel owner;

    public kontoDialog(){
        JFrame frame = new JFrame("dia");
        frame.setContentPane(new kontoDialog().dialogPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
