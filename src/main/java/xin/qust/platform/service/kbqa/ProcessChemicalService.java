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
        logger.info("import sds");
        List<KbqaSdsChemical> chemicals = kbqaSdsChemicalRepo.findAll();
        List<Map<String, Object>> sources = new ArrayList<>();

        for (KbqaSdsChemical chemical: chemicals) {
            List<String> names = new ArrayList<>();
            names.add(chemical.getChineseName());
            names.add(chemical.getEnglishName());
            if (chemical.getOtherChineseName() != null) {
                String[] cnNames = chemical.getOtherChineseName().replaceAll("；", ";").split(";");
                names.addAll(Arrays.asList(cnNames));
            }

            if (chemical.getOtherEnglishName() != null) {
                String[] enNames = chemical.getOtherEnglishName().replaceAll("；", ";").split(";");
                names.addAll(Arrays.asList(enNames));
            }

            for (String name: names) {
                Map<String, Object> jsonSource = new HashMap<>();
                jsonSource.put("smart_name", name);
                jsonSource.put("standard_name", name);
                jsonSource.put("chemical_id", chemical.getId());
                sources.add(jsonSource);
            }
        }
        elasticService.insertBatch(indexName, sources);
    }
}
