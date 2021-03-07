package xin.qust.platform.model.vo;

import java.util.List;

public class KbqaStanfordResult {

    private int index;

    private List<KbqaStanfordWord> tokens;

    private List<KbqaStanfordDependency> basicDependencies;

    private List<String> kbqaStanfordGraphs;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public List<KbqaStanfordWord> getTokens() {
        return tokens;
    }

    public void setTokens(List<KbqaStanfordWord> tokens) {
        this.tokens = tokens;
    }


    public List<KbqaStanfordWord> getKbqaStanfordWords() {
        return tokens;
    }

    public void setKbqaStanfordWords(List<KbqaStanfordWord> kbqaStanfordWords) {
        this.tokens = kbqaStanfordWords;
    }

    public List<KbqaStanfordDependency> getBasicDependencies() {
        return basicDependencies;
    }

    public void setBasicDependencies(List<KbqaStanfordDependency> basicDependencies) {
        this.basicDependencies = basicDependencies;
    }

    public List<String> getKbqaStanfordGraphs() {
        return kbqaStanfordGraphs;
    }

    public void setKbqaStanfordGraphs(List<String> kbqaStanfordGraphs) {
        this.kbqaStanfordGraphs = kbqaStanfordGraphs;
    }
}
