package xin.qust.platform.framework;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@NoRepositoryBean
@Transactional(
        readOnly = true
)
public class WMRepositoryImplementation<T, ID> extends SimpleJpaRepository<T, ID> implements WMRepository<T, ID> {

    private final JpaEntityInformation<T, ?> entityInformation;
    private final EntityManager em;
    private Map<String,Method> methodMap = new HashMap<String, Method>();


    public WMRepositoryImplementation(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation,entityManager);
        this.entityInformation = entityInformation;
        this.em = entityManager;
    }

    public WMRepositoryImplementation(Class<T> domainClass, EntityManager em) {
        this(JpaEntityInformationSupport.getEntityInformation(domainClass, em), em);
    }




    @Override
    public WebModel findByWebModel(String method, WebModel wm) {
        return null;
    }
}
