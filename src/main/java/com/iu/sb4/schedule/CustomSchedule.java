package com.iu.sb4.schedule;

import java.awt.print.Pageable;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iu.sb4.board.notice.NoticeMapper;
import com.iu.sb4.util.Pager;

@Component
public class CustomSchedule {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Scheduled(fixedRate = 1000, initialDelay = 2000)
	//@Scheduled(fixedRateString = "1000", initialDelayString = "2000")
	public void fixedRateTest() throws Exception{
		
		System.out.println("------------- Fix Rate Test ---------------");
		
	}
	
	//@Scheduled(fixedDelay = 1000, initialDelay = 2000)
	public void fixedDelayTest() throws Exception{
		
		System.out.println("----------------- Fixed Delay Test --------------------");
	}
	
	//@Scheduled(cron = " 0 14 * * * * ")
	public void cronTest() throws Exception{
		Calendar ca = Calendar.getInstance();
		
		System.out.println("----------------- Cron Test ------------------");
		System.out.println(ca.getTime());
	}
	
	@Scheduled(cron = "10 * * * * *")
	public void noticeCronTest() throws Exception{
		Pager pager = new Pager();
		
		System.out.println(noticeMapper.getList(pager));
		
	}
}
