package leandro.forum.repository

import leandro.forum.model.Topico
import org.springframework.data.jpa.repository.JpaRepository

interface TopicoRepository:JpaRepository<Topico, Int> {

}
