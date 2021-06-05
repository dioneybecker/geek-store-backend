package com.pim.geekstore.repositories;

import com.pim.geekstore.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
