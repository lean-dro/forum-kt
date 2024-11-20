package leandro.forum.services

import leandro.forum.dto.request.TopicoRequest
import leandro.forum.exceptions.RecursoNaoEncontradoException
import leandro.forum.model.Usuario
import leandro.forum.repository.TopicoRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class TopicoServiceTest{
    lateinit var topicoRepository: TopicoRepository
    lateinit var usuarioService: UsuarioService

    lateinit var topicoService: TopicoService
    @BeforeEach
    fun init(){
        usuarioService = mock(UsuarioService::class.java)
        topicoRepository = mock(TopicoRepository::class.java)

        topicoService = TopicoService(topicoRepository, usuarioService = usuarioService)
    }

    @Test
    fun `Não Criar Tópico se o ID do Usuário informado não existir`(){
        val codigoInvalido = 0
        val topicoNovo = TopicoRequest(
            titulo = "Teste",
            conteudo = "Teste",
            idUsuario = codigoInvalido
        )

        `when`(
            usuarioService.buscarUsuario(codigoInvalido)
        ).thenThrow(RecursoNaoEncontradoException::class.java)

        assertThrows<RecursoNaoEncontradoException> {
            topicoService.criarTopico(topicoNovo)
        }

    }




}