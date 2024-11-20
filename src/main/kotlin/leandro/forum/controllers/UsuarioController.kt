package leandro.forum.controllers

import leandro.forum.adapters.toDTO
import leandro.forum.dto.request.UsuarioRequest
import leandro.forum.dto.response.UsuarioResponse
import leandro.forum.services.UsuarioService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(@Autowired val service:UsuarioService) {
    @GetMapping
    fun listarUsuarios():ResponseEntity< List<UsuarioResponse>>{
       return service.listarUsuarios()
    }
    @GetMapping("/{id}")
    fun obterUsuario(@PathVariable id: Int):ResponseEntity<UsuarioResponse>{
        return ResponseEntity.status(200).body(toDTO(service.buscarUsuario(id)))
    }
    @PostMapping
    fun criarUsuario(@RequestBody novoUsuario: UsuarioRequest): ResponseEntity<UsuarioResponse> {
        return service.criarUsuario(novoUsuario)
    }

    @PutMapping("/{id}")
    fun atualizarUsuario(@RequestBody usuarioUpdate: UsuarioRequest, @PathVariable id:Int):ResponseEntity<UsuarioResponse>{
        return service.atualizarUsuario(usuarioUpdate, id)
    }
}