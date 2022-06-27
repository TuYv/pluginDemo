package com.rick.plugin.factory;

import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.intellij.openapi.util.NlsContexts.ConfigurableName;
import com.rick.plugin.Config;
import com.rick.plugin.ui.SettingUI;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import javax.swing.JComponent;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * @author Max.Tu
 * @program testPlugin
 * @description
 * @create 2022-06-05 00:24
 **/
public class SettingFactory implements SearchableConfigurable {

    private SettingUI settingUI = new SettingUI();
    @Override
    public @NotNull
    @NonNls String getId() {
        return "test.id";
    }

    @Override
    public @ConfigurableName String getDisplayName() {
        return "test-config";
    }

    @Override
    public @Nullable JComponent createComponent() {
        return settingUI.getComponent();
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        String url = settingUI.getUrlTextField().getText();
        // 设置文本信息
        try {
            File file = new File(url);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(0);

            byte[] bytes = new byte[1024 * 1024];
            int readSize = randomAccessFile.read(bytes);

            byte[] copy = new byte[readSize];
            System.arraycopy(bytes, 0, copy, 0, readSize);

            String str = new String(copy, StandardCharsets.UTF_8);

            // 设置内容
            Config.readUI.getTextContent().setText(str);

        } catch (Exception ignore) {
        }
    }
}
