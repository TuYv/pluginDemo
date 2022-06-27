package com.rick.plugin.ui;

import java.io.File;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Max.Tu
 * @program testPlugin
 * @description
 * @create 2022-05-29 19:10
 **/
public class SettingUI {

    private JPanel mainPanel;
    private JPanel settingPanel;
    private JLabel urlLabel;
    private JTextField urlTextField;
    private JButton urlBtn;
    public SettingUI() {
        // 给按钮添加一个选择文件的事件
        urlBtn.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.showOpenDialog(settingPanel);
            File file = fileChooser.getSelectedFile();
            urlTextField.setText(file.getPath());
        });
    }

    public JComponent getComponent() {
        return mainPanel;
    }

    public JTextField getUrlTextField() {
        return urlTextField;
    }
}
