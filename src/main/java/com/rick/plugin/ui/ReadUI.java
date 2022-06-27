package com.rick.plugin.ui;

import com.rick.plugin.Config;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 * @author Max.Tu
 * @program testPlugin
 * @description
 * @create 2022-06-05 00:19
 **/
public class ReadUI {

    private JPanel mainPanel;
    private JTextPane textContent;
    private JScrollPane sPanel;
    private JPanel settingPanel;
    private JTextField urlTextField;
    private JButton urlBtn;
    private JLabel urlLabel;
    private JButton pageBtn;

    private RandomAccessFile randomAccessFile;

    public ReadUI() {
        // 给按钮添加一个选择文件的事件
        urlBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showOpenDialog(settingPanel);
            File file = fileChooser.getSelectedFile();
            urlTextField.setText(file.getPath());

            // 设置文本信息
            try {
                randomAccessFile = new RandomAccessFile(file, "r");
                randomAccessFile.seek(0);

                byte[] bytes = new byte[128 * 128];
                int readSize = randomAccessFile.read(bytes);

                byte[] copy = new byte[readSize];
                System.arraycopy(bytes, 0, copy, 0, readSize);

                String str = new String(copy, StandardCharsets.UTF_8);

                // 设置内容
                this.textContent.setText(str);

            } catch (Exception ignore) {
            }
        });
        pageBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                try {

                    byte[] bytes = new byte[128 * 128];
                    int readSize = randomAccessFile.read(bytes);
                    byte[] copy = new byte[readSize];
                    System.arraycopy(bytes, 0, copy, 0, readSize);

                    String str = new String(copy, StandardCharsets.UTF_8);

                    // 设置内容
                    textContent.setText(str);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        });
    }
    public JComponent getComponent() {
        return mainPanel;
    }

    public JTextPane getTextContent() {
        return textContent;
    }
}
