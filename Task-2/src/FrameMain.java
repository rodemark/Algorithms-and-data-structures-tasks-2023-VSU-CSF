
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMain extends JFrame{
    private JPanel panelMain;
    private JButton buttonLoadInputFromFile;
    private JButton buttonGetAnswer;
    private JTextField textFieldInput;
    private JTextField textField2;
    private JPanel panel;

    public FrameMain() {
        this.setTitle("Task-2");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JFileChooser fileChooserOpen = new JFileChooser();
        JFileChooser fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("View");
        menuBarMain.add(menuLookAndFeel);
        UtilsSolomatin.SwingUtils.initLookAndFeelMenu(menuLookAndFeel);


        this.pack();
        textFieldInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });

        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        SimpleLinkedList<Integer> list = Utils.readListFromFile(fileChooserOpen.getSelectedFile().getPath());
                        textFieldInput.setText(Utils.listToString(list, ""));
                    }
                } catch (Exception err) {
                    UtilsSolomatin.SwingUtils.showErrorMessageBox(err);
                }

            }
        });

        buttonGetAnswer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String str = textFieldInput.getText();
                    SimpleLinkedList<Integer> list = Utils.StringToList(str);
                    list.swapMinMax();
                    textField2.setText(Utils.listToString(list, ""));
                }
                catch (Exception err) {
                    UtilsSolomatin.SwingUtils.showErrorMessageBox(err);
                }
            }
        });
    }
}
