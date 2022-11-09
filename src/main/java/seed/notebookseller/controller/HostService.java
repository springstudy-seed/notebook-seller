package seed.notebookseller.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import seed.notebookseller.domain.Host;
import seed.notebookseller.domain.HostRepository;

@Service
@RequiredArgsConstructor
public class HostService {
    private final HostRepository hostRepository;
    public Host createHost(Host host) {
        return hostRepository.save(host);
    }
}
