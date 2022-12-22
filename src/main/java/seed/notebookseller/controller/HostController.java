package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import seed.notebookseller.domain.Host;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class HostController {
    private final HostService hostService;

    @PostMapping("/api/hosts")
    public ResponseEntity<Host> createHost(@RequestBody Host host) {
        Host createdHost = hostService.createHost(host);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(createdHost.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(createdHost);
    }
}
