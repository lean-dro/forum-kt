package leandro.forum.services


import leandro.forum.adapters.toDto
import leandro.forum.adapters.toModel
import leandro.forum.dto.topico.TopicoRequest
import leandro.forum.dto.topico.TopicoRequestUpdate
import leandro.forum.dto.topico.TopicoResponse
import leandro.forum.extensions.existe
import leandro.forum.model.Topico
import leandro.forum.repository.TopicoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service

@Service
class TopicoService(@Autowired private val repository: TopicoRepository,
                    @Autowired private val usuarioService: UsuarioService ) {
    fun listarTopicos():ResponseEntity<List<TopicoResponse>>{
        val busca = this.repository.findAll()
        if (busca.isEmpty()){
            return ResponseEntity.status(204).build()
        }
        return ResponseEntity.status(200).body(toDto(busca))
    }
    fun buscarTopico(id:Int):Topico{
        val busca = this.repository.findById(id)
        busca.existe()
        return busca.get()
    }
    fun criarTopico(topicoRequest: TopicoRequest):ResponseEntity<TopicoResponse>{
        val criador = usuarioService.buscarUsuario(topicoRequest.idUsuario)
        val novoTopico = repository.save(
            toModel(topicoRequest, criador)
        )

        return ResponseEntity.status(201).body(toDto(novoTopico))
    }
    fun atualizarTopico(topicoRequest: TopicoRequestUpdate,id:Int):ResponseEntity<TopicoResponse>{
        val topico = buscarTopico(id)
        topico.let {
            it.titulo = topicoRequest.titulo
            it.conteudo = topicoRequest.conteudo
        }
        return ResponseEntity.status(200).body(toDto(topico))
    }

    fun deletarTopico(id: Int):ResponseEntity<Void> {
        val topico = buscarTopico(id)
        repository.delete(topico)
        return ResponseEntity.status(204).build()
    }

}
