import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class Main  extends JFrame{
   int res;
    int tries=0;
    final String[] x = new String[1];

    /* Panels */

    JPanel panel = new JPanel(new GridLayout(1,2));
    JPanel flow = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel TestLabelPanel = new JPanel(new CardLayout());

    JPanel TextLabel = new JPanel();

    /* Labels */

    JLabel label = new JLabel("Enter max number");
    JLabel labelResultTrue = new JLabel("Well done!");
    JLabel labelResultFalse = new JLabel("Try again!");

    JLabel labelTries = new JLabel();

    /* Buttons */

    JButton newGameButton = new JButton("New game");

    /* Text fields */

    JTextField textField = new JTextField("",15);
    JTextField textFieldResult = new JTextField("",15);

    public Main()  {
        super("Guess the number");
        setSize(200,200);
        setLocation(600,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container container = getContentPane();
        panel.add(newGameButton);
        flow.add(panel);
        newGameButton.setVisible(false);
        labelResultFalse.setVisible(false);
        labelResultTrue.setVisible(false);
        TextLabel.add(textField);
        TextLabel.add(label);
        TextLabel.add(textFieldResult);
        TextLabel.add(labelResultTrue);
        TextLabel.add(labelResultFalse);
        textFieldResult.setVisible(false);
        TestLabelPanel.add(TextLabel);
        container.add(TestLabelPanel,BorderLayout.CENTER);
        container.add(flow,BorderLayout.SOUTH);
        setVisible(true);

        /* Action listeners */

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int num = 0;
                try {
                    x[0] = textField.getText();
                    num = Integer.parseInt(x[0]);
                    res = (int) (Math.random() * num);
                    System.out.println(res);
                    textFieldResult.setVisible(true);
                    newGameButton.setVisible(true);
                    textField.setEnabled(false);
                } catch (NumberFormatException s) {
                    label.setText("Error, try again!");
                    textField.setEnabled(true);
                    textField.setText("");
                    newGameButton.setVisible(false);
                }
            }
        });

        textFieldResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(textFieldResult.getText()) == res){
                    labelResultFalse.setVisible(false);
                    labelResultTrue.setVisible(true);
                    labelTries.setText("Your tries: " + tries);
                    TextLabel.add(labelTries);
                }
                else {
                    tries++;
                    labelResultTrue.setVisible(false);
                    labelResultFalse.setVisible(true);
                }
            }
        });

        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldResult.setVisible(false);
                textField.setEnabled(true);
                textField.setText("");
                textField.revalidate();
                newGameButton.setVisible(false);
                labelResultFalse.setVisible(false);
                labelResultTrue.setVisible(false);
                labelTries.setVisible(false);

            }
        });


    }

    public static void main(String[] args) throws IOException {
        new Main();
    }
}
