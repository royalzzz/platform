package xin.qust.platform.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("tree")
@RestController
public class TreeApi {

    @RequestMapping("getTree")
    public String getTree() {
        return "hello tree";
    }
}
