package leandro.forum.adapters

import leandro.forum.dto.request.TopicoRequest
import leandro.forum.dto.response.TopicoResponse
import leandro.forum.model.Topico
import leandro.forum.model.Usuario

fun toDto(topicoModel:Topico): TopicoResponse {
    return TopicoResponse(
        titulo = topicoModel.titulo,
        conteudo = topicoModel.conteudo,
        dataCriacao = topicoModel.dataCriacao,
        usuario = toDTO(topicoModel.criador),
        id = topicoModel.id
    )
}

fun toDto(topicosModel:List<Topico>):List<TopicoResponse>{
    return topicosModel.map {
        toDto(it)
    }
}

fun toModel(topicoRequest: TopicoRequest, criador:Usuario):Topico{
    return Topico(
        id = null,
        titulo = topicoRequest.titulo,
        conteudo = topicoRequest.conteudo,
        criador = criador
    )
}