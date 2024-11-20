package leandro.forum.extensions

import leandro.forum.exceptions.RecursoNaoEncontradoException
import leandro.forum.model.Usuario
import org.springframework.http.HttpStatusCode
import org.springframework.web.server.ResponseStatusException
import java.util.*


fun Optional<Usuario>.existe(){
    if (this.isEmpty) {
        throw RecursoNaoEncontradoException("Usuário")
    }
}