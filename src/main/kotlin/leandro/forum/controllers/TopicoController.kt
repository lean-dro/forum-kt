package leandro.forum.controllers

import leandro.forum.adapters.toDto
import leandro.forum.dto.topico.TopicoRequest
import leandro.forum.dto.topico.TopicoRequestUpdate
import leandro.forum.dto.topico.TopicoResponse
import leandro.forum.services.TopicoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/topicos")
class TopicoController(@Autowired val service: TopicoService) {
    @GetMapping
    fun listarTopicos():ResponseEntity<List<TopicoResponse>>{
        return service.listarTopicos()
    }
    @GetMapping("/{id}")
    fun buscarTopico(@PathVariable id:Int):ResponseEntity<TopicoResponse>{
        return ResponseEntity.status(200).body(toDto(service.buscarTopico(id)))
    }
    @PostMapping
    fun criarTopico(@RequestBody novoTopico:TopicoRequest):ResponseEntity<TopicoResponse>{
        return service.criarTopico(novoTopico)
    }
    @PutMapping("/{id}")
    fun atualizarTopico(@RequestBody topicoAtualizado:TopicoRequestUpdate, @PathVariable id: Int): ResponseEntity<TopicoResponse> {
        return service.atualizarTopico(topicoAtualizado, id)
    }
    @DeleteMapping("/{id}")
    fun deletarTopico(@PathVariable id: Int): ResponseEntity<Void> {
        return service.deletarTopico(id)
    }
}