package xin.qust.platform.repository.kbqa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xin.qust.platform.domain.kbqa.KbqaQuestionText;

import java.util.List;

public interface KbqaQuestionTextRepo extends JpaRepository<KbqaQuestionText, Long> {

    List<KbqaQuestionText> findByTextContaining(String text);

}
