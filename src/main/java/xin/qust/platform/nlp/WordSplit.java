package xin.qust.platform.nlp;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class WordSplit {
    public static List<List> getList(String[] sentences){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        List<List> sp_words = new ArrayList<>();
        for (String sentence : sentences) {
            List<String> words = new ArrayList<>();
            for (SegToken item : segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX)) {
                words.add(item.word);
            }
            sp_words.add(words);
        }
        return sp_words;
    }
}
