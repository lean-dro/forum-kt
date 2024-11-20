package leandro.forum.extensions

import leandro.forum.exceptions.RecursoNaoEncontradoException
import leandro.forum.model.Topico
import org.springframework.http.HttpStatusCode
import org.springframework.web.server.ResponseStatusException
import java.util.*

fun Optional<Topico>.existe(){
    if (this.isEmpty){
        throw RecursoNaoEncontradoException("Tópico")
    }
}