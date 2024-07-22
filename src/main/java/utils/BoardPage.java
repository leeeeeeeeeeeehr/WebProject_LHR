package utils;

public class BoardPage {
	
	public static String pagingStr(int totalCount, int pageList, int pageBlock,
				int pageNum, String reqUrl) {
		// 페이지 바로가기 링크를 저장할 문자열 변수
		String pagingStr = "";
		
		// 전체 페이지 수를 계산
		int totalPages = (int) (Math.ceil(((double) totalCount / pageList)));
		
		int pageNow = (((pageNum - 1) / pageBlock) * pageBlock) + 1;
		
		// 첫 페이지, 이전 블록
		if (pageNow != 1) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=1'>[첫 페이지]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + (pageNow - 1) + "'>[이전 블록]</a>";
		}
		
		// 각 페이지 번호
		int blockCount = 1;
		while (blockCount <= pageBlock && pageNow <= totalPages) {
			if (pageNow == pageNum) {
				// 현재 페이지라면 링크 X
				pagingStr += "&nbsp;" + pageNow + "&nbsp;";
			}
			else {
				// 현재 페이지가 아닌 경우에만 링크 추가
				pagingStr += "&nbsp;<a href='" + reqUrl + "?pageNum=" + pageNow + "'>" + pageNow + "</a>&nbsp;";
			}
			// 반복하면서 1씩 증가시켜 순차적인 페이지 번호를 출력한다.
			pageNow++;
			blockCount++;
		}
		
		/* 다음 블록, 마지막 페이지  */
		if (pageNow <= totalPages) {
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + pageNow + "'>[다음 블록]</a>";
			pagingStr += "&nbsp;";
			pagingStr += "<a href='" + reqUrl + "?pageNum=" + totalPages + "'>[마지막 페이지]</a>";
		}
		
		return pagingStr;
	}

}
