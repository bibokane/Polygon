import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame(int step) {
        setTitle("MyFrame");
        setSize(1000, 1000);
        add(new KochPanel(step));
        setVisible(true);
    }
}
