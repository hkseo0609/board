package com.hanbit.board.controller;

import javax.swing.JOptionPane;
import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;
import com.hanbit.board.serviceImpl.BoardServiceImpl;
import javax.swing.*;

public class BoardController {
	public static void main(String[] args){
		BoardService board = new BoardServiceImpl();
		BoardBean bean = null;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.END  1.Write  2.list  3.FindBySeq  4.FindByWriter  5.update  6.delete")){
				case"0":
					JOptionPane.showMessageDialog(null, "종료합니다.");
					return;
				case "1":
					bean = new BoardBean();
					String[] arr = (JOptionPane.showInputDialog("글쓴이/제목/내용/날짜")).split("/");
					bean.setWriter(arr[0]);
					bean.setTitle(arr[1]);
					bean.setContent(arr[2]);
					bean.setRegdate(arr[3]);
					board.writeBoard(bean);
					JOptionPane.showMessageDialog(null, "글쓰기 완료!");
					break;
				case "2":
					BoardBean[] list = board.list();
					String sList="";
					for(int i=0; i<board.count(); i++){
						sList += list[i].toString();
					}
					JOptionPane.showMessageDialog(null, sList);
					break;
				case "3":
					JOptionPane.showMessageDialog(null, board.findByseq(Integer.parseInt(JOptionPane.showInputDialog("찾으실 글의 글번호를 입력하세요"))));
					break;
				case "4":
					BoardBean[] list2 = board.findBywriter((JOptionPane.showInputDialog("검색할 글쓴이 입력하세요")));
					String nList="";
					for(int i=0; i<list2.length; i++)
						nList += list2[i].toString()+"\n";
					JOptionPane.showMessageDialog(null, nList);
					break;
				case "5":
					BoardBean boardUp = new BoardBean();
					boardUp.setSeq(Integer.parseInt(JOptionPane.showInputDialog("수정할 글의 글번호를 입력하세요")));
					boardUp.setContent((JOptionPane.showInputDialog("수정할 내용을 입력하세요")));
					board.updateContent(boardUp);
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					break;
				case "6":
					board.deleteBoard(Integer.parseInt(JOptionPane.showInputDialog("삭제할 글의 글번호를 입력하세요")));
					JOptionPane.showMessageDialog(null, "삭제 완료!");
					break;
			}
		}
	}


}
