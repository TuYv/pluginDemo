package com.rick.plugin;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author Max.Tu
 * @program testPlugin
 * @description
 * @create 2022-05-29 15:00
 **/
public class MyAction extends AnAction {

    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        Project project = e.getData(PlatformDataKeys.PROJECT);
        //PsiFile psiFile = e.getData(CommonDataKeys.PSI_FILE);
        //String classPath = psiFile.getVirtualFile().getPath();
        Messages.showMessageDialog(project, "guide-idea-plugin-create-project-by-gradle: ", "Hi IDEA Plugin", Messages.getInformationIcon());
    }


}
