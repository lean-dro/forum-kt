package leandro.forum.repository

import leandro.forum.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository:JpaRepository<Usuario, Int> {

}