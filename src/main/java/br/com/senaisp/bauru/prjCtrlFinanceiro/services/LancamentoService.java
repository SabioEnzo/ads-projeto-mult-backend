package br.com.senaisp.bauru.prjCtrlFinanceiro.services;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.repositories.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public List<Lancamento> listarTodos() {
        return lancamentoRepository.findAll();
    }

    public Optional<Lancamento> buscarPorId(Long id) {
        return lancamentoRepository.findById(id);
    }

    public Lancamento salvar(Lancamento lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public void deletar(Long id) {
        lancamentoRepository.deleteById(id);
    }
}
