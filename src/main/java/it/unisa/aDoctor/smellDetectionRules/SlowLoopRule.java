package it.unisa.aDoctor.smellDetectionRules;

import java.io.IOException;

import org.eclipse.jdt.core.dom.CompilationUnit;

import it.unisa.aDoctor.beans.ClassBean;
import it.unisa.aDoctor.parser.CodeParser;
import it.unisa.aDoctor.parser.ForStatementVisitor;

public class SlowLoopRule {

    public int isSlowLoop(ClassBean pClassBean) throws IOException {
        CodeParser parser = new CodeParser();
        CompilationUnit compilationUnit = parser.createParser(pClassBean.getTextContent());
        ForStatementVisitor forVisitor = new ForStatementVisitor();

        compilationUnit.accept(forVisitor);

        if(!forVisitor.getForStatements().isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
