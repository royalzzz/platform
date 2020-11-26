package xin.qust.platform.service.kbqa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.KbqaSdsChemical;
import xin.qust.platform.repository.kbqa.KbqaSdsChemicalRepo;
import xin.qust.platform.service.common.ElasticService;

import java.util.*;

@Service
public class ProcessChemicalService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private KbqaSdsChemicalRepo kbqaSdsChemicalRepo;

    @Autowired
    private ElasticService elasticService;

    public void importSDS(String indexName) {
        logger.info("import SDS");
        List<KbqaSdsChemical> chemicals = kbqaSdsChemicalRepo.findAll();
        List<Map<String, Object>> sources = new ArrayList<>();

        for (KbqaSdsChemical chemical: chemicals) {
            List<String> names = new ArrayList<>();
            names.add(chemical.getChineseName());
            names.add(chemical.getEnglishName());
            if (chemical.getOtherChineseName() != null && chemical.getOtherChineseName().contains(";")) {
                String[] cnNames = chemical.getOtherChineseName().split(";");
                names.addAll(Arrays.asList(cnNames));
            }

            if (chemical.getOtherChineseName() != null && chemical.getOtherChineseName().contains("；")) {
                String[] cnNames = chemical.getOtherChineseName().split("；");
                names.addAll(Arrays.asList(cnNames));
            }

            if (chemical.getOtherEnglishName() != null && chemical.getOtherEnglishName().contains(";")) {
                String[] enNames = chemical.getOtherEnglishName().split(";");
                names.addAll(Arrays.asList(enNames));

            }

            if (chemical.getOtherEnglishName() != null && chemical.getOtherEnglishName().contains("；")) {
                String[] enNames = chemical.getOtherEnglishName().split("；");
                names.addAll(Arrays.asList(enNames));
            }

            for (String name: names) {
                System.out.println(name);
                Map<String, Object> jsonSource = new HashMap<>();
                jsonSource.put("name", name);
                jsonSource.put("chemical_id", chemical.getId());
                sources.add(jsonSource);
            }
        }
        elasticService.insertBatch(indexName, sources);
    }
}
