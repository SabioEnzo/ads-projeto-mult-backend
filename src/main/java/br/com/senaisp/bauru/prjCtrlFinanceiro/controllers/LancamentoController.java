package br.com.senaisp.bauru.prjCtrlFinanceiro.controllers;

import br.com.senaisp.bauru.prjCtrlFinanceiro.models.Lancamento;
import br.com.senaisp.bauru.prjCtrlFinanceiro.services.LancamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService lancamentoService;

    // GET /api/lancamentos
    @GetMapping
    public List<Lancamento> listar() {
        return lancamentoService.listarTodos();
    }

    // GET /api/lancamentos/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Lancamento> buscarPorId(@PathVariable Long id) {
        return lancamentoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // POST /api/lancamentos
    @PostMapping
    public ResponseEntity<Lancamento> criar(@RequestBody Lancamento lancamento) {
        Lancamento novoLancamento = lancamentoService.salvar(lancamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLancamento);
    }

    // PUT /api/lancamentos/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Lancamento> atualizar(@PathVariable Long id, @RequestBody Lancamento lancamento) {
        return lancamentoService.buscarPorId(id)
                .map(existente -> {
                    lancamento.setId(existente.getId());
                    return ResponseEntity.ok(lancamentoService.salvar(lancamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // DELETE /api/lancamentos/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (lancamentoService.buscarPorId(id).isPresent()) {
            lancamentoService.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
