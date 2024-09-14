package leandro.forum.services

import leandro.forum.adapters.toDTO
import leandro.forum.adapters.toModel
import leandro.forum.dto.usuario.UsuarioRequest
import leandro.forum.dto.usuario.UsuarioResponse
import leandro.forum.extensions.existe
import leandro.forum.model.Usuario
import leandro.forum.repository.UsuarioRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class UsuarioService(@Autowired private val repository:UsuarioRepository) {

    fun buscarUsuario(id:Int): Usuario{
        val busca = this.repository.findById(id)
        busca.existe()
        return busca.get()
    }
    fun listarUsuarios():ResponseEntity<List<UsuarioResponse>> {
        val busca = this.repository.findAll()
        if (busca.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(toDTO(busca))
    }

    fun criarUsuario(usuario:UsuarioRequest):ResponseEntity <UsuarioResponse> {
       val novoUsuario =  this.repository.save(
           toModel(usuario)
       )
       return ResponseEntity.status(201).body(toDTO(novoUsuario))
    }

    fun atualizarUsuario(usuarioUpdate: UsuarioRequest, id: Int): ResponseEntity<UsuarioResponse> {
        val usuario = buscarUsuario(id)
        usuario.let {
            it.nome = usuarioUpdate.nome
            it.email = usuarioUpdate.email
            it.dataNascimento = usuarioUpdate.dataNascimento
            it.senha = usuarioUpdate.senha
        }
        repository.save(usuario)
        return ResponseEntity.status(200).body(toDTO(usuario))
    }
}