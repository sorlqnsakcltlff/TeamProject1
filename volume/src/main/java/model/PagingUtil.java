package model;

	public class PagingUtil {
		public static String pagingImg(int totalRecordCount,
				int pageSize, 
				int blockPage, 
				int nowPage, 
				String page){

			String pagingStr="";
			
			//1.전체페이지 구하기
			int totalPage =
				(int)(Math.ceil(((double)totalRecordCount/pageSize)));
			
			//현재페이지를 통해 이전 페이지블럭에 해당하는 페이지를 구함
			int intTemp = 
				((nowPage-1) / blockPage) * blockPage + 1;
			
			
					//처음페이지 & 이전페이지를 위한 로직
			if(intTemp != 1){
				pagingStr += "<li>"
						+"<a href='"+page+"nowPage=1'>"
						+"<span class='glyphicon glyphicon-fast-backward'></span></a></li>";
				//pagingStr += "&nbsp;";
				pagingStr += "<li>"
						+"<a href='"+page+"nowPage="+(intTemp-blockPage)+"'>"
						+"<span class='glyphicon glyphicon-step-backward'></span></a></li>";
			}
			
			//페이지표시 제어를 위한 변수
			int blockCount = 1;
			
			//페이지를 뿌려주는 로직 : 블럭페이지 수만큼 혹은 마지막
			//페이지가 될때까지 페이지를 표시한다.
			while(blockCount<=blockPage && intTemp<=totalPage){
				//현제페이지인 경우
				if(intTemp==nowPage){
					pagingStr
						+="<li class='active'><a href='#'>"+intTemp+"</a></li>";
				}
				else{
					pagingStr
						+="<li><a href='"+page+"nowPage="+intTemp+"'>"+intTemp+"</a></li>";
				}
			
				intTemp = intTemp + 1;
				blockCount = blockCount + 1;
			}
			
			//다음 및 마지막 페이지를 위한 로직
			if(intTemp <= totalPage){
				pagingStr+="<li><a href='"+page+"nowPage="+intTemp+"'>"
					+ "<span class='glyphicon glyphicon-step-forward'></span></a></li>";		
				//pagingStr+="&nbsp;";		
				pagingStr+="<li><a href='"+page+"nowPage="+totalPage+"'>"
					+ "<span class='glyphicon glyphicon-fast-forward'></span></a></li>";
			}
			
			return pagingStr;
		}	

}
