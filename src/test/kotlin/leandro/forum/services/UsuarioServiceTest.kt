package leandro.forum.services

import leandro.forum.exceptions.RecursoNaoEncontradoException
import leandro.forum.model.Usuario
import leandro.forum.repository.UsuarioRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.test.assertEquals


class UsuarioServiceTest{
    lateinit var usuarioRepository: UsuarioRepository
    lateinit var usuarioService: UsuarioService
    @BeforeEach
    fun init(){
        usuarioRepository = mock(UsuarioRepository::class.java)
        usuarioService = UsuarioService(usuarioRepository)
    }

    @Test
    fun `Quando procurar ID de usuário inexistente, lançar exceção`(){
        assertThrows<RecursoNaoEncontradoException> {
            usuarioService.buscarUsuario(10000)
        }
    }
    @Test
    fun `Quando procurar ID de usuário existente, retornar o usuário`(){
        val codigo = 1
        val usuarioMock: Usuario = mock(Usuario::class.java)
        Mockito.`when`(
            usuarioRepository.existsById(codigo)
        ).thenReturn(true)
        Mockito.`when`(
            usuarioRepository.findById(codigo)
        ).thenReturn(Optional.of(usuarioMock))

        val busca = usuarioService.buscarUsuario(codigo)

        assertEquals(busca, usuarioMock)
    }

}