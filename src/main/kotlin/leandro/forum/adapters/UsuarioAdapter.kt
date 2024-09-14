package leandro.forum.adapters

import leandro.forum.dto.usuario.UsuarioRequest
import leandro.forum.dto.usuario.UsuarioResponse
import leandro.forum.model.Usuario

fun toDTO(usuarioModel: Usuario): UsuarioResponse {
    return UsuarioResponse(
        usuarioModel.nome, usuarioModel.email,
    )
}

fun toDTO(usuariosModel: List<Usuario>):List<UsuarioResponse>{
    return usuariosModel.map {
       toDTO(it)
    }
}

fun toModel(usuarioRequest: UsuarioRequest):Usuario{
    return (Usuario(
        id = null,
        dataNascimento = usuarioRequest.dataNascimento,
        nome= usuarioRequest.nome,
        email= usuarioRequest.email,
        senha = usuarioRequest.senha
    ))
}