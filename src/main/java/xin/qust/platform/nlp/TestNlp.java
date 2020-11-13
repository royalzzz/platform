package xin.qust.platform.nlp;

import org.junit.Test;

import java.util.List;

public class TestNlp {

    @Test
    public void testDemo() {
        String[] sentences = new String[] {"容器内可燃物料轻质组分急剧挥发"};
        List<List> sp_words = WordSplit.getList(sentences);
        System.out.println(sp_words);
    }
}
