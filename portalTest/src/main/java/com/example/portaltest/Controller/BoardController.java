package com.example.portaltest.Controller;

import com.example.portaltest.Controller.BoardController;
import com.example.portaltest.repository.BoardRepository;
import dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import service.BoardService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BoardController {
    private BoardService boardService;



    @GetMapping("/post/{no}")
    public String detail(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/detail.html";
    }

    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Long no, Model model) {
        BoardDto boardDTO = boardService.getPost(no);

        model.addAttribute("boardDto", boardDTO);
        return "board/update.html";
    }

    @PutMapping("/post/edit/{no}")
    public String update(BoardDto boardDTO) {
        boardService.savePost(boardDTO);

        return "redirect:/";
    }

    @DeleteMapping("/post/{no}")
    public String delete(@PathVariable("no") Long no) {
        boardService.deletePost(no);

        return "redirect:/";
    }



}