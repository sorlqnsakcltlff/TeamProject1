package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;


public interface ExchangeBbsDAOImpl {

	public ArrayList<ExchangeBbsDTO> list();
	
	
	//글쓰기
	public void write(String name, String contents, String id);
	
	//수정하기폼
	public ExchangeBbsDTO view(String idx, String id);
	
	//수정처리
	/*public int modify(String idx, String name, 
			String contents, String id);*/
	public int modify(@Param("_idx") String idx, 
			@Param("_name") String name, 
			@Param("_contents") String contents, 
			@Param("_id") String id);
	
	//삭제처리
	public int delete(String idx, String id);
	
	
	//게시판 리스트 페이지 처리
	//게시물 카운트
	public int getTotalCount();
	//start와 end를 파라미터로 받아 게시물 가져오기
	public ArrayList<ProjectBbsDTO> listPage(int s, int e);	
	
	
	//검색처리추가
	public int getTotalCountSearch(ParamDTO paramDTO);
	//start와 end를 파라미터로 받아 게시물 가져오기
	public ArrayList<ExchangeBbsDTO> listPageSearch(ParamDTO paramDTO);	
	
	//상세보기

	public ExchangeBbsDTO exView(String idx);
	
}
