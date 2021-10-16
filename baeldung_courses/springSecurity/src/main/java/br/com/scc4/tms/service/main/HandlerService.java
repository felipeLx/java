package br.com.scc4.tms.service.main;

import br.com.scc4.tms.model.main.Usuario;

import java.util.Optional;

public interface HandlerService<T> {

    Optional<T> findById(Long id);
    public T salvar(T variable);
    void apagar(Long id);
    Usuario findByUsername(String email);
}
