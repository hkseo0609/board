package com.hanbit.board.domain;

public class BoardBean {
	private int seq, upNumber;
	private String regdate, writer, title, content;
	
	public void setupNumber(int upNumber){
		this.upNumber = upNumber;
	}
	public void setSeq(int seq){
		this.seq = seq;
	}
	public void setRegdate(String regdate){
		this.regdate = regdate;
	}
	public void setWriter(String writer){
		this.writer = writer;
	}
	public void setTitle(String title){
		this.title = title;
	}
	public void setContent(String content){
		this.content = content;
	}
	
	public int getSeq(){
		return seq;
	}
	public String getRegdate(){
		return regdate;
	}
	public String getWriter(){
		return writer;
	}
	public String getTitle(){
		return title;
	}
	public String getContent(){
		return content;
	}
	public int getupNumber(){
		return upNumber;
	}
	
	public String toString(){
		return "글번호:"+seq+"\n"
				+"글제목:"+title+"\n"
				+"글쓴이:"+writer+"\n"
				+"작성날짜:"+regdate+"\n"
				+"글내용:"+content+"\n"
				+"-------------------\n";
	}
	

}
