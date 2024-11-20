package leandro.forum.dto.request

import java.time.LocalDate

data class UsuarioRequest(
    val nome:String,
    val email:String,
    val senha:String,
    val dataNascimento: LocalDate
)
