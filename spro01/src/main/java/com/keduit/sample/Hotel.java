package com.keduit.sample;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Component
@ToString //toString                 DATA로 다 커버가능      
@Getter   //getter
@AllArgsConstructor //생성자 생성 @NonNull,final 필요없음
//@RequiredArgsConstructor //@NonNull,final 넣어줘야함(넣어준것만 값을 받음 그외에 것은 null)
public class Hotel {
	//@NonNull == final
	private final Chef chef; //
	private Restaurant restaurant;   
	
//	public Hotel(Chef chef) {     //AllArgsConstructor 쓰면 오류남
//		this.chef = chef;
//	}

}
