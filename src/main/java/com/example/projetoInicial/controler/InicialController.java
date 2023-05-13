package com.example.projetoInicial.controler;


import com.example.projetoInicial.models.Acesso;
import com.example.projetoInicial.models.Usuario;
import com.example.projetoInicial.repository.AcessoRepository;
import com.example.projetoInicial.repository.UsuarioRepository;
import com.example.projetoInicial.resquest.AcessoPostRequestBody;
import com.example.projetoInicial.util.DateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log4j2
@Controller
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class InicialController {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    AcessoRepository acessoRepository;
    private final DateUtil dateUtil = new DateUtil();

    @GetMapping("/")
    public ModelAndView list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        Usuario usuario = new Usuario(33L,"Pedro");
        usuarioRepository.save(usuario);
        Acesso acesso = new Acesso("paginaInicial", java.time.LocalDateTime.now());
        acessoRepository.save(acesso);
        long paginaInicial = acessoRepository.countByPagina("paginaInicial");

        AcessoPostRequestBody build = AcessoPostRequestBody.builder().idade(usuario.getIdade()).name(usuario.getName()).pagina(acesso.getPagina()).countAcessso(paginaInicial).build();

        List<Usuario> listaUsuario = usuarioRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("usuarios-listar");
        modelAndView.addObject("titulo", "LISTA DE USUÁRIOS");
        modelAndView.addObject("listaUsuario", listaUsuario);
        return  modelAndView;
    }
    @GetMapping(path = "/add")
    public String adicionar(){
        return "usuarios-add";
    }
    @GetMapping(path = "/find")
    public ResponseEntity< List<String>> findByName(@RequestParam String name){
        return ResponseEntity.ok(new ArrayList<String>());
    }

}
