package xin.qust.platform.model.vo;

public class KbqaStanfordWord {

    private Integer index;
    private String word;
    private String originalText;
    private String lemma;
    private Integer characterOffsetBegin;
    private Integer characterOffsetEnd;
    private String pos;
    private String ner;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getNer() {
        return ner;
    }

    public void setNer(String ner) {
        this.ner = ner;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public String getOriginalText() {
        return originalText;
    }

    public void setOriginalText(String originalText) {
        this.originalText = originalText;
    }

    public String getLemma() {
        return lemma;
    }

    public void setLemma(String lemma) {
        this.lemma = lemma;
    }

    public Integer getCharacterOffsetBegin() {
        return characterOffsetBegin;
    }

    public void setCharacterOffsetBegin(Integer characterOffsetBegin) {
        this.characterOffsetBegin = characterOffsetBegin;
    }

    public Integer getCharacterOffsetEnd() {
        return characterOffsetEnd;
    }

    public void setCharacterOffsetEnd(Integer characterOffsetEnd) {
        this.characterOffsetEnd = characterOffsetEnd;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }
}
