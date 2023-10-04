package com.icia.board.service;

import com.icia.board.dto.BoardDTO;
import com.icia.board.entity.BoardEntity;
import com.icia.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public Long save(BoardDTO boardDTO) {
        BoardEntity boardEntity = BoardEntity.toSaveEntity(boardDTO);
        return boardRepository.save(boardEntity).getId();
    }

    public List<BoardDTO> findAll() {
        List<BoardEntity> boardEntityList = boardRepository.findAll();
        List<BoardDTO> boardDTOList = new ArrayList<>();
        boardEntityList.forEach(board -> {
            boardDTOList.add(BoardDTO.toDTO(board));
        });

//        for (BoardEntity board: boardEntityList) {
//            BoardDTO boardDTO = BoardDTO.toDTO(board);
//            boardDTOList.add(boardDTO);
//        }
        return boardDTOList;
    }
}














