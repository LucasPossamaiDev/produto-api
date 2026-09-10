package br.com.gerenciamento.spring_boot.service;

import br.com.gerenciamento.spring_boot.model.Produtos;
import br.com.gerenciamento.spring_boot.repository.produtosRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class produtoService {

    private final produtosRepository repository;

    public produtoService(produtosRepository repository){
        this.repository = repository;
    }

    public List<Produtos> listarTodos() {
        return repository.findAll();
    }

    public Produtos salvar(Produtos produtos) {
        return repository.save(produtos);
    }

    public Produtos buscarPorID(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com id: " + id));
    }

    public Produtos atualizar(Integer id, Produtos produtos) {
        Produtos existente = buscarPorID(id);
        existente.setName(produtos.getName());
        existente.setPrice(produtos.getPrice());
        existente.setQuantity(produtos.getQuantity());
        return repository.save(existente);
    }

    public void deletar(Integer id)
    {
        repository.deleteById(id);
    }
}
