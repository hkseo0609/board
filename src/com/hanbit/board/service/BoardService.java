package com.hanbit.board.service;

import com.hanbit.board.domain.BoardBean;

public interface BoardService {
	public void writeBoard(BoardBean bean);
	public BoardBean[] list();
	public BoardBean findByseq(int seq);
	public BoardBean[] findBywriter(String writer);
	public int count();
	public void updateContent(BoardBean bean);
	public void deleteBoard(int seq);
}
