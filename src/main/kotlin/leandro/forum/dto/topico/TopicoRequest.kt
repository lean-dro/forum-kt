package leandro.forum.dto.topico

data class TopicoRequest(val titulo:String, val conteudo:String, val idUsuario: Int )

data class TopicoRequestUpdate(val titulo: String, val conteudo: String)