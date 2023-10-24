package com.Sarthi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Sarthi.controller.model.feedBackDeatils;
import com.Sarthi.repository.FeedBackReository;

@Service
public class UserFeedBackServiceImp implements UserFeedBackService {
	
	@Autowired
	private FeedBackReository feedBackReository;

	@Override
	public feedBackDeatils saveFeedBack(feedBackDeatils fBDeatils) {
		
		System.out.println(fBDeatils.getName());
		return feedBackReository.save(fBDeatils);

}
}
