package com.hanbit.board.serviceImpl;

import com.hanbit.board.domain.BoardBean;
import com.hanbit.board.service.BoardService;


public class BoardServiceImpl implements BoardService {
	BoardBean bean;
	BoardBean[] list;
	int count;
	public BoardServiceImpl() {
		count = 0;
		bean = new BoardBean();
		list = new BoardBean[count];
		
	}

	@Override
	public void writeBoard(BoardBean bean) {
		int seqNo=count+1;
		bean.setSeq(seqNo);
		if(count==list.length){
			BoardBean[] temp = new BoardBean[count+1];
			System.arraycopy(list, 0, temp, 0, count);
			list = temp;
			seqNo++;
		}
		list[count++]=bean;
	}

	@Override
	public BoardBean[] list() {
		return list;
	}

	@Override
	public BoardBean findByseq(int seq) {
		bean = new BoardBean();
		for(int i=0; i<list.length; i++){
			if(seq==list[i].getSeq()){
				bean = list[i];
				break;
			}			
		}
		return bean;
	}

	@Override
	public BoardBean[] findBywriter(String writer) {
		int a = 0;
		for(int i=0; i<list.length; i++){
			if(writer.equals(list[i].getWriter())){
				a++;
			}
		}
		BoardBean[] nameList = new BoardBean[a];
		int j=0;
		for(int i=0; i<list.length; i++){
			if(writer.equals(list[i].getWriter())){
				nameList[j] = list[i];
				j++;
			}
			if(a==j)
				break;
		}
		return nameList;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public void updateContent(BoardBean inputBean) {
		bean = findByseq(inputBean.getSeq());
		bean.setContent(inputBean.getContent());
		/*if(inputBean.getSeq()==bean.getSeq())
			bean.setContent((inputBean.getContent()));*/
	}

	@Override
	public void deleteBoard(int seq) {
		for(int i=0; i<count; i++){
			if(seq==list[i].getSeq()){
				list[i]=list[count-1];
			}
		}
		list[count-1]=null;
		count--;
	}

}
