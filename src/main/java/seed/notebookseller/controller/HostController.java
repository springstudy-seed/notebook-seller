package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import seed.notebookseller.domain.Host;

@RestController
@RequiredArgsConstructor
public class HostController{
    private final HostService hostService;
    @PostMapping("/api/host")
    public Host createHost(@RequestBody Host host){
        host.validateName(host.name);
        return hostService.createHost(host);
    }

}
