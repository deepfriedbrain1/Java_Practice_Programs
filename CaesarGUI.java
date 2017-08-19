import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 * @author Alberto Fernandez
 */
public class CaesarGUI extends JFrame implements ActionListener
{
    private static final long serialVersionID = 1L;
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private JTextField shiftFactor;
    private JTextArea inputTA;
    private JTextArea outputTA;

    public static void main(String[] args)
    {
        new CaesarGUI().setVisible(true);
    }

    public void encryptText() throws InterruptedException
    {
        HashMap<Character, Character> alphaMap = new HashMap<Character, Character>();
        int shift;
        String textNumber = this.shiftFactor.getText();

        if(!textNumber.equals(""))
        {
            shift = Integer.parseInt(textNumber) % 26;
        }
        else
        {
            shift = 0;
        }

        for(int i = 0; i < alphabet.length(); i++)
        {
            alphaMap.put(alphabet.charAt(i), alphabet.charAt((i + shift) % 26));
        }

        String inputText = inputTA.getText().toLowerCase();
        String outputText = "";

        for(int j = 0; j < inputText.length(); j++)
        {
            outputText = outputText.concat(alphaMap.get(inputText.charAt(j)).toString());
        }

        outputTA.setText(outputText);
    }

    public void decryptText() throws InterruptedException
    {
        HashMap<Character, Character> alphaMap = new HashMap<Character, Character>();
        int shift;
        String textNumber = this.shiftFactor.getText();

        if(!textNumber.equals(""))
        {
            shift = Integer.parseInt(textNumber) % 26;
        }
        else
        {
            shift = 0;
        }

        for(int i = 0; i < alphabet.length(); i++)
        {
            alphaMap.put(alphabet.charAt((i + shift) % 26), alphabet.charAt(i));
        }

        String inputText = inputTA.getText().toLowerCase();
        String outputText = "";

        for(int j = 0; j < inputText.length(); j++)
        {
            outputText = outputText.concat(alphaMap.get(inputText.charAt(j)).toString());
        }

        outputTA.setText(outputText);
    }

    public CaesarGUI()
    {
        setTitle("Caesar Cipher");
        setVisible(true);
        setDefaultCloseOperation(3);

        Container content = getContentPane();
        GridLayout layout = new GridLayout(3, 0, 0, 10);
        content.setLayout(layout);

        inputTA = new JTextArea("Insert the text to be encrypted/decrypted here, then press the appropriate button", 12, 40);
        inputTA.setLineWrap(true);
        inputTA.setWrapStyleWord(true);
        inputTA.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        JScrollPane scroller = new JScrollPane(inputTA);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroller);

        outputTA = new JTextArea("Output text.", 12, 40);
        outputTA.setLineWrap(true);
        outputTA.setWrapStyleWord(true);
        outputTA.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        JScrollPane scroller2 = new JScrollPane(outputTA);
        scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        content.add(scroller2);

        JPanel box1 = new JPanel();
        box1.setLayout(new FlowLayout());
        JButton decryptButton = new JButton("Decrypt");
        JButton encryptButton = new JButton("Encrypt");

        decryptButton.addActionListener(this);
        encryptButton.addActionListener(this);

        box1.add(decryptButton);
        box1.add(encryptButton);
        box1.add(new JLabel("Shift Factor"));
        box1.add(this.shiftFactor = new JTextField(20));
        content.add(box1);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Encrypt"))
        {
            try
            {
                encryptText();
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }
        }
        if(e.getActionCommand().equals("Decrypt"))
            try
            {
                decryptText();
            }
            catch(InterruptedException ie)
            {
                ie.printStackTrace();
            }

    }
}
