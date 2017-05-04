package io.github.smartsteves.heartrigger;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * HearTriggerScriptEngineFactory
 */
public class HearTriggerScriptEngineFactory implements ScriptEngineFactory {
    @Override
    public String getEngineName() {
        return "HearTriggerOfficialExecutor";
    }

    @Override
    public String getEngineVersion() {
        return "Beta0.0.1";
    }

    @Override
    public List<String> getExtensions() {
        ArrayList<String> s = new ArrayList<>();
        s.add("ht");
        return s;
    }

    @Override
    public List<String> getMimeTypes() {
        return null;
    }

    @Override
    public List<String> getNames() {
        ArrayList<String> s = new ArrayList<>();
        s.add("ht");
        s.add("heartrigger");
        s.add("HearTrigger");
        s.add("HPScript");
        return s;
    }

    @Override
    public String getLanguageName() {
        return "HearTrigger";
    }

    @Override
    public String getLanguageVersion() {
        return "HearTrigger - Beta#0.1";
    }

    @Override
    public Object getParameter(String key) {
        return getLanguageVersion();
    }

    @Override
    public String getMethodCallSyntax(String obj, String m, String... args) {
        StringBuilder sb = new StringBuilder();
        sb.append("java>\n\t").append(obj).append(".").append(m);
        for(String s:args) sb.append(" ").append(s);
        sb.append("\n <");
        return sb.toString();
    }

    @Override
    public String getOutputStatement(String toDisplay) {
        StringBuilder sb = new StringBuilder();
        sb.append("log \"").append(toDisplay).append("\"");
        return sb.toString();
    }

    @Override
    public String getProgram(String... statements) {
        StringBuilder sb = new StringBuilder();
        sb.append("main>");
        for(String s:statements) sb.append("\n").append(s);
        sb.append("\n<");
        return sb.toString();
    }

    @Override
    public ScriptEngine getScriptEngine() {
        return new HearTriggerScriptEngine();
    }
}
