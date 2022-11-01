package com.iu.home.util;

import lombok.Data;

@Data
public class Pager {

	private Long page;
	private Long perPage=10L;
	private Long perBlock;
	private Long startRow;
	private Long lastRow;
	private Long startNum;
	private Long lastNum;

	//검색 컬럼의 종류
	private String kind;
	//검색어
	private String search;

	//이전 블럭의 유무
	private boolean pre = false;
	//다음 블럭의 유무
	private boolean next = false;



	public void makeRow() {
		this.startRow = (this.getPage()-1)*perPage;

	}

	public Long getPage() {
		if (this.page==null || this.page<1) {
			this.page=1L;
		}
		return this.page;
	}

	public Long getPerBlock() {
		if(this.perBlock ==null) {
			this.perBlock =5L;
		}
		return perBlock;
	}

	public String getSearch() {
		if(this.search == null)
			this.search = "";

		return search;
	}

	// 1. mapper에서 사용할 값
	public void getRowNum() throws Exception{
		this.startRow = (this.getPage()-1)*this.getPerPage()+1;
		this.lastRow = this.getPage()*this.getPerPage();
	}

	// 2. jsp에서 사용할 값
	public void getNum(Long totalCount) throws Exception{


		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() !=0) {
			totalPage++;
		}

		if(this.getPage()>totalPage) {
			this.setPage(totalPage);
		}

		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0 ) {
			totalBlock++;
		}

		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}

		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();

		//6. curBlock이 마지막Block(totalBlock과 같을 때)

		if(curBlock==totalBlock) {
			this.lastNum=totalPage;
		}

		// 7. curBlock 이전, 다음 블럭의 유무
		if(curBlock>1) {
			pre=true;
		}

		if(curBlock<totalBlock) {
			next=true;
		}
	}

}