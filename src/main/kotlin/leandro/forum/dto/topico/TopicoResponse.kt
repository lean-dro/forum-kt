package leandro.forum.dto.topico

import leandro.forum.dto.usuario.UsuarioResponse
import java.time.LocalDateTime

data class TopicoResponse(val id:Int?,val titulo:String, val conteudo:String, val dataCriacao:LocalDateTime, val usuario: UsuarioResponse)
