package com.example.boardsample.main.board.model.service;

import com.example.boardsample.main.board.model.dto.BoardDTO;
import com.example.boardsample.main.board.model.entity.Board;
import com.example.boardsample.main.board.model.repository.BoardRepogitory;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepogitory boardRepogitory;
    private final ModelMapper modelMapper;

    @Autowired
    public BoardService(BoardRepogitory boardRepogitory, ModelMapper modelMapper) {
        this.boardRepogitory = boardRepogitory;
        this.modelMapper = modelMapper;
    }
    @Transactional
    public void boardRegist(BoardDTO boardDTO) {

        /* 현재 시간 구하기 */
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        boardDTO.setPostedDate(formatedNow);

        boardRepogitory.save(modelMapper.map(boardDTO, Board.class));


    }
    /* 게시글 전체 조회 */
    public Page<BoardDTO> findBoardList(Pageable pageable) {
        pageable = PageRequest.of(pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1, pageable.getPageSize(),
                Sort.by("boardCode").descending());

        Page<Board> boardList = boardRepogitory.findAll(pageable);

        return boardList.map(board -> modelMapper.map(board, BoardDTO.class));
    }

    /* 게시글 상세 조회 */
    public BoardDTO findBoardByCode(int boardCode) {

        Board board = boardRepogitory.findById(boardCode).orElseThrow();

        return modelMapper.map(board, BoardDTO.class);
    }

    /* 게시글 수정 */
    @Transactional
    public void boardModify(BoardDTO boardModify) {
        /* 현재 시간 구하기 */
        LocalDateTime now = LocalDateTime.now();
        String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));


        Board board = boardRepogitory.findById(boardModify.getBoardCode()).orElseThrow();

        board.setTitle(boardModify.getTitle());
        board.setBoardContent(boardModify.getBoardContent());
        board.setPostedDate(formatedNow);

    }

    /* 게시글 제목 검색 (쿼리메소드)*/
    @Transactional
    public void boardDelete(BoardDTO boardDelete) {
        boardRepogitory.deleteById(boardDelete.getBoardCode());
    }
    public List<BoardDTO> findByBoardSearchWord(String searchWord) {

        List<Board> boardList = boardRepogitory.findByTitleContaining(searchWord);
        return boardList.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
    }

    public List<BoardDTO> findByBoardSearchAll(String searchAll) {
        List<Board> boardList = boardRepogitory.findByBoardSearchAll(searchAll);
        return boardList.stream().map(board -> modelMapper.map(board, BoardDTO.class)).collect(Collectors.toList());
    }

}