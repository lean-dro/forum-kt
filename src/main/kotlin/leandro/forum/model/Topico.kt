package leandro.forum.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topico(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int?,
    var titulo:String,
    var conteudo:String,
    var dataCriacao: LocalDateTime = LocalDateTime.now(),
    @ManyToOne
    val criador: Usuario
) {
}