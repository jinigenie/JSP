package com.baek.findcomment.model;

public class commentVO {
		
		private String seq;
		private String id;
		private String content;
		private String regdate;
		private String pseq;
		private String name; // 추가멤버 (이름) 


		// getter / setter 구현하기 (생략)
		public commentVO() {
			// TODO Auto-generated constructor stub
		}


		public commentVO(String seq, String id, String content, String regdate, String pseq, String name) {
			super();
			this.seq = seq;
			this.id = id;
			this.content = content;
			this.regdate = regdate;
			this.pseq = pseq;
			this.name = name;
		}


		public String getSeq() {
			return seq;
		}


		public void setSeq(String seq) {
			this.seq = seq;
		}


		public String getId() {
			return id;
		}


		public void setId(String id) {
			this.id = id;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}


		public String getRegdate() {
			return regdate;
		}


		public void setRegdate(String regdate) {
			this.regdate = regdate;
		}


		public String getPseq() {
			return pseq;
		}


		public void setPseq(String pseq) {
			this.pseq = pseq;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}
		
}
