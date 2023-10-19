package com.example.boardsample.main.board.controller;

import com.example.boardsample.main.board.model.dto.BoardDTO;
import com.example.boardsample.main.board.model.dto.CommentDTO;
import com.example.boardsample.main.board.model.service.BoardService;
import com.example.boardsample.main.common.Pagenation;
import com.example.boardsample.main.common.PagingButton;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("selectCode")
    public void selectCpde() {
    }

    @GetMapping("{boardCode}")
    public String findBoardByCode(@PathVariable int boardCode, Model model) {
        BoardDTO board = boardService.findBoardByCode(boardCode);
        List<CommentDTO> commentList = boardService.findCommentList(boardCode);

        model.addAttribute("commentList", commentList);
        model.addAttribute("board", board);

        return "board/detail";

    }

    @GetMapping("/list")
    public String findBoardList(Model model, @PageableDefault(size = 5) Pageable pageable) {
        Page<BoardDTO> boardList = boardService.findBoardList(pageable);

        PagingButton paging = Pagenation.getPagingButtonInfo(boardList);

        model.addAttribute("boardList", boardList);
        model.addAttribute("paging", paging);

        return "board/list";
    }

    @GetMapping("/regist")
    public void registPage() {
    }

    @PostMapping("/regist")
    public String boardRegist(BoardDTO boardDTO) {
        boardService.boardRegist(boardDTO);

        return "redirect:/board/regist";
    }

    @GetMapping("/modify/{boardCode}")
    public String boardModifyPage(@PathVariable int boardCode, Model model) {
        BoardDTO board = boardService.findBoardByCode(boardCode);
        model.addAttribute("board", board);

        return "/board/modify";
    }

    @PostMapping("/modify")
    public String boardModify(BoardDTO boardModify) {
        boardService.boardModify(boardModify);

        return "redirect:/board/" + boardModify.getBoardCode();
    }

    @GetMapping("/delete")
    public void deletePage() {
    }

    @PostMapping("/delete")
    public String boardDeletePage(BoardDTO boardDelete) {
        boardService.boardDelete(boardDelete);

        return "redirect:/board/list";
    }

    @GetMapping("/querymethod")
    public void queryMethodPage() {}

    @GetMapping("/search")
    public String findByBoardSearchhWord(@RequestParam String searchWord, Model model) {
        List<BoardDTO> boardList = boardService.findByBoardSearchWord(searchWord);
        model.addAttribute("boardList", boardList);

        return "board/searchResult";
    }

    @GetMapping("/searchAll")
    public String findByBoardSearchAll(@RequestParam String searchAll, Model model) {
        List<BoardDTO> boardList = boardService.findByBoardSearchAll(searchAll);
        model.addAttribute("boardList", boardList);

        return "board/searchResult";
    }

    @PostMapping("/comment")
    public String saveComment(@RequestBody CommentDTO newComment){
        boardService.commentNewPosting(newComment);

        return "redirect:/board/"+ newComment.getBoardCode();
    }

    @PostMapping("/commentDelete")
    public String commentDelete(CommentDTO deletComment) {
        System.out.println(deletComment);
        boardService.commentDelete(deletComment);

        return "redirect:/board/"+ deletComment.getBoardCode();
    }
}
