package xin.qust.platform.api.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.util.CoreMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static xin.qust.platform.utils.ToolKit.mapToJsonString;

@RequestMapping("kbqa/stanford")
@RestController
public class StanfordExampleApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("example")
    public void example() throws IOException {
        String text = "今天是2021年3月1日星期一，妹妹开学了，她放学的时候看起来特别的开心，看来是老师布置了很多家庭作业。";
        logger.info(text);
        StanfordCoreNLP pipeline = new StanfordCoreNLP("chinese");

        Annotation document = new Annotation(text);

        //获取文本处理结果
        List<CoreMap> sentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap sentence : sentences) {
            // traversing the words in the current sentence
            // a CoreLabel is a CoreMap with additional token-specific methods
            for (CoreLabel token : sentence.get(CoreAnnotations.TokensAnnotation.class)) {

                // 获取句子的token（可以是作为分词后的词语）
                String word = token.get(CoreAnnotations.TextAnnotation.class);
                System.out.println(word);

                // 命名实体识别
                String ne = token.get(CoreAnnotations.NormalizedNamedEntityTagAnnotation.class);
                String ner = token.get(CoreAnnotations.NamedEntityTagAnnotation.class);
                System.out.println(word + " | analysis : {  original : " + ner + "," + " normalized : "
                        + ne + "}");
            }

            // 句子的解析树
            Tree tree = sentence.get(TreeCoreAnnotations.TreeAnnotation.class);
            System.out.println("句子的解析树:");
            tree.pennPrint();

            // 句子的依赖图
            SemanticGraph graph =
                    sentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
            System.out.println("句子的依赖图");
            System.out.println(graph.toString(SemanticGraph.OutputFormat.LIST));
        }
    }

}
