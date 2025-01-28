package api.payload;

import java.util.ArrayList;
import java.util.List;

public class GetAllTweetsResponse {

	List<TweetResponse> li = new ArrayList<TweetResponse>();

	public List<TweetResponse> getLi() {
		return li;
	}

	public void setLi(List<TweetResponse> li) {
		this.li = li;
	}

	public GetAllTweetsResponse(List<TweetResponse> li) {
		super();
		this.li = li;
	}
	
	
	
}
