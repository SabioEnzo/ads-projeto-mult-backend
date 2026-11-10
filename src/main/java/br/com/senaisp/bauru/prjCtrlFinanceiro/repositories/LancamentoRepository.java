package br.com.senaisp.bauru.prjCtrlFinanceiro.repositories;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {
}
