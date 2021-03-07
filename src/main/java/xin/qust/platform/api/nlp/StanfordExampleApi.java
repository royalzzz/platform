package xin.qust.platform.api.nlp;

import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.IndexedWord;
import edu.stanford.nlp.ling.Label;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.semgraph.SemanticGraph;
import edu.stanford.nlp.semgraph.SemanticGraphCoreAnnotations;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.trees.Dependency;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreeCoreAnnotations;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.util.CoreMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.vo.KbqaStanfordDependency;
import xin.qust.platform.model.vo.KbqaStanfordResult;
import xin.qust.platform.model.vo.KbqaStanfordWord;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.*;

import static xin.qust.platform.utils.ToolKit.mapToJsonString;

@RequestMapping("kbqa/stanford")
@RestController
public class StanfordExampleApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    StanfordCoreNLP pipeline = new StanfordCoreNLP("StanfordCoreNLP-chinese.properties");

    @RequestMapping("example")
    public Message example(String text) {
        logger.info(text);
        Annotation document = new Annotation(text);
        pipeline.annotate(document);
        List<KbqaStanfordResult> kbqaStanfordResults = new ArrayList<>();
        List<KbqaStanfordWord> tokens = new ArrayList<>();
        List<KbqaStanfordDependency> basicDependencies = new ArrayList<>();
        List<String> kbqaStanfordGraphs = new ArrayList<>();

        //获取文本处理结果
        int i = 0;
        List<CoreMap> coreSentences = document.get(CoreAnnotations.SentencesAnnotation.class);
        for (CoreMap coreSentence : coreSentences) {
            for (CoreLabel token : coreSentence.get(CoreAnnotations.TokensAnnotation.class)) {
                KbqaStanfordWord kbqaStanfordWord = new KbqaStanfordWord();
                kbqaStanfordWord.setIndex(token.index());
                kbqaStanfordWord.setOriginalText(token.originalText());
                kbqaStanfordWord.setWord(token.word());
                kbqaStanfordWord.setLemma(token.lemma());
                kbqaStanfordWord.setCharacterOffsetBegin(token.beginPosition());
                kbqaStanfordWord.setCharacterOffsetEnd(token.endPosition());
                kbqaStanfordWord.setNer(token.ner());
                kbqaStanfordWord.setPos(token.tag());
                tokens.add(kbqaStanfordWord);
            }

            // 句子的解析树
            SemanticGraph basic  = coreSentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
            List<TypedDependency> typedDependencies = (List<TypedDependency>) basic.typedDependencies();
            for (TypedDependency typedDependency: typedDependencies) {
                KbqaStanfordDependency kbqaStanfordDependency = new KbqaStanfordDependency();
                kbqaStanfordDependency.setDep(typedDependency.reln().getShortName());
                kbqaStanfordDependency.setSpecific(typedDependency.reln().getSpecific());
                kbqaStanfordDependency.setLongName(typedDependency.reln().getLongName());
                kbqaStanfordDependency.setShortName(typedDependency.reln().getShortName());
                kbqaStanfordDependency.setDependent(typedDependency.dep().index());
                kbqaStanfordDependency.setDependentGloss(typedDependency.dep().word());
                kbqaStanfordDependency.setGovernor(typedDependency.gov().index());
                if (kbqaStanfordDependency.getGovernor() == 0) {
                    kbqaStanfordDependency.setGovernorGloss("ROOT");
                }
                else {
                    kbqaStanfordDependency.setGovernorGloss(typedDependency.gov().word());
                }
                basicDependencies.add(kbqaStanfordDependency);
            }

            // 句子的依赖图
            SemanticGraph graph =
                    coreSentence.get(SemanticGraphCoreAnnotations.BasicDependenciesAnnotation.class);
            kbqaStanfordGraphs.add(graph.toString());

            KbqaStanfordResult kbqaStanfordResult = new KbqaStanfordResult();
            kbqaStanfordResult.setIndex(i++);
            kbqaStanfordResult.setKbqaStanfordWords(tokens);
            kbqaStanfordResult.setBasicDependencies(basicDependencies);
            kbqaStanfordResult.setKbqaStanfordGraphs(kbqaStanfordGraphs);
            kbqaStanfordResults.add(kbqaStanfordResult);
        }
        Map<String, List<KbqaStanfordResult>> resultMap = new HashMap<>();
        resultMap.put("sentences", kbqaStanfordResults);
        return Message.createSuccessMessage(resultMap);
    }

}
