package br.com.scc4.tms.service.tenant;

import java.util.Optional;

public interface IEmbarcadorService<T> {

    Optional<T> findById(Long id);

    void apagar(Long id);
}
