package xin.qust.platform.service.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.qust.platform.repository.EventNodeRepo;

@Service
public class EventGraphService {
    @Autowired
    private EventNodeRepo eventNodeRepoRepo;

    public void getNodes(){
        System.out.println(eventNodeRepoRepo.findAll());
    }
}
