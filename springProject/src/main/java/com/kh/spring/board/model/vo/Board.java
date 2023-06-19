package com.kh.spring.board.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor //매개변수가 없는 생성자
@AllArgsConstructor
public class Board {
	@NonNull
    private int boardNo;
	@NonNull
    private String boardTitle;
	@NonNull
    private String boardWriter;
	@NonNull
    private String content;
    private String originalFilename;
    private String changeFilename;
    private int count;
    private Date createDate;
    
}
