package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import seed.notebookseller.domain.Host;

@RestController
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;
    @PostMapping("/api/host")
    public boolean createHost(Host host){
        hostService.createHost(host);
        return true;
    }
}
