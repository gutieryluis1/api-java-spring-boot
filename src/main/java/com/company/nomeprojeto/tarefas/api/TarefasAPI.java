package com.company.nomeprojeto.tarefas.api;

import com.company.nomeprojeto.tarefas.dto.TarefaDTO;
import com.company.nomeprojeto.tarefas.facade.TarefasFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TarefasAPI {
    @Autowired
    private TarefasFacade tarefasFacade;
//Cria um registro
    @PostMapping
    @ResponseBody
    public TarefaDTO criar(@RequestBody TarefaDTO tarefaDTO) {
       return tarefasFacade.criar(tarefaDTO);
    }
//Fazer uma atualização
    @PutMapping("/{tarefaId}")
    @ResponseBody
    public TarefaDTO atualizar(@PathVariable("tarefaId") Long tarefaId,
                               @RequestBody TarefaDTO tarefaDTO) {
        return tarefasFacade.atualizar(tarefaDTO, tarefaId);
    }
//Pega algum dado
    @GetMapping
    @ResponseBody
    public List<TarefaDTO> getAll() {
        return tarefasFacade.getAll();
    }
//Deleta algum dado
    @DeleteMapping("/{tarefaId}")
    @ResponseBody
    public String deletar(@PathVariable("tarefaId") Long tarefaId) {
        return tarefasFacade.delete(tarefaId);
    }
}
