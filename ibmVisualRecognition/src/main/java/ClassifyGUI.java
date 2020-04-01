import com.ibm.watson.assistant.v1.model.Example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClassifyGUI  extends JFrame{
    private JPanel mainPanel;
    private JTextField URLField;
    private JButton classifyButton;
    private JTextArea textClassification;
    //private JLabel classifyLabel;

    public ClassifyGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
        classifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempURL = URLField.getText();
                ClassifyUrlDefault classify = new ClassifyUrlDefault();
                String result = classify.ClassifyImage(tempURL);
                textClassification.setText(result);

            }
        });
    }

    public static void Examples(){
        System.out.println("https://i.ibb.co/mbddFc7/portada1.png");
        System.out.println("https://i.ibb.co/brxvyVY/fr00g-perfil.png");
        System.out.println("https://i.ibb.co/fC6k0jY/qsqqsqsqs.png");
        System.out.println("https://i.ibb.co/sbDj5JR/viking-33877-640.png");
    }

    public static void main(String[] args){
        Examples();
        JFrame frame = new ClassifyGUI("URL Clasificador de Imagenes");
        frame.setVisible(true);
    }
}
