package leandro.forum.exceptions

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus


@ResponseStatus(HttpStatus.NOT_FOUND)
class RecursoNaoEncontradoException(recurso: String): RuntimeException(
                                    "$recurso com identificador não foi encontrado!"){
}